package train.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import train.config.pojo.Config;

import train.mycalendar.dao.t_mycalendarDAO;
import train.mycalendar.pojo.MonthSummary;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;


/**
 * 乱七八糟小工具
 * @author htzx
 *
 */
public class Util {


	// public static final String basepath = "C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/office/" ;//服务器
	//public static final String basepath ="C:/Program Files/apache-tomcat-7.0.59-windows-x86/apache-tomcat-7.0.59/webapps/train/";
	public static final String basepath ="C:/Program Files (x86)/apache-tomcat-7.0.59/webapps/train/";
	//public static final String basepath ="D:/Program Files/Apache Software Foundation/apache-tomcat-7.0.59/webapps/office/";

	public static final String downloadpath = basepath+"derive/" ;//下载
	public static final String mubanpath = basepath+"templet/" ;//下载
	public static final String jihepath = basepath+"file/jihefile/" ;//稽核文件
	public static final String ptpath = basepath+"file/ptfile/" ;//平台用户文件
	public static final String ctpath = basepath+"file/costfile/" ;//cost文件
	public static final String docpath = basepath+"file/docfile/" ;//
	public static final String temppath = basepath+"file/tempfile/" ;//临时文件下载
	public static final int pagesize=10;
	public static final String beginday = "01";
	public static final String endday = "31";

	
	public static String dateToStandard(String date)
	{
		return date.substring(0,4)+"-"+date.substring(4,6)+"-"+date.substring(6,8);
	}
	/**
	 * 如果是空
	 * @param s
	 * @return
	 */
	public static boolean ifEmpty(String s){
		if(s==null||s.equalsIgnoreCase("null")||s.isEmpty()||s.equals(""))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static String statusToString(Integer status)
	{
		String result = "";
		if(status==0)
		{
			result = "等待撤销";
		}
		else if(status==1)
		{
			result = "待审批";
		}
		else if(status==2)
		{
			result = "审批通过";
		}
		else if(status==3)
		{
			result = "已发布";
		}
		else if(status==4)
		{
			result = "已办结";
		}
		else if(status==5)
		{
			result = "已退回";
		}
		else if(status==6)
		{
			result = "已撤销";
		}
		else if(status==7)
		{
			result = "待确认";
		}
		else if(status==8)
		{
			result = "待考试";
		}
		else if(status==9)
		{
			result = "待评估";
		}
		else if(status==10)
		{
			result = "待反馈签到表";
		}
		else
		{
			result ="";
		}
		return result;
	}
	public static String isbaoToString(Integer status)
	{
		String result = "";
		if(status==1)
		{
			result = "需报名";
		}
		else 
		{
			result = "无需报名";
		}
		
		return result;
	}
	
	public static String isqianToString(Integer status)
	{
		String result = "";
		if(status==1)
		{
			result = "需签到";
		}
		else 
		{
			result = "无需签到";
		}
		
		return result;
	}
	
	public static String isexamToString(Integer status)
	{
		String result = "";
		if(status==1)
		{
			result = "需考试";
		}
		else 
		{
			result = "无需考试";
		}
		
		return result;
	}
	
	public static String isevaluateToString(Integer status)
	{
		String result = "";
		if(status==1)
		{
			result = "需评估";
		}
		else 
		{
			result = "无需评估";
		}
		
		return result;
	}
	
	
	public static String trainTypeToString(Integer status)
	{
		String result = "";
		if(status==1)
		{
			result = "专题培训";
		}
		else if(status==2)
		{
			result = "日常业务培训";
		}
		else if(status==3)
		{
			result = "入职培训";
		}
		else if(status==4)
		{
			result = "精品课程";
		}
		else
		{
			result = "其他";
		}
		return result;
	}
	

	
	


	/**
	 * 如果字符串数组中存在相同字符串
	 * @param input
	 * @return
	 */
	public static boolean ifHasSame(String[] input)
	{
		boolean flag=true;
		for(int i=0;i<input.length;i++)
		{
			for(int j=i+1;j<input.length;j++)
			{
				if(input[i].equals(input[j]))
				{
					flag = false;
				}
			}
		}
		return flag;
	}
	/**
	 * 20150103-->2015年01月03日
	 * @param simple
	 * @return
	 */
	public static String simpleToStanderd(String simple)
	{
		return simple.substring(0,4)+"年"+simple.substring(4,6)+"月"+simple.substring(6,8)+"日";
	}
	
	public static String timetoshow(String time)
	{
		String times[] = time.split(",");
		return "日期："+times[0]+"      时间："+times[1];
	}

	/**
	 * 增加5分钟
	 * 输入00:00:00
	 * 输出00:05:00
	 * @param time
	 * @return
	 */
	public static String plusFiveMinutes(String time)
	{
		String result = "";
		if(time.split(":").length>1)
		{
			int shi = Integer.valueOf(time.split(":")[0]);
			int fen = Integer.valueOf(time.split(":")[1]);
			String miao = time.split(":")[2];
			fen+=5;
			if(fen>=60)
			{
				fen -=60;
				shi +=1;
			}
			String strshi = String.valueOf(shi);
			String strfen = String.valueOf(fen);
			if(shi<10)
			{
				strshi = "0"+strshi;
			}
			if(fen<10)
			{
				strfen = "0"+strfen;
			}
			result = strshi+":"+strfen+":"+miao;
		}
		return result;
	}
	
	public static String NewNumberToName(String newnumber)
	{
		String result = "";
		if(newnumber==null)
		{
			result="无";
		}
		else
		{
			Session session = HibernateSessionFactory.getSession();
	 	    Transaction trans=session.beginTransaction();
			UserInfoDAO uidao = new UserInfoDAO();
			UserInfo ui = uidao.findByNewNumber(newnumber);
			if(ui==null)
			{
				result = "无";
			}
			else
			{
				result = ui.getUsername();
			}
	 		trans.commit();
	 		session.flush();
	 		session.clear();
	 		session.close();
		}
		return result;
	}
	
	public static String opinionToString(Integer opinion)
	{
		String result = "";
		if(opinion==1)
		{
			result = "同意";
		}
		else if(opinion==2)
		{
			result = "不同意";
		}
		
		return result;
	}
	
	public static String zhiToString(Integer zhi)
	{
		String result = "";
		if(zhi==1)
		{
			result = "主任";
		}
		else if(zhi==3)
		{
			result = "处室负责人";
		}
		else if(zhi==4)
		{
			result = "团队负责人";
		}
		else if(zhi==5)
		{
			result = "班组长";
		}
		else if(zhi==6)
		{
			result = "经办岗";
		}
		
		return result;
	}
	
	public static String authoToName(String autho)
	{
		String result = "";
		String authoU=autho.substring(20, 21);
		String authoV=autho.substring(21, 22);
		if(authoU.equals("U"))
		{
			result = "中心培训管理员";
		}
		else if(authoV.equals("V"))
		{
			result = "处室培训管理员";
		}
	
		else 
		{
			result = "普通用户";
		}
		
		return result;
	}
	
}



