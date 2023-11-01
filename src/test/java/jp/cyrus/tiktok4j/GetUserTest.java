package jp.cyrus.tiktok4j;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Get feed test.
 *
 * @author cyrus
 */
public class GetUserTest {

	/**
	 * User id.
	 */
	private static final long userId = 6654764350730928133L;

	/**
	 * main.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("System.currentTimeMillis : " + System.currentTimeMillis());

		// Get default instance
		TikTok4j tikTok4j = TikTok4j.getDefaultInstance();

		// Get user data
		JsonNode response = tikTok4j.user(userId);
		System.out.println(response);
	}
}