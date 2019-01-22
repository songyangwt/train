package train.trainnotice.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import train.trainmanage.dao.TFileDAO;
import train.trainmanage.dao.TManageDAO;
import train.trainmanage.pojo.TFile;
import train.trainmanage.pojo.TManage;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import train.util.DateUtil;
import ccb.hibernate.HibernateSessionFactory;

public class ViewTrainNoticeDetail {
	private String number;
	private String newnumber;
	private TManage tm;
	private List<TFile> listtf;
	
	private UserInfo ui;


	public List<TFile> getListtf() {
		return listtf;
	}
	public void setListtf(List<TFile> listtf) {
		this.listtf = listtf;
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
	
	public TManage getTm() {
		return tm;
	}
	public void setTm(TManage tm) {
		this.tm = tm;
	}
	
	public UserInfo getUi() {
		return ui;
	}
	public void setUi(UserInfo ui) {
		this.ui = ui;
	}

	public String execute() throws Exception
	{
		TManageDAO tmdao = new TManageDAO();
		DateUtil du = new DateUtil();
        TFileDAO tfdao = new TFileDAO();
		UserInfoDAO uidao = new  UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    
 	    tm= tmdao.findAllBynumber(number);
 	  
 	    ui = uidao.findByNewNumber(tm.getInitiator());
		listtf = tfdao.findAllByNumber(number);
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
