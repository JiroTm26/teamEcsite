package com.internousdev.espresso.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.espresso.dao.PurchaseHistoryInfoDAO;
import com.internousdev.espresso.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeletePurchaseHistoryAction extends ActionSupport implements SessionAware{
	private List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList;
	private Map<String, Object> session;
	public String execute() {
			/* セッションでloginFlgを取得 */
		String examLogined = String.valueOf(session.get("loginFlg"));
		int logined  = "null".equals(examLogined)? 0 : Integer.parseInt(examLogined);
		if(logined != 1) {
				return "loginError";
		}

		String result = ERROR;
			/* PurchaseHistoryInfoDAOをインスタンス化 */
		PurchaseHistoryInfoDAO purchaseHistoryInfoDAO = new PurchaseHistoryInfoDAO();

		int count = purchaseHistoryInfoDAO.deleteALL(String.valueOf(session.get("userId")));
		if(count > 0) {
			purchaseHistoryInfoDTOList = purchaseHistoryInfoDAO.getPurchaseHistoryList(String.valueOf(session.get("userId")));
			result = SUCCESS;
		}
		return result;
	}

	public List<PurchaseHistoryInfoDTO> getPurchaseHistoryInfoDTOList(){
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