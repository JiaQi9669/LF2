package cn.LF2.pro.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.LF2.base.BaseDaoImpl;
import cn.LF2.pro.entity.Day;
import cn.LF2.pro.service.DayService;

/**
 * 按天查询
 * @author JiaQi
 *
 */
@Service
@Transactional
public class DayServiceImpl extends BaseDaoImpl<Day> implements DayService{

//	通过类型查找
	public Day findDayByType(Integer type) {
		String hql ="FROM Day d WHERE d.type = ?";
		return (Day) getSession().createQuery(hql).setParameter(0, type).uniqueResult();
	}

}
