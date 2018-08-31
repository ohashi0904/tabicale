package com.internousdev.tabicale.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.tabicale.dao.CartInfoDAO;
import com.internousdev.tabicale.dto.CartInfoDTO;
import com.internousdev.tabicale.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class AddCartAction extends ActionSupport implements SessionAware{

	private int productId;
	private String productName;
	private String productNameKana;
	private String imageFilePath;
	private String imageFileName;
	private int price;
	private String productCount;
	private String releaseCompany;
	private Date releaseDate;
	private String productDescription;
	private String checkRandomId;

	private String categoryId;

	private Map<String, Object> session;

	public String execute(){
		String result = ERROR;
		String userId = null;
		String tempUserId = null;

		//ログインせず、仮ユーザーIDも発行されていない場合に仮ユーザIDを発行します
		if(!(session.containsKey("loginId")) && !(session.containsKey("tempUserId"))){
			CommonUtility commonUtility = new CommonUtility();
			session.put("tempUserId", commonUtility.getRandomValue());
		}

		//ログインしている場合
		if(session.containsKey("loginId")){
			userId = String.valueOf(session.get("loginId"));
		}

		//ログインせず、仮ユーザーIDが発行されている場合
		if(!(session.containsKey("loginId")) && session.containsKey("tempUserId")){
			userId = String.valueOf(session.get("tempUserId"));
			tempUserId = String.valueOf(session.get("tempUserId"));
		}

		System.out.println(userId+"userId");
		System.out.println(tempUserId+"tempUserId");
		//カートに入れる個数を数字だけのデータにします
		productCount = String.valueOf((productCount.split(" ,",0))[0]);
		System.out.println(productCount);

		//データベースにカート情報を追加します
		//更新ボタンを押した場合は無効です
		CartInfoDAO cartInfoDao = new CartInfoDAO();
		if(String.valueOf(session.get("checkRandomId")).equals(checkRandomId)){
			int count = cartInfoDao.regist(userId, tempUserId, productId, productCount, price);
			if(count > 0){
				session.remove("checkRandomId");
				result = SUCCESS;
			}
		}else{
			result = SUCCESS;
		}


		//カート画面に遷移するので現在のカート情報を取得します
		List<CartInfoDTO> cartInfoDtoList = new ArrayList<CartInfoDTO>();
		cartInfoDtoList = cartInfoDao.getCartInfoDtoList(userId);

		//カートが空だったのか判断します
		Iterator<CartInfoDTO> iterator = cartInfoDtoList.iterator();
		if(!(iterator.hasNext())){
			cartInfoDtoList = null;
		}
		session.put("cartInfoDtoList", cartInfoDtoList);

		//カート内の合計金額を取得します
		int totalPrice = Integer.parseInt(String.valueOf(cartInfoDao.getTotalPrice(userId)));
		session.put("totalPrice", totalPrice);

		//エラーメッセージの初期化
		session.remove("checkListErrorMessageList");

		return result;
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductNameKana() {
		return productNameKana;
	}
	public void setProductNameKana(String productNameKana) {
		this.productNameKana = productNameKana;
	}
	public String getImageFilePath() {
		return imageFilePath;
	}
	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public String getProductCount() {
		return productCount;
	}
	public void setProductCount(String productCount) {
		this.productCount = productCount;
	}
	public String getReleaseCompany() {
		return releaseCompany;
	}
	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getCheckRandomId(){
		return checkRandomId;
	}

	public void setCheckRandomId(String checkRandomId){
		this.checkRandomId = checkRandomId;
	}
}
