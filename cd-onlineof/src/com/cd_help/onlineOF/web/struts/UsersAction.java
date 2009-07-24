/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.struts;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.vo.RestaurantVo;
import com.cd_help.onlineOF.web.vo.UsersVo;

@SuppressWarnings("serial")
@Service("usersAction")
public class UsersAction extends BaseAction {

	private String usersId;
	private UsersVo usersVo;
	private List<UsersVo> usersVoList;
	private PageBean pb;
	private int page = 1;
	private String usersname;
	private String restaurantId;
	private List<RestaurantVo> restaurantVos = new ArrayList<RestaurantVo>();

	/**
	 * 加载所有用户
	 * 
	 * @return
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String searchUsersByPage() {
		log.debug("--->> begin loadAllUsers");
		String params[] = null;
		Object conditions[] = null;
		String hql = "searchUsersByPage";
		try {
			this.pb.setCurrentPage(page);
			this.pb.setPagesize(2);
			log
					.debug("--->> search by usersname" + "  usersname: "
							+ usersname);
			params = new String[] { "usersname", "restaurantId" };
			conditions = new Object[] {
					null == this.usersname ? "%" : "%" + this.usersname + "%",
					null == restaurantId || "".equals(restaurantId) ? "%" : "%"
							+ this.restaurantId + "%" };
			// 只有超级用户采用 根据餐厅去查用户
			if (null != this.getSession()
					&& this.getSession().getUsersVo().getIsSuper() == 1) {
				log.debug("--->> 超级用户");
			}
			// 加载所有餐厅
			restaurantVos = this.getOnlineOF().getRestaurantManager().loadAll();
			this.pb = this.getOnlineOF().getUsersManager().searchByPage(hql,
					params, conditions, this.pb, this.getSession());
		} catch (AppException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * 删除用户
	 * 
	 * @return
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String deleteUsers() {
		log.debug("--->> begin deleteUsers");
		try {
			this.getOnlineOF().getUsersManager().delete(this.getSession(),
					usersId);
			this.searchUsersByPage();
		} catch (AppException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * 根据ID获取信息
	 * 
	 * @return
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String getUsersById() {
		log.debug("--->> begin getUsersById");
		try {
			usersVo = this.getOnlineOF().getUsersManager().get(
					this.getSession(), usersId);
		} catch (AppException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public UsersVo getUsersVo() {
		return usersVo;
	}

	public void setUsersVo(UsersVo usersVo) {
		this.usersVo = usersVo;
	}

	public List<UsersVo> getUsersVoList() {
		return usersVoList;
	}

	public void setUsersVoList(List<UsersVo> usersVoList) {
		this.usersVoList = usersVoList;
	}

	public String getUsersId() {
		return usersId;
	}

	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}

	public PageBean getPb() {
		return pb;
	}

	public String getUsersname() {
		return usersname;
	}

	public void setUsersname(String usersname) {
		this.usersname = usersname;
	}

	public String getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}

	@Autowired
	@Resource(name = "pageBean")
	public void setPb(PageBean pb) {
		this.pb = pb;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<RestaurantVo> getRestaurantVos() {
		return restaurantVos;
	}

	public void setRestaurantVos(List<RestaurantVo> restaurantVos) {
		this.restaurantVos = restaurantVos;
	}
}
