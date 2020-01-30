package com.internousdev.espresso.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.espresso.dao.PurchaseHistoryInfoDAO;
import com.internousdev.espresso.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

	//商品購入履歴テーブルを操作するDAO
public class PurchaseHistoryAction extends ActionSupport implements SessionAware {
	//「商品情報テーブル」と「カート情報テーブル」から、『宛先ID,ユーザーID,商品ID、個数』を、商品購入履歴テーブルに保存する。（各テーブルに対応したDAOを利用する）

	private List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList;
	private Map<String, Object> session;

	public String execute() {
		String examLogined = String.valueOf(session.get("loginFlg"));
		int logined = "null".equals(examLogined)? 0 : Integer.parseInt(examLogined);
		if(logined != 1) {
				return "loginError";
		}
			/* PurchaseHistoryInfoDAOをインスタンス化 */
		PurchaseHistoryInfoDAO purchaseHistoryInfoDAO = new PurchaseHistoryInfoDAO();
		purchaseHistoryInfoDTOList = purchaseHistoryInfoDAO.getPurchaseHistoryList(String.valueOf(session.get("userId")));

		return SUCCESS;
	}

	public List<PurchaseHistoryInfoDTO> getPurchaseHistoryInfoDTOList() {
		return purchaseHistoryInfoDTOList;
	}

	public void setPurchaseHistoryInfoDTOList(List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList) {
		this.purchaseHistoryInfoDTOList = purchaseHistoryInfoDTOList;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}