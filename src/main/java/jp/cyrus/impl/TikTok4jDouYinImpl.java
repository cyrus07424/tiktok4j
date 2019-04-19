package jp.cyrus.impl;

import jp.cyrus.TikTok4j;
import jp.cyrus.models.Device;
import jp.cyrus.signingServices.SigningService;

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