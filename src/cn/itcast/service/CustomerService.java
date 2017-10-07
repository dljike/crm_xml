package cn.itcast.service;

import java.io.File;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Customer;
import cn.itcast.utils.PageBean;

public interface CustomerService {
	/**
	 * 添加客户
	 * @param customer
	 */
	public void save(Customer customer);
	
	/**
	 * 查询总条数
	 * @param dc 
	 * @return
	 */
	public int findCount(DetachedCriteria dc);
	/**
	 * 分页查询数据
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public List<Customer> findPageList(DetachedCriteria dc,int start, int pageSize);

	/**
	 * 删除客户
	 * @param cust_id
	 */
	public void deleteCustomer(Long cust_id);
	/**
	 * 根据id查找客户
	 * @param cust_id
	 * @return
	 */
	public Customer findCustomerById(Long cust_id);
	/**
	 * 修改用户信息
	 * @param customer
	 * @param upload
	 * @param uploadFileName
	 */
	public void updateCustomer(Customer customer, File upload,
			String uploadFileName);
	/**
	 * 获取所有
	 * @return
	 */
	public List<Customer> findCustomerList();

}
