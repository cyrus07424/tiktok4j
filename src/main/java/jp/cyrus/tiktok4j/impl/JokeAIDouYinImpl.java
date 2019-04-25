package jp.cyrus.tiktok4j.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import jp.cyrus.tiktok4j.TikTok4j;
import jp.cyrus.tiktok4j.constants.Configurations;
import jp.cyrus.tiktok4j.models.Device;
import jp.cyrus.tiktok4j.models.Feed;
import jp.cyrus.tiktok4j.utils.HttpClientHelper;
import jp.cyrus.tiktok4j.utils.JsonHelper;
import jp.cyrus.tiktok4j.utils.TikTokLogicHelper;
import jp.cyrus.tiktok4j.utils.UrlHelper;

/**
 * JokeAI DouYin sign service based implementation.<br>
 * https://github.com/JokeAI/Sign-DouYin
 *
 * @author cyrus
 */
public class JokeAIDouYinImpl extends TikTok4j {

	/**
	 * Key.
	 */
	private static final String KEY_DATA = "data";

	@Override
	public Device deviceRegister() {
		String url = Configurations.JOKE_AI_DOUYIN_API_BASE_URL + "/device";
		return HttpClientHelper.getHttpResponse(url, Device.class);
	}

	@Override
	public Feed feed() {
		try {
			String url = Configurations.JOKE_AI_DOUYIN_API_BASE_URL + "/feed";
			return JsonHelper.getObjectMapper().readValue(
					HttpClientHelper.getHttpResponse(url).get(KEY_DATA).toString(),
					Feed.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public JsonNode awemePost(long userId, int maxCursor, int count) {
		String url = Configurations.JOKE_AI_DOUYIN_API_BASE_URL + "/aweme/post";
		Map<String, Object> queryParameterMap = new LinkedHashMap<>();
		queryParameterMap.put("user_id", userId);
		queryParameterMap.put("max_cursor", maxCursor);
		queryParameterMap.put("count", count);
		return HttpClientHelper.getHttpResponse(UrlHelper.addQueryParameterToUrl(url, queryParameterMap)).get(KEY_DATA);
	}

	@Override
	public JsonNode awemeFavorite(long userId, int maxCursor, int count) {
		String url = Configurations.JOKE_AI_DOUYIN_API_BASE_URL + "/aweme/favorite";
		Map<String, Object> queryParameterMap = new LinkedHashMap<>();
		queryParameterMap.put("user_id", userId);
		queryParameterMap.put("max_cursor", maxCursor);
		queryParameterMap.put("count", count);
		return HttpClientHelper.getHttpResponse(UrlHelper.addQueryParameterToUrl(url, queryParameterMap)).get(KEY_DATA);
	}

	@Override
	public JsonNode user(long userId) {
		String url = Configurations.JOKE_AI_DOUYIN_API_BASE_URL + "/user";
		Map<String, Object> queryParameterMap = new LinkedHashMap<>();
		queryParameterMap.put("user_id", userId);
		return HttpClientHelper.getHttpResponse(UrlHelper.addQueryParameterToUrl(url, queryParameterMap)).get(KEY_DATA);
	}

	@Override
	public JsonNode userFollowingList(long userId) {
		String url = Configurations.JOKE_AI_DOUYIN_API_BASE_URL + "/user/following/list";
		Map<String, Object> queryParameterMap = new LinkedHashMap<>();
		queryParameterMap.put("user_id", userId);
		queryParameterMap.put("max_time", TikTokLogicHelper.getServerTime());
		return HttpClientHelper.getHttpResponse(UrlHelper.addQueryParameterToUrl(url, queryParameterMap)).get(KEY_DATA);
	}

	@Override
	public JsonNode userFollowerList(long userId) {
		String url = Configurations.JOKE_AI_DOUYIN_API_BASE_URL + "/user/follower/list";
		Map<String, Object> queryParameterMap = new LinkedHashMap<>();
		queryParameterMap.put("user_id", userId);
		queryParameterMap.put("max_time", TikTokLogicHelper.getServerTime());
		return HttpClientHelper.getHttpResponse(UrlHelper.addQueryParameterToUrl(url, queryParameterMap)).get(KEY_DATA);
	}

	@Override
	public JsonNode commentList(long awemeId, int cursor) {
		String url = Configurations.JOKE_AI_DOUYIN_API_BASE_URL + "/comment/list";
		Map<String, Object> queryParameterMap = new LinkedHashMap<>();
		queryParameterMap.put("aweme_id", awemeId);
		queryParameterMap.put("cursor", cursor);
		return HttpClientHelper.getHttpResponse(UrlHelper.addQueryParameterToUrl(url, queryParameterMap)).get(KEY_DATA);
	}

	@Override
	public JsonNode categoryList(int cursor) {
		String url = Configurations.JOKE_AI_DOUYIN_API_BASE_URL + "/category/list";
		Map<String, Object> queryParameterMap = new LinkedHashMap<>();
		queryParameterMap.put("cursor", cursor);
		return HttpClientHelper.getHttpResponse(UrlHelper.addQueryParameterToUrl(url, queryParameterMap)).get(KEY_DATA);
	}

	@Override
	public JsonNode challengeAweme(long chId, int cursor) {
		String url = Configurations.JOKE_AI_DOUYIN_API_BASE_URL + "/challenge/aweme";
		Map<String, Object> queryParameterMap = new LinkedHashMap<>();
		queryParameterMap.put("ch_id", chId);
		queryParameterMap.put("cursor", cursor);
		return HttpClientHelper.getHttpResponse(UrlHelper.addQueryParameterToUrl(url, queryParameterMap)).get(KEY_DATA);
	}

	@Override
	public JsonNode challengeDetail(long chId) {
		String url = Configurations.JOKE_AI_DOUYIN_API_BASE_URL + "/challenge/detail";
		Map<String, Object> queryParameterMap = new LinkedHashMap<>();
		queryParameterMap.put("ch_id", chId);
		return HttpClientHelper.getHttpResponse(UrlHelper.addQueryParameterToUrl(url, queryParameterMap)).get(KEY_DATA);
	}

	@Override
	public JsonNode searchDiscover(String keyword, int cursor) {
		String url = Configurations.JOKE_AI_DOUYIN_API_BASE_URL + "/search/discover";
		Map<String, Object> queryParameterMap = new LinkedHashMap<>();
		queryParameterMap.put("keyword", keyword);
		queryParameterMap.put("cursor", cursor);
		return HttpClientHelper.getHttpResponse(UrlHelper.addQueryParameterToUrl(url, queryParameterMap)).get(KEY_DATA);
	}

	@Override
	public JsonNode searchMusic(String keyword, int cursor) {
		String url = Configurations.JOKE_AI_DOUYIN_API_BASE_URL + "/search/music";
		Map<String, Object> queryParameterMap = new LinkedHashMap<>();
		queryParameterMap.put("keyword", keyword);
		queryParameterMap.put("cursor", cursor);
		return HttpClientHelper.getHttpResponse(UrlHelper.addQueryParameterToUrl(url, queryParameterMap)).get(KEY_DATA);
	}

	@Override
	public JsonNode searchChallenge(String keyword, int cursor) {
		String url = Configurations.JOKE_AI_DOUYIN_API_BASE_URL + "/search/challenge";
		Map<String, Object> queryParameterMap = new LinkedHashMap<>();
		queryParameterMap.put("keyword", keyword);
		queryParameterMap.put("cursor", cursor);
		return HttpClientHelper.getHttpResponse(UrlHelper.addQueryParameterToUrl(url, queryParameterMap)).get(KEY_DATA);
	}

	@Override
	public JsonNode searchItem(String keyword, int cursor) {
		String url = Configurations.JOKE_AI_DOUYIN_API_BASE_URL + "/search/item";
		Map<String, Object> queryParameterMap = new LinkedHashMap<>();
		queryParameterMap.put("keyword", keyword);
		queryParameterMap.put("cursor", cursor);
		return HttpClientHelper.getHttpResponse(UrlHelper.addQueryParameterToUrl(url, queryParameterMap)).get(KEY_DATA);
	}

	@Override
	public JsonNode userPromotions(long userId, int cursor) {
		String url = Configurations.JOKE_AI_DOUYIN_API_BASE_URL + "/user/promotions";
		Map<String, Object> queryParameterMap = new LinkedHashMap<>();
		queryParameterMap.put("user_id", userId);
		queryParameterMap.put("cursor", cursor);
		return HttpClientHelper.getHttpResponse(UrlHelper.addQueryParameterToUrl(url, queryParameterMap)).get(KEY_DATA);
	}

	@Override
	public JsonNode roomFeed(int cursor) {
		String url = Configurations.JOKE_AI_DOUYIN_API_BASE_URL + "/room/feed";
		Map<String, Object> queryParameterMap = new LinkedHashMap<>();
		queryParameterMap.put("cursor", cursor);
		return HttpClientHelper.getHttpResponse(UrlHelper.addQueryParameterToUrl(url, queryParameterMap)).get(KEY_DATA);
	}

	@Override
	public JsonNode hotsearchWord() {
		String url = Configurations.JOKE_AI_DOUYIN_API_BASE_URL + "/hotsearch/word";
		return HttpClientHelper.getHttpResponse(url).get(KEY_DATA);
	}

	@Override
	public JsonNode hotsearchAweme() {
		String url = Configurations.JOKE_AI_DOUYIN_API_BASE_URL + "/hotsearch/aweme";
		return HttpClientHelper.getHttpResponse(url).get(KEY_DATA);
	}

	@Override
	public JsonNode hotsearchEnergy() {
		String url = Configurations.JOKE_AI_DOUYIN_API_BASE_URL + "/hotsearch/energy";
		return HttpClientHelper.getHttpResponse(url).get(KEY_DATA);
	}
}