package com.internousdev.tabicale.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.tabicale.dao.CartInfoDAO;
import com.internousdev.tabicale.dto.CartInfoDTO;
import com.internousdev.tabicale.dto.MCategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteCartAction extends ActionSupport implements SessionAware{

	private Collection<String> checkList;
	private String categoryId;
	private String productId;

	/*
	private String sex;
	private List<String> sexList = new ArrayList<String>();
	private static final String MALE = "男性";
	private static final String FEMALE = "女性";
	private String defaultSexValue = MALE;
	*/

	private String productName;
	private String productNameKana;
	private String imageFilePath;
	private String imageFileName;
	private String price;
	private String releaseCompany;
	private String releaseDate;
	private String productCount;
	private String subtotal;
	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();

	private Map<String,Object> session;

	public String execute(){
		String result = ERROR;
		String userId = null;

		//チェックリストの値を検証し処理を分岐させます
		//チェックリストの値は配列[cartId,cartId,cartId]のような形式です
		System.out.println(checkList);
		CartInfoDAO cartInfoDao = new CartInfoDAO();
		int count = 0;
		List<String> checkListErrorMessageList = new ArrayList<String>();

		//削除した後のカート情報を取得します
		if(session.containsKey("loginId")){
			userId = String.valueOf(session.get("loginId"));
		}else if(session.containsKey("tempUserId")){
			userId = String.valueOf(session.get("tempUserId"));
		}

		//チェックがされていない場合にエラーでカート画面に遷移します
		if(checkList==null){
			checkListErrorMessageList.add("チェックされていません");
			session.put("checkListErrorMessageList", checkListErrorMessageList);
			return ERROR;
		}

		for(String productId:checkList){
			count += cartInfoDao.delete(productId,userId);
		}

		//カートの商品情報のデリートが実行されているか確認します
		if(count <= 0){
			//1件も実行なし
			checkListErrorMessageList.add("チェックされていません");
			session.put("checkListErrorMessageList", checkListErrorMessageList);
			return ERROR;
		}else{
			//1件以上実行あり
			List<CartInfoDTO> cartInfoDtoList = new ArrayList<CartInfoDTO>();

			cartInfoDtoList = cartInfoDao.getCartInfoDtoList(userId);
			Iterator<CartInfoDTO> iterator = cartInfoDtoList.iterator();
			if(!(iterator.hasNext())){
				cartInfoDtoList = null;
			}
			session.put("cartInfoDtoList", cartInfoDtoList);

			//削除した後の合計金額を取得します
			int totalPrice = Integer.parseInt(String.valueOf(cartInfoDao.getTotalPrice(userId)));
			session.put("totalPrice", totalPrice);

			/*
			sexList.add(MALE);
			sexList.add(FEMALE);
			*/

			//エラーメッセージの初期化
			session.remove("checkListErrorMessageList");

			result = SUCCESS;
		}
		return result;
	}

	public List<MCategoryDTO> getmCategoryDtoList() {
		return mCategoryDtoList;
	}

	public void setmCategoryDtoList(List<MCategoryDTO> mCategoryDtoList) {
		this.mCategoryDtoList = mCategoryDtoList;
	}

	/*
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<String> getSexList() {
		return sexList;
	}

	public void setSexList(List<String> sexList) {
		this.sexList = sexList;
	}

	public String getDefaultSexValue() {
		return defaultSexValue;
	}

	public void setDefaultSexValue(String defaultSexValue) {
		this.defaultSexValue = defaultSexValue;
	}

	*/

	public Collection<String> getCheckList() {
		return checkList;
	}

	public void setCheckList(Collection<String> checkList) {
		this.checkList = checkList;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getReleaseCompany() {
		return releaseCompany;
	}

	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getProductCount() {
		return productCount;
	}

	public void setProductCount(String productCount) {
		this.productCount = productCount;
	}

	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}
}
