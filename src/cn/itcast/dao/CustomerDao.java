package cn.itcast.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Customer;
import cn.itcast.utils.PageBean;

public interface CustomerDao {
	/**
	 * ����ͻ�
	 * @param customer
	 */
	void save(Customer customer);
	/**
	 * ��ȡ��ҳ�б�
	 * @param pb 
	 * @return
	 */
	List<Customer> getCustomerList(DetachedCriteria dc,int start, int pageSize);
	/**
	 * ��ȡ������������
	 * @param dc 
	 * @return
	 */
	int getAllCount(DetachedCriteria dc);
	
	/**
	 * ɾ��
	 * @param c
	 */
	void deleteCustomer(Customer c);
	/**
	 * ����id����
	 * @param cust_id
	 * @return
	 */
	Customer findById(Long cust_id);
	/**
	 * �޸��û���Ϣ
	 * @param customer
	 */
	void updateCustomer(Customer customer);
	/**
	 * ��ȡ�����û�
	 * @return
	 */
	List<Customer> findCustomerList();
	
	

}
