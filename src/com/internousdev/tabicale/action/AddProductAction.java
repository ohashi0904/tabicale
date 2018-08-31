package com.internousdev.tabicale.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.tabicale.dao.MCategoryDAO;
import com.internousdev.tabicale.dto.MCategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AddProductAction extends ActionSupport implements SessionAware{

	private int productId;
	private String productName;
	private String productNameKana;
	private String productDescription;
	private int categoryId;
	private int price;

	private String imageFilePath;
	private String imageFileName;
	private String imageFileName2;

	private File userImage;
	private File userImage2;

	private String releaseDate;
	private String releaseCompany;

	private Map<String,Object>session;

	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();


	public String execute(){
		String result = ERROR;

		//管理者ログインフラグの判定
		if(!(session.get("adminFlag").equals("1"))){
			return ERROR;
		}

		session.remove("productIdErrorMessageList");
		session.remove("productNameErrorMessageList");
		session.remove("productNameKanaErrorMessageList");
		session.remove("productDescriptionErrorMessageList");
		session.remove("categoryIdErrorMessageList");
		session.remove("priceErrorMessageList");

		session.remove("imageFilePathErrorMessageList");

		session.remove("releaseDateErrorMessageList");
		session.remove("releaseCompanyErrorMessageList");

		session.remove("identical_productNameErrorMessageList");
		session.remove("identical_productNameKanaErrorMessageList");

		session.remove("imageFileNameErrorMessageList1");
		session.remove("imageFileNameErrorMessageList2");


		//入力された値を保存する
		session.put("productId", productId);
		session.put("productName", productName);
		session.put("productNameKana", productNameKana);
		session.put("productDescription", productDescription);
		session.put("categoryId", categoryId);
		session.put("price", price);

		session.put("imageFilePath", imageFilePath);
		session.put("userImage", userImage);
		session.put("userImage2", userImage2);

		session.put("releaseDate", releaseDate);
		session.put("releaseCompany", releaseCompany);

		MCategoryDAO mCategoryDao = new MCategoryDAO();
		mCategoryDtoList = mCategoryDao.getMCategoryList();
		mCategoryDtoList.remove(0);
		session.put("mCategoryDtoList",  mCategoryDtoList);

		result = SUCCESS;
		return result;
	}

	public int getProductId(){
		return productId;
	}
	public void setProductId(int productId){
		this.productId = productId;
	}

	public String getProductName(){
		return productName;
	}
	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getProductNameKana(){
		return productNameKana;
	}
	public void setProductNameKana(String productNameKana){
		this.productNameKana = productNameKana;
	}

	public String getProductDescription(){
		return productDescription;
	}
	public void SetProductDescription(String productDescription){
		this.productDescription = productDescription;
	}

	public int getCategoryId(){
		return categoryId;
	}
	public void setCategoryId(int categoryId){
		this.categoryId = categoryId;
	}

	public int getPrice(){
		return price;
	}
	public void setPrice(int price){
		this.price = price;
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

	public String getImageFileName2(){
		return imageFileName2;
	}
	public void setImageFileName2(String imageFileName2){
		this.imageFileName2 = imageFileName2;
	}

	public File getUserImage(){
		return userImage;
	}
	public void setUserImage(File userImage){
		this.userImage = userImage;
	}

	public File getUserImage2(){
		return userImage2;
	}
	public void setUserImage2(File userImage2){
		this.userImage2 = userImage2;
	}

	public String getReleaseDate(){
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate){
		this.releaseDate = releaseDate;
	}

	public String getReleaseCompany(){
		return releaseCompany;
	}
	public void setReleaseCompany(String releaseCompany){
		this.releaseCompany = releaseCompany;
	}






	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object>session){
		this.session = session;
	}

}
