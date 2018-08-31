package com.internousdev.tabicale.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.tabicale.dao.DestinationInfoDAO;
import com.internousdev.tabicale.dto.DestinationInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminDestinationInfoAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private List<DestinationInfoDTO> destinationInfoDtoList = new ArrayList<DestinationInfoDTO>();
	public String execute() {

		//管理者ログインフラグの判定
		if(!(session.get("adminFlag").equals("1"))){
			return ERROR;
		}

		//全宛先情報を取得します
		DestinationInfoDAO destinationInfoDao = new DestinationInfoDAO();
		destinationInfoDtoList = destinationInfoDao.getDestinationInfoDtoListByAdmin();

		Iterator<DestinationInfoDTO> iterator =destinationInfoDtoList.iterator();
		if(!(iterator.hasNext())) {
			destinationInfoDtoList = null;
		}
		session.put("destinationInfoDtoList", destinationInfoDtoList);

		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動作成されたメソッドとスタブ
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

}
