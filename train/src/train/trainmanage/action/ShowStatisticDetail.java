package train.trainmanage.action;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import train.trainmanage.dao.TManageDAO;
import train.trainmanage.dao.TrainPeopleDAO;
import train.trainmanage.dao.TrainScoreDAO;
import train.trainmanage.pojo.TManage;
import train.trainmanage.pojo.TrainPeople;
import train.trainmanage.pojo.TrainScore;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;

public class ShowStatisticDetail {
	private String newnumber;
	private String number;
    private int trainpeoplenum=0;
    private int signpeoplenum=0;
    private int exampeoplenum=0;
    private int markpeoplenum=0;
    private int peoplemarknum=0;
    private int avg=0;
    private int top1=0;
    private int low=0;
    private List<String> peopleremark=new ArrayList<String>();
    private List<String> listexamscore=new ArrayList<String>();
    private List<String> listname=new ArrayList<String>();
    private int isexam;
    private List<TrainScore> listts;
    private List<String> listscore = new ArrayList<String>();
    private TManage tm;
    

	public int getPeoplemarknum() {
		return peoplemarknum;
	}

	public void setPeoplemarknum(int peoplemarknum) {
		this.peoplemarknum = peoplemarknum;
	}

	public List<String> getListname() {
		return listname;
	}

	public void setListname(List<String> listname) {
		this.listname = listname;
	}

	public List<String> getListexamscore() {
		return listexamscore;
	}

	public void setListexamscore(List<String> listexamscore) {
		this.listexamscore = listexamscore;
	}

	public TManage getTm() {
		return tm;
	}

	public void setTm(TManage tm) {
		this.tm = tm;
	}

	public List<String> getListscore() {
		return listscore;
	}

	public void setListscore(List<String> listscore) {
		this.listscore = listscore;
	}

	public List<TrainScore> getListts() {
		return listts;
	}

	public void setListts(List<TrainScore> listts) {
		this.listts = listts;
	}

	public int getIsexam() {
		return isexam;
	}

	public void setIsexam(int isexam) {
		this.isexam = isexam;
	}

	public int getSignpeoplenum() {
		return signpeoplenum;
	}

	public void setSignpeoplenum(int signpeoplenum) {
		this.signpeoplenum = signpeoplenum;
	}

	public int getTrainpeoplenum() {
		return trainpeoplenum;
	}

	public void setTrainpeoplenum(int trainpeoplenum) {
		this.trainpeoplenum = trainpeoplenum;
	}

	public int getExampeoplenum() {
		return exampeoplenum;
	}

	public void setExampeoplenum(int exampeoplenum) {
		this.exampeoplenum = exampeoplenum;
	}

	public int getMarkpeoplenum() {
		return markpeoplenum;
	}

	public void setMarkpeoplenum(int markpeoplenum) {
		this.markpeoplenum = markpeoplenum;
	}


	public int getAvg() {
		return avg;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}



	public int getTop1() {
		return top1;
	}

