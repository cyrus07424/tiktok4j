package jp.cyrus.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Device.
 *
 * @author cyrus
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Device {

	/**
	 * install_id.
	 */
	public long install_id;

	/**
	 * new_user.
	 */
	public int new_user;

	/**
	 * ssid.
	 */
	public String ssid;

	/**
	 * server_time.
	 */
	public long server_time;

	/**
	 * device_id.
	 */
	public long device_id;
}