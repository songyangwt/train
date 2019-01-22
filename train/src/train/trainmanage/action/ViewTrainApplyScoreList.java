package train.trainmanage.action;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import train.trainmanage.pojo.TManage;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import train.util.Util;
import ccb.hibernate.HibernateSessionFactory;

public class ViewTrainApplyScoreList {
	
	private List<TManage> list;
	private String newnumber;
	
	
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


	public String execute() throws Exception
	{
		Query query;
		String hql = "";
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = uidao.findByNewNumber(newnumber);
		String name = ui.getUsername();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
		try {
			
			hql = "select tm.* from t_manage as tm ,t_trainpeople as tp where tm.status=9 and tm.number=tp.number and tp.signpeople like'%"+name+"%' and (tp.markpeople is null or tp.markpeople not like '%"+name+"%') order by tm.id desc";			
			list = session.createSQLQuery(hql).addEntity(TManage.class).list();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		return "success";
	}
	
}
