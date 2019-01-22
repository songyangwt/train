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

public class DeleteTrainApplyPage {
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
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    
		OperateLogDAO oldao = new OperateLogDAO();//记录日志
		OperateLog ol = new OperateLog();
		DateUtil du = new DateUtil();
		TManageDAO tmdao = new TManageDAO();
		ShenpiOperateDAO lprodao = new ShenpiOperateDAO();
		ShenpiOperate lpro = new ShenpiOperate();
		//Timestamp time = new Timestamp(System.currentTimeMillis()); 
		TManage tm = tmdao.findAllBynumber(number);
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = uidao.findByNewNumber(newnumber);
		String time = du.getSimpleDateTime();
		message = "撤销成功";
		
		ol.setItem("PXSQ");
		ol.setName(ui.getUsername());
		ol.setNewnumber(newnumber);
		ol.setTime(du.getDateTime());
		ol.setOperate("撤销审批表");
		ol.setRemark(number);
		
		lpro.setAuthority(ui.getAuthority());
		lpro.setNumber(number);
		lpro.setTime(time);
		lpro.setViewer(ui.getUsername());
		lpro.setViewernewnumber(ui.getNewnumber());
		lpro.setRemark("已撤销");
		lpro.setRole("撤销");
		
		lprodao.merge(lpro);
		oldao.merge(ol);
		
		/*if(tz.getStatus()==3||tz.getStatus()==4)//如果状态已审批完毕，需反向执行提交操作
		{
			//message = tzdao.unSubmitWcggPage(number);
		}*/
		
//		String sqlwp = "delete from t_wcgg_page where number='"+number+"'";
//		String sqllpro = "delete from t_leave_process where number='"+number+"'";
//		String sqlbd = "delete from t_wcgg_baodao where number='"+number+"'";
//		session.createSQLQuery(sqlwp).executeUpdate();
//		session.createSQLQuery(sqllpro).executeUpdate();
//		session.createSQLQuery(sqlbd).executeUpdate();
		
		tm.setStatus(6);//状态修改为已撤销
		tm.setPreunder("");
		tm.setThisunder("");
		tmdao.merge(tm);
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
