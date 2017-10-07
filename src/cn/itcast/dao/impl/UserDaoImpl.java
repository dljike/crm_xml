package cn.itcast.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.SysUser;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	/**
	 * 用户注册
	 */ 
	public void regist(SysUser user) {
		this.getHibernateTemplate().save(user);
	}

 

	/**
	 * 用户登录
	 */
	public SysUser userLogin(SysUser sysUser) {
		
		  List<SysUser> find = (List<SysUser>) this.getHibernateTemplate().find("from SysUser where user_code=? and user_password=? ", sysUser.getUser_code(),sysUser.getUser_password());
		  if (find.size()>0) {
			return find.get(0);
		}
		  return null;
	}

}
