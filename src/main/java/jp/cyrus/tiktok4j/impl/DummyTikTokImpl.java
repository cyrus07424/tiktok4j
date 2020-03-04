package jp.cyrus.tiktok4j.impl;

import java.io.File;
import java.nio.file.Files;
import java.util.UUID;
import java.util.stream.Collectors;

import jp.cyrus.tiktok4j.TikTok4j;
import jp.cyrus.tiktok4j.models.Device;
import jp.cyrus.tiktok4j.models.Feed;
import jp.cyrus.tiktok4j.utils.JsonHelper;
import jp.cyrus.tiktok4j.utils.TikTokLogicHelper;

/**
 * Dummy data implementation.
 *
 * @author cyrus
 */
public class DummyTikTokImpl extends TikTok4j {

	@Override
	public Device deviceRegister() {
		Device device = new Device();
		device.newUser = 1;
		device.installId = 6683748580261431000L;
		device.deviceId = 6683746146131544000L;
		device.ssid = UUID.randomUUID().toString();
		device.serverTime = TikTokLogicHelper.getServerTime();
		return device;
	}

	@Override
	public Feed feed() {
		try {
			String JSON = Files.readAllLines(new File("src/main/resources/dummyFeed.json").toPath()).stream()
					.collect(Collectors.joining());
			return JsonHelper.getObjectMapper().readValue(JSON, Feed.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}