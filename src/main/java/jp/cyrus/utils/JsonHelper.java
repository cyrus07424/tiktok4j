package jp.cyrus.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

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
		return new ObjectMapper();
	}
}