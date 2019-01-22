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
import train.trainmanage.pojo.TrainScore;

/**
 	* A data access object (DAO) providing persistence and search support for TrainScore entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .TrainScore
  * @author MyEclipse Persistence Tools 
 */

public class TrainScoreDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(TrainScoreDAO.class);
		//property constants
	public static final String NUMBER = "number";
	public static final String NEWNUMBER = "newnumber";
	public static final String SCORE1 = "score1";
	public static final String SCORE2 = "score2";
	public static final String SCORE3 = "score3";
	public static final String SCORE4 = "score4";
	public static final String SCORE5 = "score5";
	public static final String SCORE6 = "score6";
	public static final String SCORE7 = "score7";
	public static final String SCORE8 = "score8";
	public static final String SCORE9 = "score9";
	public static final String SCORE10 = "score10";
	public static final String REMARK = "remark";



    
    public void save(TrainScore transientInstance) {
        log.debug("saving TrainScore instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TrainScore persistentInstance) {
        log.debug("deleting TrainScore instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TrainScore findById( java.lang.Integer id) {
        log.debug("getting TrainScore instance with id: " + id);
        try {
            TrainScore instance = (TrainScore) getSession()
                    .get("TrainScore", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TrainScore instance) {
        log.debug("finding TrainScore instance by example");
        try {
            List results = getSession()
                    .createCriteria("TrainScore")
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
      log.debug("finding TrainScore instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TrainScore as model where model." 
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
	
	public List findByNewnumber(Object newnumber
	) {
		return findByProperty(NEWNUMBER, newnumber
		);
	}
	
	public List findByScore1(Object score1
	) {
		return findByProperty(SCORE1, score1
		);
	}
	
	public List findByScore2(Object score2
	) {
		return findByProperty(SCORE2, score2
		);
	}
	
	public List findByScore3(Object score3
	) {
		return findByProperty(SCORE3, score3
		);
	}
	
	public List findByScore4(Object score4
	) {
		return findByProperty(SCORE4, score4
		);
	}
	
	public List findByScore5(Object score5
	) {
		return findByProperty(SCORE5, score5
		);
	}
	
	public List findByScore6(Object score6
	) {
		return findByProperty(SCORE6, score6
		);
	}
	
	public List findByScore7(Object score7
	) {
		return findByProperty(SCORE7, score7
		);
	}
	
	public List findByScore8(Object score8
	) {
		return findByProperty(SCORE8, score8
		);
	}
	
	public List findByScore9(Object score9
	) {
		return findByProperty(SCORE9, score9
		);
	}
	
	public List findByScore10(Object score10
	) {
		return findByProperty(SCORE10, score10
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	

	public List findAll() {
		log.debug("finding all TrainScore instances");
		try {
			String queryString = "from TrainScore";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public TrainScore merge(TrainScore detachedInstance) {
        log.debug("merging TrainScore instance");
        try {
            TrainScore result = (TrainScore) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TrainScore instance) {
        log.debug("attaching dirty TrainScore instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TrainScore instance) {
        log.debug("attaching clean TrainScore instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
     public List<TrainScore> findAllBynumber(String number) {
    	
    	try {
    		 String queryString = "from TrainScore as tm where tm.number ='"+number+"'";
             Query queryObject = getSession().createQuery(queryString);
            
             List<TrainScore> list= queryObject.list();
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
     
     public TrainScore findAllBynewnumberandnum(String newnumber,String number) {
     	
     	try {
     		 String queryString = "from TrainScore as tm where tm.newnumber ='"+newnumber+"' and tm.number='"+number+"'";
              Query queryObject = getSession().createQuery(queryString);
             
              List<TrainScore> list= queryObject.list();
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