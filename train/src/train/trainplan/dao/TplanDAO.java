package train.trainplan.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import train.trainplan.pojo.Tplan;
import train.userinfo.pojo.UserInfo;

/**
 	* A data access object (DAO) providing persistence and search support for Tplan entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Tplan
  * @author MyEclipse Persistence Tools 
 */

public class TplanDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(TplanDAO.class);
		//property constants
	public static final String CHU = "chu";
	public static final String MANAGER = "manager";
	public static final String CONTENT = "content";
	public static final String PEOPLE = "people";
	public static final String TIME = "time";
	public static final String LOCATION = "location";
	public static final String REMARK = "remark";
	public static final String YEAR = "year";



    
    public void save(Tplan transientInstance) {
        log.debug("saving Tplan instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Tplan persistentInstance) {
        log.debug("deleting Tplan instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Tplan findById( java.lang.Integer id) {
        log.debug("getting Tplan instance with id: " + id);
        try {
            Tplan instance = (Tplan) getSession()
                    .get("Tplan", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Tplan instance) {
        log.debug("finding Tplan instance by example");
        try {
            List results = getSession()
                    .createCriteria("Tplan")
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
      log.debug("finding Tplan instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Tplan as model where model." 
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
	
	public List findByManager(Object manager
	) {
		return findByProperty(MANAGER, manager
		);
	}
	
	public List findByContent(Object content
	) {
		return findByProperty(CONTENT, content
		);
	}
	
	public List findByPeople(Object people
	) {
		return findByProperty(PEOPLE, people
		);
	}
	
	public List findByTime(Object time
	) {
		return findByProperty(TIME, time
		);
	}
	
	public List findByLocation(Object location
	) {
		return findByProperty(LOCATION, location
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	
	public List findByYear(Object year
	) {
		return findByProperty(YEAR, year
		);
	}
	

	public List findAll() {
		log.debug("finding all Tplan instances");
		try {
			String queryString = "from Tplan";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Tplan merge(Tplan detachedInstance) {
        log.debug("merging Tplan instance");
        try {
            Tplan result = (Tplan) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Tplan instance) {
        log.debug("attaching dirty Tplan instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Tplan instance) {
        log.debug("attaching clean Tplan instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public List<Tplan> findByChuAndYear(int chu,String year) {
    	log.debug("finding all tplan instances");
    	try {
    		 String queryString = "from Tplan as tp where tp.chu ="+chu+" and tp.year= '"+year+"'";
             Query queryObject = getSession().createQuery(queryString);
            
             List<Tplan> list= queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	
    			 return list;
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    
    public Tplan findAllByid(int id) {
    	log.debug("finding all tplan instances");
    	try {
    		 String queryString = "from Tplan as tp where tp.id ="+id;
             Query queryObject = getSession().createQuery(queryString);
            
             List<Tplan> list= queryObject.list();
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
}