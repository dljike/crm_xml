package cn.itcast.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Customer implements Serializable {
 
	private static final long serialVersionUID = 1L;

	private Long cust_id; // �ͻ����
	private String cust_name; // �ͻ���˾����
	private BaseDict baseDictSource; //��Ϣ��Դ
	private BaseDict baseDictIndustry; //������ҵ
	private BaseDict baseDictLevel; //�ͻ�����
	private String cust_phone; // �̶��绰
	private String cust_address; // �ͻ���ϵ��ַ
	private String cust_image; // ͼƬ����·��
	private String cust_filename; // ͼƬ��ʵ������
	// һ���ͻ���Ӧ�����ϵ��
	private Set<LinkMan> linkMans = new HashSet<LinkMan>();
	
	public Set<LinkMan> getLinkMans() {
		return linkMans;
	}
	public void setLinkMans(Set<LinkMan> linkMans) {
		this.linkMans = linkMans;
	}
	public String getCust_image() {
		return cust_image;
	}
	public void setCust_image(String cust_image) {
		this.cust_image = cust_image;
	}
	public String getCust_filename() {
		return cust_filename;
	}
	public void setCust_filename(String cust_filename) {
		this.cust_filename = cust_filename;
	}
	public Long getCust_id() {
		return cust_id;
	}
	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public BaseDict getBaseDictSource() {
		return baseDictSource;
	}
	public void setBaseDictSource(BaseDict baseDictSource) {
		this.baseDictSource = baseDictSource;
	}
	public BaseDict getBaseDictIndustry() {
		return baseDictIndustry;
	}
	public void setBaseDictIndustry(BaseDict baseDictIndustry) {
		this.baseDictIndustry = baseDictIndustry;
	}
	public BaseDict getBaseDictLevel() {
		return baseDictLevel;
	}
	public void setBaseDictLevel(BaseDict baseDictLevel) {
		this.baseDictLevel = baseDictLevel;
	}
	public String getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	public String getCust_address() {
		return cust_address;
	}
	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name
				+ ", baseDictSource=" + baseDictSource + ", baseDictIndustry="
				+ baseDictIndustry + ", baseDictLevel=" + baseDictLevel
				+ ", cust_phone=" + cust_phone + ", cust_address="
				+ cust_address + ", cust_image=" + cust_image
				+ ", cust_filename=" + cust_filename + ", linkMans=" + linkMans
				+ "]";
	}
 
	
	
	
	
}
