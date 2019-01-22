package train.userinfo.action;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.servlet.http.HttpServletResponse;

import train.config.dao.ConfigDAO;
import train.config.pojo.Config;
import train.util.DateUtil;


import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import train.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Entity
public class UserLogin extends ActionSupport implements ServletResponseAware{
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	
	private Session h_session;
    private Transaction trans;
    private String hql;
    private Query query;
    private int errNum = 0;
    private int restNum;
    private int isneedalert=0;
    
    Timestamp d = new Timestamp(System.currentTimeMillis());
    
    
	public int getIsneedalert() {
		return isneedalert;
	}


	public void setIsneedalert(int isneedalert) {
		this.isneedalert = isneedalert;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}




	public Session getSession() {
		return h_session;
	}


	public void setSession(Session h_session) {
		this.h_session = h_session;
	}


	public Transaction getTrans() {
		return trans;
	}


	public void setTrans(Transaction trans) {
		this.trans = trans;
	}


	public String getHql() {
		return hql;
	}


	public void setHql(String hql) {
		this.hql = hql;
	}


	public Query getQuery() {
		return query;
	}


	public void setQuery(Query query) {
		this.query = query;
	}
     public void setServletResponse(HttpServletResponse response)
       {
       }

	public String execute() throws Exception
	{
	/*固定写法*/
		  DateUtil du = new DateUtil();
		  ConfigDAO cfgdao = new ConfigDAO();
		  int views = 0;//访问量统计
		  h_session=HibernateSessionFactory.getSession();
		  trans=h_session.beginTransaction();
		 // ifKQQSDisabled(h_session);//考勤缺失
		  Config config = cfgdao.findAllByName("times");
		  username=new String(username.getBytes("ISO8859-1"),"UTF-8");
		  hql="select user from UserInfo as user where user.username=:u";
		  query=h_session.createQuery(hql);
		  query.setString("u",username);//设置查询参数
		//  query.setString("p",password);//设置查询参数
		  System.out.println(username+":"+hql);
          List l=query.list();
     	  if((l==null)||(l.size()<=0))
     	  {
     		  this.addFieldError("用户","用户不存在!");
			  return "false";
     	  }
     	  else 
     	  {
     		  UserInfo u=(UserInfo)(l.get(0));
     		  id=u.getId();
     		  username = this.getUsername();
     		
     		  System.out.print("username:"+username);
     		 
     		  
     		 if(ActionContext.getContext().getSession().get(username) == null)
 			 {
 				 errNum = 0;
 			 }
 			 else{
 				 errNum=(Integer)ActionContext.getContext().getSession().get(username);
 			 }
 			 System.out.print(ActionContext.getContext().getSession().get(username));
 			 if(errNum>=5)
 			 {
 				this.addFieldError("用户","该用户已经被锁定,请找管理员解锁");
				return "false";
 			 }
     		 /* if(!password.equals(u.getPassword()))
     		  {
     			 if(errNum==0)
        		  {
        			 errNum = errNum+1;
        			 ActionContext.getContext().getSession().put(username,errNum);  
        			 this.addFieldError("用户","你已经输入错误1次，还有4次");
       			  	 return "false";
        		  }
     			 else 
     			 {
     					restNum = 5-errNum;
     					this.addFieldError("用户","你已经输入错误"+errNum+"次，还有"+restNum+"次");
     					errNum = errNum+1;
     					ActionContext.getContext().getSession().put(username,errNum);  
     					return "false";
     			 }
     			
     		  }*/
     		 
     		  
     		  System.out.print("time1"+d);
        	  ActionContext.getContext().getSession().put("username",u.getUsername());
        	  ActionContext.getContext().getSession().put("zhi",u.getZhi());
        	  ActionContext.getContext().getSession().put("chu",u.getChu());
        	 // ActionContext.getContext().getSession().put("password",u.getPassword());
        	 // ActionContext.getContext().getSession().put("zhi",u.getPosition().substring(0,1));//30303
        	 // ActionContext.getContext().getSession().put("chu",u.getPosition().substring(2,3));//30303
        	 // ActionContext.getContext().getSession().put("zu",u.getPosition().substring(4,5));//30303
        	  ActionContext.getContext().getSession().put("id",id);
        	 
        	  ActionContext.getContext().getSession().put("newnumber",u.getNewnumber());
        	  ActionContext.getContext().getSession().put("year",du.getThisYear());
        	  ActionContext.getContext().getSession().put("autho",u.getAuthority());
        	  ActionContext.getContext().getSession().put("authoA",u.getAuthority().substring(0,1));
        	  ActionContext.getContext().getSession().put("authoB",u.getAuthority().substring(1,2));
        	  ActionContext.getContext().getSession().put("authoC",u.getAuthority().substring(2,3));
        	  ActionContext.getContext().getSession().put("authoD",u.getAuthority().substring(3,4));
        	  ActionContext.getContext().getSession().put("authoE",u.getAuthority().substring(4,5));
        	  ActionContext.getContext().getSession().put("authoF",u.getAuthority().substring(5,6));
        	  ActionContext.getContext().getSession().put("authoG",u.getAuthority().substring(6,7));
        	  ActionContext.getContext().getSession().put("authoH",u.getAuthority().substring(7,8));
        	  ActionContext.getContext().getSession().put("authoI",u.getAuthority().substring(8,9));
        	  ActionContext.getContext().getSession().put("authoJ",u.getAuthority().substring(9,10));
        	  ActionContext.getContext().getSession().put("authoK",u.getAuthority().substring(10,11));
        	  ActionContext.getContext().getSession().put("authoL",u.getAuthority().substring(11,12));
        	  ActionContext.getContext().getSession().put("authoM",u.getAuthority().substring(12,13));
        	  ActionContext.getContext().getSession().put("authoN",u.getAuthority().substring(13,14));
        	  ActionContext.getContext().getSession().put("authoO",u.getAuthority().substring(14,15));
        	  ActionContext.getContext().getSession().put("authoP",u.getAuthority().substring(15,16));
        	  ActionContext.getContext().getSession().put("authoQ",u.getAuthority().substring(16,17));
        	  ActionContext.getContext().getSession().put("authoR",u.getAuthority().substring(17,18));
        	  ActionContext.getContext().getSession().put("authoS",u.getAuthority().substring(18,19));
        	  ActionContext.getContext().getSession().put("authoT",u.getAuthority().substring(19,20));
        	  ActionContext.getContext().getSession().put("authoU",u.getAuthority().substring(20,21));
        	  ActionContext.getContext().getSession().put("authoV",u.getAuthority().substring(21,22));
        	  config.setValue(config.getValue()+1);
        	  ActionContext.getContext().getSession().put("views",config.getValue());
        	  cfgdao.merge(config);
        	  //访问量统计
//        	  HttpSession session=null;
//        	  session.setAttribute("user", this.getUsername());
        	  trans.commit();
        	  h_session.flush();
        	  h_session.clear();
        	  h_session.close();
        	  return "success";
     	  }
  }
}
