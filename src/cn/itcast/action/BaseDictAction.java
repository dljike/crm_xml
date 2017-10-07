package cn.itcast.action;

import java.util.List;

import cn.itcast.domain.BaseDict;
import cn.itcast.service.BaseDictService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict> {

	private static final long serialVersionUID = 1L;

	private BaseDict baseDict = new BaseDict();
	@Override
	public BaseDict getModel() {
		return baseDict;
	}

	private BaseDictService baseDictService;
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}

	// struts 框架 ajax请求， 自动把数据保存在action值栈里，
	private List<BaseDict> baseDicts;
	
	public List<BaseDict> getBaseDicts() {
		return baseDicts;
	}


	public String findBaseDict(){
		 baseDicts = baseDictService.findBaseDict(baseDict);
		return SUCCESS;
	}
	
	
}
