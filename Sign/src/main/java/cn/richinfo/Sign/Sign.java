package cn.richinfo.Sign;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName: Sign
 * @Description: 签名tool
 */
public class Sign {

	// 拼接参数字符串
	private static String concatParams(Map<String, Object> params) throws UnsupportedEncodingException {
		Object[] key_arr = params.keySet().toArray();
		Arrays.sort(key_arr);
		String str = "";
		for (Object key : key_arr) {
			if (key.equals("signature")) {
				continue;
			}
			String val = params.get(key).toString();
			key = URLEncoder.encode(key.toString(), "UTF-8");
			val = URLEncoder.encode(val, "UTF-8");
			str += "&" + key + "=" + val;
		}

		return str.replaceFirst("&", "");
	}

	// hex计算
	private static String byte2hex(byte[] b) {
		StringBuffer buf = new StringBuffer();
		int i;

		for (int offset = 0; offset < b.length; offset++) {
			i = b[offset];
			if (i < 0) {
				i += 256;
			}
			if (i < 16) {
				buf.append("0");
			}
			buf.append(Integer.toHexString(i));
		}

		return buf.toString();
	}

	// 获取签名
	public static String genSig(Map<String, Object> params, String consumerSecret)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		StringBuffer stringBuffer = new StringBuffer(concatParams(params));
		stringBuffer.append(consumerSecret);

		String str = stringBuffer.toString();
		System.out.println("生成签名前的字符串==>" + str);

		MessageDigest md = MessageDigest.getInstance("SHA1");
		String sig = byte2hex(md.digest(byte2hex(stringBuffer.toString().getBytes("UTF-8")).getBytes()));
		System.out.println("生成签名后的字符串==>" + sig);
		return sig;
	}

	// 获取签名
	public static String getSign(String str) {
		String sign = "";
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			if (StringUtils.isNotEmpty(str)) {
				String[] array = str.split("&");
				for (String string : array) {
					String[] param = string.split("=");
					params.put(param[0], param[1]);
				}
			}
			sign = genSig(params, "L7Fs2r405Jwu98dOB3O81s0BZq1q03e2");
		} catch (Exception e) {
			System.out.println("签名错误,输入参数异常!");
		}
		return sign;
	}

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入需要加密的字符串,示例(name=123&age=456)");
			String str = sc.nextLine(); // 读取字符串型输入
			Map<String, Object> params = new HashMap<String, Object>();
			if (StringUtils.isNotEmpty(str)) {
				String[] array = str.split("&");
				for (String string : array) {
					String[] param = string.split("=");
					params.put(param[0], param[1]);
				}
			}
			genSig(params, "L7Fs2r405Jwu98dOB3O81s0BZq1q03e2");
		} catch (Exception e) {
			System.out.println("签名错误,输入参数异常!");
		}
	}

}
