package cn.itcast.service;

import cn.itcast.domain.SysUser;

public interface UserService {
	/**
	 * ×¢²áÓÃ»§
	 * @param user
	 */
	public int regist(SysUser user);
	
	public SysUser userLogin(SysUser sysUser);
	
	
	

}
