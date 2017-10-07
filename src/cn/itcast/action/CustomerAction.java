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
	
	
	private int pageSize; // ���յ�ǰҳ�����ṩset����
	private int page; // ���յ�ǰ�ǵڼ�ҳ���ṩset����
	
	private PageBean<Customer> pb; // ��ҳ��pagebeanҪ�ṩget��������Ϊҳ��Ҫ��ȡ
	
	private File upload; // ��ʾ�ϴ��ļ�������Ҫ��ҳ����file��nameһ��  ��ȡҳ������ �ṩset����
	private String uploadContentType; // ��ʾ�ϴ��ļ����� �ṩset����   
	private String uploadFileName; // �ϴ��ļ������� �ṩset����
	
	private Customer customerView; // ���޸�ҳ�洫����Ϣ
	
	private List<Customer> customers; // ajax ��ȡ�����û� �ṩget
	
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
	 * �����û�
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
			// ��������ļ���
			String randomFileName = UploadUtils.generateRandonFileName(uploadFileName);
			// �����������Ŀ¼
			String randomDir = UploadUtils.generateRandomDir(randomFileName);
			// ͼƬ���浽ָ��·��
			try {
				FileUtils.copyFile(upload, new File(SystemConstants.baseDir+randomDir+"/"+randomFileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
			// �������ݿ�ͼƬ����·��
			customer.setCust_image(randomDir+"/"+randomFileName);
			// �������ݿ�ͼƬ��ʵ����
			customer.setCust_filename(uploadFileName);
			
			
			
		}
		
		customerService.save(customer);
		return SUCCESS;
	}
	
	/**
	 * ��ȡ��ҳ���� + ������ѯ
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
		// �������߲�ѯ����
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		// ƴ������
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

		
		// ��ѯ�����ܼ�¼��
		int total = customerService.findCount(dc);
		pb.setTotal(total);
		List<Customer> list = customerService.findPageList(dc,pb.getStart(),pb.getPageSize());
		pb.setDatas(list);
		 
		return SUCCESS;
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public String deleteCustomer(){
		
		customerService.deleteCustomer(customer.getCust_id());
		
		return SUCCESS;
	}
	

	/**
	 * ����id�����û����޸ģ�
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
