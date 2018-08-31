package com.internousdev.tabicale.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.tabicale.dao.CartInfoDAO;
import com.internousdev.tabicale.dao.DestinationInfoDAO;
import com.internousdev.tabicale.dao.MCategoryDAO;
import com.internousdev.tabicale.dao.ProductInfoDAO;
import com.internousdev.tabicale.dao.UserInfoDAO;
import com.internousdev.tabicale.dto.CartInfoDTO;
import com.internousdev.tabicale.dto.DestinationInfoDTO;
import com.internousdev.tabicale.dto.MCategoryDTO;
import com.internousdev.tabicale.dto.ProductInfoDTO;
import com.internousdev.tabicale.dto.UserInfoDTO;
import com.internousdev.tabicale.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private String categoryId;
	private String loginId;
	private String password;
	private int settlementFlag;
	private boolean savedLoginId;

	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
	private List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();

	private List<String> loginIdErrorMessageList = new ArrayList<String>();
	private List<String> passwordErrorMessageList = new ArrayList<String>();
	private List<String> passwordIncorrectErrorMessageList = new ArrayList<String>();

	private Map<String, Object> session;

	public String execute(){
		String result = ERROR;
		String userId= null;

		session.remove("loginIdErrorMessageList");
		session.remove("passwordErrorMessageList");
		session.remove("passwordIncorrectErrorMessageList");
		session.remove("checkListErrorMessageList");

		if(savedLoginId==true) {
			session.put("savedLoginId", true);
			session.put("saveId", loginId);
		}else{
			session.put("savedLoginId", false);
			session.remove("saveId", loginId);
		}

		InputChecker inputChecker = new InputChecker();
		loginIdErrorMessageList = inputChecker.doCheck("ログインID", loginId, 1, 8, true, false, false, true, false, false, false, false);
		passwordErrorMessageList = inputChecker.doCheck("パスワード", password, 1, 16, true, false, false, true, false, false, false, false);

		if(loginIdErrorMessageList.size()!=0){
			session.put("loginIdErrorMessageList", loginIdErrorMessageList);
			session.put("logined", 0);
		}
		if(passwordErrorMessageList.size()!=0){
			session.put("passwordErrorMessageList", passwordErrorMessageList);
			session.put("logined", 0);
		}

		if(!session.containsKey("mCategoryList")){
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryDtoList = mCategoryDao.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}

		UserInfoDAO userInfoDao = new UserInfoDAO();

		if(userInfoDao.isExistsUserInfo(loginId, password)) {
			if(userInfoDao.login(loginId, password) > 0) {
				UserInfoDTO userInfoDTO = userInfoDao.getUserInfo(loginId, password);

				//管理者ユーザーの場合の処理
				if(userInfoDTO.getStatus().equals("1")){
					ProductInfoDAO productInfoDao = new ProductInfoDAO();
					productInfoDtoList = productInfoDao.getProductInfoList();
					session.put("productInfoDtoList", productInfoDtoList);
					session.put("logined", 0);
					session.put("adminFlag", "1");
					return "admin";
				}

				session.put("loginId", userInfoDTO.getUserId());
				int count = 0;


				CartInfoDAO cartInfoDao = new CartInfoDAO();

				count = cartInfoDao.linkToLoginId(String.valueOf(session.get("tempUserId")), loginId);

				List<CartInfoDTO> cartInfoDtoList = new ArrayList<CartInfoDTO>();
				userId = loginId;
				cartInfoDtoList = cartInfoDao.getCartInfoDtoList(userId);

				Iterator<CartInfoDTO> iteratorCart = cartInfoDtoList.iterator();
				if(!(iteratorCart.hasNext())){
					cartInfoDtoList = null;
				}
				session.put("cartInfoDtoList", cartInfoDtoList);

				int totalPrice = Integer.parseInt(String.valueOf(cartInfoDao.getTotalPrice(userId)));
				session.put("totalPrice", totalPrice);

				if(count > 0 && settlementFlag==1){
					DestinationInfoDAO destinationInfoDao = new DestinationInfoDAO();
					try{
						List<DestinationInfoDTO> destinationInfoDtoList =new ArrayList<DestinationInfoDTO>();
						destinationInfoDtoList = destinationInfoDao.getDestinationInfo(loginId);
						Iterator<DestinationInfoDTO> iterator = destinationInfoDtoList.iterator();
						if(!(iterator.hasNext())){
							destinationInfoDtoList = null;
						}
						session.put("destinationInfoDtoList", destinationInfoDtoList);

					} catch(SQLException e){
						e.printStackTrace();
					}
					result = "settlement";
				}else{
					result = SUCCESS;
				}
				session.put("logined", 1);
			}
		}else{
			passwordIncorrectErrorMessageList.add("入力されたパスワードが異なります。");
			session.put("passwordIncorrectErrorMessageList", passwordIncorrectErrorMessageList);
			session.put("logined", 0);
		}
		return result;
	}

	public String getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public String getLoginId(){
		return loginId;
	}

	public void setLoginId(String loginId){
		this.loginId = loginId;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public boolean getSavedLoginId(){
		return savedLoginId;
	}

	public void setSavedLoginId(boolean savedLoginId){
		this.savedLoginId = savedLoginId;
	}

	public List<String> getLoginIdErrorMessageList(){
		return loginIdErrorMessageList;
	}

	public void setLoginIdErrorMessageList(List<String> loginIdErrorMessageList){
		this.loginIdErrorMessageList = loginIdErrorMessageList;
	}

	public List<String> getPasswordErrorMessageList(){
		return passwordErrorMessageList;
	}

	public void setPasswordErrorMessageList(List<String> passwordErrorMessageList){
		this.passwordErrorMessageList = passwordErrorMessageList;
	}

	public List<String> getPasswordIncorrectErrorMessageList(){
		return passwordIncorrectErrorMessageList;
	}

	public void setPasswordIncorrectErrorMessageList(List<String> passwordIncorrectErrorMessageList){
		this.passwordIncorrectErrorMessageList = passwordIncorrectErrorMessageList;
	}

	public List<ProductInfoDTO> getProductInfoDtoList(){
		return productInfoDtoList;
	}

	public void setProductInfoDtoList(List<ProductInfoDTO> productInfoDtoList){
		this.productInfoDtoList = productInfoDtoList;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

	public int getSettlementFlag() {
		return settlementFlag;
	}

	public void setSettlementFlag(int settlementFlag) {
		this.settlementFlag = settlementFlag;
	}
}
