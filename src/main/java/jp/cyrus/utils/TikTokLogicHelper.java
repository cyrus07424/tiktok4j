package jp.cyrus.utils;

import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * TikTok logic helper.
 *
 * @author cyrus
 */
public class TikTokLogicHelper {

	/**
	 * Encrypt string.<br>
	 * https://gist.github.com/szdc/1be2d33c535ff0e2acda5e57cc6008b0#file-musically-encrypt-js
	 *
	 * @param string
	 * @return
	 */
	public static String getEncryptedString(String string) {
		return string.chars().mapToObj(i -> Integer.toHexString(i ^ 5)).collect(Collectors.joining());
	}

	/**
	 * Server time(seconds).
	 *
	 * @return
	 */
	public static long getServerTime() {
		return System.currentTimeMillis() / 1000;
	}

	/**
	 * Get openudid.
	 *
	 * @return
	 */
	public static String getOpenudid() {
		return RandomStringUtils.random(16, "0123456789abcdef");
	}
}