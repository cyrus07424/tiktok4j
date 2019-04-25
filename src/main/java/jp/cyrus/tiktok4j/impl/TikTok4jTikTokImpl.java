package jp.cyrus.tiktok4j.impl;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.JsonNode;

import jp.cyrus.tiktok4j.TikTok4j;
import jp.cyrus.tiktok4j.models.Device;
import jp.cyrus.tiktok4j.signingServices.SigningService;
import jp.cyrus.tiktok4j.utils.JsonHelper;
import jp.cyrus.tiktok4j.utils.LogHelper;
import jp.cyrus.tiktok4j.utils.TikTokLogicHelper;
import jp.cyrus.tiktok4j.utils.UrlHelper;

/**
 * Official TikTok App based implementation.
 *
 * @author cyrus
 */
public class TikTok4jTikTokImpl extends TikTok4j {

	/**
	 * API BASE URL.
	 */
	private static final String API_BASE_URL = "https://api2.musical.ly";

	/**
	 * USER AGENT.
	 */
	private static final String USER_AGENT = "com.zhiliaoapp.musically/2018052132 (Linux; U; Android 8.0.0; en_US; Pixel 2; Build/ABCXYZ; Cronet/58.0.2991.0)";

	/**
	 * SigningService.
	 */
	private SigningService signingService;

	/**
	 * Device.
	 */
	private Device device;

	/**
	 * Constructor.
	 *
	 * @param signingService
	 */
	public TikTok4jTikTokImpl(SigningService signingService) {
		this.signingService = signingService;
	}

	@Override
	public Device deviceRegister() {
		if (device == null) {
			// Create dummy data
			device = new Device();
			device.newUser = 1;
			device.installId = 6683748580261431000L;
			device.deviceId = 6683746146131544000L;
			device.ssid = UUID.randomUUID().toString();
			device.serverTime = TikTokLogicHelper.getServerTime();
		}
		return device;
	}

	@Override
	public JsonNode loginWithEmail(String email, String password) {
		try {
			// Get device info
			Device device = deviceRegister();

			// Create request paramater
			Map<String, Object> queryParameterMap = getDefaultQueryString();

			// Get URL
			String url = API_BASE_URL + "/passport/user/login";
			String urlWithParameter = UrlHelper.addQueryParameterToUrl(url, queryParameterMap);
			System.out.println("url = " + urlWithParameter);

			// Get signed URL
			String signedUrl = signingService.signUrl(
					urlWithParameter, TikTokLogicHelper.getServerTime(), device.deviceId);
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
			HttpPost httpPost = new HttpPost(signedUrl);
			httpPost.setHeader("Cookie", String.format("Cookie: install_id=%s", device.installId));
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

	@Override
	public JsonNode feed() {
		// Get device info
		Device device = deviceRegister();

		String url = API_BASE_URL + "/aweme/v1/feed";
		Map<String, Object> queryParameterMap = new LinkedHashMap<>();
		queryParameterMap.put("count", 20);
		queryParameterMap.put("offset", 0);
		queryParameterMap.put("max_cursor", 0);
		queryParameterMap.put("type", 0);
		queryParameterMap.put("is_cold_start", 1);
		queryParameterMap.put("pull_type", 1);
		queryParameterMap.putAll(getDefaultQueryString());

		// Get URL
		String urlWithParameter = UrlHelper.addQueryParameterToUrl(url, queryParameterMap);

		// Get signed URL
		String signedUrl = signingService.signUrl(
				urlWithParameter, TikTokLogicHelper.getServerTime(), device.deviceId);

		return getHttpResponse(signedUrl);
	}

	/**
	 * Get default query string.
	 *
	 * @return
	 */
	private Map<String, Object> getDefaultQueryString() {
		// Get device info
		Device device = deviceRegister();

		Map<String, Object> queryParameterMap = new LinkedHashMap<>();
		queryParameterMap.put("ts", TikTokLogicHelper.getServerTime());
		queryParameterMap.put("js_sdk_version", "");
		queryParameterMap.put("app_type", "normal");
		queryParameterMap.put("region", "JP");
		queryParameterMap.put("version_name", "5.8.3");
		queryParameterMap.put("timezone_name", "Asia%2FTokyo");
		queryParameterMap.put("device_type", "LGL22");
		queryParameterMap.put("uild_number", "5.8.3");
		queryParameterMap.put("resolution", "1080*1776");
		queryParameterMap.put("aid", "1180");
		queryParameterMap.put("app_name", "trill");
		queryParameterMap.put("_rticket", System.currentTimeMillis());
		queryParameterMap.put("device_patform", "android");
		queryParameterMap.put("version_code", "583");
		queryParameterMap.put("uoo", "0");
		queryParameterMap.put("dpi", "480");
		queryParameterMap.put("sys_region", "JP");
		queryParameterMap.put("ssmix", "a");
		queryParameterMap.put("s_api", "19");
		queryParameterMap.put("timezone_offset", "32400");
		queryParameterMap.put("pass-route", "1");
		queryParameterMap.put("device_brand", "KDDI");
		queryParameterMap.put("maifest_version_code", "583");
		queryParameterMap.put("os_version", "4.4.2");
		queryParameterMap.put("ab_version", "5.8.3");
		queryParameterMap.put("update_version_code", "5830");
		queryParameterMap.put("app_language", "ja");
		queryParameterMap.put("ac", "wifi");
		queryParameterMap.put("pass-region", "1");
		queryParameterMap.put("language", "ja");
		queryParameterMap.put("is_my_cn", "0");
		queryParameterMap.put("channel", "googleplay");
		queryParameterMap.put("iid", device.installId);
		queryParameterMap.put("openudid", TikTokLogicHelper.getOpenudid());
		queryParameterMap.put("device_id", device.deviceId);
		return queryParameterMap;
	}

	/**
	 * Get HTTP response.
	 *
	 * @param url
	 * @return
	 */
	private static JsonNode getHttpResponse(String url) {
		try {
			LogHelper.debug("Get : " + url);
			HttpGet httpGet = new HttpGet(url);
			httpGet.setHeader("Host", UrlHelper.getHostname(url));
			httpGet.setHeader("X-SS-TC", "0");
			httpGet.setHeader("User-Agent", USER_AGENT);
			httpGet.setHeader("Accept-Encoding", "gzip");
			httpGet.setHeader("Connection", "keep-alive");
			httpGet.setHeader("X-Tt-Token", "");
			httpGet.setHeader("sdk-version", "1");
			httpGet.setHeader("Cookie", "");

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
}