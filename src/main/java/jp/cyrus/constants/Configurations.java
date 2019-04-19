package jp.cyrus.constants;

/**
 * Envoronment configurations.
 *
 * @author cyrus
 */
public interface Configurations {

	/**
	 * Debug mode.
	 */
	boolean DEBUG_MODE = false;

	/**
	 * User Agent.
	 */
	String HTTP_CLIENT_USER_AGENT ="Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:52.0) Gecko/20100101 Firefox/52.0";

	/**
	 * JokeAI TikTok sign service API base URL.
	 */
	String JOKE_AI_TIKTOK_API_BASE_URL = "https://jokeai.zongcaihao.com/tiktok/v872";

	/**
	 * JokeAI DouYin sign service API base URL.
	 */
	String JOKE_AI_DOUYIN_API_BASE_URL = "https://jokeai.zongcaihao.com/douyin/v292";

	/**
	 * vsdouyin TikTok/DouYin sign service API baseURL.
	 */
	String VSDOUYIN_API_BASE_URL = "https://sign.vsdouyin.com/api";
}