package train.trainmanage.action;

import java.util.List;

import train.process.action.FindNextUnder;
import train.process.dao.ProcessDAO;
import train.process.pojo.Process;
import train.trainmanage.dao.ShenpiOperateDAO;
import train.trainmanage.dao.TFileDAO;
import train.trainmanage.dao.TManageDAO;
import train.trainmanage.pojo.ShenpiOperate;
import train.trainmanage.pojo.TFile;
import train.trainmanage.pojo.TManage;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import train.util.DateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;

public class ViewTrainApplyUnderDetail {
	private String number;
	private String undersign;
	private TManage tm;	
	private List<ShenpiOperate> listlp;
	private List<UserInfo> listui;
	private int youshenpi;
	private String position;
	private UserInfo ui;
	private String time;
	private List<TFile> listtf;
	

	public List<TFile> getListtf() {
		return listtf;
	}
	public void setListtf(List<TFile> listtf) {
		this.listtf = listtf;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getUndersign() {
		return undersign;
	}
	public void setUndersign(String undersign) {
		this.undersign = undersign;
	}
	

	public TManage getTm() {
		return tm;
	}
	public void setTm(TManage tm) {
		this.tm = tm;
	}
	public List<ShenpiOperate> getListlp() {
		return listlp;
	}
	public void setListlp(List<ShenpiOperate> listlp) {
		this.listlp = listlp;
	}
	public List<UserInfo> getListui() {
		return listui;
	}
	public void setListui(List<UserInfo> listui) {
		this.listui = listui;
	}
	public int getYoushenpi() {
		return youshenpi;
	}
	public void setYoushenpi(int youshenpi) {
		this.youshenpi = youshenpi;
	}
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}


	public UserInfo getUi() {
		return ui;
	}
	public void setUi(UserInfo ui) {
		this.ui = ui;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public String execute() throws Exception
	{
		DateUtil du = new DateUtil();
		TManageDAO tmdao = new TManageDAO();
		ShenpiOperateDAO lpdao = new ShenpiOperateDAO();
		TFileDAO tfdao = new TFileDAO();
		FindNextUnder fnu = new FindNextUnder();
		ProcessDAO pdao = new ProcessDAO();
		UserInfoDAO uidao = new  UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    tm = tmdao.findAllBynumber(number);
  	    listlp = lpdao.findAllByNumber(number);
 	  	listui = fnu.findNextUnder("PXSQ", number);
 	  	listtf = tfdao.findAllByNumber(number);
 	  	ui = uidao.findByNewNumber(tm.getInitiator());
 	  	Process p = pdao.findByItemAndApplicant("PXSQ",tm.getProcess());
 	  	time = du.getDate();
 	  	int jindulength = tm.getJindu().length();
 	  	String proc = p.getProcess();
 	  	
 	  	undersign = proc.substring(jindulength, jindulength+1);
 	  	
 	  	if(listui.isEmpty())
 	  	{
 	  		youshenpi = 0;
 	  	}
 	  	else
 	  	{
 	  		youshenpi = 1;
 	  	}
 	 
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
