package cn.itcast.dao;

import cn.itcast.domain.SysUser;

public interface UserDao {
	/**
	 * ע���û�
	 * @param user
	 */
	public void regist(SysUser user);
 
	/**
	 * �û���¼
	 * @param sysUser
	 * @return
	 */
	public SysUser userLogin(SysUser sysUser);
}
