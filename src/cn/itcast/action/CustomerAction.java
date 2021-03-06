package cn.itcast.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.itcast.domain.Customer;
import cn.itcast.service.CustomerService;
import cn.itcast.utils.PageBean;
import cn.itcast.utils.SystemConstants;
import cn.itcast.utils.UploadUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
 
	private static final long serialVersionUID = 1L;

	private Customer customer = new Customer();
	@Override
	public Customer getModel() {
		return customer;
	}
	
	private CustomerService customerService;
	
	
	private int pageSize; // 接收当前页数，提供set方法
	private int page; // 接收当前是第几页，提供set方法
	
	private PageBean<Customer> pb; // 分页的pagebean要提供get方法，因为页面要获取
	
	private File upload; // 表示上传文件，名字要与页面上file的name一致  获取页面数据 提供set方法
	private String uploadContentType; // 表示上传文件类型 提供set方法   
	private String uploadFileName; // 上传文件的名字 提供set方法
	
	private Customer customerView; // 给修改页面传递信息
	
	private List<Customer> customers; // ajax 获取所有用户 提供get
	
	public List<Customer> getCustomers() {
		return customers;
	}

	public Customer getCustomerView() {
		return customerView;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public PageBean<Customer> getPb() {
		return pb;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public void setPage(int page) {
		this.page = page;
	}

 

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	/**
	 * 保存用户
	 * @return
	 */
	public String save(){
		if (StringUtils.isBlank(customer.getBaseDictIndustry().getDict_id())) {
			customer.setBaseDictIndustry(null);
		}
		if (StringUtils.isBlank(customer.getBaseDictLevel().getDict_id())) {
			customer.setBaseDictLevel(null);
		}
		if (StringUtils.isBlank(customer.getBaseDictSource().getDict_id())) {
			customer.setBaseDictSource(null);
		}
		
		if (upload != null) {
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
			customer.setCust_image(randomDir+"/"+randomFileName);
			// 设置数据库图片真实名字
			customer.setCust_filename(uploadFileName);
			
			
			
		}
		
		customerService.save(customer);
		return SUCCESS;
	}
	
	/**
	 * 获取分页数据 + 条件查询
	 * @return
	 */
	public String getCustomerList(){
		pb = new PageBean<Customer>();
		if (page != 0) {
			pb.setCurrentPage(page);
		}
		if (pageSize != 0) {
			pb.setPageSize(pageSize);
		}
		// 构造离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		// 拼接条件
		if (StringUtils.isNotBlank(customer.getCust_name())) {
				dc.add(Restrictions.eq("cust_name", customer.getCust_name()));
		}
		if(customer.getBaseDictIndustry() != null){
			if (StringUtils.isNotBlank(customer.getBaseDictIndustry().getDict_id())) {
				dc.add(Restrictions.eq("baseDictIndustry.dict_id", customer.getBaseDictIndustry().getDict_id()));
			}
		}
		if(customer.getBaseDictSource() != null){
			if (StringUtils.isNotBlank(customer.getBaseDictSource().getDict_id())) {
				dc.add(Restrictions.eq("baseDictSource.dict_id", customer.getBaseDictSource().getDict_id()));
			}
		}
		if(customer.getBaseDictLevel() != null){
			if (StringUtils.isNotBlank(customer.getBaseDictLevel().getDict_id())) {
				dc.add(Restrictions.eq("baseDictLevel.dict_id", customer.getBaseDictLevel().getDict_id()));
			}
		}

		
		// 查询表里总记录数
		int total = customerService.findCount(dc);
		pb.setTotal(total);
		List<Customer> list = customerService.findPageList(dc,pb.getStart(),pb.getPageSize());
		pb.setDatas(list);
		 
		return SUCCESS;
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String deleteCustomer(){
		
		customerService.deleteCustomer(customer.getCust_id());
		
		return SUCCESS;
	}
	

	/**
	 * 根据id查找用户（修改）
	 * @return
	 */
	public String findCustomerById(){
		customerView = customerService.findCustomerById(customer.getCust_id());
		return SUCCESS;
	}
	
	public String updateCustomer(){
		customerService.updateCustomer(customer,upload,uploadFileName);
		return SUCCESS;
	}
	
 
	
	public String findCustomerList(){
		customers = customerService.findCustomerList();
		return SUCCESS;
	}

}
