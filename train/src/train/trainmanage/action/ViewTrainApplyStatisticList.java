package train.trainmanage.action;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import train.trainmanage.pojo.TManage;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;

public class ViewTrainApplyStatisticList {
	private String newnumber;// 新一代员工编号
	private List<TManage> list;
	private String authoU;
	private String authoV ;
	private int chutuan;
	private String begindate;
	private String enddate;
	private String type="wu";
	private String programname;
	private String manager;
	
		
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProgramname() {
		return programname;
	}

	public void setProgramname(String programname) {
		this.programname = programname;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getAuthoU() {
		return authoU;
	}

	public void setAuthoU(String authoU) {
		this.authoU = authoU;
	}

	public String getAuthoV() {
		return authoV;
	}

	public void setAuthoV(String authoV) {
		this.authoV = authoV;
	}

	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}


	public List<TManage> getList() {
		return list;
	}

	public void setList(List<TManage> list) {
		this.list = list;
	}

	
	public String getBegindate() {
		return begindate;
	}

	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public int getChutuan() {
		return chutuan;
	}

	public void setChutuan(int chutuan) {
		this.chutuan = chutuan;
	}



	public String execute() throws Exception
	{
		String result = "success";
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = new UserInfo();
		Query query;
		String hql = "";	
		String zhi = "";
		String chu = "";	
		String bd = "";
		String ed = "";
				
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			ui = uidao.findByNewNumber(newnumber);
			zhi = ui.getZhi().toString();
			chu = ui.getChu().toString();
			authoU = ui.getAuthority().substring(20, 21);
			authoV = ui.getAuthority().substring(21, 22);
			hql = "from TManage as tm";
			
			hql +=" where tm.status = 4";
			if(begindate!=null&&!begindate.equals("")&&enddate!=null&&!enddate.equals(""))
			{
				bd = begindate.replace("-","");
				ed = enddate.replace("-", "");
				hql += " and tm.date>='"+bd+"' and tm.date<='"+ed+"'";
			}
			if(type!=null&&!type.equals("")&&!type.equals("wu"))
			{
				hql += " and tm.type='"+type+"'";
			}
			if(manager!=null&&!manager.equals(""))
			{
				hql += " and tm.manager='"+manager+"'";
			}
			if(programname!=null&&!programname.equals(""))
			{
				hql += " and tm.programname='"+programname+"'";
			}
			if(zhi.equals("1")||authoU.equals("U"))
			{
			    if(chutuan!=0)
			    {
			    	hql += " and tm.chu='"+chutuan+"'";
			    }
					
			}
			else//处室培训管理员
			{
				hql += " and tm.chu='"+chu+"'";
			}
			hql += " order by tm.id desc";
			System.out.println(hql);
			query = session.createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		
		return result;
	}
	
	
}
