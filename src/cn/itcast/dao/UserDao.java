package cn.itcast.dao;

import cn.itcast.domain.SysUser;

public interface UserDao {
	/**
	 * 注册用户
	 * @param user
	 */
	public void regist(SysUser user);
 
	/**
	 * 用户登录
	 * @param sysUser
	 * @return
	 */
	public SysUser userLogin(SysUser sysUser);
}
