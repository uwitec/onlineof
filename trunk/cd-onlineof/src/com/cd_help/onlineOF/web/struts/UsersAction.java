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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.ConvertUtils;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.utils.StringUtil;
import com.cd_help.onlineOF.web.vo.RestaurantVo;
import com.cd_help.onlineOF.web.vo.RoleVo;
import com.cd_help.onlineOF.web.vo.UsersVo;

/**
 * <b><code></code></b>
 * <p/>
 * 用户处理Action
 * <p/>
 * <b>Creation Time:</b> Jul 25, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
@Service("usersAction")
@Scope("prototype")
public class UsersAction extends BaseAction {

	private String usersId;
	private UsersVo usersVo = new UsersVo(); // 用户
	private List<UsersVo> usersVoList;
	private PageBean pb; // 分页
	private int page = 1;
	private String usersname;
	private String restaurantId;
	private List<RestaurantVo> restaurantVos = new ArrayList<RestaurantVo>();
	private String checksItem[] = {};
	private List<RoleVo> roleVos = new ArrayList<RoleVo>();

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
			this.pb.setPagesize(10);
			log.debug("--->> search by usersname");
			params = new String[] { "usersname", "restaurantId" };
			conditions = new Object[] {
					null == this.usersname ? "%" : "%" + this.usersname + "%",
					null == restaurantId || "".equals(restaurantId) ? "%" : "%"
							+ this.restaurantId + "%" };
			if (null != this.getSession()
					&& this.getSession().getUsersVo().getIsSuper() == 1) {
				log.debug("--->> 超级用户");
			}
			// 加载所有餐厅
			loadAllRestaurant();
			this.pb = this.getOnlineOF().getUsersManager().searchByPage(hql,
					params, conditions, this.pb, this.getSession());
		} catch (Exception e) {
			log.error(null,e);
			throw new AppException("",e.getMessage());
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
			roleVos = this.getOnlineOF().getRoleManager().loadAllRole(this.getSession());
		}catch(Exception e){
			log.error(e);
			throw new AppException("",e.getMessage(),e);
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
			usersVo.setBirthday(ConvertUtils.toDate2(usersVo.getBirthdayStr()));
			usersVo.setPassword(StringUtil.encodePassword(usersVo.getPassword(), "MD5"));
			this.getOnlineOF().getUsersManager().addUsers(this.getSession(), usersVo);
			this.searchUsersByPage();
		}catch(Exception e){
			log.error(e);
			throw new AppException("",e.getMessage(),e);
		}
		return SUCCESS;
	}

	/**
	 * 删除用户
	 * 
	 * @return
	 * @throws AppException 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String deleteUsers() throws AppException {
		log.debug("--->> begin deleteUsers");
		try {
			if(null != this.checksItem){
				for(int i=0; i<this.checksItem.length; i++){
					log.debug(this.checksItem[i]);
					this.getOnlineOF().getUsersManager().deleteUsers(this.getSession(),
							this.checksItem[i]);
				}
			}
			this.searchUsersByPage();
		} catch (Exception e) {
			log.error(e);
			throw new AppException("",e.getMessage(),e);
		}
		return SUCCESS;
	}
	
	private void loadAllRestaurant() throws AppException{
		// 加载所有餐厅
		try{
		   restaurantVos = this.getOnlineOF().getRestaurantManager().loadAll();
		}catch(AppException e){
			throw new AppException("",e.getMessage(),e);
		}
	}

	/**
	 * 跳转到编辑页面
	 * @return
	 * @throws AppException 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String editUsres() throws AppException {
		log.debug("--->> begin editUsres");
		try {
			usersVo = this.getOnlineOF().getUsersManager().getUsersById(
					this.getSession(), usersId);
			// 加载所有餐厅
			loadAllRestaurant(); 
			// 加载所有角色
			roleVos = this.getOnlineOF().getRoleManager().loadAllRole(this.getSession());
			return SUCCESS;
		} catch (AppException e) {
			this.setErrorMsg(e.getMessage());
			this.setErrorCode(e.getError_code());
			return ERROR;
			// log.error(e);
			// throw new AppException("",e.getMessage(),e);
		}
	}
	
	/**
	 * 更新用户
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String updateUsers() throws AppException{
		log.debug("--->> begin updateUsers");
		try{
			this.getOnlineOF().getUsersManager().updateUsers(this.getSession(), usersVo);
			this.searchUsersByPage();
		}catch(Exception e){
			log.error(e);
			throw new AppException("",e.getMessage(),e);
		}
		return SUCCESS;
	}
	
	/**
	 * 跳转到重置密码页面 
	 * @return
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String forwardPasswordSet(){
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
    
	public String[] getChecksItem() {
		return checksItem;
	}

	public void setChecksItem(String[] checksItem) {
		this.checksItem = checksItem;
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
