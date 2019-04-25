package jp.cyrus.tiktok4j.signingServices.impl;

import jp.cyrus.tiktok4j.signingServices.SigningService;

/**
 * Official algorithm based implementation.<br>
 * https://github.com/LCSP/tiktokapi-security
 *
 * @author cyrus
 */
public class TikTok4jSigningService implements SigningService {

	@Override
	public String signUrl(String url, long ts, long deviceId) {
		// FIXME
		return url + "&as=a1qwert123&cp=cbfhckdckkde1";
	}
}