package train.process.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import train.process.dao.ProcessDAO;
import train.process.pojo.*;
import train.process.pojo.Process;
import train.trainmanage.dao.TManageDAO;
import train.trainmanage.pojo.TManage;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;

public class FindNextUnder {

	/**
	 *  根据审批表当前状态、进度等信息查找下一个审批人
	 * 
	 * @param item
	 *            事项编号
	 * @param number
	 *            审批表标号
	 */
	public List<UserInfo> findNextUnder(String item,String number)
	{
		ProcessDAO pdao = new ProcessDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = new UserInfo();
			
		Process p = new Process();
		
		List<UserInfo> list = new ArrayList<UserInfo>();
		List<UserInfo> listtemp = new ArrayList<UserInfo>();
		String newnumber = "";//实际请假/公干人新员工工号
		String proc = "";// 完整流程
		String jindu = "";// 当前进度
		String under = "无";
		int chu=0 ;
		//String chudf = "";//对方处室
		int length = 0;//当前进度长度
		int applicant = 0;
		if(item.equals("PXSQ"))
		{
			TManageDAO tmdao = new TManageDAO();
			TManage tm = tmdao.findAllBynumber(number);
			newnumber = tm.getInitiator();
			applicant = tm.getProcess();
			jindu = tm.getJindu();
		}
		
		ui = uidao.findByNewNumber(newnumber);
		chu = ui.getChu();
		
		length = jindu.length();
		p = pdao.findByItemAndApplicant(item, applicant);
		proc = p.getProcess();
		if((length+1)<proc.length())//如果有下一个审批人 // EDCB
		{
			under = proc.substring(length+1,length+2);//EDCBA
		}
	    if(under.equals("C"))// 如果下一审批人是团队负责人
		{
			listtemp = uidao.findTuanByAuthorityAndChu(under,chu);
		}
		else if(under.equals("B"))// 如果下一审批人是处室负责人
		{
			listtemp = uidao.findTuanByAuthorityAndChu(under,chu);
		}

		else
		{
			listtemp = uidao.findAllByAuthority(under);
		}
		if(!listtemp.isEmpty())
		{
			for(int i=0;i<listtemp.size();i++)
			{
				UserInfo uitemp = listtemp.get(i);
				UserInfo uithis = new UserInfo();
				
				String tempstr = "";
				//String autho = uitemp.getAuthority();
			    int tempchu = uitemp.getChu();
				int tempzhi = uitemp.getZhi();
				//String tempzu = position.substring(4,5);
				
				if(under.equals("T"))
				{
					tempstr = "排班管理员（"+uitemp.getUsername()+"）";
				}
				else if(under.equals("Q"))
				{
					tempstr = "门禁管理员（"+uitemp.getUsername()+"）";
				}
				else if(under.equals("G"))
				{
					tempstr = "人力资源团队（"+uitemp.getUsername()+"）";
				}
				else if(under.equals("J"))
				{
					tempstr = "薪酬管理员（"+uitemp.getUsername()+"）";
				}
				else if(under.equals("P"))
				{
					tempstr = "综合与财务管理团队（"+uitemp.getUsername()+"）";
				}
				else if(under.equals("o"))
				{
					tempstr = "UASS管理员（"+uitemp.getUsername()+"）";
				}
				else if(tempzhi==0)
				{
					tempstr = "分中心主任（"+uitemp.getUsername()+"）";
				}
				else if(tempchu==1)
				{
					tempstr = "综合与生产管理处（"+uitemp.getUsername()+"）";
				}
				else if(tempchu==2)
				{
					tempstr = "合规与监督二处（"+uitemp.getUsername()+"）";
				}
				else if(tempchu==3)
				{
					tempstr = "通用业务二处（"+uitemp.getUsername()+"）";
				}
				else if(tempchu==4)
				{
					tempstr = "专业处理二处（"+uitemp.getUsername()+"）";
				}
				else if(tempchu==5)
				{
					tempstr = "研发支持二处（"+uitemp.getUsername()+"）";
				}
				
				uithis.setUsername(tempstr);
				uithis.setNewnumber(uitemp.getNewnumber());
				list.add(uithis);
			}
		}
		return list;
	}
	
}
