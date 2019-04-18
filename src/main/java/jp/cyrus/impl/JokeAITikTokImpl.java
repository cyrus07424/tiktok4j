package jp.cyrus.impl;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.JsonNode;

import jp.cyrus.TikTok4j;
import jp.cyrus.models.Device;
import jp.cyrus.utils.JsonHelper;

/**
 * JokeAI TikTok sign service based implementation.<br>
 * https://github.com/JokeAI/Sign-Tiktok
 *
 * @author cyrus
 */
public class JokeAITikTokImpl extends TikTok4j {

	/**
	 * API BASE URL.
	 */
	private static final String API_BASE_URL = "https://jokeai.zongcaihao.com/tiktok/v872";

	@Override
	public Device deviceRegister() {
		HttpGet httpGet = new HttpGet(API_BASE_URL + "/device");
		try (CloseableHttpClient client = HttpClientBuilder.create().build();
				CloseableHttpResponse response = client.execute(httpGet)) {
			String responseString = EntityUtils.toString(response.getEntity());
			return JsonHelper.getObjectMapper().readValue(responseString, Device.class);
		} catch (IOException e) {
			e.printStackTrace();

			// FIXME
			return null;
		}
	}

	@Override
	public JsonNode feed() {
		try {
			// Get response
			JsonNode response = getHttpResponse(API_BASE_URL + "/feed");

			// Get data
			return response.get("data");
		} catch (Exception e) {
			e.printStackTrace();

			// FIXME
			return null;
		}
	}

	/**
	 * Get HTTP response.
	 *
	 * @param url
	 * @return
	 * @throws Exception
	 */
	private static JsonNode getHttpResponse(String url) throws Exception {
		HttpGet httpPost = new HttpGet(url);
		try (CloseableHttpClient client = HttpClientBuilder.create().build();
				CloseableHttpResponse response = client.execute(httpPost)) {
			System.out.println(response);
			System.out.println("code = " + response.getStatusLine().getStatusCode());
			String responseString = EntityUtils.toString(response.getEntity());
			System.out.println("response = " + responseString);
			return JsonHelper.getObjectMapper().readTree(responseString);
		}
	}
}