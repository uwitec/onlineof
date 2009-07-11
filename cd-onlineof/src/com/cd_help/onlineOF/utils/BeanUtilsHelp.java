/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.utils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class BeanUtilsHelp {

	public static void copyProperties(Object src,Object target) throws AppException {
		   try {
			BeanUtils.copyProperties(src, target);
		} catch (IllegalAccessException e) {
			throw new AppException(1,"转换异常",e);
		} catch (InvocationTargetException e) {
			throw new AppException(1,"转换异常",e);
		}
	 }
}
