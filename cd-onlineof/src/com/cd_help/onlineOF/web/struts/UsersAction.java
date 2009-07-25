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
import com.cd_help.onlineOF.utils.ConvertUtils;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.utils.StringUtil;
import com.cd_help.onlineOF.web.vo.RestaurantVo;
import com.cd_help.onlineOF.web.vo.RoleVo;
import com.cd_help.onlineOF.web.vo.UsersVo;

@SuppressWarnings("serial")
@Service("usersAction")
public class UsersAction extends BaseAction {

	private String usersId;
	private UsersVo usersVo = new UsersVo(); // 用户
	private List<UsersVo> usersVoList;
	private PageBean pb; // 分页
	private int page = 1;
	private String usersname;
	private String restaurantId;
	private List<RestaurantVo> restaurantVos = new ArrayList<RestaurantVo>();
	private List<RoleVo> roleVos = new ArrayList<RoleVo>();
	private String checkRoles[] = {};

	/**
	 * 加载所有用户
	 * 
	 * @return
	 * @throws AppException 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String searchUsersByPage() throws AppException {
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
			loadAllRestaurant();
			this.pb = this.getOnlineOF().getUsersManager().searchByPage(hql,
					params, conditions, this.pb, this.getSession());
		} catch (AppException e) {
			log.error(null,e);
			throw new AppException(e.getError_code(),e.getMessage());
		}
		return SUCCESS;
	}
	
	/**
	 * 跳转到添加用户页面
	 * @return
	 * @throws AppException 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String forwardAddUsers() throws AppException{
		try{
			// 加载所有餐厅
			loadAllRestaurant(); 
			// 加载所有角色
			roleVos = this.getOnlineOF().getRoleManager().loadAll(this.getSession());
		}catch(AppException e){
			log.error(e);
			throw new AppException(e.getError_code(),e.getMessage());
		}
		return SUCCESS;
	}
	
	/**
	 * 添加用户
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String addUsers() throws AppException{
		try{
			String[] roles = this.checkRoles;
			List<String> roleIds = null;
			if (null != roles) {
				roleIds = new ArrayList<String>();
				for(int i=0; i<roles.length; i++){
					roleIds.add(roles[i]);
				}
			}
			usersVo.setBirthday(ConvertUtils.toDate2(usersVo.getBirthdayStr()));
			usersVo.setPassword(StringUtil.encodePassword(usersVo.getPassword(), "MD5"));
			this.getOnlineOF().getUsersManager().addUsers(this.getSession(), usersVo, roleIds);
			this.searchUsersByPage();
		}catch(AppException e){
			log.error(e);
			throw new AppException(e.getError_code(),e.getMessage());
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
	
	private void loadAllRestaurant() throws AppException{
		// 加载所有餐厅
		restaurantVos = this.getOnlineOF().getRestaurantManager().loadAll();
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
	
	@Autowired
	@Resource(name = "pageBean")
	public void setPb(PageBean pb) {
		this.pb = pb;
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
    
	public String[] getCheckRoles() {
		return checkRoles;
	}

	public void setCheckRoles(String[] checkRoles) {
		this.checkRoles = checkRoles;
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

	public List<RoleVo> getRoleVos() {
		return roleVos;
	}

	public void setRoleVos(List<RoleVo> roleVos) {
		this.roleVos = roleVos;
	}
}
