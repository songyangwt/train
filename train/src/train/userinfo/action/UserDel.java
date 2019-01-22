package train.userinfo.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class UserDel {
	private String id;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String execute() throws Exception
	{
		
		String sql = "delete from t_userinfo where id="+id;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		session.createSQLQuery(sql).executeUpdate();
		message="删除成功";
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
