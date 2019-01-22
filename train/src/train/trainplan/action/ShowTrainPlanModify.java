package train.trainplan.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import train.trainplan.dao.TplanDAO;
import train.trainplan.pojo.Tplan;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;

public class ShowTrainPlanModify {
	private int id;
	private Tplan tp;
		
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Tplan getTp() {
		return tp;
	}


	public void setTp(Tplan tp) {
		this.tp = tp;
	}

	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    
 	    TplanDAO tpdao = new TplanDAO();
 	    tp = tpdao.findAllByid(id);
 	   	 
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
	
		return "success";
	}
}
