package train.trainplan.action;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import train.trainplan.pojo.Tplan;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import train.util.DateUtil;
import ccb.hibernate.HibernateSessionFactory;

public class ShowTrainPlanAll {
	private String year;
	private List<Tplan>listtp;
	
	
	public List<Tplan> getListtp() {
		return listtp;
	}

	public void setListtp(List<Tplan> listtp) {
		this.listtp = listtp;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}


	public String execute() throws Exception
	{
		DateUtil du = new DateUtil();
		Query query;
	    year = String.valueOf(du.getThisYear());
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    String queryString = "from Tplan as tp where tp.year= '"+year+"' order by tp.chu,tp.time";
        Query queryObject = session.createQuery(queryString);      
        listtp= queryObject.list(); 
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
	
		return "success";
	}
}
