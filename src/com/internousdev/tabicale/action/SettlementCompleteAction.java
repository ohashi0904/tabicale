package com.internousdev.tabicale.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.tabicale.dao.CartInfoDAO;
import com.internousdev.tabicale.dao.PurchaseHistoryInfoDAO;
import com.internousdev.tabicale.dto.CartInfoDTO;
import com.internousdev.tabicale.dto.DestinationInfoDTO;
import com.internousdev.tabicale.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementCompleteAction extends ActionSupport implements SessionAware {

	private String id;
	private String categoryId;
	private Map<String, Object> session;
	private Collection<String> checkList;
	private String productId;
	private String productName;
	private String productNameKana;
	private String imageFilePath;
	private String imageFileName;
	private String price;
	private String releaseDate;
	private String releaseCompany;
	private String productCount;
	private String subtotal;

	public String execute() {
		String result = ERROR;

		@SuppressWarnings("unchecked")
		ArrayList<PurchaseHistoryInfoDTO> purchaseHistoryInfoDtoList =
			(ArrayList<PurchaseHistoryInfoDTO>)session.get("purchaseHistoryInfoDtoList");
		@SuppressWarnings("unchecked")
		ArrayList<DestinationInfoDTO> destinationInfoDtoList =
			(ArrayList<DestinationInfoDTO>)session.get("destinationInfoDtoList");
		for(int i=0;i<purchaseHistoryInfoDtoList.size();i++) {
			purchaseHistoryInfoDtoList.get(i).setDestinationId(destinationInfoDtoList.get(0).getId());
		}

		PurchaseHistoryInfoDAO purchaseHistoryInfoDAO = new PurchaseHistoryInfoDAO();
		int count = 0;
		for(int i=0; i<purchaseHistoryInfoDtoList.size();i++) {
			count += purchaseHistoryInfoDAO.regist (
					String.valueOf(session.get("loginId")),
					purchaseHistoryInfoDtoList.get(i).getProductId(),
					purchaseHistoryInfoDtoList.get(i).getProductCount(),
					Integer.valueOf(id),
					purchaseHistoryInfoDtoList.get(i).getSubtotal()
					);
		}

		if(count > 0) {
			CartInfoDAO cartInfoDAO = new CartInfoDAO();
			count = cartInfoDAO.deleteAll(String.valueOf(session.get("loginId")));
			if(count > 0) {
				List<CartInfoDTO> cartInfoDtoList = new ArrayList<CartInfoDTO>();
				cartInfoDtoList = cartInfoDAO.getCartInfoDtoList(String.valueOf(session.get("loginId")));
				Iterator<CartInfoDTO> iterator = cartInfoDtoList.iterator();
				if(!(iterator.hasNext())) {
					cartInfoDtoList = null;
				}
				session.put("cartInfoDtoList", cartInfoDtoList);

				int totalPrice = Integer.parseInt(String.valueOf(cartInfoDAO.getTotalPrice(String.valueOf(session.get("loginId")))));
				session.put("totalPrice", totalPrice);
				result = SUCCESS;
			}
		}
		return result;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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


	public String getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}


	public String getReleaseCompany() {
		return releaseCompany;
	}


	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
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