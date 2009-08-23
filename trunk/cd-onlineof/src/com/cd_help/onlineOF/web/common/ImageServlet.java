package com.cd_help.onlineOF.web.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cd_help.onlineOF.api.OnlineOF;
import com.cd_help.onlineOF.utils.AppException;

@SuppressWarnings("serial")
public class ImageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String resId = req.getParameter("resId");
		int typeId = Integer.parseInt(req.getParameter("typeId")); /*
																	 * typeId:1代表餐厅图片
																	 * 2代表菜图片
																	 */
		resp.setHeader("Pragma", "No-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);
		resp.setContentType("image/jpeg;charset=GB2312");
		ServletOutputStream out = null;
		InputStream in = null;
		try {
			Blob image = null;
			if (null != resId && resId.length() > 0) {
				if (typeId == 1) {
					image = this.getOnlineOF().getRestaurantManager()
							.getRestaurantById(resId).getImg();
				} else if (typeId == 2) {
					image = this.getOnlineOF().getFoodManager().getFoodById(resId)
							.getImg();
				} else {
					throw new AppException("img0002", "数据库读取图片出错!");
				}
			} else {
				throw new AppException("img0001", "操作错误,图片不存在!");
			}
			if (null != image) {
				try {
					in = image.getBinaryStream();
					out = resp.getOutputStream();
					byte[] bytes = image.getBytes(new Long(1),in.available());
					out.write(bytes);
					out.flush();
				} catch (Exception ex) {
					throw new AppException("img0004", "响应图片出错!");
				} finally {
					if (in != null) {
						in.close();
					}
					if (out != null) {
						out.close();
					}
				}
			} else {
				throw new AppException("img0003", "该餐厅或者菜不存在图片!");
			}
		} catch (Exception ex) {
			//ex.printStackTrace();
			throw new ServletException("读取图片出错!");
		}
	}

	// 获取到OnlineOF
	public OnlineOF getOnlineOF() throws Exception {
		OnlineOF onlineOF = null;
		ServletContext servletContext = this.getServletContext();
		WebApplicationContext WebApplicationContext = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servletContext);
		onlineOF = (OnlineOF) WebApplicationContext.getBean("onlineOF");
		return onlineOF;
	}

}
