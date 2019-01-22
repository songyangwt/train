package train.trainmanage.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import train.trainmanage.pojo.TFile;
import train.trainmanage.pojo.TempFile;

/**
 	* A data access object (DAO) providing persistence and search support for TempFile entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .TempFile
  * @author MyEclipse Persistence Tools 
 */

public class TempFileDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(TempFileDAO.class);
		//property constants
	public static final String NAME = "name";
	public static final String FILENAME = "filename";
	public static final String NUMBER = "number";



    
    public void save(TempFile transientInstance) {
        log.debug("saving TempFile instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TempFile persistentInstance) {
        log.debug("deleting TempFile instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TempFile findById( java.lang.Integer id) {
        log.debug("getting TempFile instance with id: " + id);
        try {
            TempFile instance = (TempFile) getSession()
                    .get("TempFile", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TempFile instance) {
        log.debug("finding TempFile instance by example");
        try {
            List results = getSession()
                    .createCriteria("TempFile")
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
      log.debug("finding TempFile instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TempFile as model where model." 
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
	
	public List findByFilename(Object filename
	) {
		return findByProperty(FILENAME, filename
		);
	}
	
	public List findByNumber(Object number
	) {
		return findByProperty(NUMBER, number
		);
	}
	

	public List findAll() {
		log.debug("finding all TempFile instances");
		try {
			String queryString = "from TempFile";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public TempFile merge(TempFile detachedInstance) {
        log.debug("merging TempFile instance");
        try {
            TempFile result = (TempFile) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TempFile instance) {
        log.debug("attaching dirty TempFile instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TempFile instance) {
        log.debug("attaching clean TempFile instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public List<TempFile> findAllByNumber(String number) {
    	log.debug("finding all LeaveProcess instances");
    	try {
    		String queryString = "from TempFile as lp where lp.number='"+number+"' order by lp.id";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
}