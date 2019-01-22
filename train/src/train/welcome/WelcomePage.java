package train.welcome;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import train.welcome.WelcomeBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import train.trainmanage.pojo.TManage;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import train.util.UserUtil;
import ccb.hibernate.HibernateSessionFactory;


/**
 * 欢迎页面查看待办事宜
 * 
 * @author htzx
 * 
 */
public class WelcomePage {

	private String newnumber;
	private String number;
	private List<TManage> listwb1;
	private List<TManage> listwb2;
	private List<TManage> listwb3;
	private List<WelcomeBean> listwb;
	
	

	public List<TManage> getListwb3() {
		return listwb3;
	}

	public void setListwb3(List<TManage> listwb3) {
		this.listwb3 = listwb3;
	}

	public List<WelcomeBean> getListwb() {
		return listwb;
	}

	public void setListwb(List<WelcomeBean> listwb) {
		this.listwb = listwb;
	}

	public List<TManage> getListwb1() {
		return listwb1;
	}

	public void setListwb1(List<TManage> listwb1) {
		this.listwb1 = listwb1;
	}

	public List<TManage> getListwb2() {
		return listwb2;
	}

	public void setListwb2(List<TManage> listwb2) {
		this.listwb2 = listwb2;
	}

	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}

	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}


	public String execute() throws Exception {
		String hql1 = "";
		String hql2 = "";
		String hql3 = "";
		MyCompartor mc = new MyCompartor();
		MyCompartor1 mc1 = new MyCompartor1();
		//listwb2 = new ArrayList<WelcomeBean>();
		//listwb3 = new ArrayList<WelcomeBean>();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = uidao.findByNewNumber(newnumber);
		String name = ui.getUsername();
		listwb = new ArrayList<WelcomeBean>();
		try {
			String newnumber1=newnumber.substring(0,8);
			
			hql1 = "from TManage as tm where substr(tm.thisunder,1,8)='"+newnumber1+"' or (substr(tm.initiator,1,8)='"+newnumber1+"' and tm.status in (0,5)) order by tm.id desc";
			listwb1 = session.createQuery(hql1).list();
			hql2 = "from TManage as tm where tm.status=3 and ((tm.issign=1)or(tm.issign=2 and tm.people like '%"+name+"%')) order by tm.id desc";
			listwb2 = session.createQuery(hql2).list();
			hql3 = "select tm.* from t_manage as tm ,t_trainpeople as tp where tm.status=9 and tm.number=tp.number and tp.signpeople like'%"+name+"%' and (tp.markpeople is null or tp.markpeople not like '%"+name+"%') order by tm.id desc";			
			listwb3 = session.createSQLQuery(hql3).addEntity(TManage.class).list();
			for(int i=0;i<listwb1.size();i++)
			{
				TManage tm = listwb1.get(i);
				WelcomeBean wb = new WelcomeBean();
			    wb.setChu(tm.getChu());
			    wb.setDate(tm.getDate());
			    wb.setInitiator(tm.getInitiator());
			    wb.setIsregister(tm.getIsregister());
			    wb.setManager(tm.getManager());
			    wb.setNumber(tm.getNumber());
			    wb.setProgramname(tm.getProgramname());
			    wb.setStatus(tm.getStatus());
			    wb.setThisunder(tm.getThisunder());
			    wb.setType(tm.getType());
				listwb.add(wb);
			}
			for(int i=0;i<listwb3.size();i++)
			{
				TManage tm = listwb3.get(i);
				WelcomeBean wb = new WelcomeBean();
			    wb.setChu(tm.getChu());
			    wb.setDate(tm.getDate());
			    wb.setInitiator(tm.getInitiator());
			    wb.setIsregister(tm.getIsregister());
			    wb.setManager(tm.getManager());
			    wb.setNumber(tm.getNumber());
			    wb.setProgramname(tm.getProgramname());
			    wb.setStatus(tm.getStatus());
			    wb.setThisunder(tm.getThisunder());
			    wb.setType(tm.getType());
				listwb.add(wb);
			}
			Collections.sort(listwb,mc1);
			Collections.sort(listwb2,mc);
			//Collections.sort(listwb3,mc);
			//Collections.reverse(listwb);
		} catch (Exception e) {
			// TODO: handle exception
			trans.rollback();
			e.printStackTrace();
		} finally {
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		return "success";
	}
	
}
