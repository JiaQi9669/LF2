package cn.LF2.pro.action;

import cn.LF2.base.BaseAction;
import cn.LF2.pro.entity.User;

/**
 * 用户
 * @author JiaQi
 *
 */
public class UserAction extends BaseAction<User>{
	
//	登陆
	public String Login(){
		
		User user = null;
		try{
			user = userService.UserLogin(getModel().getUsername(), getModel().getPass());
			System.out.println(user.getName()+"===============>登录");
		}catch (Exception e) {
			e.printStackTrace();
			return "file";
		}
		if(null!=user){
			if(user.getPass().equals(getModel().getPass())){
				setAdmins(user);
				return "success";
			}else{
				return "file";
			}
		}
		return "file";
	}
}
