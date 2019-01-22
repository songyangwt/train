package train.userinfo.action;

import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class UserModify {
	private UserInfo ui;
	private int id;
	private int zhi;
	private int chu;   
	private String role;
	
	private String authoU;
	private String authoV;

	
	public int getZhi() {
		return zhi;
	}

	public void setZhi(int zhi) {
		this.zhi = zhi;
	}

	public int getChu() {
		return chu;
	}

	public void setChu(int chu) {
		this.chu = chu;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserInfo getUi() {
		return ui;
	}

	public void setUi(UserInfo ui) {
		this.ui = ui;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	public String getAuthoU() {
		return authoU;
	}

	public void setAuthoU(String authoU) {
		this.authoU = authoU;
	}

	public String getAuthoV() {
		return authoV;
	}

	public void setAuthoV(String authoV) {
		this.authoV = authoV;
	}

	public String execute() throws Exception
	{
		Query query;
		String hql="";
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    UserInfoDAO uidao=new UserInfoDAO();
 	    ui = uidao.findAllById(id);
 	    zhi=ui.getZhi();
 	    chu=ui.getChu();
 	 
 	    role=ui.getAuthority();
 	   
 	    authoU=role.substring(20,21);
 	    authoV=role.substring(21,22);
 	   
 	   
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
