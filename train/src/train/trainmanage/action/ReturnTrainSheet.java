package train.trainmanage.action;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import train.trainmanage.dao.TManageDAO;

import train.trainmanage.pojo.TManage;

import ccb.hibernate.HibernateSessionFactory;

public class ReturnTrainSheet {
	private String newnumber;
	private String number;
    private TManage tm;
    private String names;

	
	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public TManage getTm() {
		return tm;
	}

	public void setTm(TManage tm) {
		this.tm = tm;
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
		
		TManageDAO tmdao = new TManageDAO();
	
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
		tm = tmdao.findAllBynumber(number);
		names = tm.getPeople();
		
		trans.commit();
		session.flush();
		session.clear();
		session.close();
	
		return "success";
	}
}
