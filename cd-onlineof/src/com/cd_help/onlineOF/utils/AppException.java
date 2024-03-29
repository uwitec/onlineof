/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.utils;

/**
 * <b><code></code></b>
 * <p/>
 * 自定义异常类
 * <p/>
 * <b>Creation Time:</b> Jul 3, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
public class AppException extends Exception{

	
	/* 错误编号 */
	private String error_code;

	public AppException(String error_code, String message) {
		this(error_code, message, null);
	}

	public AppException(String error_code, String message, Throwable e) {
		super(message, e);
		this.error_code = error_code;
	}

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	
}
