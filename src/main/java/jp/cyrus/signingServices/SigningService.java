package jp.cyrus.signingServices;

/**
 * URL Signing service.
 *
 * @author cyrus
 */
public interface SigningService {

	/**
	 * Get signed URL.
	 *
	 * @param url
	 * @param ts
	 * @param deviceId
	 * @return
	 */
	public String signUrl(String url, long ts, long deviceId);
}