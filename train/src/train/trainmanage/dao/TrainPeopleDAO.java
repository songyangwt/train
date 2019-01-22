package train.trainmanage.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import train.trainmanage.pojo.TManage;
import train.trainmanage.pojo.TrainPeople;

/**
 	* A data access object (DAO) providing persistence and search support for TrainPeople entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .TrainPeople
  * @author MyEclipse Persistence Tools 
 */

public class TrainPeopleDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(TrainPeopleDAO.class);
		//property constants
	public static final String NUMBER = "number";
	public static final String SIGNPEOPLE = "signpeople";
	public static final String MARKPEOPLE = "markpeople";
	public static final String EXAMPEOPLE = "exampeople";



    
    public void save(TrainPeople transientInstance) {
        log.debug("saving TrainPeople instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TrainPeople persistentInstance) {
        log.debug("deleting TrainPeople instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TrainPeople findById( java.lang.Integer id) {
        log.debug("getting TrainPeople instance with id: " + id);
        try {
            TrainPeople instance = (TrainPeople) getSession()
                    .get("TrainPeople", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TrainPeople instance) {
        log.debug("finding TrainPeople instance by example");
        try {
            List results = getSession()
                    .createCriteria("TrainPeople")
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
      log.debug("finding TrainPeople instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TrainPeople as model where model." 
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
	
	public List findBySignpeople(Object signpeople
	) {
		return findByProperty(SIGNPEOPLE, signpeople
		);
	}
	
	public List findByMarkpeople(Object markpeople
	) {
		return findByProperty(MARKPEOPLE, markpeople
		);
	}
	
	public List findByExampeople(Object exampeople
	) {
		return findByProperty(EXAMPEOPLE, exampeople
		);
	}
	

	public List findAll() {
		log.debug("finding all TrainPeople instances");
		try {
			String queryString = "from TrainPeople";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public TrainPeople merge(TrainPeople detachedInstance) {
        log.debug("merging TrainPeople instance");
        try {
            TrainPeople result = (TrainPeople) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TrainPeople instance) {
        log.debug("attaching dirty TrainPeople instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TrainPeople instance) {
        log.debug("attaching clean TrainPeople instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    
    
    public TrainPeople findAllBynumber(String number) {
    	
    	try {
    		 String queryString = "from TrainPeople as tm where tm.number ='"+number+"'";
             Query queryObject = getSession().createQuery(queryString);
            
             List<TrainPeople> list= queryObject.list();
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