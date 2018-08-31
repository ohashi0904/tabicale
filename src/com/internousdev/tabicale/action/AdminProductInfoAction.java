package com.internousdev.tabicale.action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.tabicale.dao.ProductInfoDAO;
import com.internousdev.tabicale.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;
public class AdminProductInfoAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
	public String execute(){


		//管理者ログインフラグの判定
		if(!(session.get("adminFlag").equals("1"))){
			return ERROR;
		}

		//全カート情報を取得します
		ProductInfoDAO productInfoDao = new ProductInfoDAO();
		productInfoDtoList = productInfoDao.getProductInfoListAll();

		Iterator<ProductInfoDTO> iterator = productInfoDtoList.iterator();
		if(!(iterator.hasNext())){
			productInfoDtoList = null;
		}
		session.put("productInfoDtoList", productInfoDtoList);

		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;
	}

	public Map<String,Object> getSession(){
		return session;
	}
}
