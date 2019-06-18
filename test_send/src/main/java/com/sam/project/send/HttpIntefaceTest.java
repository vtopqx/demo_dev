package com.sam.project.send;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.kit.HttpKit;

import net.sf.json.JSONObject;


public class HttpIntefaceTest {
	
	private static String getTokenTest(){
		//调用示例
//        String token = HttpRequest.post("http://localhost:8080/rcsoaplus-gateway/message/token?app_key=153&app_secret=L7Fs2r405Jwu98dOB3O81s0BZq1q03e2&sdk_from=java&timestamp=20171201121229")
//                .execute().body();
        
		String appKey = "153";
		String appSecret = "L7Fs2r405Jwu98dOB3O81s0BZq1q03e2";
		String sdkFrom = "java";
		String timestamp = "20171201121229";
		String signature = "111111";
		
        String requestUrl = "http://localhost:8080/rcsoaplus-gateway/";
        String interfaceUrl = "message/token";
        String sendUrl = requestUrl + interfaceUrl + "?"
        		+"&app_key="+appKey
        		+"&app_secret="+appSecret
        		+"&sdk_from="+sdkFrom
        		+"&timestamp="+timestamp
        		+"&signature="+signature;
        
        
        String url = "http://localhost:8080/rcsoaplus-gateway/message/token?app_key=153&app_secret=L7Fs2r405Jwu98dOB3O81s0BZq1q03e2&sdk_from=java&timestamp=20171201121229";
        
        JSONObject postData = new JSONObject();
		postData.put("app_key", "153");
		postData.put("app_secret", "L7Fs2r405Jwu98dOB3O81s0BZq1q03e2");
		postData.put("sdk_from", "java");
		postData.put("timestamp", "20171201121229");
		postData.put("signature", "111111");
		String resultData = null;
		try {
			resultData = HttpKit.post(sendUrl, postData.toString());
		} catch (Exception e) {
			System.out.println("调用Token接口过程异常，异常信息：" + e.getMessage());
			e.printStackTrace();
		}
        return resultData;
	}
	

	private static String sendMessage(String token){
		//调用示例
//        String result = HttpRequest.post("http://localhost:8080/rcsoaplus-gateway/message/send?app_key=153&access_token="+token+"&sender_address=125600400000044&title=46&text=3333&timestamp=20171201121439&sdk_from=java&enterprise_id=36301&contact_ids=2276119,2291499,2276158")
//                .execute().body();
        return null;
	}

    public static void main(String[] args) {
        
        String token = getTokenTest();
        System.out.println("token:"+token);
//        String result = sendMessage("MjAxNzEyMDExODI5MTIzMCtBY2NUb2tlbitMRm5SQ0pqRGxaZGNBcnlReU9VWQ==");
//        System.out.println("result:"+result);
        
        
    }
}
