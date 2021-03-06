package cn.itcast.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import cn.itcast.service.CustomerService;
import cn.itcast.utils.PageBean;
import cn.itcast.utils.SystemConstants;
import cn.itcast.utils.UploadUtils;

public class CustomerServiceImpl implements CustomerService {

	
	private CustomerDao customerDao;
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}


	/**
	 * 添加客户
	 */
	@Override
	public void save(Customer customer) {
		customerDao.save(customer);
	}
 

	/**
	 * 查询总条数
	 */
	@Override
	public int findCount(DetachedCriteria dc) {
		return  customerDao.getAllCount(dc);
	}


	@Override
	public List<Customer> findPageList(DetachedCriteria dc,int start, int pageSize) {
		 List<Customer> list = customerDao.getCustomerList(dc,start,pageSize);
		 return list;
	}

	/**
	 * 删除
	 */
	@Override
	public void deleteCustomer(Long cust_id) {
		Customer c = customerDao.findById(cust_id);
		
		// 删除服务器对应图片
		if (StringUtils.isNoneBlank(c.getCust_image())) {
			new File(SystemConstants.baseDir+c.getCust_image()).delete();
		}
		customerDao.deleteCustomer( c);
		
	}

	/**
	 * 根据id查找客户
	 */
	@Override
	public Customer findCustomerById(Long cust_id) {
		return  customerDao.findById(cust_id);
	}

	/**
	 * 修改信息
	 */
	@Override
	public void updateCustomer(Customer customer, File upload,
			String uploadFileName) {
			// 注意： 这里要用oldcustomer对象，session中不能有相同的OID
			Customer oldCustomer = customerDao.findById(customer.getCust_id());
			
			 if (upload != null) {
				 // 删除旧文件
				 if (StringUtils.isNotBlank(oldCustomer.getCust_image())) {
					new File(SystemConstants.baseDir+ oldCustomer.getCust_image()).delete();
				}
				 // 生成新文件
				// 随机生成文件名
					String randomFileName = UploadUtils.generateRandonFileName(uploadFileName);
					// 生成随机二级目录
					String randomDir = UploadUtils.generateRandomDir(randomFileName);
					// 图片保存到指定路径
					try {
						FileUtils.copyFile(upload, new File(SystemConstants.baseDir+randomDir+"/"+randomFileName));
					} catch (IOException e) {
						e.printStackTrace();
					}
					// 设置数据库图片保存路径
					oldCustomer.setCust_image(randomDir+"/"+randomFileName);
					oldCustomer.setCust_filename(uploadFileName);
				
			} 
			 	oldCustomer.setCust_name(customer.getCust_name());
				oldCustomer.setCust_phone(customer.getCust_phone());
				oldCustomer.setCust_address(customer.getCust_address());
				
				if(StringUtils.isBlank(customer.getBaseDictIndustry().getDict_id())){
					oldCustomer.setBaseDictIndustry(null);
				}else{
					oldCustomer.setBaseDictIndustry(customer.getBaseDictIndustry());
				}
				
				if(StringUtils.isBlank(customer.getBaseDictLevel().getDict_id())){
					oldCustomer.setBaseDictLevel(null);
				}else{
					oldCustomer.setBaseDictLevel(customer.getBaseDictLevel());
				}
				if(StringUtils.isBlank(customer.getBaseDictSource().getDict_id())){
					oldCustomer.setBaseDictSource(null);
				}else{
					oldCustomer.setBaseDictSource(customer.getBaseDictSource());
				}
				customerDao.updateCustomer(oldCustomer);
			
	}

	/**
	 * 获取所有用户
	 */
	@Override
	public List<Customer> findCustomerList() {
		return customerDao.findCustomerList();
	 
	}

 

}
