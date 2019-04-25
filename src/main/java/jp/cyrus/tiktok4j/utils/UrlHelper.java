package jp.cyrus.tiktok4j.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * URL helper.
 *
 * @author cyrus
 */
public class UrlHelper {

	/**
	 * Add query string to URL.
	 *
	 * @param url
	 * @param queryParameterMap
	 * @return
	 */
	public static String addQueryParameterToUrl(String url, Map<String, Object> queryParameterMap) {
		try {
			StringBuilder urlStringBuilder = new StringBuilder(url);
			boolean first = true;
			for (Map.Entry<String, Object> entry : queryParameterMap.entrySet()) {
				if (first) {
					urlStringBuilder.append("?");
					first = false;
				} else {
					urlStringBuilder.append("&");
				}
				urlStringBuilder.append(entry.getKey());
				urlStringBuilder.append("=");
				// URL Encode
				urlStringBuilder
						.append(URLEncoder.encode(String.valueOf(entry.getValue()), StandardCharsets.UTF_8.name()));
			}
			return urlStringBuilder.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Get hostname from URL.
	 *
	 * @param url
	 * @return
	 */
	public static String getHostname(String url) {
		try {
			return new URL(url).getHost();
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
}