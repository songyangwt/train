package train.trainmanage.action;



import org.hibernate.Session;
import org.hibernate.Transaction;

import train.process.dao.ProcessDAO;
import train.process.pojo.Process;
import train.trainmanage.dao.OperateLogDAO;
import train.trainmanage.dao.ShenpiOperateDAO;
import train.trainmanage.dao.TManageDAO;
import train.trainmanage.pojo.OperateLog;
import train.trainmanage.pojo.ShenpiOperate;
import train.trainmanage.pojo.TManage;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import train.util.DateUtil;
import train.util.UserUtil;

import ccb.hibernate.HibernateSessionFactory;

public class TrainApplyShenpi {
	private String thisunder;
	private String xuanze;
	private String number;
	private String textfield;
	private String radio;
	private String message;
	private String thisnewnumber;
	private String thisundername;
	public String getThisunder() {
		return thisunder;
	}
	public void setThisunder(String thisunder) {
		this.thisunder = thisunder;
	}
	public String getXuanze() {
		return xuanze;
	}
	public void setXuanze(String xuanze) {
		this.xuanze = xuanze;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getTextfield() {
		return textfield;
	}
	public void setTextfield(String textfield) {
		this.textfield = textfield;
	}
	public String getRadio() {
		return radio;
	}
	public void setRadio(String radio) {
		this.radio = radio;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getThisnewnumber() {
		return thisnewnumber;
	}
	public void setThisnewnumber(String thisnewnumber) {
		this.thisnewnumber = thisnewnumber;
	}
	public String getThisundername() {
		return thisundername;
	}
	public void setThisundername(String thisundername) {
		this.thisundername = thisundername;
	}
	public String execute() throws Exception
	{
		String result = "success";
		message = "审批成功";
		//Timestamp time = new Timestamp(System.currentTimeMillis()); 
		TManageDAO tmdao = new TManageDAO();
		DateUtil du = new DateUtil();
	    ShenpiOperateDAO lprodao = new ShenpiOperateDAO();
		ShenpiOperate lpro = new ShenpiOperate();//审批意见写在leaveprocess中
		UserInfoDAO uidao = new UserInfoDAO();
		ProcessDAO pdao = new ProcessDAO();
		OperateLogDAO oldao = new OperateLogDAO();//记录日志
		OperateLog ol = new OperateLog();
		String time = du.getSimpleDateTime();
		if(radio==null)
		{
			message = "失败！请选择审批意见";
			return "success";
		}
		if(xuanze!=null&&xuanze.contains("选择")&&radio.equals("agree"))
		{
			message = "失败！请选择下一级审批人";
			return "success";
		}
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 		try {
 			UserInfo ui = uidao.findByNewNumber(thisnewnumber);
 			TManage tm = tmdao.findAllBynumber(number);
 			Process p = pdao.findByItemAndApplicant("PXSQ", tm.getProcess());
 			String proc = p.getProcess();//完整请假流程
 			String jindu = tm.getJindu();
 			String under = tm.getThisunder();//当前审批人
 			ol.setItem("PXSQ");
 			ol.setName(thisundername);
 			ol.setNewnumber(thisnewnumber);
 			ol.setTime(du.getDateTime());
 			ol.setRemark(number);
 			
 			lpro.setNumber(number);
 			lpro.setTime(time);
 			lpro.setViewer(thisundername);
 			lpro.setViewernewnumber(thisnewnumber);
 			lpro.setAuthority(thisunder);
 			lpro.setRemark(textfield);
 			if((thisnewnumber.substring(0,8)).equals(under))
 			{
 				if(radio.equals("agree"))//审批人决定//1 通过 2 不通过
 				{
 				lpro.setOpinion(1);
 				if((proc.length()-jindu.length())==1)//BOSS审批完毕，进入待报道状态
 				{
 					tm.setJindu(proc);
 					tm.setStatus(2);
 					tm.setThisunder(tm.getInitiator());//
 					//wpdao.submitWcggPage(number);//更新汇总表
 					ol.setOperate("审批通过,"+UserUtil.NewNumberToNameNoSession(tm.getInitiator())+"已更新");
 					oldao.merge(ol);
 				}
 				else
 				{
 					tm.setThisunder(xuanze);
 					tm.setJindu(tm.getJindu()+thisunder);
 					tm.setStatus(1);//流转中状态
 				}
 				tm.setPreunder(thisnewnumber);
 				}
 				else
 				{
 				lpro.setOpinion(2);
 				tm.setStatus(5);//修改为已退回状态
 				tm.setPreunder(null);
 				tm.setThisunder(null);//下一处理人是自己
 				tm.setJindu(tm.getJindu().substring(0,1));
 				}
 				lprodao.merge(lpro);
 			
 	 			tmdao.merge(tm);
 			}
 			else
 			{
 				message = "失败！，您已经审批过该事项或您没有该事项审批权限！";
 			}
 			
 		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		
		return result;
	}
}
