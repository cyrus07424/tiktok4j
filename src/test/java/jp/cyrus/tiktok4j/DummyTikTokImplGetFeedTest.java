package jp.cyrus.tiktok4j;

import jp.cyrus.tiktok4j.impl.DummyTikTokImpl;
import jp.cyrus.tiktok4j.models.Aweme;
import jp.cyrus.tiktok4j.models.Feed;

/**
 * Get feed test.
 *
 * @author cyrus
 */
public class DummyTikTokImplGetFeedTest {

	/**
	 * main.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("System.currentTimeMillis : " + System.currentTimeMillis());

		// Get dummy feed data
		Feed feed = new DummyTikTokImpl().feed();
		System.out.println(feed);

		for (Aweme ameme : feed.awemeList) {
			System.out.println("awemeId=" + ameme.awemeId);
			System.out.println("desc=" + ameme.desc);
		}
	}
}