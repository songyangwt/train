package train.trainmanage.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import train.process.dao.ProcessDAO;
import train.process.pojo.Process;

import train.process.action.GetProcessByPosition;

import org.hibernate.Session;
import org.hibernate.Transaction;

import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;

import ccb.hibernate.HibernateSessionFactory;



public class ShowTrainApplyPage {
	private String newnumber;
	private UserInfo ui;
	private List<UserInfo> list;
	
	
	public List<UserInfo> getList() {
		return list;
	}

	public void setList(List<UserInfo> list) {
		this.list = list;
	}

	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}

	public UserInfo getUi() {
		return ui;
	}

	public void setUi(UserInfo ui) {
		this.ui = ui;
	}

	public String execute() throws Exception
	{
		
		UserInfoDAO uidao = new UserInfoDAO();
		//ProcessDAO pdao = new ProcessDAO();
 	   // int process = 0;
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    //GetProcessByPosition gpbp = new GetProcessByPosition();
 	    ui = uidao.findByNewNumber(newnumber);
 	   // process = gpbp.getPxsqProcess(ui.getZhi(),ui.getChu());
	   // Process p = pdao.findByItemAndApplicant("PXSQ", process);
	   // String thisunder = "";
	    

	    
	    
	    /*if(p!=null)
	    {
	    	thisunder = p.getProcess().substring(1, 2);//EDCA
	    	list = uidao.findByAuthorityAndPosition(thisunder, ui.getChu());
	    }*/
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}
}
