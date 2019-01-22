package train.util;

import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;

/**
 * 与用户信息相关的工具函数
 * @author htzx
 *
 */
public class UserUtil {

	/**
	 * 根据身份证号返回性别
	 * @param identity
	 * @return
	 */
	public static int positionlength=6;
	public static String cdfzx = "'综合与生产管理处','合规与监督二处','通用业务二处','专业处理二处','研发支持二处'";
	public static String whyqb = "'物业服务处','安保及基础设施运维处'";

	
	public static String getSexFromIdentity(String identity)
	{
		int sex = 0;
		if(identity==null||identity.length()<3)
		{
			return "未知";
		}
		else
		{
			sex = Integer.parseInt(identity.substring(identity.length()-2,identity.length()-1));//倒数第二位
			if(sex%2==1)
			{
				return "男";
			}
			else
			{
				return "女";
			}
		}
	}
	public static String getBirthFromIdentity(String identity)
	{
		String Birth = "";
		if(identity==null||identity.length()<3)
		{
			return "未知";
		}
		else
		{
			Birth = identity.substring(6,identity.length()-8)+"-"+identity.substring(10,identity.length()-6)+"-"+identity.substring(12,identity.length()-4);//5101811988
			return Birth;
		}
	}

	/**
	 * 分组中提取数字
	 * @param zx
	 * @return
	 */
	public static Integer teamToTnteger(String team)
	{
		String str2 = "";
		if (team == null) {
			return -1;
		} else {
			team = team.trim();
			if (!"".equals(team)) {
				for (int i = 0; i < team.length(); i++) {
					if (team.charAt(i) >= 48 && team.charAt(i) <= 57) {
						str2 += team.charAt(i);
					}
				}
				if(!"".equals(str2))
				return Integer.parseInt(str2);
			}
			return -1;
		}
			
	}


	
	/**
	 * 处室转化为描述
	 * @param s
	 * @return
	 */
	public static String chuToString(Integer c)
	{
	    if(c==1)
		{
			return "综合与生产管理处";
		}
	    else if(c==111)
		{
			return "中心领导";
		}
		else if(c==2)
		{
			return "合规与监督二处";
		}
		else if(c==3)
		{
			return "通用业务二处";
		}
		else if(c==5)
		{
			return "研发支持二处";
		}
		else if(c==6)
		{
			return "专业处理二处";
		}
		else if(c==11)
		{
			return "总行";
		}
		else if(c==12)
		{
			return "分行";
		}
		else if(c==13)
		{
			return "中心";
		}
		else if(c==14)
		{
			return "分中心";
		}
		else if(c==15)
		{
			return "其他";
		}



		else
		{
			return "--";
		}
	}
	
	public static String NewNumberToNameNoSession(String newnumber)
	{
		String result = "";
		if(newnumber==null)
		{
			result="无";
		}
		else
		{
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
		}
		return result;
	}
}
