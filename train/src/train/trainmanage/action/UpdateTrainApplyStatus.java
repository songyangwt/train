package train.trainmanage.action;

import org.hibernate.Session;
import org.hibernate.Transaction;
import train.trainmanage.dao.OperateLogDAO;
import train.trainmanage.dao.ShenpiOperateDAO;
import train.trainmanage.dao.TManageDAO;
import train.trainmanage.pojo.OperateLog;
import train.trainmanage.pojo.ShenpiOperate;
import train.trainmanage.pojo.TManage;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import train.util.DateUtil;

import ccb.hibernate.HibernateSessionFactory;

public class UpdateTrainApplyStatus {
	private String message;
	private String number;
	private String newnumber;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String execute() throws Exception
	{
		String result = "success";
		//Timestamp time = new Timestamp(System.currentTimeMillis()); 
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    TManageDAO tmdao = new TManageDAO();
 	    ShenpiOperateDAO lprodao = new ShenpiOperateDAO();
		ShenpiOperate lpro = new ShenpiOperate();
		OperateLogDAO oldao = new OperateLogDAO();//记录日志
		OperateLog ol = new OperateLog();
		DateUtil du = new DateUtil();
		UserInfoDAO uidao = new UserInfoDAO();
		String time = du.getSimpleDateTime();
		TManage tm = tmdao.findAllBynumber(number);
		String jindu = tm.getJindu();
		int jdlength = tm.getJindu().length();//F//FE
		int status = tm.getStatus();
		
		UserInfo ui = uidao.findByNewNumber(newnumber);
		
		ol.setItem("PXSQ");
		ol.setName(ui.getUsername());
		ol.setNewnumber(tm.getPreunder());
		ol.setTime(du.getDateTime());
		ol.setRemark(number);
			
		lpro.setNumber(number);
		lpro.setTime(time);
		lpro.setViewer(ui.getUsername());
		lpro.setViewernewnumber(tm.getPreunder());
		lpro.setAuthority(jindu.substring(jdlength-1, jdlength));
		lpro.setRole("收回");
		
		lpro.setRemark("收回申请，重新发起");
		ol.setOperate("收回申请，重新发起");
		
		tm.setThisunder(tm.getPreunder());
		tm.setPreunder(null);
		
		if(jdlength>=2)
			tm.setJindu(jindu.substring(0, jdlength-1));
		else
			tm.setJindu("");
		if(status==4)
		{
			tm.setStatus(1);
		}
		/*else if(status==3)
		{
			tz.setStatus(2);
			//tzdao.unSubmitWcggPage(number);
		}*/
		else if(status==1)
		{
			tm.setStatus(0);
			tm.setThisunder(null);
		}
		message = "收回成功";
		result = "success";
		oldao.merge(ol);
		lprodao.merge(lpro);
		tmdao.merge(tm);
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return result;
	}
}
