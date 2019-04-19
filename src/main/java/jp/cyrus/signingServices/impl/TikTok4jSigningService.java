package jp.cyrus.signingServices.impl;

import jp.cyrus.signingServices.SigningService;

/**
 * Official algorithm based implementation.<br>
 * https://github.com/LCSP/tiktokapi-security
 *
 * @author cyrus
 */
public class TikTok4jSigningService implements SigningService {

	@Override
	public String signUrl(String url, long ts, long deviceId) {
		// TODO
		return url;
	}
}