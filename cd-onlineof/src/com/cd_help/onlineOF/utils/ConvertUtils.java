/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <b><code></code></b>
 * <p/>
 * 日期转换类
 * <p/>
 * <b>Creation Time:</b> Jul 3, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public class ConvertUtils {
	
	/**
	 * 转换一
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public static SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
	/**
	 * 转换二
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public static SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMdd");

	/**
	 * 将Date转换为String yyyy-MM-dd hh:mm
	 * @param date
	 * @return
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public static String toString1(Date date) {
		if(date == null) return "";
		return format1.format(date);
	}
	/**
	 * 将Date转换为String yyyyMMdd
	 * @param date
	 * @return
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public static String toString2(Date date) {
		if(date == null) return "";
		return format2.format(date);
	}

	/**
	 * 将String转换为Date yyyy-MM-dd hh:mm
	 * @param strDate
	 * @return
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public static Date toDate1(String strDate) {
		if (strDate == null || "".equals(strDate)) {
			return null;
		} else {
			try {
				return format1.parse(strDate);
			} catch (ParseException e) {
				return null;
			}
		}
	}
	/**
	 * 将String转换为Date yyyyMMdd
	 * @param strDate
	 * @return
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public static Date toDate2(String strDate) {
		if (strDate == null || "".equals(strDate)) {
			return null;
		} else {
			try {
				return format2.parse(strDate);
			} catch (ParseException e) {
				return null;
			}
		}
	}
}
