/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.struts;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.utils.PropertiesFinalValue;
import com.cd_help.onlineOF.web.vo.OrdersItemVo;
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
	private List<OrdersItemVo> itemVoList;
	private int page = 1;
	private String o = "";
	private String endTime = "";
	private String memberId = "";
	private String restaurantId = "";
	/**
	 * comment here
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private static final long serialVersionUID = 1L;

	public String addOrders() throws AppException {
		memberId = "member123";
		restaurantId = "a8b6815d108a4f35a7f00d27eabd49d3";
		OrdersVo ordersVo = new OrdersVo();
		ordersVo.setContactGender(1);
		ordersVo.setContactName("冬瓜");
		ordersVo.setContactPhone("7788120");
		ordersVo.setOrdersCode("5432452453");
		ordersVo.setRemark("快餐送到楼下， 到后给我电话");
		ordersVo.setRequestAddress("西苑露12号5楼333室");
		ordersVo.setStatus(PropertiesFinalValue.ORDER_WAIT);
		try {
			this.getOnlineOF().getOrdersManager().create(
					this.getSession(),
					ordersVo,
					memberId,
					restaurantId,
					new String[] { "0c8159ba1acb4aefb057ecae9b7f7586",
							"1eb3e180face4b4fbaeed024cfbd770d",
							"45a63e044ab0400e91f5b4846406cfa3" },
					new String[] { "5", "8", "3" });
		} catch (Exception e) {
			throw new AppException("", "Adding the new order error!");
		}
		return SUCCESS;
	}

	/**
	 * 删除订单
	 * 
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String delOrders() throws AppException {
		String[] checkItems = this.getRequest()
				.getParameterValues("checksItem");
		for (String str : checkItems) {
			try {
				this.getOnlineOF().getOrdersManager().delte(this.getSession(),
						str);
			} catch (Exception e) {
				throw new AppException("", "Failure to update more");
			}
		}
		return SUCCESS;
	}

	/**
	 * 批量更新订单
	 * 
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String updateManyOrders() throws AppException {
		String[] checkItems = this.getRequest()
				.getParameterValues("checksItem");
		for (String str : checkItems) {
			ordersVo.setOrdersId(str);
			ordersVo.setStatus(this.getRequest().getParameter("status"));
			try {
				this.getOnlineOF().getOrdersManager().update(this.getSession(),
						ordersVo);
			} catch (Exception e) {
				throw new AppException("", "Failure to update more");
			}
		}
		ordersVo.setStatus("");
		return SUCCESS;
	}

	/**
	 * 更新订单
	 * 
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String updateOrders() throws AppException {
		try {
			this.getOnlineOF().getOrdersManager().update(this.getSession(),
					ordersVo);
		} catch (Exception e) {
			throw new AppException("", "Updating the order error!");
		}
		this.getRequest().setAttribute("upd", true);
		return SUCCESS;
	}

	/**
	 * 
	 * 订单详细
	 * 
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String searchOrderInfo() throws AppException {
		try {
			ordersVo = this.getOnlineOF().getOrdersManager().get(
					this.getSession(), ordersVo.getOrdersId());
			itemVoList = this.getOnlineOF().getOrdersManager()
					.searchFoodListByOrderId(this.getSession(),
							ordersVo.getOrdersId());
		} catch (Exception e) {
			throw new AppException("", "Loading the order deatil info error!");
		}
		this.getRequest().setAttribute("tip", PropertiesFinalValue.TIP);
		return SUCCESS;
	}

	/**
	 * 
	 * 查询订单列表
	 * 
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String searchOrders() throws AppException {
		pb.setPagesize(PropertiesFinalValue.PAGE_SIZE);
		pb.setCurrentPage(page);
		if (o.equals("tod")) {
			try {
				pb = this.getOnlineOF().getOrdersManager()
						.searchTodayOrdersByPage(this.getSession(), ordersVo,
								pb);
			} catch (Exception e) {
				log.error("", e);
				throw new AppException("", "Loading the orders error！");
			}
		} else {
			try {
				pb = this.getOnlineOF().getOrdersManager()
						.searchHistoryOrdersByPage(this.getSession(), ordersVo,
								endTime, pb);
			} catch (Exception e) {
				log.error("", e);
				throw new AppException("", "Loading the orders error！");
			}
		}
		if (this.getSession().getUsersVo().getIsSuper().equals(1)) {
			try {
				restaurantVos = this.getOnlineOF().getRestaurantManager()
						.loadAll();
			} catch (Exception e) {
				throw new AppException("", "Error");
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

	public List<OrdersItemVo> getItemVoList() {
		return itemVoList;
	}

	public void setItemVoList(List<OrdersItemVo> itemVoList) {
		this.itemVoList = itemVoList;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
}