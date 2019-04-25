package jp.cyrus.tiktok4j;

import com.fasterxml.jackson.databind.JsonNode;

import jp.cyrus.tiktok4j.impl.TikTok4jTikTokImpl;
import jp.cyrus.tiktok4j.signingServices.impl.TikTok4jSigningService;

/**
 * Get feed test.
 *
 * @author cyrus
 */
public class TikTok4jTikTokImplGetFeedTest {

	/**
	 * main.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("System.currentTimeMillis : " + System.currentTimeMillis());

		// Get instance
		TikTok4j tikTok4j = new TikTok4jTikTokImpl(new TikTok4jSigningService());

		// Get feed data
		JsonNode response = tikTok4j.feed();
		System.out.println(response);
	}
}