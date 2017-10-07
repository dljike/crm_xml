package cn.itcast.service.impl;


import cn.itcast.dao.UserDao;
import cn.itcast.domain.SysUser;
import cn.itcast.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * �û�ע��
	 */
	public int regist(SysUser user) {
		user.setUser_state("1");
		userDao.regist(user);
		return 1;
	}

	/**
	 * �û���¼
	 */
	public SysUser userLogin(SysUser sysUser) {
		return userDao.userLogin(sysUser);
	}

}
