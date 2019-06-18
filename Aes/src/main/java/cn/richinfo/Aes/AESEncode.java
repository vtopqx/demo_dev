package cn.richinfo.Aes;

import java.security.SecureRandom;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class AESEncode {

	/**
	 * AES加密
	 * <p>
	 * add by CJ 2018年4月25日
	 * </p>
	 * 
	 * @param encodeRules
	 *            加密规则（初始化秘钥生成器）
	 * @param content
	 * @return
	 */
	public static String AESEncode(String encodeRules, String content) {
		try {
			KeyGenerator keygen = KeyGenerator.getInstance("AES");
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			random.setSeed(encodeRules.getBytes());
			keygen.init(128, random);
			SecretKey original_key = keygen.generateKey();
			byte[] raw = original_key.getEncoded();
			SecretKey key = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] byte_encode = content.getBytes("utf-8");
			byte[] byte_AES = cipher.doFinal(byte_encode);
			String AES_encode = new String(Base64.encodeBase64String(byte_AES));
			return AES_encode;
		} catch (Exception e) {
			System.out.println("AESEncode error : " + e.getMessage());
		}
		return null;
	}

	/**
	 * AES解密
	 * <p>
	 * add by CJ 2018年4月25日
	 * </p>
	 * 
	 * @param encodeRules
	 *            解密规则（同加密规则）
	 * @param content
	 * @return
	 */
	public static String AESDncode(String encodeRules, String content) {
		try {
			KeyGenerator keygen = KeyGenerator.getInstance("AES");
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			random.setSeed(encodeRules.getBytes());
			keygen.init(128, random);
			SecretKey original_key = keygen.generateKey();
			byte[] raw = original_key.getEncoded();
			SecretKey key = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] byte_content = Base64.decodeBase64(content);
			byte[] byte_decode = cipher.doFinal(byte_content);
			String AES_decode = new String(byte_decode, "utf-8");
			return AES_decode;
		} catch (Exception e) {
			System.out.println("AESDncode error : " + e.getMessage());
		}
		return null;
	}

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("是否使用默认密钥? Y or N");
		System.out.println();
		String isOk = sc1.nextLine(); // 读取字符串型输入
		String secret = "ba327bca4fa15b0b0f4207d1bc13def4";
		if ("N".equals(isOk.trim().toUpperCase())) {
			System.out.print("输入加密密钥：");
			secret = sc1.nextLine(); // 读取字符串型输入
		}
		while (true) {
			System.out.println("当前使用密钥："+secret);
			System.out.println("当前时间戳："+System.currentTimeMillis());
			System.out.println();
			
			Scanner sc2 = new Scanner(System.in);
			System.out.print("输入待加密参数：");
			String data = sc2.nextLine(); // 读取字符串型输入
			String code = AESEncode.AESEncode(secret,data);
			System.out.println("加密后字符串：" + code);
			System.out.println();
		}
	}

}
