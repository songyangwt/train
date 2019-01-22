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
import train.trainmanage.pojo.TFile;

/**
 	* A data access object (DAO) providing persistence and search support for TFile entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .TFile
  * @author MyEclipse Persistence Tools 
 */

public class TFileDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(TFileDAO.class);
		//property constants
	public static final String NAME = "name";
	public static final String NUMBER = "number";
	public static final String FILENAME = "filename";



    
    public void save(TFile transientInstance) {
        log.debug("saving TFile instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TFile persistentInstance) {
        log.debug("deleting TFile instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TFile findById( java.lang.Integer id) {
        log.debug("getting TFile instance with id: " + id);
        try {
            TFile instance = (TFile) getSession()
                    .get("TFile", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TFile instance) {
        log.debug("finding TFile instance by example");
        try {
            List results = getSession()
                    .createCriteria("TFile")
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
      log.debug("finding TFile instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TFile as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List findByNumber(Object number
	) {
		return findByProperty(NUMBER, number
		);
	}
	
	public List findByFilename(Object filename
	) {
		return findByProperty(FILENAME, filename
		);
	}
	

	public List findAll() {
		log.debug("finding all TFile instances");
		try {
			String queryString = "from TFile";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public TFile merge(TFile detachedInstance) {
        log.debug("merging TFile instance");
        try {
            TFile result = (TFile) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TFile instance) {
        log.debug("attaching dirty TFile instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TFile instance) {
        log.debug("attaching clean TFile instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public List<TFile> findAllByNumber(String number) {
    	log.debug("finding all LeaveProcess instances");
    	try {
    		String queryString = "from TFile as lp where lp.number='"+number+"' order by lp.id";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
}