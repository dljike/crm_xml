package cn.itcast.service;

import java.io.File;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Customer;
import cn.itcast.utils.PageBean;

public interface CustomerService {
	/**
	 * ��ӿͻ�
	 * @param customer
	 */
	public void save(Customer customer);
	
	/**
	 * ��ѯ������
	 * @param dc 
	 * @return
	 */
	public int findCount(DetachedCriteria dc);
	/**
	 * ��ҳ��ѯ����
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public List<Customer> findPageList(DetachedCriteria dc,int start, int pageSize);

	/**
	 * ɾ���ͻ�
	 * @param cust_id
	 */
	public void deleteCustomer(Long cust_id);
	/**
	 * ����id���ҿͻ�
	 * @param cust_id
	 * @return
	 */
	public Customer findCustomerById(Long cust_id);
	/**
	 * �޸��û���Ϣ
	 * @param customer
	 * @param upload
	 * @param uploadFileName
	 */
	public void updateCustomer(Customer customer, File upload,
			String uploadFileName);
	/**
	 * ��ȡ����
	 * @return
	 */
	public List<Customer> findCustomerList();

}
