package train.trainplan.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import train.trainplan.dao.TplanDAO;
import train.trainplan.pojo.Tplan;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;

public class TrainPlanDelete {
	private int id;
	private int chu;
	private String message;
	

	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public int getChu() {
		return chu;
	}



	public void setChu(int chu) {
		this.chu = chu;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    
 	    TplanDAO tpdao = new TplanDAO();
 	    Tplan tp = tpdao.findAllByid(id);
 	    chu = tp.getChu();
 	    tpdao.delete(tp);
 	    message = "删除成功";
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
	
		return "success";
	}
}
