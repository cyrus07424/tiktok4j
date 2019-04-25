package jp.cyrus.tiktok4j.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Log helper.
 *
 * @author cyrus
 */
public class LogHelper {

	/**
	 * Print log.
	 *
	 * @param message
	 */
	public static void info(Object message) {
		System.out.println(getFormattedLogMessage("INFO", message));
	}

	/**
	 * Print log.
	 *
	 * @param message
	 */
	public static void debug(Object message) {
		System.out.println(getFormattedLogMessage("DEBUG", message));
	}

	/**
	 * Print log.
	 *
	 * @param message
	 */
	public static void error(Object message) {
		System.err.println(getFormattedLogMessage("ERROR", message));
	}

	/**
	 * Get formatted log message.
	 *
	 * @param logLevel
	 * @param message
	 * @return
	 */
	private static String getFormattedLogMessage(String logLevel, Object message) {
		return String.format("%s [%s] from %s - %s",
				getDateString(), logLevel, getCalledFrom(), String.valueOf(message));
	}

	/**
	 * Get formatted date.
	 *
	 * @return
	 */
	private static String getDateString() {
		return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss,SSS").format(new Date());
	}

	/**
	 * Get called from method information.<br>
	 * http://javasampleokiba.blog.fc2.com/blog-entry-4.html
	 *
	 * @return
	 */
	private static String getCalledFrom() {
		int useIndex = 4;
		StackTraceElement[] steArray = Thread.currentThread().getStackTrace();
		if (steArray.length <= useIndex) {
			return "NOT AVAILABLE";
		}
		StackTraceElement stackTraceElement = steArray[useIndex];
		return stackTraceElement.getClassName() + "#" + stackTraceElement.getMethodName();
	}
}