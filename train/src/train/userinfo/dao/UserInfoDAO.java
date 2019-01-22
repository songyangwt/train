package train.userinfo.dao;
// default package

import ccb.dao.BaseHibernateDAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import train.userinfo.pojo.UserInfo;

/**
 	* A data access object (DAO) providing persistence and search support for UserInfo entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .UserInfo
  * @author MyEclipse Persistence Tools 
 */

public class UserInfoDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(UserInfoDAO.class);
		//property constants
	public static final String CHU = "chu";
	public static final String AUTHORITY = "authority";
	public static final String ZHI = "zhi";
	public static final String NEWNUMBER = "newnumber";
	public static final String USERNAME = "username";



    
    public void save(UserInfo transientInstance) {
        log.debug("saving UserInfo instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UserInfo persistentInstance) {
        log.debug("deleting UserInfo instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UserInfo findById( java.lang.Integer id) {
        log.debug("getting UserInfo instance with id: " + id);
        try {
            UserInfo instance = (UserInfo) getSession()
                    .get("UserInfo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UserInfo instance) {
        log.debug("finding UserInfo instance by example");
        try {
            List results = getSession()
                    .createCriteria("UserInfo")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding UserInfo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserInfo as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByChu(Object chu
	) {
		return findByProperty(CHU, chu
		);
	}
	
	public List findByAuthority(Object authority
	) {
		return findByProperty(AUTHORITY, authority
		);
	}
	
	public List findByZhi(Object zhi
	) {
		return findByProperty(ZHI, zhi
		);
	}
	
	public List findByNewnumber(Object newnumber
	) {
		return findByProperty(NEWNUMBER, newnumber
		);
	}
	
	public List findByUsername(Object username
	) {
		return findByProperty(USERNAME, username
		);
	}
	

	public List findAll() {
		log.debug("finding all UserInfo instances");
		try {
			String queryString = "from UserInfo";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UserInfo merge(UserInfo detachedInstance) {
        log.debug("merging UserInfo instance");
        try {
            UserInfo result = (UserInfo) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UserInfo instance) {
        log.debug("attaching dirty UserInfo instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UserInfo instance) {
        log.debug("attaching clean UserInfo instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
	public UserInfo findAllById( int id) {
        log.debug("getting UserInfo instance with id: " + id);
        try {
        	String queryString = "from UserInfo as ui where ui.id="+id;
	         Query queryObject = getSession().createQuery(queryString);
			 List list = queryObject.list();
			if(list.isEmpty())
			{
				return null;
			}
			else
			{
				return (UserInfo) list.get(0);
			}
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    public UserInfo findByNewNumber(String newnumber) {
    	log.debug("finding all UserInfo instances");
    	try {
    		String queryString = "from UserInfo as ui where ui.newnumber=:u";
             Query queryObject = getSession().createQuery(queryString);
             queryObject.setString("u",newnumber);
             List<UserInfo> list= queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 UserInfo ui = (UserInfo) list.get(0);
    			 return ui;
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    
    /**
	 * 涉及分组情况
	 * 根据权限,分组查询，，返回list
	 * @param authority
	 * @return
	 */
	public List<UserInfo> findTuanByAuthorityAndChu(String authority,int chu) {
		log.debug("finding all UserInfo instances");
		try {
			String queryString = "from UserInfo as ui where ui.authority like '%"+authority+"%' and ui.chu = "+chu+" and length(ui.newnumber)=8 ";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	/**
	 * 根据权限查询，返回list
	 * @param authority
	 * @return
	 */
	public List<UserInfo> findAllByAuthority(String authority) {
		log.debug("finding all UserInfo instances");
		try {
			String queryString = "from UserInfo as ui where ui.authority like '%"+authority+"%' and length(ui.newnumber)=8 ";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public String nameToNewnumbernull(String name) {
    	log.debug("finding all UserInfo instances");
    	try {
    		String queryString = "from UserInfo as ui where ui.username=:u";
             Query queryObject = getSession().createQuery(queryString);
             queryObject.setString("u",name);
             List<UserInfo> list= queryObject.list();
             if(list.isEmpty())
             {
            	 return "";
             }
             else
             {
            	 UserInfo ui = (UserInfo) list.get(0);
    			 return ui.getNewnumber();
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    
    public List<UserInfo> findByAuthorityAndPosition(String authority,int chu)
    {
    	
    		List<UserInfo> listtemp = new ArrayList<UserInfo>();
    		List<UserInfo> list = new ArrayList<UserInfo>();
    		if(authority.equals("V"))
        	{
    			listtemp=findTuanByAuthorityAndChu(authority,chu);
        	}
        	
        	else if(authority.equals("U"))
        	{
        		listtemp=findAllByAuthority(authority);
        	}
    		
    		list = UserlistToSelectlist(listtemp);
    		return list;
    }
    
	
	
	  public List<UserInfo> UserlistToSelectlist(List<UserInfo> listtemp)
	    {
	    	List<UserInfo> list = new ArrayList<UserInfo>();
	    	if(!listtemp.isEmpty())
	    	{
	    		for(int i=0;i<listtemp.size();i++)
	    		{
	    			UserInfo uitemp = listtemp.get(i);
	    			UserInfo uithis = new UserInfo();
	    			//String temppos = uitemp.getPosition();
	    			String tempautho=uitemp.getAuthority().substring(21,22);
	    			String tempstr = "";
	    			int tempchu = uitemp.getChu();
	    			//int tempzhi = uitemp.getZhi();
	    			
	    		    if(tempchu==1)
	    			{
	    				tempstr = "综合与生产管理处培训管理员（"+uitemp.getUsername()+"）";
	    			}
	    			else if(tempchu==2)
	    			{
	    				tempstr = "合规与监督二处培训管理员（"+uitemp.getUsername()+"）";
	    			}
	    			
	    			else if(tempchu==3)
	    			{
	    			
	    			    tempstr = "通用业务二处培训管理员（"+uitemp.getUsername()+"）";
	    				
	    				
	    			}
	    			
	    			else if(tempchu==5)
	    			{
	    				  tempstr = "研发支持二处培训管理员（"+uitemp.getUsername()+"）";
	    			}
	    			else if(tempchu==6)
	    			{
	    				
	    					tempstr = "专业处理二处培训管理员（"+uitemp.getUsername()+"）";
	    			  				
	    			}
	    			
	    			if(tempautho.equals("U"))
	    			{
	    				    tempstr = "中心培训管理员（"+uitemp.getUsername()+"）";
	    			}
	    			uithis.setUsername(tempstr);
	    			uithis.setNewnumber(uitemp.getNewnumber());
	    			list.add(uithis);
	    		}
	    		
	    		
	    	}
	    	return list;
	    }
	  
	  public String findBoss(List<UserInfo>list)
	    {
	    	String bossname = "";
	    	
	    	for(int i=0;i<list.size();i++)
	    	{
	    		UserInfo ui = list.get(list.size()-i-1);
	    		bossname = ui.getUsername()+":"+ui.getNewnumber()+";"+bossname;
	    	}
	    	 if(bossname.length()>0)
	    	        bossname=bossname.substring(0,bossname.length()-1);
	    	return bossname;
	    }

	  public UserInfo findByName(String username) {
	    	log.debug("finding all UserInfo instances");
	    	try {
	    		String queryString = "from UserInfo as ui where ui.username=:u ";
	             Query queryObject = getSession().createQuery(queryString);
	             queryObject.setString("u",username);
	             List<UserInfo> list = queryObject.list();
	             if(list.isEmpty())
	             {
	            	 return null;
	             }
	             else
	             {
	            	 return list.get(0);
	             }
	    		
	    	} catch (RuntimeException re) {
	    		log.error("find all failed", re);
	    		throw re;
	    	}
	    }
	  
		public UserInfo findByNewNumberId(String newnumber, int id) {
			log.debug("finding all User instances");
			try {
				String queryString = "from UserInfo as pu where pu.newnumber='"+newnumber+"' and pu.id!='"+id+"'";
				Query queryObject = getSession().createQuery(queryString);
				List list = queryObject.list();
				if(list.isEmpty())
				{
					return null;
				}
				else
				{
					return (UserInfo) list.get(0);
				}
				 
			} catch (RuntimeException re) {
				log.error("find all failed", re);
				throw re;
			}
		}
		
		public UserInfo findByNameId(String name,int id) {
			log.debug("finding all User instances");
			try {
				String queryString = "from UserInfo as pu where pu.username='"+name+"' and pu.id!='"+id+"'";
				Query queryObject = getSession().createQuery(queryString);
				List list = queryObject.list();
				if(list.isEmpty())
				{
					return null;
				}
				else
				{
					return (UserInfo) list.get(0);
				}
				 
			} catch (RuntimeException re) {
				log.error("find all failed", re);
				throw re;
			}
		}

}