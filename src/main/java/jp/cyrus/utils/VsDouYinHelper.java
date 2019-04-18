package jp.cyrus.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 * vsdouyin helper.<br>
 * https://github.com/vsdouyin/tiktok-service
 *
 * @author cyrus
 */
public class VsDouYinHelper {

	/**
	 * API BASE URL.
	 */
	private static final String API_BASE_URL = "https://sign.vsdouyin.com/api";

	/**
	 * Token.
	 */
	private static String TOKEN;

	/**
	 * Get signed URL.
	 *
	 * @param url
	 * @throws IOException
	 */
	public static String getSignedUrl(String url) throws IOException {
		if (TOKEN == null) {
			TOKEN = getToken();
		}
		return getSignedUrl(url, TOKEN);
	}

	/**
	 * Get signed URL.
	 *
	 * @param url
	 * @param token
	 * @throws IOException
	 */
	private static String getSignedUrl(String url, String token) throws IOException {
		// Create request parameters
		Map<String, Object> requestData = new HashMap<>();
		requestData.put("url", url);
		String parameterString = JsonHelper.getObjectMapper().writeValueAsString(requestData);

		// Create request
		HttpPost httpPost = new HttpPost(API_BASE_URL + "/653d33c/sign/" + token);
		httpPost.setHeader("Content-type", "application/json; charset=UTF-8");
		httpPost.setEntity(new StringEntity(parameterString, StandardCharsets.UTF_8));
		try (CloseableHttpClient client = HttpClientBuilder.create().build();
				CloseableHttpResponse response = client.execute(httpPost)) {
			String responseString = EntityUtils.toString(response.getEntity());
			return JsonHelper.getObjectMapper().readTree(responseString).get("url").asText();
		}
	}

	/**
	 * Get token.
	 *
	 * @return
	 */
	private static String getToken() {
		HttpGet httpGet = new HttpGet(API_BASE_URL + "/token/gen/");
		try (CloseableHttpClient client = HttpClientBuilder.create().build();
				CloseableHttpResponse response = client.execute(httpGet)) {
			String responseString = EntityUtils.toString(response.getEntity());
			return JsonHelper.getObjectMapper().readTree(responseString).get("token").asText();
		} catch (IOException e) {
			e.printStackTrace();

			// FIXME
			return null;
		}
	}
}