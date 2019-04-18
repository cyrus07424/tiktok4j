package jp.cyrus;

import com.fasterxml.jackson.databind.JsonNode;

import jp.cyrus.impl.JokeAITikTokImpl;
import jp.cyrus.models.Device;

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
		throw new RuntimeException("Method not implemented.");
	}

	/**
	 * Login with email.
	 *
	 * @param email
	 * @param password
	 * @return
	 */
	public JsonNode loginWithEmail(String email, String password) {
		throw new RuntimeException("Method not implemented.");
	}

	/**
	 * Get Home feed data.
	 *
	 * @return
	 */
	public JsonNode feed() {
		throw new RuntimeException("Method not implemented.");
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
		throw new RuntimeException("Method not implemented.");
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
		throw new RuntimeException("Method not implemented.");
	}

	/**
	 * Get personal profile data.
	 *
	 * @param userId
	 * @return
	 */
	public JsonNode user(long userId) {
		throw new RuntimeException("Method not implemented.");
	}

	/**
	 * Get user's following data.
	 *
	 * @param userId
	 * @return
	 */
	public JsonNode userFollowingList(long userId) {
		throw new RuntimeException("Method not implemented.");
	}

	/**
	 * Get user's follower data.
	 *
	 * @param userId
	 * @return
	 */
	public JsonNode userFollowerList(long userId) {
		throw new RuntimeException("Method not implemented.");
	}

	/**
	 * Get video's comment data.
	 *
	 * @param awemeId
	 * @param cursor
	 * @return
	 */
	public JsonNode commentList(long awemeId, int cursor) {
		throw new RuntimeException("Method not implemented.");
	}

	/**
	 * Get hot topic data.
	 *
	 * @param cursor
	 * @return
	 */
	public JsonNode categoryList(int cursor) {
		throw new RuntimeException("Method not implemented.");
	}

	/**
	 * Get topic related video data.
	 *
	 * @param chId
	 * @param cursor
	 * @return
	 */
	public JsonNode v2ChallengeAweme(long chId, int cursor) {
		throw new RuntimeException("Method not implemented.");
	}

	/**
	 * Get topic detail info data.
	 *
	 * @param chId
	 * @return
	 */
	public JsonNode v2ChallengeDetail(long chId) {
		throw new RuntimeException("Method not implemented.");
	}

	/**
	 * Get search user data.
	 *
	 * @param keyword
	 * @param cursor
	 * @return
	 */
	public JsonNode v2SearchDiscover(String keyword, int cursor) {
		throw new RuntimeException("Method not implemented.");
	}

	/**
	 * Get search music data.
	 *
	 * @param keyword
	 * @param cursor
	 * @return
	 */
	public JsonNode v2SearchMusic(String keyword, int cursor) {
		throw new RuntimeException("Method not implemented.");
	}

	/**
	 * Get search topic data.
	 *
	 * @param keyword
	 * @param cursor
	 * @return
	 */
	public JsonNode v2SearchChallenge(String keyword, int cursor) {
		throw new RuntimeException("Method not implemented.");
	}
}