package cn.LF2.pro.service;

import java.util.ArrayList;

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
//	查找指定名称
	ArrayList<Day> findListByType(String chkName,Integer type);
//	获取部门名称
	ArrayList<String> findPartName();
}
