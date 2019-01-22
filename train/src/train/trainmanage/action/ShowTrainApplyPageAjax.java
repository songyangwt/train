package train.trainmanage.action;


import java.util.List;

import train.process.dao.ProcessDAO;
import train.process.pojo.Process;
import org.hibernate.Session;
import org.hibernate.Transaction;

import train.process.action.GetProcessByPosition;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;

import ccb.hibernate.HibernateSessionFactory;

public class ShowTrainApplyPageAjax {
	private String newnumber;
	//private String name;
	//private String chutuan;
	private String bossname;
	private UserInfo ui;
	//private String identity;
	//private String passport;
	//private String zxdate;
	//private String username;
    //private String time;
    //private String sex;
    private int chu;
    private List<UserInfo> list;
    
	public List<UserInfo> getList() {
		return list;
	}
	public void setList(List<UserInfo> list) {
		this.list = list;
	}
	public int getChu() {
		return chu;
	}
	public void setChu(int chu) {
		this.chu = chu;
	}

	public UserInfo getUi() {
		return ui;
	}
	public void setUi(UserInfo ui) {
		this.ui = ui;
	}
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	
	public String getBossname() {
		return bossname;
	}
	public void setBossname(String bossname) {
		this.bossname = bossname;
	}
	public String execute() throws Exception
	{
		String result = "success";
		UserInfoDAO uidao = new UserInfoDAO();
		//DateUtil du = new DateUtil();
		//time = du.getDate();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    ui = uidao.findByNewNumber(newnumber);
		
		//identity=ui.getIdentity();
		//passport=ui.getPassport();
		//zxdate=ui.getZxdate();
		//username=ui.getUsername();
		//sex = UserUtil.getSexFromIdentity(ui.getIdentity());
		
		if(ui==null)
		{
			result = "failededed";
		}
		else if(ifcandai(chu,ui))
		{
			
			//chutuan = UserUtil.positionToName(ui.getPosition());
		 GetProcessByPosition gpbp = new GetProcessByPosition();
		 ProcessDAO pdao = new ProcessDAO();
		 int process = 0;
	 	 process = gpbp.getPxsqProcess(ui,chu);
		 Process p = pdao.findByItemAndApplicant("PXSQ", process);
		 String thisunder = "";
		      
		    if(p!=null)
		    {
		    	thisunder = p.getProcess().substring(1, 2);//EDCA
		    	list = uidao.findByAuthorityAndPosition(thisunder,ui.getChu());
		    	bossname = uidao.findBoss(list);
		    }
		 
		}
		else
		{
			result = "failed";
		}
		trans.commit();
        session.flush();
        session.clear();
        session.close();
		return result;
	}
	
	
	/**
	 * a是否能代b发起 返回true能。返回false不能
	 * @param positionfq
	 * @param positionsq
	 * @return
	 */
	public boolean ifcandai(int chu,UserInfo ui)
	{
		int uichu = ui.getChu();
		if(chu==1||chu==2||chu==3||chu==5||chu==6)
		{
			if(uichu==chu)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return true;
		}
	}
}
