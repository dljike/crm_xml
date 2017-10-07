package cn.itcast.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.dao.LinkManDao;
import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;

public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao{

	@Override
	public void save(LinkMan linkMan) {
	 this.getHibernateTemplate().save(linkMan);
		
	}

	@Override
	public List<LinkMan> findLinkManList() {
		List<LinkMan> list = (List<LinkMan>) this.getHibernateTemplate().find("from LinkMan");
		return list;
	}

	@Override
	public int getAllCount(DetachedCriteria dc) {
		// 离线查询总行数
		 dc.setProjection(Projections.rowCount());
		 List<Long> count = (List<Long>) this.getHibernateTemplate().findByCriteria(dc);
		return count.get(0).intValue();
	}

	@Override
	public List<LinkMan> getCustomerList(DetachedCriteria dc, int start,
			int pageSize) {
		dc.setProjection(null);
		List<LinkMan> list = (List<LinkMan>) this.getHibernateTemplate().findByCriteria(dc,start,pageSize);
		return list;
	}

	@Override
	public void deleteLinkMan(LinkMan linkMan) {
		 this.getHibernateTemplate().delete(linkMan);
		
	}

}
