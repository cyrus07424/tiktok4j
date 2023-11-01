package jp.cyrus.tiktok4j.impl;

import jp.cyrus.tiktok4j.TikTok4j;
import jp.cyrus.tiktok4j.models.Device;
import jp.cyrus.tiktok4j.signingServices.SigningService;

/**
 * Official DouYin App based implementation.
 *
 * @author cyrus
 */
public class TikTok4jDouYinImpl extends TikTok4j {

	/**
	 * API BASE URL.
	 */
	private static final String API_BASE_URL = "https://aweme.snssdk.com";

	/**
	 * USER AGENT.
	 */
	private static final String USER_AGENT = "okhttp/3.8.2";

	/**
	 * SigningService.
	 */
	private SigningService signingService;

	/**
	 * Device.
	 */
	private Device device;

	/**
	 * Constructor.
	 *
	 * @param signingService
	 */
	public TikTok4jDouYinImpl(SigningService signingService) {
		this.signingService = signingService;
	}
}