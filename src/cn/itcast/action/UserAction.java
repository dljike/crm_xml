package cn.itcast.action;

import cn.itcast.domain.SysUser;
import cn.itcast.service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<SysUser> {
	private static final long serialVersionUID = 1L;
	
	private SysUser sysUser = new SysUser();
	@Override
	public SysUser getModel() {
		return sysUser;
	}
	
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	/**
	 * �û�ע��
	 * @return
	 */
	public String register(){
		int regist = userService.regist(sysUser);
		if (regist == 0) {
			return "false";
		}
		return SUCCESS;
	}
	
	/**
	 * �û���¼
	 */
	public String login(){
		System.out.println(sysUser);
		if (sysUser.getUser_code() == null || sysUser.getUser_password() == null) {
			return "login";
		}
		SysUser user = userService.userLogin(sysUser);
		if (user == null) {
			this.addActionError("�û������������");
			return "login";
		}
		
		return SUCCESS;
	}
	
	
	
	
}
