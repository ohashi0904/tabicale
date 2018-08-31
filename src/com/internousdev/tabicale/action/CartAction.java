package com.internousdev.tabicale.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.tabicale.dao.CartInfoDAO;
import com.internousdev.tabicale.dao.MCategoryDAO;
import com.internousdev.tabicale.dto.CartInfoDTO;
import com.internousdev.tabicale.dto.MCategoryDTO;
import com.opensymphony.xwork2.ActionSupport;
public class CartAction extends ActionSupport implements SessionAware{

	private String categoryId;
	private String keywords;
	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
	private Map<String,Object> session;
	public String execute(){
		String result = ERROR;
		String userId= null;

		//エラーメッセージの初期化
		session.remove("checkListErrorMessageList");

		//ログインしていない場合に仮のユーザーIdを発行します
		CartInfoDAO cartInfoDao = new CartInfoDAO();
		List<CartInfoDTO> cartInfoDtoList = new ArrayList<CartInfoDTO>();
		if(session.containsKey("loginId")){
			userId = String.valueOf(session.get("loginId"));
		}else if(session.containsKey("tempUserId")){
			userId = String.valueOf(session.get("tempUserId"));
		}

		//ユーザーIDよりカート情報を全て取得します
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
		result = SUCCESS;

		//ヘッダー部分に表示するカテゴリリストのセッション切れ対策です
		if(!session.containsKey("mCategroyList")){
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryDtoList = mCategoryDao.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}

		return result;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
