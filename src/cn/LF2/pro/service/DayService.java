package cn.LF2.pro.service;

import cn.LF2.base.BaseDao;
import cn.LF2.pro.entity.Day;

/**
 * 昨日查询
 * @author JiaQi
 *
 */
public interface DayService extends BaseDao<Day> {
	
//	通过类型查找
	Day findDayByType(Integer type);
}
