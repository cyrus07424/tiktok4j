package jp.cyrus.tiktok4j.utils;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import jp.cyrus.tiktok4j.constants.Configurations;

/**
 * vsdouyin helper.<br>
 * https://github.com/vsdouyin/tiktok-service
 *
 * @author cyrus
 */
public class VsDouYinHelper {

	/**
	 * Get token.
	 *
	 * @return
	 */
	public static String getToken() {
		HttpGet httpGet = new HttpGet(Configurations.VSDOUYIN_API_BASE_URL + "/token/gen/");
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