package com.sam.project.send;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfinal.kit.HttpKit;

import net.sf.json.JSONObject;

/**
 * 融合通信Token管理
 * 
 * @author luowu
 *
 */
public class RcsAccessTokenUtils {


	/** 保存Token **/
	private static RcsAccessToken rcsAccessToken = null;

	/**
	 * 获取Token地址
	 */
	private static String GET_TOKEN_URL = null;
	private static String APP_ID = null;
	private static String APP_PASSWORD = null;
	
	//test
	public static void main(String[] args) {
		
		RcsAccessToken a = new RcsAccessToken();
		
		System.out.println("开始调用...");
		String token = getAccessToken();
		System.out.println(token);
	}

	static {
		// GET_TOKEN_URL = PropertiesUtils.getProperties("GET_TOKEN_URL");
		// APP_ID = PropertiesUtils.getProperties("APP_ID");
		// APP_PASSWORD = PropertiesUtils.getProperties("APP_PASSWORD");

		GET_TOKEN_URL = "http://120.197.90.58:9080/services/OauthAPIV1/token";
//		GET_TOKEN_URL = "http://117.136.180.220:8080/services/OauthAPIV1/token";
		APP_ID = "26";
		APP_PASSWORD = "OE1262Q22z2x9Po95Q5721XPf0qr34R9";
	}

	/**
	 * 获取Token，36000s内有效
	 * 
	 * @return
	 */
	public static String getAccessToken() {
		Date now = new Date();
		if (rcsAccessToken == null || now.after(rcsAccessToken.getExpiresTime())) {
			refreshAccessToken();
		}
		return rcsAccessToken.getToken();
	}

	@SuppressWarnings("all")
	public static void refreshAccessToken() {
		RcsAccessToken token = null;
		String accessToken = null;
		JSONObject postData = new JSONObject();
		postData.put("app_id", APP_ID);
		postData.put("app_password", APP_PASSWORD);
		postData.put("grant_type", "client_credentials");
		postData.put("redirect_uri", "https://client.example.com/cb");
//		postData.put("state ", "20170104012100123456789");
//		postData.put("state ", "20171124012100123456789");

		/**
		 * { "ResultCode": "0", "access_token":
		 * "MjAxNzAxMDYxNjM2MTk4MytBY2NUb2tlbitZaWZtb0daOWRSRzRnbU5aUm1NeQ==",
		 * "token_type": "bearer", "expires_in": "36000" }
		 */
		String resultData = null;
		try {
			resultData = HttpKit.post(GET_TOKEN_URL, postData.toString());
		} catch (Exception e) {
			System.out.println("调用Token接口过程异常，异常信息：" + e.getMessage());
			e.printStackTrace();
		}

		// logger.info("return:"+resultData);
		if (StringUtils.isNotEmpty(resultData)) {
			try {
				Map map = new ObjectMapper().readValue(resultData, Map.class);
				if (map != null && map.get("ResultCode") != null) {
					String resultCode = (String) map.get("ResultCode");
					if (StringUtils.isNotEmpty(resultCode) && "0".equalsIgnoreCase(resultCode)) {
						token = new RcsAccessToken();
						accessToken = (String) map.get("access_token");
						token.setToken(accessToken);
					}
				}
			} catch (Exception e) {
				System.out.println("解析获取Token接口的返回信息异常，异常信息：" + e.getMessage());
				e.printStackTrace();
			}
		}
		rcsAccessToken = token;
	}

}
