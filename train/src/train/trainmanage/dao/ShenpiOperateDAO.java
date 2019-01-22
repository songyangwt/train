package train.trainmanage.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;



import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import train.trainmanage.pojo.ShenpiOperate;

/**
 	* A data access object (DAO) providing persistence and search support for ShenpiOperate entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .ShenpiOperate
  * @author MyEclipse Persistence Tools 
 */

public class ShenpiOperateDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ShenpiOperateDAO.class);
		//property constants
	public static final String NUMBER = "number";
	public static final String TIME = "time";
	public static final String VIEWER = "viewer";
	public static final String VIEWERNEWNUMBER = "viewernewnumber";
	public static final String ROLE = "role";
	public static final String AUTHORITY = "authority";
	public static final String OPINION = "opinion";
	public static final String REMARK = "remark";



    
    public void save(ShenpiOperate transientInstance) {
        log.debug("saving ShenpiOperate instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ShenpiOperate persistentInstance) {
        log.debug("deleting ShenpiOperate instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ShenpiOperate findById( java.lang.Integer id) {
        log.debug("getting ShenpiOperate instance with id: " + id);
        try {
            ShenpiOperate instance = (ShenpiOperate) getSession()
                    .get("ShenpiOperate", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ShenpiOperate instance) {
        log.debug("finding ShenpiOperate instance by example");
        try {
            List results = getSession()
                    .createCriteria("ShenpiOperate")
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
      log.debug("finding ShenpiOperate instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ShenpiOperate as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByNumber(Object number
	) {
		return findByProperty(NUMBER, number
		);
	}
	
	public List findByTime(Object time
	) {
		return findByProperty(TIME, time
		);
	}
	
	public List findByViewer(Object viewer
	) {
		return findByProperty(VIEWER, viewer
		);
	}
	
	public List findByViewernewnumber(Object viewernewnumber
	) {
		return findByProperty(VIEWERNEWNUMBER, viewernewnumber
		);
	}
	
	public List findByRole(Object role
	) {
		return findByProperty(ROLE, role
		);
	}
	
	public List findByAuthority(Object authority
	) {
		return findByProperty(AUTHORITY, authority
		);
	}
	
	public List findByOpinion(Object opinion
	) {
		return findByProperty(OPINION, opinion
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	

	public List findAll() {
		log.debug("finding all ShenpiOperate instances");
		try {
			String queryString = "from ShenpiOperate";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ShenpiOperate merge(ShenpiOperate detachedInstance) {
        log.debug("merging ShenpiOperate instance");
        try {
            ShenpiOperate result = (ShenpiOperate) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ShenpiOperate instance) {
        log.debug("attaching dirty ShenpiOperate instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ShenpiOperate instance) {
        log.debug("attaching clean ShenpiOperate instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public List<ShenpiOperate> findAllByNumber(String number) {
    	log.debug("finding all LeaveProcess instances");
    	try {
    		String queryString = "from ShenpiOperate as lp where lp.number='"+number+"' order by lp.id";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    
    
}