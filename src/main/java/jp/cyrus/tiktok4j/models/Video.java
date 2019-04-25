
package jp.cyrus.tiktok4j.models;

import java.util.List;

/**
 * Video.
 *
 * @author cyrus
 */
public class Video {

	public PlayAddr playAddr;

	public Cover cover;

	public Integer height;

	public Integer width;

	public DynamicCover dynamicCover;

	public OriginCover originCover;

	public String ratio;

	public DownloadAddr downloadAddr;

	public Boolean hasWatermark;

	public List<BitRate> bitRate = null;

	public Integer duration;

	public Integer isH265;
}