package cn.itcast.utils;

import java.util.List;


public class PageBean<T> {
	
	private List<T> datas; // 当前页面数据集合
	private int total; // 总共有几条记录
	private int totalPage; // 总页数
	private int pageSize=3; // 每页显示的条数
	private int currentPage=1; // 当前页
	private int start;// 开始位置
	
	
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	/**
	 * 计算总页数
	 * @return
	 */
	public int getTotalPage() {
		return total % pageSize == 0 ? total/pageSize:total/pageSize+1;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getStart() {
		return (currentPage-1)*pageSize;
	}
	public void setStart(int start) {
		this.start = start;
	}
	
	
	
	

}
