package cn.LF2.pro.action;

import com.opensymphony.xwork2.ActionContext;

import cn.LF2.base.BaseAction;
import cn.LF2.pro.entity.Day;

/**
 * 关于昨日查询
 * @author JiaQi
 */
public class IndexAction extends BaseAction<Day>{
//	查询昨日入馆人数
	public String findDay(){
		Day day = null;
//		查询
		day = dayService.findDayByType(4);
		int desc;
		if(day == null){
			desc = 0;
		}else{
			desc = day.getNum1()+day.getNum2()+day.getNum3()+day.getNum4()+day.getNum5()+day.getNum6()+day.getNum7()+day.getNum8()
					+day.getNum9()+day.getNum10()+day.getNum11()+day.getNum12()+day.getNum13()+day.getNum14()+day.getNum15();
		}
		
		ActionContext.getContext().put("desc",desc);
		
		System.out.println("昨日入馆人数=============》"+desc);
		
		return "index";
	}
}
