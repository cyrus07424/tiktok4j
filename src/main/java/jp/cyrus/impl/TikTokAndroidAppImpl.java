package jp.cyrus.impl;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.JsonNode;

import jp.cyrus.TikTok4j;
import jp.cyrus.models.Device;
import jp.cyrus.utils.JsonHelper;
import jp.cyrus.utils.TikTokLogicHelper;
import jp.cyrus.utils.VsDouYinHelper;

/**
 * TikTok Android app based implementation.
 *
 * @author cyrus
 */
public class TikTokAndroidAppImpl extends TikTok4j {

	/**
	 * API BASE URL.
	 */
	private static final String API_BASE_URL = "https://api2.musical.ly";

	/**
	 * USER AGENT.
	 */
	private static final String USER_AGENT = "com.zhiliaoapp.musically/2018052132 (Linux; U; Android 8.0.0; en_US; Pixel 2; Build/ABCXYZ; Cronet/58.0.2991.0)";

	/**
	 * Device.
	 */
	private static Device DEVICE;

	@Override
	public Device deviceRegister() {
		if (DEVICE == null) {
			// Create dummy data
			DEVICE = new Device();
			DEVICE.install_id = 6680910656474695426L;
			DEVICE.device_id = 6680907123225904642L;
			DEVICE.ssid = UUID.randomUUID().toString();
			DEVICE.server_time = System.currentTimeMillis() / 1000;
		}
		return DEVICE;
	}

	@Override
	public JsonNode loginWithEmail(String email, String password) {
		try {
			// Get device info
			Device device = deviceRegister();

			// Create request paramater
			Map<String, String> queryStringMap = getDefaultQueryString();
			queryStringMap.put("iid", String.valueOf(device.install_id));
			queryStringMap.put("openudid", TikTokLogicHelper.getOpenudid());
			queryStringMap.put("device_id", String.valueOf(device.device_id));

			StringBuilder urlStringBuilder = new StringBuilder();
			urlStringBuilder.append(API_BASE_URL + "/passport/user/login");
			boolean first = true;
			for (Map.Entry<String, String> entry : queryStringMap.entrySet()) {
				if (first) {
					urlStringBuilder.append("?");
					first = false;
				} else {
					urlStringBuilder.append("&");
				}
				urlStringBuilder.append(entry.getKey());
				urlStringBuilder.append("=");
				urlStringBuilder.append(entry.getValue());
			}
			System.out.println("url = " + urlStringBuilder.toString());

			// Get signed URL
			String signedUrl = VsDouYinHelper.getSignedUrl(urlStringBuilder.toString());
			System.out.println("signedUrl = " + signedUrl);

			// Create request paramater
			ArrayList<BasicNameValuePair> requestData = new ArrayList<>();
			requestData.add(new BasicNameValuePair("mix_mode", "1"));
			requestData.add(new BasicNameValuePair("username", ""));
			requestData.add(new BasicNameValuePair("email", TikTokLogicHelper.getEncryptedString(email)));
			requestData.add(new BasicNameValuePair("mobile", ""));
			requestData.add(new BasicNameValuePair("account", ""));
			requestData.add(new BasicNameValuePair("password", TikTokLogicHelper.getEncryptedString(password)));
			requestData.add(new BasicNameValuePair("multi_login", "1"));
			requestData.add(new BasicNameValuePair("captcha", ""));

			// Set request paramater
			HttpPost httpPost = new HttpPost(urlStringBuilder.toString());
			httpPost.setHeader("Cookie", String.format("Cookie: install_id=%s", device.install_id));
			httpPost.setHeader("User-Agent", USER_AGENT);
			httpPost.setEntity(new UrlEncodedFormEntity(requestData, StandardCharsets.UTF_8));

			// Execute request
			try (CloseableHttpClient client = HttpClientBuilder.create().build();
					CloseableHttpResponse response = client.execute(httpPost)) {
				System.out.println(response);

				// Print HTTP status code
				System.out.println("code = " + response.getStatusLine().getStatusCode());

				// Print response
				String responseString = EntityUtils.toString(response.getEntity());
				System.out.println("response = " + responseString);

				// Get response JSON
				return JsonHelper.getObjectMapper().readTree(responseString);
			}
		} catch (Exception e) {
			e.printStackTrace();

			// FIXME
			return null;
		}
	}

	/**
	 * Get default query string.
	 *
	 * @return
	 */
	private static Map<String, String> getDefaultQueryString() {
		Map<String, String> queryStringMap = new LinkedHashMap<>();
		queryStringMap.put("ts", String.valueOf(System.currentTimeMillis() / 1000));
		queryStringMap.put("js_sdk_version", "");
		queryStringMap.put("app_type", "normal");
		queryStringMap.put("region", "JP");
		queryStringMap.put("version_name", "5.8.3");
		queryStringMap.put("timezone_name", "Asia%2FTokyo");
		queryStringMap.put("device_type", "LGL22");
		queryStringMap.put("uild_number", "5.8.3");
		queryStringMap.put("resolution", "1080*1776");
		queryStringMap.put("aid", "1180");
		queryStringMap.put("app_name", "trill");
		queryStringMap.put("_rticket", String.valueOf(System.currentTimeMillis()));
		queryStringMap.put("device_patform", "android");
		queryStringMap.put("version_code", "583");
		queryStringMap.put("uoo", "0");
		queryStringMap.put("dpi", "480");
		queryStringMap.put("sys_region", "JP");
		queryStringMap.put("ssmix", "a");
		queryStringMap.put("s_api", "19");
		queryStringMap.put("timezone_offset", "32400");
		queryStringMap.put("pass-route", "1");
		queryStringMap.put("device_brand", "KDDI");
		queryStringMap.put("maifest_version_code", "583");
		queryStringMap.put("os_version", "4.4.2");
		queryStringMap.put("ab_version", "5.8.3");
		queryStringMap.put("update_version_code", "5830");
		queryStringMap.put("app_language", "ja");
		queryStringMap.put("ac", "wifi");
		queryStringMap.put("pass-region", "1");
		queryStringMap.put("language", "ja");
		queryStringMap.put("is_my_cn", "0");
		queryStringMap.put("channel", "googleplay");
		return queryStringMap;
	}
}