	public void setTop1(int top1) {
		this.top1 = top1;
	}

	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = low;
	}

	public List<String> getPeopleremark() {
		return peopleremark;
	}

	public void setPeopleremark(List<String> peopleremark) {
		this.peopleremark = peopleremark;
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
		TrainPeopleDAO tpdao = new TrainPeopleDAO();
		TrainScoreDAO tsdao = new TrainScoreDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
		tm = tmdao.findAllBynumber(number);
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = new UserInfo();
		isexam = tm.getIsexam();
		TrainPeople tp = tpdao.findAllBynumber(number); 
		listts = tsdao.findAllBynumber(number);
		if(listts!=null)
		{
			 avg = findavgscore(listts);
			 top1 = findtopscore(listts);
			 low = findlowscore(listts);
		}
	   
	
		if((tp!=null)&&(tp.getSignpeople()!=null)&&!(tp.getSignpeople().equals("")))
		{
				signpeoplenum = tp.getSignpeople().split("、").length;
		}
			
			
		if((tp!=null)&&(tp.getMarkpeople()!=null)&&!(tp.getMarkpeople().equals("")))
		{
				markpeoplenum = tp.getMarkpeople().split("、").length;
		 }
			
		
	    if((tm.getPeople()!=null)&&!(tm.getPeople().equals("")))
	    {
	    	 trainpeoplenum = tm.getPeople().split("、").length;	
	    }
	   
	    if(listts!=null)
	    {
	    	for(int i=0;i<listts.size();i++)
	  	    {
	  	    	TrainScore ts = listts.get(i);
	  	    	String score = jisuanscore(ts);
	  	    	ui = uidao.findByNewNumber(ts.getNewnumber());
	  	    	String name = ui.getUsername();
	  	    	listscore.add(score);
	  	    	if(ts.getRemark()!=null&&(!ts.getRemark().equals("")))
	  	    	{
	  	    		peopleremark.add(ts.getRemark());
	  	    	}
	  	    	
	  	    	listname.add(name);
	  	    }
	    	  peoplemarknum = peopleremark.size();
	    	  
	    }
	    
	  
	  
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}
	
	int findtopscore(List<TrainScore>listts)
	{
		int top1 = listts.get(0).getScore1()+listts.get(0).getScore2()+listts.get(0).getScore3()+listts.get(0).getScore4()+listts.get(0).getScore5()+listts.get(0).getScore6()+listts.get(0).getScore7()+listts.get(0).getScore8()+listts.get(0).getScore9()+listts.get(0).getScore10();
		for(int i=1; i<listts.size();i++ )
		{
			int score = listts.get(i).getScore1()+listts.get(i).getScore2()+listts.get(i).getScore3()+listts.get(i).getScore4()+listts.get(i).getScore5()+listts.get(i).getScore6()+listts.get(i).getScore7()+listts.get(i).getScore8()+listts.get(i).getScore9()+listts.get(i).getScore10();
		    if(score>top1)
		    {
		    	top1=score;
		    }
		}
		return top1;
	}
	
	int findlowscore(List<TrainScore>listts)
	{
		int low = listts.get(0).getScore1()+listts.get(0).getScore2()+listts.get(0).getScore3()+listts.get(0).getScore4()+listts.get(0).getScore5()+listts.get(0).getScore6()+listts.get(0).getScore7()+listts.get(0).getScore8()+listts.get(0).getScore9()+listts.get(0).getScore10();
		for(int i=1; i<listts.size();i++ )
		{
			int score = listts.get(i).getScore1()+listts.get(i).getScore2()+listts.get(i).getScore3()+listts.get(i).getScore4()+listts.get(i).getScore5()+listts.get(i).getScore6()+listts.get(i).getScore7()+listts.get(i).getScore8()+listts.get(i).getScore9()+listts.get(i).getScore10();
		    if(score<low)
		    {
		    	low=score;
		    }
		}
		return low;
	}
	
	int findavgscore(List<TrainScore>listts)
	{
	    int all =0;
		for(int i=0; i<listts.size();i++ )
		{
			
			int score = listts.get(i).getScore1()+listts.get(i).getScore2()+listts.get(i).getScore3()+listts.get(i).getScore4()+listts.get(i).getScore5()+listts.get(i).getScore6()+listts.get(i).getScore7()+listts.get(i).getScore8()+listts.get(i).getScore9()+listts.get(i).getScore10();
		    all= all+score;
		}
		
		return all/listts.size();
	}
	
	String jisuanscore(TrainScore ts)
	{
		int score = ts.getScore1()+ts.getScore2()+ts.getScore3()+ts.getScore4()+ts.getScore5()+ts.getScore6()+ts.getScore7()+ts.getScore8()+ts.getScore9()+ts.getScore10();
		String allscore = Integer.toString(score);
		return allscore;
	}


}
