package com.cd_help.onlineOF.utils;

import java.io.IOException;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StringUtil {

	// 返回指定位数的字符串
	public static String getDigit(int digit, int num) {
		String str = "";
		for (int i = 0; i < digit; i++) {
			str = str + "0";
		}
		str = str + num;
		str = str.substring((str.length() - digit), str.length());
		return str;
	}

	// 返回由系统当前时间组成的字符串
	public static String getNowString() {
		Calendar now = Calendar.getInstance();
		return new String("" + now.get(Calendar.YEAR)
				+ getDigit(2, (now.get(Calendar.MONTH) + 1))
				+ getDigit(2, now.get(Calendar.DAY_OF_MONTH))
				+ getDigit(2, now.get(Calendar.HOUR_OF_DAY))
				+ getDigit(2, now.get(Calendar.MINUTE))
				+ getDigit(2, now.get(Calendar.SECOND))
				+ getDigit(3, now.get(Calendar.MILLISECOND)));

	}

	private final static Log log = LogFactory.getLog(StringUtil.class);

	/**
	 * Encode a string using algorithm specified in web.xml and return the
	 * resulting encrypted password. If exception, the plain credentials string
	 * is returned
	 * 
	 * @param password
	 *            Password or other credentials to use in authenticating this
	 *            username
	 * @param algorithm
	 *            Algorithm used to do the digest. MD5 or SHA
	 * 
	 * @return encypted password based on the algorithm.
	 */
	public static String encodePassword(String password, String algorithm) {
		byte[] unencodedPassword = password.getBytes();
		MessageDigest md = null;
		try {
			// first create an instance, given the provider
			md = MessageDigest.getInstance(algorithm);
		} catch (Exception e) {
			log.error("Exception: " + e);
			return password;
		}

		md.reset();

		// call the update method one or more times
		// (useful when you don't know the size of your data, eg. stream)
		md.update(unencodedPassword);

		// now calculate the hash
		byte[] encodedPassword = md.digest();
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < encodedPassword.length; i++) {
			if ((encodedPassword[i] & 0xff) < 0x10) {
				buf.append("0");
			}
			buf.append(Long.toString(encodedPassword[i] & 0xff, 16));
		}

		return buf.toString();
	}

	/**
	 * Encode a string using Base64 encoding. Used when storing passwords as
	 * cookies.
	 * 
	 * This is weak encoding in that anyone can use the decodeString routine to
	 * reverse the encoding.
	 * 
	 * @param str
	 * @return String
	 */
	public static String encodeString(String str) {
		sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
		return encoder.encodeBuffer(str.getBytes()).trim();
	}

	/**
	 * Decode a string using Base64 encoding.
	 * 
	 * @param str
	 * @return String
	 */
	public static String decodeString(String str) {
		sun.misc.BASE64Decoder dec = new sun.misc.BASE64Decoder();
		try {
			return new String(dec.decodeBuffer(str));
		} catch (IOException io) {
			throw new RuntimeException(io.getMessage(), io.getCause());
		}
	}

	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	@SuppressWarnings("deprecation")
	public static String formatTime(Timestamp time) {
		int hour = time.getHours();
		int minute = time.getMinutes();
		String hourString;
		String minuteString;

		if (hour < 10) {
			hourString = "0" + hour;
		} else {
			hourString = Integer.toString(hour);
		}
		if (minute < 10) {
			minuteString = "0" + minute;
		} else {
			minuteString = Integer.toString(minute);
		}

		return hourString + ":" + minuteString;
	}

	/**
	 * 将题干中的‘____’替换成题号
	 * 
	 * @param filecontent
	 * @param num
	 * @return
	 */
	public static String regexQuestionNumNoLink(String filecontent, int num) {
		filecontent = replace(filecontent, "__", "____");
		String pattern = "\\_(_+)\\_";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(filecontent);
		StringBuffer sb = new StringBuffer();
		// int i = 0;
		while (m.find()) {
			// i++;
			// System.out.println(m.group(1));
			@SuppressWarnings("unused")
			StringBuffer res = new StringBuffer(m.group(1));
			m.appendReplacement(sb, "(" + num + ")");
			num = num + 1;
			// System.out.println(sb.toString());
		}
		m.appendTail(sb);
		return sb.toString();
	}

	public static String replace(String s, String sub, String with) {

		if (s == null || s.equals("") || sub == null || sub.equals("")) {
			return s;
		}
		int c = 0;
		int i = s.indexOf(sub, c);
		if (i == -1) {
			return s;
		}

		StringBuffer buf = new StringBuffer(s.length() + with.length());

		do {
			buf.append(s.substring(c, i));
			buf.append(with);
			c = i + sub.length();
		} while ((i = s.indexOf(sub, c)) != -1);

		if (c < s.length()) {
			buf.append(s.substring(c, s.length()));
		}

		return buf.toString();
	}

	/**
	 * 
	 * 根据当前时间获取差距int天的整点日期
	 * example:当前时间2008-9-25 12:33:25 day=1
	 * return 2008-9-26 00:00:00
	 * @param day
	 * @return
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public static Date getDateByInt(int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.DATE, day);
		return cal.getTime();
	}
	
	/**
	 * 
	 * hql的like参数判断
	 * @param str
	 * @return
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public static String hqlParamLike(String str) {
		if (null == str || str.equals("")){
			return "%";
		}else {
			return "%" + str + "%";
		}
	}
}
