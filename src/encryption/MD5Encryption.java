package encryption;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//https://stackoverflow.com/questions/5494447/what-will-be-the-android-java-equivalent-of-md5-function-in-php
public class MD5Encryption {
	public static String md5(String passphrase){
		byte[] hash;

		try {
			hash = MessageDigest.getInstance("MD5").digest(passphrase.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("MD5 isn't supported.", e);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("UTF-8 isn't supported.", e);
		}

		StringBuilder hex = new StringBuilder(hash.length * 2);

		for (byte b : hash) {
			int i = (b & 0xFF);
			if (i < 0x10)
				hex.append('0');
			hex.append(Integer.toHexString(i));
		}

		return hex.toString();
	}
}
