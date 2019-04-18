package jp.cyrus;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Get feed test.
 *
 * @author cyrus
 */
public class GetFeedTest {

	/**
	 * main.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("System.currentTimeMillis : " + System.currentTimeMillis());

		// Get default instance
		TikTok4j tikTok4j = TikTok4j.getDefaultInstance();

		// Get feed data
		JsonNode response = tikTok4j.feed();
		System.out.println(response);
	}
}