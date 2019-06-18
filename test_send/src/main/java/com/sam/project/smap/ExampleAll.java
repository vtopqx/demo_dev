package com.sam.project.smap;

import junit.framework.Assert;

import com.siemens.ct.its.smap.common.constants.ReturnCode;
import com.siemens.ct.its.smap.common.exception.SmapAuthenticateTypeNotSatisfied;
import com.siemens.ct.its.smap.common.exception.SmapAuthenticateUserBySessionIdException;
import com.siemens.ct.its.smap.common.exception.SmapFingerPrintException;
import com.siemens.ct.its.smap.common.exception.SmapTicketException;
import com.siemens.ct.its.smap.common.exception.SmapUserException;
import com.siemens.ct.its.smap.sso2.common.model.SessionDataBall;
import com.siemens.ct.its.smap.sso2.common.model.TicketBall;
import com.siemens.ct.its.smap2.client.XSmap2Client;
import com.siemens.ct.its.smap2.client.XSmap2ClientFactory;
import com.siemens.ct.its.smap2.client.XSmapClientLogger;

public class ExampleAll {
	String localAppId;
	String authenticateUrls;
	boolean ticketCache = true;

	/**
	 * 开启客户端日志输入出至控台（SYSTEM.OUT）。
	 */
	public static void enableDebugToSystemOut() {
		XSmapClientLogger.isDebug = true;
	}

	/**
	 * 开启客户端日志，按照LOG4J配置输出，LOG4J配置参见siemens-smap-client-3.x.x.jar中log4j.
	 * properties。 注：1.需要将jar内的配置放入项目的log4j配置文件中 2.需要log4j相关jar包
	 */
	public static void enableDebugToLog4j() {
		XSmap2ClientFactory.setLog4jClientLogger("smapClientLogger");
	}

	/**
	 * 初始化客户端,默认配置：ticketCache = true,缓存ticket;timeOut = 10000L,客户端访问超时时间为10s.
	 * 
	 * @return
	 */
	public XSmap2Client getClient() {
		return XSmap2ClientFactory.getInstance(localAppId, authenticateUrls);
	}

	/**
	 * 初始化客户端：设置客户端是否对ticket进行缓存
	 * 
	 * @param ticketCache
	 * @return
	 */
	public XSmap2Client getClientCacheTicket(boolean ticketCache) {
		return XSmap2ClientFactory.getInstance(localAppId, authenticateUrls, ticketCache);
	}

	/**
	 * 初始化客户端：设置客户端是否对ticket进行缓存和客户端与服务段访问超时时间
	 * 
	 * @param timeOut
	 * @param ticketCache
	 * @return
	 */
	public XSmap2Client getClientSettingTimeout(long timeOut, boolean ticketCache) {
		return XSmap2ClientFactory.getInstance(localAppId, authenticateUrls, ticketCache, timeOut);
	}

	/**
	 * SSO 接收方： 认证会话数据，并获取用户uid
	 * 
	 * @param sessionData
	 * @return SSO UID
	 * @throws SmapAuthenticateUserBySessionIdException
	 * @throws SmapAuthenticateTypeNotSatisfied
	 */
	public String userLoginBySessionData(String sessionData)
			throws SmapAuthenticateUserBySessionIdException, SmapAuthenticateTypeNotSatisfied {
		XSmap2Client client = getClient();
		if (client != null) {
			System.out.println("-------accessApplication: " + sessionData);
			TicketBall tb = client.accessApplication(sessionData);

			String uid = tb.getTicket().getUid().toLowerCase();
			// GET MORE INFO OF THE USER IN THE TICKET
			// tb.getTicket().getDisplayName()
			// .....

			return uid;
		} else {
			return "Client Init Error";
		}
	}

	/**
	 * 通过静态密码出发动态密码
	 * 
	 * @param uid
	 * @param password
	 * @return
	 */
	public String triggerOtpByPassword(String uid, String password) {
		XSmap2Client client = getClient();
		int result = client.triggerOtpByPassword(uid, password);
		return "TriggerOtp return Message:" + ReturnCode.translate(result);
	}

	/**
	 * 动态／静态密码认证
	 * 
	 * @param uid
	 * @param password
	 *            [password | otp(动态密码)]
	 * @param authType
	 *            [static(静态密码) | dynamic(动态密码)]
	 * @return
	 */
	public String userLoginByPassword(String uid, String password, String authType) {
		XSmap2Client client = getClient();
		int result = -1;
		if (client != null) {
			if (authType.equalsIgnoreCase("static"))
				result = client.authenticateUserByPassword(uid, password);
			else
				result = client.authenticateUserByOtp(uid, password);
		}
		if (result == ReturnCode.OK) {
			return "Auth User Error,Error Message" + ReturnCode.translate(result);
		}
		return "Client Init Error";
	}

	/**
	 * 
	 * @param uid
	 * @param deivceId
	 * @param fingerPrintData
	 * @return
	 */
	public String userLoginByFingerPrint(String uid, String deviceId, String fingerPrintData) {
		XSmap2Client client = getClient();
		int result = -1;
		if (client != null) {
			try {
				result = client.authenticationUserByFingerPrint(deviceId, uid, fingerPrintData);
			} catch (SmapFingerPrintException e) {
				/**
				 * 认证异常
				 */
				e.printStackTrace();
				return e.getMessage();
			}
		}
		if (result == ReturnCode.OK) {
			return "Auth User Error,Error Message" + ReturnCode.translate(result);
		}
		return "Client Init Error";
	}

	/**
	 * SSO发起方，获取会话数据
	 * 
	 * @param uid
	 * @param remoteAppId
	 *            [remote application]
	 * @return SSO SESSION DATA, post/get the session data to the remote
	 *         application.
	 */
	public String getSSOSessionData(String uid, String remoteAppId) {
		XSmap2Client client = getClient();
		byte[] ticket = null;
		SessionDataBall sessionData = null;
		try {
			ticket = client.acquireTicketByUid(uid);
		} catch (SmapUserException e) {
			e.printStackTrace();
		}
		Assert.assertNotNull(ticket);
		try {
			sessionData = client.acquireSessionDataTicket(ticket, remoteAppId);
		} catch (SmapTicketException e) {
			e.printStackTrace();
		}
		System.out.println(sessionData.getSessionData());
		return sessionData.getSessionData();
	}

	/**
	 * 根据返回代码，获取返回码对应错误信息。
	 * 
	 * @param code
	 * @return
	 */
	public String getReturnMessageByCode(int code) {
		return ReturnCode.translate(code);
	}

}
