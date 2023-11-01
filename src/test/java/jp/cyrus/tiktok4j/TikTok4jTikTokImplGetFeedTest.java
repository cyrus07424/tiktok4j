package jp.cyrus.tiktok4j;

import jp.cyrus.tiktok4j.impl.TikTok4jTikTokImpl;
import jp.cyrus.tiktok4j.models.Aweme;
import jp.cyrus.tiktok4j.models.Feed;
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
		Feed feed = tikTok4j.feed();
		System.out.println(feed);

		for (Aweme ameme : feed.awemeList) {
			System.out.println("awemeId=" + ameme.awemeId);
			System.out.println("desc=" + ameme.desc);
		}
	}
}