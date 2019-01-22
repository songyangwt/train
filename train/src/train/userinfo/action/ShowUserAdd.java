package train.userinfo.action;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ShowUserAdd {
	public String execute() throws Exception
	{
		Query query;
		String hql="";
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	  
	
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
