package jp.cyrus.tiktok4j.signingServices.impl;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import jp.cyrus.tiktok4j.constants.Configurations;
import jp.cyrus.tiktok4j.signingServices.SigningService;
import jp.cyrus.tiktok4j.utils.JsonHelper;
import jp.cyrus.tiktok4j.utils.VsDouYinHelper;

/**
 * vsdouyin TikTok/DouYin sign service based implementation.<br>
 * https://github.com/vsdouyin/tiktok-service
 * https://github.com/vsdouyin/douyin-service
 *
 * @author cyrus
 */
public class VsdouyinSigningService implements SigningService {

	/**
	 * Token.
	 */
	private String token;

	/**
	 * Constructor.
	 */
	public VsdouyinSigningService() {
	}

	/**
	 * Constructor.
	 *
	 * @param token
	 */
	public VsdouyinSigningService(String token) {
		this.token = token;
	}

	@Override
	public String signUrl(String url, long ts, long deviceId) {
		try {
			// Get token
			if (token == null) {
				token = VsDouYinHelper.getToken();
			}

			// Create request parameters
			Map<String, Object> requestData = new HashMap<>();
			requestData.put("url", url);
			String parameterString = JsonHelper.getObjectMapper().writeValueAsString(requestData);

			// Create request
			HttpPost httpPost = new HttpPost(Configurations.VSDOUYIN_API_BASE_URL + "/653d33c/sign/" + token);
			httpPost.setHeader("Content-type", "application/json;");
			httpPost.setEntity(new StringEntity(parameterString, StandardCharsets.UTF_8));
			try (CloseableHttpClient client = HttpClientBuilder.create().build();
					CloseableHttpResponse response = client.execute(httpPost)) {
				String responseString = EntityUtils.toString(response.getEntity());
				return JsonHelper.getObjectMapper().readTree(responseString).get("url").asText();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}