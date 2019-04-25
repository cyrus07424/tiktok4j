package jp.cyrus.tiktok4j;

import com.fasterxml.jackson.databind.JsonNode;

import jp.cyrus.tiktok4j.impl.JokeAITikTokImpl;
import jp.cyrus.tiktok4j.models.Device;
import jp.cyrus.tiktok4j.models.Feed;

/**
 * TikTok API.
 *
 * @author cyrus
 */
public abstract class TikTok4j {

	/**
	 * Get default instance.
	 */
	public static TikTok4j getDefaultInstance() {
		return new JokeAITikTokImpl();
	}

	/**
	 * Register device.
	 *
	 * @return
	 */
	public Device deviceRegister() {
		throw new UnsupportedOperationException("Method not implemented.");
	}

	/**
	 * Login with email.
	 *
	 * @param email
	 * @param password
	 * @return
	 */
	public JsonNode loginWithEmail(String email, String password) {
		throw new UnsupportedOperationException("Method not implemented.");
	}

	/**
	 * Get Home feed data.
	 *
	 * @return
	 */
	public Feed feed() {
		throw new UnsupportedOperationException("Method not implemented.");
	}

	/**
	 * Get user's video data.
	 *
	 * @param userId
	 * @param maxCursor
	 * @param count
	 * @return
	 */
	public JsonNode awemePost(long userId, int maxCursor, int count) {
		throw new UnsupportedOperationException("Method not implemented.");
	}

	/**
	 * Get user's favorite video data.
	 *
	 * @param userId
	 * @param maxCursor
	 * @param count
	 * @return
	 */
	public JsonNode awemeFavorite(long userId, int maxCursor, int count) {
		throw new UnsupportedOperationException("Method not implemented.");
	}

	/**
	 * Get personal profile data.
	 *
	 * @param userId
	 * @return
	 */
	public JsonNode user(long userId) {
		throw new UnsupportedOperationException("Method not implemented.");
	}

	/**
	 * Get user's following data.
	 *
	 * @param userId
	 * @return
	 */
	public JsonNode userFollowingList(long userId) {
		throw new UnsupportedOperationException("Method not implemented.");
	}

	/**
	 * Get user's follower data.
	 *
	 * @param userId
	 * @return
	 */
	public JsonNode userFollowerList(long userId) {
		throw new UnsupportedOperationException("Method not implemented.");
	}

	/**
	 * Get video's comment data.
	 *
	 * @param awemeId
	 * @param cursor
	 * @return
	 */
	public JsonNode commentList(long awemeId, int cursor) {
		throw new UnsupportedOperationException("Method not implemented.");
	}

	/**
	 * Get hot topic data.
	 *
	 * @param cursor
	 * @return
	 */
	public JsonNode categoryList(int cursor) {
		throw new UnsupportedOperationException("Method not implemented.");
	}

	/**
	 * Get topic related video data.
	 *
	 * @param chId
	 * @param cursor
	 * @return
	 */
	public JsonNode challengeAweme(long chId, int cursor) {
		throw new UnsupportedOperationException("Method not implemented.");
	}

	/**
	 * Get topic detail info data.
	 *
	 * @param chId
	 * @return
	 */
	public JsonNode challengeDetail(long chId) {
		throw new UnsupportedOperationException("Method not implemented.");
	}

	/**
	 * Get search user data.
	 *
	 * @param keyword
	 * @param cursor
	 * @return
	 */
	public JsonNode searchDiscover(String keyword, int cursor) {
		throw new UnsupportedOperationException("Method not implemented.");
	}

	/**
	 * Get search music data.
	 *
	 * @param keyword
	 * @param cursor
	 * @return
	 */
	public JsonNode searchMusic(String keyword, int cursor) {
		throw new UnsupportedOperationException("Method not implemented.");
	}

	/**
	 * Get search topic data.
	 *
	 * @param keyword
	 * @param cursor
	 * @return
	 */
	public JsonNode searchChallenge(String keyword, int cursor) {
		throw new UnsupportedOperationException("Method not implemented.");
	}

	/**
	 * Get search video data.
	 *
	 * @param keyword
	 * @param cursor
	 * @return
	 */
	public JsonNode searchItem(String keyword, int cursor) {
		throw new UnsupportedOperationException("Method not implemented.");
	}

	/**
	 * Get goods data.
	 *
	 * @param userId
	 * @param cursor
	 * @return
	 */
	public JsonNode userPromotions(long userId, int cursor) {
		throw new UnsupportedOperationException("Method not implemented.");
	}

	/**
	 * Get live video data.
	 *
	 * @param cursor
	 * @return
	 */
	public JsonNode roomFeed(int cursor) {
		throw new UnsupportedOperationException("Method not implemented.");
	}

	/**
	 * Get hot topic data.
	 *
	 * @return
	 */
	public JsonNode hotsearchWord() {
		throw new UnsupportedOperationException("Method not implemented.");
	}

	/**
	 * Get hot video data.
	 *
	 * @return
	 */
	public JsonNode hotsearchAweme() {
		throw new UnsupportedOperationException("Method not implemented.");
	}

	/**
	 * Get hot energy data.
	 *
	 * @return
	 */
	public JsonNode hotsearchEnergy() {
		throw new UnsupportedOperationException("Method not implemented.");
	}
}