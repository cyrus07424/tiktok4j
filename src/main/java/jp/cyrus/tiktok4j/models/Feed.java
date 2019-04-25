
package jp.cyrus.tiktok4j.models;

import java.util.List;

/**
 * Feed.
 *
 * @author cyrus
 */
public class Feed {

	public Integer statusCode;

	public Integer minCursor;

	public Integer maxCursor;

	public Integer hasMore;

	public List<Aweme> awemeList;

	public Integer homeModel;

	public Integer refreshClear;

	public Extra extra;

	public LogPb logPb;

	public List<Object> preloadAds;
}