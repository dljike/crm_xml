package cn.itcast.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Customer;
import cn.itcast.utils.PageBean;

public interface CustomerDao {
	/**
	 * 保存客户
	 * @param customer
	 */
	void save(Customer customer);
	/**
	 * 获取分页列表
	 * @param pb 
	 * @return
	 */
	List<Customer> getCustomerList(DetachedCriteria dc,int start, int pageSize);
	/**
	 * 获取所有数据条数
	 * @param dc 
	 * @return
	 */
	int getAllCount(DetachedCriteria dc);
	
	/**
	 * 删除
	 * @param c
	 */
	void deleteCustomer(Customer c);
	/**
	 * 根据id查找
	 * @param cust_id
	 * @return
	 */
	Customer findById(Long cust_id);
	/**
	 * 修改用户信息
	 * @param customer
	 */
	void updateCustomer(Customer customer);
	/**
	 * 获取所有用户
	 * @return
	 */
	List<Customer> findCustomerList();
	
	

}
