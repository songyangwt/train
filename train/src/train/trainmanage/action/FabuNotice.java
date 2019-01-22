package train.trainmanage.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import train.process.action.GetProcessByPosition;
import train.process.dao.ProcessDAO;
import train.process.pojo.Process;
import train.trainmanage.dao.TManageDAO;
import train.trainmanage.dao.TrainPeopleDAO;
import train.trainmanage.pojo.TManage;
import train.trainmanage.pojo.TrainPeople;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;

public class FabuNotice {
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
		tm.setStatus(3);
		if(tm.getIsregister()==2&&tm.getIsevaluate()==1)
		{
			tm.setThisunder(newnumber);
			/*if(tm.getIssign()==2)
			{
				TrainPeople tp1= new TrainPeople();
				tp1.setNumber(number);
				tp1.setSignpeople(tm.getPeople());
				tpdao.merge(tp1);
			}*/
		}
		else if(tm.getIsregister()==2&&tm.getIsevaluate()==2)
		{
			tm.setThisunder("");
		}
		else
		{
			tm.setThisunder(newnumber);
		}
		
		message = "发布成功";
		tmdao.merge(tm);
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}
}
