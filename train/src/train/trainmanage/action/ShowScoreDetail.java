package train.trainmanage.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import train.trainmanage.dao.TManageDAO;
import train.trainmanage.dao.TrainPeopleDAO;
import train.trainmanage.pojo.TManage;
import train.trainmanage.pojo.TrainPeople;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;

public class ShowScoreDetail {
	private String newnumber;
	private String number;
    private TManage tm;
    private String message="";
    
    
    
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
		String result="success";
		TManageDAO tmdao = new TManageDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
	    tm = tmdao.findAllBynumber(number);
        TrainPeopleDAO tpdao = new TrainPeopleDAO();
        TrainPeople tp = new TrainPeople();
        tp = tpdao.findAllBynumber(number);
        UserInfoDAO uidao = new UserInfoDAO(); 
        UserInfo ui = uidao.findByNewNumber(newnumber);
        int flag= isscore(ui.getUsername(),tp.getMarkpeople());
        if(flag==1)
        {
        	result="failed";
        	message="已评估过，请勿重复评估！";
        }
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return result;
	}
	public int isscore (String name,String scorename)
	{
		int flag = 0;
		if(scorename==null||scorename.equals(""))
		{
			flag = 0;
		}
		else
		{
			String []names = scorename.split("、");
			for(int i =0;i<names.length;i++)
			{
				if(names[i].equals(name))
				{
					flag=1;
					break;
				}
			}
		}
		
		return flag;
	}
}
