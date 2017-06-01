package cn.LF2.pro.service.impl;

import java.util.ArrayList;
import java.util.List;

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
//	查找指定名称
	public ArrayList<Day> findListByType(String chkName,Integer type){
		
		ArrayList<Day> list_day = new ArrayList<Day>();
		
		String[] partname = chkName.split(", ");
		
		int i = 0;
		while(i<chkName.length()){
			Day d = new Day();
			String hql ="FROM Day d WHERE d.type = ? and d.name = ?";
			d = (Day) getSession().createQuery(hql).setParameter(0, type).setParameter(1, partname[i]).uniqueResult();
			list_day.add(d);
			i++;
		}
		
		return list_day;
	}
	
//	获取部门名称
	public ArrayList<String> findPartName() {
		ArrayList<String> part = new ArrayList<String>();
		
		String hql ="FROM Day d WHERE d.type = ?";
		List<Day> list_day = (List<Day>) getSession().createQuery(hql).setParameter(0, 1).list();
		
		int i = 0;		
		while(i < list_day.size()){
			part.add(list_day.get(i).getName());
			i++;
		}
		
		return part;
	}

}
