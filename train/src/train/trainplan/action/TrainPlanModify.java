package train.trainplan.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import train.trainplan.dao.TplanDAO;
import train.trainplan.pojo.Tplan;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;

public class TrainPlanModify {
	 private String manager;
     private String content;
     private String people;
     private String time;
     private String location;
     private String remark;
	 private int id;	
	 private int chu;
	 private String authoU;
	 private String message;
	
	

	public String getAuthoU() {
		return authoU;
	}



	public void setAuthoU(String authoU) {
		this.authoU = authoU;
	}



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



	public String getManager() {
		return manager;
	}



	public void setManager(String manager) {
		this.manager = manager;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getPeople() {
		return people;
	}



	public void setPeople(String people) {
		this.people = people;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
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
 	    Tplan tp = new Tplan();
 	    tp = tpdao.findAllByid(id);
 	  
 	    if(authoU.equals("U"))
 	    {
 	    	tp.setChu(chu);
 	    }
 	    tp.setContent(content);
 	    tp.setLocation(location);
 	    tp.setManager(manager);
 	    tp.setPeople(people);
 	    tp.setRemark(remark);
 	    tp.setTime(time);
 	    tpdao.merge(tp);
 	    message = "修改成功";
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
	
		return "success";
	}
}
