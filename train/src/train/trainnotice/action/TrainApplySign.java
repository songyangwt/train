package train.trainnotice.action;

import org.hibernate.Session;
import org.hibernate.Transaction;
import train.trainmanage.dao.TManageDAO;
import train.trainmanage.pojo.TManage;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;

public class TrainApplySign {
	private String newnumber;
	private String number;
    private String message;
    
	

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
		
		TManageDAO tmdao = new TManageDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
		TManage tm = tmdao.findAllBynumber(number);
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = uidao.findByNewNumber(newnumber); 
		if(!tm.getPeople().equals(""))
		{
			String[] people = tm.getPeople().split("、");
			int flag = 0 ;
			String name = ui.getUsername();
			for(int i=0;i<people.length;i++)
			{
			  	if(name.equals(people[i]))
			  	{
			  		flag =1;
			  	}
			}
			if(flag==1)
			{
				message="已报名，请勿重复报名！";
			}
			else
			{
				String peoplesave = tm.getPeople()+"、"+ui.getUsername();
				tm.setPeople(peoplesave);
				message = "报名成功";
			}
			
		}
		else
		{
			tm.setPeople(ui.getUsername());
			message = "报名成功";
		}
		tmdao.merge(tm);
		
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
	

}
