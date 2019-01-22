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

public class SubScoreDetail {
	private String newnumber;
	private String number;
    private String message;
    private int score1;
    private int score2;
    private int score3;
    private int score4;
    private int score5;
    private int score6;
    private int score7;
    private int score8;
    private int score9;
    private int score10;
    private String remark;
    

	public int getScore1() {
		return score1;
	}

	public void setScore1(int score1) {
		this.score1 = score1;
	}

	public int getScore2() {
		return score2;
	}

	public void setScore2(int score2) {
		this.score2 = score2;
	}

	public int getScore3() {
		return score3;
	}

	public void setScore3(int score3) {
		this.score3 = score3;
	}

	public int getScore4() {
		return score4;
	}

	public void setScore4(int score4) {
		this.score4 = score4;
	}

	public int getScore5() {
		return score5;
	}

	public void setScore5(int score5) {
		this.score5 = score5;
	}

	public int getScore6() {
		return score6;
	}

	public void setScore6(int score6) {
		this.score6 = score6;
	}

	public int getScore7() {
		return score7;
	}

	public void setScore7(int score7) {
		this.score7 = score7;
	}

	public int getScore8() {
		return score8;
	}

	public void setScore8(int score8) {
		this.score8 = score8;
	}

	public int getScore9() {
		return score9;
	}

	public void setScore9(int score9) {
		this.score9 = score9;
	}

	public int getScore10() {
		return score10;
	}

	public void setScore10(int score10) {
		this.score10 = score10;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

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
		
		TrainScoreDAO tsdao = new TrainScoreDAO();
		TManageDAO tmdao = new TManageDAO();
		TManage tm = tmdao.findAllBynumber(number);
		TrainPeopleDAO tpdao = new TrainPeopleDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    UserInfo ui = uidao.findByNewNumber(newnumber);
 	    String name = ui.getUsername();
		TrainScore ts = new TrainScore();
		ts.setNewnumber(newnumber);
		ts.setNumber(number);
		ts.setScore1(score1);
		ts.setScore2(score2);
		ts.setScore3(score3);
		ts.setScore4(score4);
		ts.setScore5(score5);
		ts.setScore6(score6);
		ts.setScore7(score7);
		ts.setScore8(score8);
		ts.setScore9(score9);
		ts.setScore10(score10);
		ts.setRemark(remark);
	    tsdao.merge(ts);
	    TrainPeople tp = tpdao.findAllBynumber(number);
	    if(tp!=null)
	    {
	    	if(tp.getMarkpeople()==null||tp.getMarkpeople().equals(""))
	    	{
	    		tp.setMarkpeople(name);
	    		tpdao.merge(tp);
	    	}
	    	else
	    	{
	    		String nametemp = tp.getMarkpeople()+"、"+name;
	    		tp.setMarkpeople(nametemp);
	    		tpdao.merge(tp);
	    	}
	    }
	    String signpeople = tp.getSignpeople();
	    String markpeople = tp.getMarkpeople();
		int isend = choicepeople(tp.getSignpeople(),tp.getMarkpeople());
		if(isend ==1)
		{
			tm.setStatus(4);
			tm.setThisunder("");
			tmdao.merge(tm);
		}
		
		message = "评估成功";
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}
	
	public int choicepeople(String planpeople,String realpeople )
	{
		int flag=0;
		String []plan = planpeople.split("、");
		String []real = realpeople.split("、");
	    if(plan.length==real.length)
	    {
	    	flag=1;
	    }
		return flag;
	}
}
