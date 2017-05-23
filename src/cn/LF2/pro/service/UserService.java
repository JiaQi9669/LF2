package cn.LF2.pro.service;

import cn.LF2.base.BaseDao;
import cn.LF2.pro.entity.User;

public interface UserService extends BaseDao<User>{
//	登陆
	User UserLogin(String username, String pass);
}
