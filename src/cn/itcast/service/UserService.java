package cn.itcast.service;

import cn.itcast.domain.SysUser;

public interface UserService {
	/**
	 * ע���û�
	 * @param user
	 */
	public int regist(SysUser user);
	
	public SysUser userLogin(SysUser sysUser);
	
	
	

}
