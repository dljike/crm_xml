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
	 * �����û�
	 */
	@Override
	public void save(Customer customer) {
		this.getHibernateTemplate().save(customer);
	}

 
	/**
	 * ��ȡ������
	 */
	@Override
	public int getAllCount(DetachedCriteria dc) {
		// ���߲�ѯ������
		dc.setProjection(Projections.rowCount());
//		 List<Long> count = (List<Long>) this.getHibernateTemplate().find("select count(*) from Customer");
		List<Long> count = (List<Long>) this.getHibernateTemplate().findByCriteria(dc);
		return count.get(0).intValue();
	}
	/**
	 * ��ȡ��ҳ����
	 */
	@Override
	public List<Customer> getCustomerList(DetachedCriteria dc,int start, int pageSize) {
		//�������߲�ѯ
//		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		
		// ���֮ǰ���ò�ѯ���е���Ϣ
		dc.setProjection(null);
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(dc,start,pageSize);
		return list;
	}

	/**
	 * ɾ��
	 */
	@Override
	public void deleteCustomer(Customer customer) {
		 this.getHibernateTemplate().delete(customer);
		
	}

	/**
	 * ����id����
	 */
	@Override
	public Customer findById(Long cust_id) {
		 Customer customer = this.getHibernateTemplate().get(Customer.class, cust_id);
		return customer;
	}

	/**
	 * �޸��û�
	 */
	@Override
	public void updateCustomer(Customer customer) {
		this.getHibernateTemplate().update(customer);
		
	}

	/**
	 * ��ȡ�����û�
	 */
	@Override
	public List<Customer> findCustomerList() {
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer");
		return list;
	}

 

}
