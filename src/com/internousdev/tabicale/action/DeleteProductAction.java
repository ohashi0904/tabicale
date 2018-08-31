package com.internousdev.tabicale.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.tabicale.dao.CartInfoDAO;
import com.internousdev.tabicale.dao.ProductInfoDAO;
import com.internousdev.tabicale.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteProductAction extends ActionSupport implements SessionAware{
private int productId;
List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
private Map<String, Object> session;


public String execute(){
	String result = ERROR;
	ProductInfoDAO dao = new ProductInfoDAO();
	CartInfoDAO cartInfoDao = new CartInfoDAO();
	int count = dao.delete(productId);
	count += cartInfoDao.deleteByProductId(String.valueOf(productId));
	if(count > 0){
		productInfoDtoList = dao.getProductInfoListAll();
		session.put("productInfoDtoList", productInfoDtoList);
		result = SUCCESS;
	}
	return result;
}

public int getProductId(){
	return productId;
}

public void setProductId(int productId){
	this.productId = productId;
}

public Map<String, Object> getSession(){
	return session;
}

public void setSession(Map<String, Object> session){
	this.session = session;
}
}
