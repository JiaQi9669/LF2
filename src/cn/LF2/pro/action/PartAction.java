package cn.LF2.pro.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;

import cn.LF2.base.BaseAction;
import cn.LF2.pro.entity.Day;

/**
 * 部门统计
 * @author JiaQi
 *
 */
public class PartAction<T> extends BaseAction<T>{
//	查询名字
	private String chkName;
//	查询时间
	private String chkYear;
	
	public String getChkYear() {
		return chkYear;
	}

	public void setChkYear(String chkYear) {
		this.chkYear = chkYear;
	}

	public String getChkName() {
		return chkName;
	}

	public void setChkName(String chkName) {
		this.chkName = chkName;
	}
	
	
//	获取部门名称
	public String findPartName(){
		ActionContext.getContext().put("part",dayService.findPartName());
		return "part";
	}
	
	
//	获取部门
	public String findPart(){
		findPartName();
		String desc = null;
		
//		昨天
		if(chkYear.equals("y1")){
			ArrayList<Day> list_day = dayService.findListByType(chkName, 1);
			if(list_day.isEmpty()){
				ActionContext.getContext().put("desc","暂无数据");
			}else{
				int i = 0;
				while(i<list_day.size()){
					desc = "{name: '"+list_day.get(i).getName()+"',data: ["+list_day.get(i).getNum1()+","
							+list_day.get(i).getNum2()+","
							+list_day.get(i).getNum3()+","
							+list_day.get(i).getNum4()+","
							+list_day.get(i).getNum5()+","
							+list_day.get(i).getNum6()+","
							+list_day.get(i).getNum7()+","
							+list_day.get(i).getNum8()+","
							+list_day.get(i).getNum9()+","
							+list_day.get(i).getNum10()+","
							+list_day.get(i).getNum11()+","
							+list_day.get(i).getNum12()+","
							+list_day.get(i).getNum13()+","
							+list_day.get(i).getNum14()+","
							+list_day.get(i).getNum15()+"]},";
				}
				ActionContext.getContext().put("desc",desc);
			}
		}else if(chkYear.equals("y2")){
			
		}else if(chkYear.equals("y3")){
			
		}else if(chkYear.equals("y4")){
			
		}
		
		return "part";
	}
}
