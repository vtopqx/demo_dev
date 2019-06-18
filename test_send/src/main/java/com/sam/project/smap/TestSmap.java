package com.sam.project.smap;

import com.siemens.ct.its.smap.common.model.AuthenticateSsoCenterStore;
import com.siemens.ct.its.smap.sso2.common.model.SessionDataBall;
import com.siemens.ct.its.smap2.client.XSmap2Client;
import com.siemens.ct.its.smap2.client.XSmap2ClientFactory;

/**
 * @ClassName: TestSmap
 * @Description: 测试获取SessionData
 * @author mqx
 * @date 2018年4月26日 下午6:15:25
 */
public class TestSmap {

	public static final String mobile = "13928915271";
	public static final String REMOTE_APP_ID = "MOAZQ@HQ.CMCC";// moa
	//smap地址(测试)
	public static final String smapUrl = "https://nfjdres.wmp51.com/tailor/AjtmoaP/http://eip.hq.cmcc/interface/rcs/sso.do";

	public static void main(String[] args) {
		String sessionData = getSSOSessionDataTryThreeTimes(mobile, REMOTE_APP_ID);
		System.out.println("sessionData:" + sessionData);
	}

	/**
	 * 获取SessionData，并在接口问题时尝试三次。
	 * 
	 * @param mobile
	 * @param remoteAppId
	 * @return
	 */
	private static String getSSOSessionDataTryThreeTimes(String mobile, String remoteAppId) {
		int i = 0;
		String sessionData = null;
		while (i < 3 && sessionData == null) {
			sessionData = getSSOSessionData(mobile, remoteAppId);
			if (sessionData != null && sessionData.length() > 0) {
				break;
			}
			System.out.println("SMAP接口异常");
			i++;
		}
		return sessionData;
	}

	/**
	 * SSO发起方，获取会话数据
	 * 
	 * @param mobile
	 * @return SSO SESSION DATA, post/get the session data to the remote
	 *         application.
	 */
	private static String getSSOSessionData(String mobile, String remoteAppId) {
		String seData = "";
		byte[] ticket = null;
		SessionDataBall sessionData = null;
		try {
			XSmap2Client client = XSmap2ClientFactory.getInstance("RCS@HQ.CMCC", smapUrl, true, 1000);
			ticket = client.acquireTicketByMobile(mobile);
			sessionData = client.acquireSessionDataTicket(ticket, remoteAppId);
			if (null != seData)
				seData = sessionData.getSessionData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return seData;
	}

}
