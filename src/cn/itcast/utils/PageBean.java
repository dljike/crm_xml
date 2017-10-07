package cn.itcast.utils;

import java.util.List;


public class PageBean<T> {
	
	private List<T> datas; // ��ǰҳ�����ݼ���
	private int total; // �ܹ��м�����¼
	private int totalPage; // ��ҳ��
	private int pageSize=3; // ÿҳ��ʾ������
	private int currentPage=1; // ��ǰҳ
	private int start;// ��ʼλ��
	
	
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
	 * ������ҳ��
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
