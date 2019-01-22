package train.trainplan.action;

import java.util.ArrayList;
import java.util.List;

import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import train.util.DateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;

public class ShowTrainPlanImport {

	private String newnumber;
	private UserInfo ui;
	private List<String> listyear;
	
	
	public List<String> getListyear() {
		return listyear;
	}

	public void setListyear(List<String> listyear) {
		this.listyear = listyear;
	}

	public UserInfo getUi() {
		return ui;
	}

	public void setUi(UserInfo ui) {
		this.ui = ui;
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
 	    Transaction trans = session.beginTransaction();
 	    listyear = new ArrayList<String>();
 	    UserInfoDAO uidao = new UserInfoDAO();
 	    DateUtil du = new DateUtil();
 	    int date = du.getThisYear();
 	    for(int i=0; i<5;i++)
 	    {
 	    	listyear.add(Integer.toString((date+i)));
 	    }
 	    int process = 0;
 	    ui = uidao.findByNewNumber(newnumber);
 	 
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
	
		return "success";
	}
}
