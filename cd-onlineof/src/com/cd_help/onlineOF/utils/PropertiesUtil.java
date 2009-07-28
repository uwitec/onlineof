/**
 * 
 */
package com.cd_help.onlineOF.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

/**
 * <b><code></code></b>
 * <p/>
 * 屬性文件工具類
 * <p/>
 * <b>Creation Time:</b> 2009-7-28
 * @author SongHao
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public final class PropertiesUtil {
	private Properties pros = null;
	private String fn = null;// 记录配置文件名

	/**
	 * 创建新属性文件用
	 */
	public PropertiesUtil() {
		this.pros = new Properties();
	}

	/**
	 * 读写属性文件
	 * 
	 * @param resource
	 *            属性文件所在路径 以根路径为原点
	 * @throws IOException
	 */
	public PropertiesUtil(String resource) {
		this.pros = new Properties();
		this.fn = resource;
		InputStream is = PropertiesUtil.class.getResourceAsStream(this.fn); // 获取文件输出流
		try {
			this.pros.load(is);
		} catch (Exception e) {
			System.out.print("无法读取指定的配置文件：" + this.fn);
		}
	}

	/**
	 * 根据指定的配置项名 获取配置值
	 * 
	 * @param key
	 *            配置项名
	 * @return
	 */
	public String getProperty(String key) {
		return this.pros.getProperty(key);
	}

	/**
	 * 根据指定的配置项名 获取配置值或默认值
	 * 
	 * @param key
	 *            配置项名
	 * @param defaultValue
	 *            当配置值为null时 返回默认值
	 * @return
	 */
	public String getValue(String key, String defaultValue) {
		return this.pros.getProperty(key, defaultValue);
	}

	/**
	 * 设置配置项名称及其值
	 * 
	 * @param key
	 *            配置项名
	 * @param value
	 *            配置值
	 */
	public void setValue(String key, String value) {
		this.pros.setProperty(key, value);
	}

	/**
	 * 保存配置文件，原文件名和抬头描述
	 * 
	 * @param description
	 *            抬头描述
	 * @throws IOException
	 */
	public void saveFile(String description) throws Exception {
		try {
			this.fn = Class.class.getResource(this.fn).toString();
			this.fn = this.fn.replaceAll("%20", " ");
			this.fn = this.fn.substring(6);
			FileOutputStream fout = new FileOutputStream(this.fn);
			this.pros.store(fout, description);// 保存文件
			fout.close();
		} catch (Exception ex) {
			throw new IOException("无法保存指定的配置文件:" + this.fn);
		}
	}

	/**
	 * 保存配置文件，原文件名
	 * 
	 * @throws IOException
	 */
	public void saveFile() throws Exception {
		if (this.fn.length() == 0) {
			throw new IOException("无法保存指定的配置文件:" + this.fn);
		}
		this.saveFile("");
	}

	/**
	 * 保存配置文件，指定文件名
	 * 
	 * @param fileName
	 *            指定文件名
	 * @throws IOException
	 */
	public void saveNewFile(String fileName) throws Exception {
		this.saveNewFile(fileName, "");
	}

	/**
	 * 保存配置文件，指定文件名
	 * 
	 * @param fileName
	 *            指定文件名
	 * @param description
	 *            抬头描述
	 * @throws IOException
	 */
	public void saveNewFile(String fileName, String description)
			throws Exception {
		try {
			if (fileName.length() == 0) {
				throw new IOException();
			}
			if (fileName.charAt(0) == '/') {
				fileName = fileName.substring(1);
			}
			fileName = Class.class.getResource("/").getPath() + fileName;
			fileName = fileName.replaceAll("%20", " ");
			fileName = fileName.substring(1);
			FileOutputStream fout = new FileOutputStream(fileName);
			this.pros.store(fout, description);// 保存文件
			fout.close();
		} catch (Exception e) {
			throw new IOException("无法保存指定的配置文件:" + fileName);
		}
	}

	/**
	 * 获取所有配置项名
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<String> getAllKeyName() {
		ArrayList<String> al = null;
		Enumeration em = this.pros.keys();
		if (em.hasMoreElements()) {
			al = new ArrayList<String>();
		}
		while (em.hasMoreElements()) {
			al.add(em.nextElement().toString());
		}
		return al;
	}
}
