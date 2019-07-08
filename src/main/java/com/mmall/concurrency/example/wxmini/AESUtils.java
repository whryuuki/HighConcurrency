package com.mmall.concurrency.example.wxmini;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.Security;

/**
 * @author Lion Li
 * @version 2019-4-19
 */
public class AESUtils {
	public static volatile boolean initialized = false;

	/**
	 * AES解密
	 * @param content 密文
	 */
	public static byte[] decrypt(byte[] content, byte[] keyByte, byte[] ivByte) throws InvalidAlgorithmParameterException {
		initialize();
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
			Key sKeySpec = new SecretKeySpec(keyByte, "AES");
			// 初始化
			cipher.init(Cipher.DECRYPT_MODE, sKeySpec, generateIV(ivByte));
			return cipher.doFinal(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void initialize() {
		if (initialized)
			return;
		Security.addProvider(new BouncyCastleProvider());
		initialized = true;
	}

	/**
	 * 生成iv
	 *
	 * @param iv
	 * @throws Exception
	 */
	public static AlgorithmParameters generateIV(byte[] iv) throws Exception {
		AlgorithmParameters params = AlgorithmParameters.getInstance("AES");
		params.init(new IvParameterSpec(iv));
		return params;
	}

}