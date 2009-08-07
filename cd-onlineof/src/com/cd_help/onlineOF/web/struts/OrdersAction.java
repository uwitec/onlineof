/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.struts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.vo.OrdersVo;
import com.cd_help.onlineOF.web.vo.RestaurantVo;

/**
 * <b><code></code></b>
 * <p/>
 * 处理订单 Action
 * <p/>
 * <b>Creation Time:</b> Jul 3, 2009
 * 
 * @author TanDong
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
@Service("ordersAction")
@Scope("prototype")
public class OrdersAction extends BaseAction {
	private PageBean pb = new PageBean();
	private OrdersVo ordersVo = new OrdersVo();
	private List<RestaurantVo> restaurantVos;
	private int page = 1;
	private String o = "";
	private String endTime = "";

	/**
	 * comment here
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private static final long serialVersionUID = 1L;

	public String addOrders() {
		return SUCCESS;
	}

	public String searchOrders() throws AppException {
//		if (!endTime.equals("")){
//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
//			System.out.println(endTime);
//			try {
//				simpleDateFormat.parse(endTime);
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//		}
		pb.setPagesize(2);
		pb.setCurrentPage(page);
		if (o.equals("tod")) {
			try {
				pb = this.getOnlineOF().getOrdersManager()
						.searchTodayOrdersByPage(ordersVo, pb,
								this.getSession());
			} catch (Exception e) {
				log.error("", e);
				throw new AppException("", "Loading the orders error！");
			}
		} else {
			try {
				pb = this.getOnlineOF().getOrdersManager()
						.searchHistoryOrdersByPage(ordersVo, endTime, pb,
								this.getSession());
			} catch (Exception e) {
				log.error("", e);
				throw new AppException("", "Loading the orders error！");
			}
		}
		if (this.getSession().getUsersVo().getIsSuper().equals(1)) {
			try {
				restaurantVos = this.getOnlineOF().getRestaurantManager().loadAll();
			} catch (Exception e) {
				throw new AppException("","Error");
			}
		}
		return SUCCESS;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getO() {
		return o;
	}

	public void setO(String o) {
		this.o = o;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public OrdersVo getOrdersVo() {
		return ordersVo;
	}

	public void setOrdersVo(OrdersVo ordersVo) {
		this.ordersVo = ordersVo;
	}

	public PageBean getPb() {
		return pb;
	}

	public void setPb(PageBean pb) {
		this.pb = pb;
	}

	public List<RestaurantVo> getRestaurantVos() {
		return restaurantVos;
	}

	public void setRestaurantVos(List<RestaurantVo> restaurantVos) {
		this.restaurantVos = restaurantVos;
	}
}
