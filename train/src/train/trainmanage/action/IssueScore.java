package train.trainmanage.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import train.trainmanage.dao.TManageDAO;
import train.trainmanage.dao.TrainPeopleDAO;
import train.trainmanage.pojo.TManage;
import train.trainmanage.pojo.TrainPeople;
import ccb.hibernate.HibernateSessionFactory;

public class IssueScore {
	private String newnumber;
	private String number;
    private String message;
    
	

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
		
		TManageDAO tmdao = new TManageDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
		TManage tm = tmdao.findAllBynumber(number);
		TrainPeopleDAO tpdao = new TrainPeopleDAO();
		tm.setStatus(9);
		tm.setThisunder("");
		TrainPeople tp1= new TrainPeople();
		tp1.setNumber(number);
		tp1.setSignpeople(tm.getPeople());
		tpdao.merge(tp1);
		message = "发布成功";
		tmdao.merge(tm);
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}
}
