package cn.itcast.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.dao.LinkManDao;
import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
import cn.itcast.service.LinkManServie;

public class LinkManServiceImpl implements LinkManServie {

	private LinkManDao linkManDao;
	
	
	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}


	@Override
	public void save(LinkMan linkMan) {
		linkManDao.save(linkMan);
	}

 
	@Override
	public int findCount(DetachedCriteria dc) {
		return  linkManDao.getAllCount(dc);
	 
	}


	@Override
	public List<LinkMan> findPageList(DetachedCriteria dc, int start,
			int pageSize) {
		 List<LinkMan> list = linkManDao.getCustomerList(dc,start,pageSize);
		return list;
	}


	@Override
	public void deleteLinkMan(LinkMan linkMan) {
		 linkManDao.deleteLinkMan(linkMan);
		
	}

}
