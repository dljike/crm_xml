package cn.itcast.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.LinkMan;

public interface LinkManDao {

	void save(LinkMan linkMan);

	List<LinkMan> findLinkManList();

	int getAllCount(DetachedCriteria dc);

	List<LinkMan> getCustomerList(DetachedCriteria dc, int start, int pageSize);

	void deleteLinkMan(LinkMan linkMan);
	
}
