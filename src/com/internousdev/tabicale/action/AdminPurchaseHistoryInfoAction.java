package com.internousdev.tabicale.action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.tabicale.dao.PurchaseHistoryInfoDAO;
import com.internousdev.tabicale.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;
public class AdminPurchaseHistoryInfoAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDtoList = new ArrayList<PurchaseHistoryInfoDTO>();
	public String execute(){


		//管理者ログインフラグの判定
		if(!(session.get("adminFlag").equals("1"))){
			return ERROR;
		}


		//全カート情報を取得します
		PurchaseHistoryInfoDAO purchaseHistoryInfoDao = new PurchaseHistoryInfoDAO();
		purchaseHistoryInfoDtoList = purchaseHistoryInfoDao.getPurchaseHistoryInfoDtoListByAdmin();

		Iterator<PurchaseHistoryInfoDTO> iterator = purchaseHistoryInfoDtoList.iterator();
		if(!(iterator.hasNext())){
			purchaseHistoryInfoDtoList = null;
		}
		session.put("purchaseHistoryInfoDtoList", purchaseHistoryInfoDtoList);

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
