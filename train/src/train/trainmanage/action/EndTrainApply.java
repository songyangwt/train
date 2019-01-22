package train.trainmanage.action;

import org.hibernate.Session;
import org.hibernate.Transaction;
import train.trainmanage.dao.TManageDAO;
import train.trainmanage.pojo.TManage;
import ccb.hibernate.HibernateSessionFactory;

public class EndTrainApply {
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
		tm.setStatus(4);
		tm.setThisunder("");
	    tmdao.merge(tm);
		message = "进程已结束";
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}
}
