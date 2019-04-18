package jp.cyrus;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Login test.
 *
 * @author cyrus
 */
public class LoginTest {

	/**
	 * Email.
	 */
	private static final String EMAIL = "CHANGEME";

	/**
	 * Password.
	 */
	private static final String PASSWORD = "CHANGEME";

	/**
	 * main.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("System.currentTimeMillis : " + System.currentTimeMillis());

		// Get default instance
		TikTok4j tikTok4j = TikTok4j.getDefaultInstance();

		// Login
		JsonNode response = tikTok4j.loginWithEmail(EMAIL, PASSWORD);
		System.out.println(response);
	}
}