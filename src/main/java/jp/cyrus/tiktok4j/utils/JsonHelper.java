package jp.cyrus.tiktok4j.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

/**
 * Json helper.
 *
 * @author cyrus
 */
public class JsonHelper {

	/**
	 * Get ObjectMapper.
	 *
	 * @return
	 */
	public static final ObjectMapper getObjectMapper() {
		return new ObjectMapper()
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
				.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
	}
}