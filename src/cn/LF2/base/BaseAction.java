package cn.LF2.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import cn.LF2.pro.entity.User;
import cn.LF2.pro.service.DayService;
import cn.LF2.pro.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	protected T model;
	public BaseAction(){
		try{
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
			model = clazz.newInstance();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	protected int pageNum = 1;

	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	//获取模型驱动
	public T getModel(){
		return model;
	}
	
//	全局变量用以接收用户信息
	protected User getAdmins() {
		return (User)ActionContext.getContext().getSession().get("admins");
	}
	protected void setAdmins(User admins) {
		ActionContext.getContext().getSession().put("admins", admins);
	}
	
	/**
	 * 注入所有的service
	 */
	@Resource
	protected UserService userService;
	@Resource
	protected DayService dayService;
}
