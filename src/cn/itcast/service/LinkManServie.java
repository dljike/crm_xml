package cn.itcast.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.LinkMan;

public interface LinkManServie {

	void save(LinkMan linkMan);

 

	int findCount(DetachedCriteria dc);



	List<LinkMan> findPageList(DetachedCriteria dc, int start, int pageSize);



	void deleteLinkMan(LinkMan linkMan);

}
