package train.trainmanage.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import train.trainmanage.dao.TManageDAO;
import train.trainmanage.dao.TrainScoreDAO;

import train.trainmanage.pojo.ScoreBean;
import train.trainmanage.pojo.TManage;
import train.trainmanage.pojo.TrainScore;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;

public class ShowStatisticScoreDetail {
	private String number;
    private String trainname;
    private List<TrainScore> listts;
    private List<ScoreBean> listscorename = new ArrayList<ScoreBean>();
    
    
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


	public List<ScoreBean> getListscorename() {
		return listscorename;
	}


	public void setListscorename(List<ScoreBean> listscorename) {
		this.listscorename = listscorename;
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
	  	    	String score = jisuanscore(ts);
	  	    	ui = uidao.findByNewNumber(ts.getNewnumber());
	  	    	String name = ui.getUsername();
	  	    	ScoreBean sb = new ScoreBean();
	  	    	sb.setName(name);
	  	    	sb.setScore(score);
	  	    	listscorename.add(sb);
	  	    }
	    }
	    
	    
	  
	  
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}
	

	String jisuanscore(TrainScore ts)
	{
		int score = ts.getScore1()+ts.getScore2()+ts.getScore3()+ts.getScore4()+ts.getScore5()+ts.getScore6()+ts.getScore7()+ts.getScore8()+ts.getScore9()+ts.getScore10();
		String allscore = Integer.toString(score);
		return allscore;
	}
}
