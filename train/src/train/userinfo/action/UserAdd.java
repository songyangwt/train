package train.userinfo.action;

import javax.servlet.http.HttpServletResponse;

import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import ccb.hibernate.HibernateSessionFactory;

public class UserAdd extends ActionSupport implements ServletResponseAware {
	private static final long serialVersionUID = 1L;
	private String newnumber;
    private String name;
    
    private int zhiwu;
    private int chu; 
    private String role;
    
    private String message;
    
   

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public int getZhiwu() {
		return zhiwu;
	}

	public void setZhiwu(int zhiwu) {
		this.zhiwu = zhiwu;
	}

	public int getChu() {
		return chu;
	}

	public void setChu(int chu) {
		this.chu = chu;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		
	}
	public String execute() throws Exception
	{
		UserInfoDAO uidao=new UserInfoDAO();
		UserInfo ui =new UserInfo();
		UserInfo uitemp = new UserInfo();
		
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 		uitemp=uidao.findByName(name);
		if(uitemp!=null)
		{
			this.addFieldError("用户","姓名已存在");
		  	 return "failed";
		}
		uitemp=uidao.findByNewNumber(newnumber);
		if(uitemp!=null)
		{
			this.addFieldError("用户","新一代编号已存在");
		  	 return "failed";
		}
 	    if(newnumber==null||newnumber.equals(""))
		  {
 			 this.addFieldError("用户","新一代编号为空");
			  	 return "failed";
		  } 
		  else if(name==null||name.equals(""))
		  {
			 this.addFieldError("用户","姓名为空");
		  	 return "failed";
		  }
		
		 
		  else if(zhiwu==0)
		  {
			 this.addFieldError("用户","职务为空");
		  	 return "failed";
		  }
		  else if((chu==0)&&(zhiwu!=1))
		  {
			 this.addFieldError("用户","处室为空");
		  	 return "failed";
		  }
		
		  /*else if(zu.equals(""))
		  {
			 this.addFieldError("用户","班组为空");
		  	 return "false";
		  }*/
		  else if(role.equals("wu")||role.equals(""))
		  {
			 this.addFieldError("用户","角色权限为空");
		  	 return "failed";
		  }

 	    ui.setChu(chu);
 	    ui.setZhi(zhiwu);
 	    ui.setNewnumber(newnumber);
 	    ui.setUsername(name);
 	    ui.setAuthority(roletoautho(role));
 	    uidao.merge(ui);
 	    message="添加成功";
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
   public static String roletoautho(String role)
    {
    	String autho="";
    
    	if(role.equals("U"))
    	{
    		autho="00000000000000000000U0";
    	}
    	else if(role.equals("V"))
    	{
    		autho="000000000000000000000V";
    	}
    	else
    	{
    		autho="0000000000000000000000";
    	}
    	return autho;
    }
}
