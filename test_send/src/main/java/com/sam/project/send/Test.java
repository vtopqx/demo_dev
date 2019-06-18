package com.sam.project.send;

import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
public class Test {


	/**
	 * 获取Token地址
	 */
	private static String GET_TOKEN_URL = null;
	private static String APP_ID = null;
	private static String APP_PASSWORD = null;
	
	//test
	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString());
		System.out.println(UUID.randomUUID().toString().length());
		System.out.println("开始调用...");
		getAccessToken();
	}

	static {
		GET_TOKEN_URL = "https://api1.cytxl.com.cn/enterprise/getItem.json";
	}

	/**
	 * 获取Token，36000s内有效
	 * 
	 * @return
	 */
	public static void getAccessToken() {
		String msg = refreshAccessToken();
		System.out.println("msg:"+msg);
	}

	@SuppressWarnings("all")
	public static String refreshAccessToken() {
		String accessToken = null;
		
		JSONObject postData = new JSONObject();
		postData.put("app_key", "67650d7a5712f5ce0d54e80c9399a9ac");
		postData.put("channel", "mcontact_api_qytxl_datain_RCSchuangxinpt");
		postData.put("contactId", "2276119");
		postData.put("enterpriseId", "36301");
		postData.put("once ", "080333213468");
		postData.put("operator ", "8G5GE1Q2p79Sgc2Q0DfyMQ==");
		postData.put("sdk_from ", "java");
		postData.put("signature ", "497dd621e41ad4a1e55a8ba6e522d0e41c8dcf0a");
		postData.put("version ", "1.0");

		/**
		 * { "ResultCode": "0", "access_token":
		 * "MjAxNzAxMDYxNjM2MTk4MytBY2NUb2tlbitZaWZtb0daOWRSRzRnbU5aUm1NeQ==",
		 * "token_type": "bearer", "expires_in": "36000" }
		 */
		String resultData = null;
		try {
			resultData = HttpKit.post(GET_TOKEN_URL, postData.toString());
			System.out.println("resultData:"+resultData);
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
						accessToken = (String) map.get("access_token");
					}
				}
			} catch (Exception e) {
				System.out.println("解析获取Token接口的返回信息异常，异常信息：" + e.getMessage());
				e.printStackTrace();
			}
		}
		return resultData;
	}

}
