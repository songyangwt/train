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
import train.trainplan.pojo.Tplan;

/**
 	* A data access object (DAO) providing persistence and search support for TManage entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .TManage
  * @author MyEclipse Persistence Tools 
 */

public class TManageDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(TManageDAO.class);
		//property constants
	public static final String CHU = "chu";
	public static final String MANAGER = "manager";
	public static final String CONTENT = "content";
	public static final String PEOPLE = "people";
	public static final String TIME = "time";
	public static final String LOCATION = "location";
	public static final String REQUIREMENT = "requirement";
	public static final String NUMBER = "number";
	public static final String PROGRAMNAME = "programname";
	public static final String TEL = "tel";
	public static final String PROCESS = "process";
	public static final String JINDU = "jindu";
	public static final String DATE = "date";
	public static final String STATUS = "status";
	public static final String PREUNDER = "preunder";
	public static final String THISUNDER = "thisunder";
	public static final String INITIATOR = "initiator";
	public static final String TYPE = "type";
	public static final String ISSIGN = "issign";
	public static final String ISREGISTER = "isregister";
	public static final String ISEXAM = "isexam";
	public static final String ISEVALUATE = "isevaluate";
	public static final String COURSEWARENUM = "coursewarenum";
	public static final String REMARK = "remark";
	public static final String TEACHER = "teacher";



    
    public void save(TManage transientInstance) {
        log.debug("saving TManage instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TManage persistentInstance) {
        log.debug("deleting TManage instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TManage findById( java.lang.Integer id) {
        log.debug("getting TManage instance with id: " + id);
        try {
            TManage instance = (TManage) getSession()
                    .get("TManage", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TManage instance) {
        log.debug("finding TManage instance by example");
        try {
            List results = getSession()
                    .createCriteria("TManage")
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
      log.debug("finding TManage instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TManage as model where model." 
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
	
	public List findByRequirement(Object requirement
	) {
		return findByProperty(REQUIREMENT, requirement
		);
	}
	
	public List findByNumber(Object number
	) {
		return findByProperty(NUMBER, number
		);
	}
	
	public List findByProgramname(Object programname
	) {
		return findByProperty(PROGRAMNAME, programname
		);
	}
	
	public List findByTel(Object tel
	) {
		return findByProperty(TEL, tel
		);
	}
	
	public List findByProcess(Object process
	) {
		return findByProperty(PROCESS, process
		);
	}
	
	public List findByJindu(Object jindu
	) {
		return findByProperty(JINDU, jindu
		);
	}
	
	public List findByDate(Object date
	) {
		return findByProperty(DATE, date
		);
	}
	
	public List findByStatus(Object status
	) {
		return findByProperty(STATUS, status
		);
	}
	
	public List findByPreunder(Object preunder
	) {
		return findByProperty(PREUNDER, preunder
		);
	}
	
	public List findByThisunder(Object thisunder
	) {
		return findByProperty(THISUNDER, thisunder
		);
	}
	
	public List findByInitiator(Object initiator
	) {
		return findByProperty(INITIATOR, initiator
		);
	}
	
	public List findByType(Object type
	) {
		return findByProperty(TYPE, type
		);
	}
	
	public List findByIssign(Object issign
	) {
		return findByProperty(ISSIGN, issign
		);
	}
	
	public List findByIsregister(Object isregister
	) {
		return findByProperty(ISREGISTER, isregister
		);
	}
	
	public List findByIsexam(Object isexam
	) {
		return findByProperty(ISEXAM, isexam
		);
	}
	
	public List findByIsevaluate(Object isevaluate
	) {
		return findByProperty(ISEVALUATE, isevaluate
		);
	}
	
	public List findByCoursewarenum(Object coursewarenum
	) {
		return findByProperty(COURSEWARENUM, coursewarenum
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	
	public List findByTeacher(Object teacher
	) {
		return findByProperty(TEACHER, teacher
		);
	}
	

	public List findAll() {
		log.debug("finding all TManage instances");
		try {
			String queryString = "from TManage";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public TManage merge(TManage detachedInstance) {
        log.debug("merging TManage instance");
        try {
            TManage result = (TManage) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TManage instance) {
        log.debug("attaching dirty TManage instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TManage instance) {
        log.debug("attaching clean TManage instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public TManage findAllBynumber(String number) {
    	
    	try {
    		 String queryString = "from TManage as tm where tm.number ='"+number+"'";
             Query queryObject = getSession().createQuery(queryString);
            
             List<TManage> list= queryObject.list();
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