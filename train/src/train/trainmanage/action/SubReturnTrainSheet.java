package train.trainmanage.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import train.trainmanage.dao.TManageDAO;
import train.trainmanage.dao.TrainPeopleDAO;
import train.trainmanage.pojo.TManage;
import train.trainmanage.pojo.TrainPeople;
import ccb.hibernate.HibernateSessionFactory;

public class SubReturnTrainSheet {
	private String newnumber;
	private String number;
    private TManage tm;
    private String [] signname;
	private TrainPeople tp;
	private String message;
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String[] getSignname() {
		return signname;
	}

	public void setSignname(String[] signname) {
		this.signname = signname;
	}

	public TrainPeople getTp() {
		return tp;
	}

	public void setTp(TrainPeople tp) {
		this.tp = tp;
	}

	public TManage getTm() {
		return tm;
	}

	public void setTm(TManage tm) {
		this.tm = tm;
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
	    TrainPeopleDAO  tpdao = new TrainPeopleDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
		tm = tmdao.findAllBynumber(number);
		String []listname = tm.getPeople().split("、");
		String names = "";
		for(int i =0; i<signname.length;i++)
		{
			if(signname[i]!=null)
			{
				if(names.equals(""))
				{
					names = listname[i];
				}
				else
				{
					names = names+"、"+listname[i];
				}
			}
		}
		tp=tpdao.findAllBynumber(number);
		if(tp!=null)
		{
			tp.setSignpeople(names);
			tpdao.merge(tp);
		}
		else
		{
			TrainPeople tp1= new TrainPeople();
			tp1.setNumber(number);
			tp1.setSignpeople(names);
			tpdao.merge(tp1);
		}
		if(tm.getIsexam()==1)
		{
			tm.setStatus(8);
		}
		else if(tm.getIsevaluate()==1)
		{
			tm.setStatus(9);
			tm.setThisunder("");
		}
		else
		{
			tm.setStatus(4);
			tm.setThisunder("");
		}
		tmdao.merge(tm);
		message="反馈成功";
		trans.commit();
		session.flush();
		session.clear();
		session.close();
	
		return "success";
	}
}
