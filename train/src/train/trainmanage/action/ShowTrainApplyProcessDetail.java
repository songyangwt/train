package train.trainmanage.action;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import train.trainmanage.dao.TManageDAO;
import train.trainmanage.dao.TrainPeopleDAO;
import train.trainmanage.pojo.TManage;
import train.trainmanage.pojo.TrainPeople;
import ccb.hibernate.HibernateSessionFactory;

public class ShowTrainApplyProcessDetail {
	private String newnumber;
	private String number;
    private int trainpeoplenum;
    private int signpeoplenum;
    private int exampeoplenum;
    private int markpeoplenum;
    private List<String> unexampeople;
    private List<String> unmarkpeople;
    private String isregister;
    private TManage tm;
    

	public TManage getTm() {
		return tm;
	}

	public void setTm(TManage tm) {
		this.tm = tm;
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


	public List<String> getUnexampeople() {
		return unexampeople;
	}

	public void setUnexampeople(List<String> unexampeople) {
		this.unexampeople = unexampeople;
	}

	public List<String> getUnmarkpeople() {
		return unmarkpeople;
	}

	public void setUnmarkpeople(List<String> unmarkpeople) {
		this.unmarkpeople = unmarkpeople;
	}

	public String getIsregister() {
		return isregister;
	}

	public void setIsregister(String isregister) {
		this.isregister = isregister;
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
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
	    tm = tmdao.findAllBynumber(number);
	    if(tm.getPeople()!=null&&!(tm.getPeople().equals(""))){
	    	trainpeoplenum = tm.getPeople().split("、").length;
	    } 
		TrainPeople tp = tpdao.findAllBynumber(number); 
		/*if(tm.getIsregister()==1&&tp!=null&&(tp.getSignpeople()==null||tp.getSignpeople().equals("")))
		{
			    isregister = "未反馈";
			    signpeoplenum = 0;
			    exampeoplenum = 0;
			    markpeoplenum = 0;
			    trainpeoplenum = 0;
				unexampeople = null;
				unmarkpeople = null;
		}*/
		if(tm.getIsregister()==1&&tp==null)
		{
			isregister = "未反馈";
		    signpeoplenum = 0;
		    exampeoplenum = 0;
		    markpeoplenum = 0;
		    trainpeoplenum = 0;
			unexampeople = null;
			unmarkpeople = null;
		}
		else if(tm.getIsregister()==1&&tp!=null&&(tp.getSignpeople()!=null&&!(tp.getSignpeople().equals(""))))
		{
			    signpeoplenum = tp.getSignpeople().split("、").length;
			    if(tp.getExampeople()!=null&&!tp.getExampeople().equals(""))
			    {
			    	  exampeoplenum = tp.getExampeople().split("、").length;
			    	  unexampeople = choicepeople(tm.getPeople(),tp.getExampeople());
			    }
			    if(tp.getMarkpeople()!=null&&!tp.getMarkpeople().equals(""))
			    {
			    	markpeoplenum = tp.getMarkpeople().split("、").length;
			    	unmarkpeople = choicepeople(tm.getPeople(),tp.getMarkpeople());
			    }
			    if(tp.getMarkpeople()==null||tp.getMarkpeople().equals(""))
			    {
			    	markpeoplenum = 0;
			    	unmarkpeople = choicepeople(tm.getPeople(),"");
			    }
			   
			   
				isregister = "已反馈";
				
		}
		else if(tm.getIsevaluate()==1&&tp!=null)
		{
			 if(tp.getMarkpeople()!=null&&!tp.getMarkpeople().equals(""))
			    {
			    	markpeoplenum = tp.getMarkpeople().split("、").length;
			    	unmarkpeople = choicepeople(tm.getPeople(),tp.getMarkpeople());
			    }
			    if(tp.getMarkpeople()==null||tp.getMarkpeople().equals(""))
			    {
			    	markpeoplenum = 0;
			    	unmarkpeople = choicepeople(tm.getPeople(),"");
			    }
		}
		
	  
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}
	public List<String> choicepeople(String planpeople,String realpeople )
	{
		List<String> people=new ArrayList();
		String []plan = planpeople.split("、");
		String []real = realpeople.split("、");
		for(int i=0;i<plan.length;i++)
		{
			int flag=0;
			for(int j=0;j<real.length;j++)
			{
				
				if(plan[i].equals(real[j]))
				{
					flag=1;
					break;
				}
			}
			if(flag==0)
			{
				people.add(plan[i]);
			}
		}
		return people;
	}
}
