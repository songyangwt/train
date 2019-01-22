package train.trainmanage.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import train.trainmanage.dao.TManageDAO;
import train.trainmanage.dao.TrainScoreDAO;
import train.trainmanage.pojo.RemarkBean;
import train.trainmanage.pojo.TManage;
import train.trainmanage.pojo.TrainScore;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;

public class ShowStatisticRemarkDetail {
	private String number;
    private String trainname;
    private List<TrainScore> listts;
    private List<RemarkBean> listremarkname = new ArrayList<RemarkBean>();
    
    
    public String getTrainname() {
		return trainname;
	}


	public void setTrainname(String trainname) {
		this.trainname = trainname;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public List<TrainScore> getListts() {
		return listts;
	}


	public void setListts(List<TrainScore> listts) {
		this.listts = listts;
	}



	public List<RemarkBean> getListremarkname() {
		return listremarkname;
	}


	public void setListremarkname(List<RemarkBean> listremarkname) {
		this.listremarkname = listremarkname;
	}


	public String execute() throws Exception
	{
		
	
		TrainScoreDAO tsdao = new TrainScoreDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
		
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = new UserInfo();
	
		listts = tsdao.findAllBynumber(number);
		TManageDAO tmdao = new TManageDAO();
		TManage tm =  tmdao.findAllBynumber(number);
		trainname = tm.getProgramname();
	   
	    if(listts!=null)
	    {
	    	for(int i=0;i<listts.size();i++)
	  	    {
	  	    	TrainScore ts = listts.get(i);
	  	    	
	  	    	ui = uidao.findByNewNumber(ts.getNewnumber());
	  	    	String name = ui.getUsername();
	  	    	String remark = ts.getRemark();
	  	    	if(remark!=null&&(!remark.equals("")))
	  	    	{
	  	    		RemarkBean rb = new RemarkBean();
		  	    	rb.setName(name);
		  	    	rb.setRemark(remark);
		  	    	listremarkname.add(rb);
	  	    	}
	  	    	
	  	    }
	    }
	    
	    
	  
	  
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}
}
