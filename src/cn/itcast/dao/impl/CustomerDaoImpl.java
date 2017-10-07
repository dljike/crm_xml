package cn.itcast.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import cn.itcast.utils.PageBean;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	/**
	 * 保存用户
	 */
	@Override
	public void save(Customer customer) {
		this.getHibernateTemplate().save(customer);
	}

 
	/**
	 * 获取总条数
	 */
	@Override
	public int getAllCount(DetachedCriteria dc) {
		// 离线查询总行数
		dc.setProjection(Projections.rowCount());
//		 List<Long> count = (List<Long>) this.getHibernateTemplate().find("select count(*) from Customer");
		List<Long> count = (List<Long>) this.getHibernateTemplate().findByCriteria(dc);
		return count.get(0).intValue();
	}
	/**
	 * 获取分页数据
	 */
	@Override
	public List<Customer> getCustomerList(DetachedCriteria dc,int start, int pageSize) {
		//创建离线查询
//		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		
		// 清空之前设置查询总行的信息
		dc.setProjection(null);
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(dc,start,pageSize);
		return list;
	}

	/**
	 * 删除
	 */
	@Override
	public void deleteCustomer(Customer customer) {
		 this.getHibernateTemplate().delete(customer);
		
	}

	/**
	 * 根据id查找
	 */
	@Override
	public Customer findById(Long cust_id) {
		 Customer customer = this.getHibernateTemplate().get(Customer.class, cust_id);
		return customer;
	}

	/**
	 * 修改用户
	 */
	@Override
	public void updateCustomer(Customer customer) {
		this.getHibernateTemplate().update(customer);
		
	}

	/**
	 * 获取所有用户
	 */
	@Override
	public List<Customer> findCustomerList() {
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer");
		return list;
	}

 

}
