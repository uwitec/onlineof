/**
 * 
 */
package com.cd_help.onlineOF.utils;


/**
 * <b><code></code></b>
 * <p/>
 * Comment here
 * <p/>
 * <b>Creation Time:</b> 2009-7-28
 * @author SongHao
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public final class PropertiesFinalValue {
	private final static PropertiesFinalValue pfv = new PropertiesFinalValue();

	static PropertiesUtil pu;

	private PropertiesFinalValue() {
		if (PropertiesFinalValue.pu == null) {
			PropertiesFinalValue.pu = new PropertiesUtil("/onlineof.properties");
		}
	}

	public static PropertiesFinalValue getInstance() {
		return PropertiesFinalValue.pfv;
	}
	
	public static final String ORDER_WAIT = PropertiesFinalValue.pu.getProperty("order.wait");
	
	public static final Integer PAGE_SIZE = new Integer(PropertiesFinalValue.pu.getProperty("pagesize"));
	
	public static final Integer TIP = new Integer(PropertiesFinalValue.pu.getProperty("tip"));
}
