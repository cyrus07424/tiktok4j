package jp.cyrus.tiktok4j.utils;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.JsonNode;

import jp.cyrus.tiktok4j.constants.Configurations;


/**
 * Http client helper.
 *
 * @author cyrus
 */
public class HttpClientHelper {

	/**
	 * Get HTTP response.
	 *
	 * @param url
	 * @return
	 */
	public static JsonNode getHttpResponse(String url) {
		try {
			LogHelper.debug("Get : " + url);
			HttpGet httpGet = new HttpGet(url);
			httpGet.setHeader("User-Agent", Configurations.HTTP_CLIENT_USER_AGENT);
			try (CloseableHttpClient client = HttpClientBuilder.create().build();
					CloseableHttpResponse response = client.execute(httpGet)) {
				LogHelper.debug(response);
				LogHelper.debug("code = " + response.getStatusLine().getStatusCode());
				String responseString = EntityUtils.toString(response.getEntity());
				LogHelper.debug("response = " + responseString);
				return JsonHelper.getObjectMapper().readTree(responseString);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Get HTTP response.
	 *
	 * @param url
	 * @param valueType
	 * @return
	 */
	public static <T> T getHttpResponse(String url, Class<T> valueType) {
		try {
			LogHelper.debug("Get : " + url);
			HttpGet httpGet = new HttpGet(url);
			httpGet.setHeader("User-Agent", Configurations.HTTP_CLIENT_USER_AGENT);
			try (CloseableHttpClient client = HttpClientBuilder.create().build();
					CloseableHttpResponse response = client.execute(httpGet)) {
				LogHelper.debug(response);
				LogHelper.debug("code = " + response.getStatusLine().getStatusCode());
				String responseString = EntityUtils.toString(response.getEntity());
				LogHelper.debug("response = " + responseString);
				return JsonHelper.getObjectMapper().readValue(responseString, valueType);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}