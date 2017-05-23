package cn.LF2.pro.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.LF2.base.BaseDaoImpl;
import cn.LF2.pro.entity.User;
import cn.LF2.pro.service.UserService;

/**
 * 用户
 * @author JiaQi
 *
 */
@Service
@Transactional
public class UserServiceImpl extends BaseDaoImpl<User> implements UserService{

//	判定登陆
	public User UserLogin(String username, String pass) {
		
		String hql ="FROM User s WHERE s.username=? AND s.pass=?";
		return (User) getSession().createQuery(hql).setParameter(0, username).setParameter(1, pass).uniqueResult();
	}

}
