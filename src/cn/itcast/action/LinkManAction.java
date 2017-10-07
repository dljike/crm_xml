package cn.itcast.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
import cn.itcast.service.LinkManServie;
import cn.itcast.utils.PageBean;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {
 
	private static final long serialVersionUID = 1L;
	private LinkMan linkMan = new LinkMan();
	@Override
	public LinkMan getModel() {
		// TODO Auto-generated method stub
		return linkMan;
	}
	
	private LinkManServie linkManService;
	
	private int pageSize; // ���յ�ǰҳ�����ṩset����
	private int page; // ���յ�ǰ�ǵڼ�ҳ���ṩset����
	
	private PageBean<LinkMan> pb; // ��ҳ��pagebeanҪ�ṩget��������Ϊҳ��Ҫ��ȡ
	
	public PageBean<LinkMan> getPb() {
		return pb;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setLinkManService(LinkManServie linkManService) {
		this.linkManService = linkManService;
	}

	public String save(){
		if (linkMan.getCustomer().getCust_id() == null) {
			this.addActionError("�����ͻ�����Ϊ��");
			return "fail";
		}
		linkManService.save(linkMan);
		return SUCCESS;
	}
	
	public String linkManList(){
		pb = new PageBean<LinkMan>();
		if (page != 0) {
			pb.setCurrentPage(page);
		}
		if (pageSize != 0) {
			pb.setPageSize(pageSize);
		}
		// �������߲�ѯ����
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		// ��ѯ�����ܼ�¼��
		int total = linkManService.findCount(dc);
		pb.setTotal(total);
		List<LinkMan> list = linkManService.findPageList(dc,pb.getStart(),pb.getPageSize());
		pb.setDatas(list);
		
		return SUCCESS;
	}
	
	public String LinkManDelete(){
		linkManService.deleteLinkMan(linkMan);
		return SUCCESS;
	}
	
	

}
