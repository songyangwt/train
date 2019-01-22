package train.mycalendar.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;



import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import train.mycalendar.pojo.t_mycalendar;

/**
 	* A data access object (DAO) providing persistence and search support for t_mycalendar entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .t_mycalendar
  * @author MyEclipse Persistence Tools 
 */

public class t_mycalendarDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(t_mycalendarDAO.class);
		//property constants
	public static final String DATE = "date";
	public static final String WEEK = "week";
	public static final String WORKDAY = "workday";
	public static final String REMARK = "remark";



    
    public void save(t_mycalendar transientInstance) {
        log.debug("saving t_mycalendar instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(t_mycalendar persistentInstance) {
        log.debug("deleting t_mycalendar instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public t_mycalendar findById( java.lang.Integer id) {
        log.debug("getting t_mycalendar instance with id: " + id);
        try {
            t_mycalendar instance = (t_mycalendar) getSession()
                    .get("t_mycalendar", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(t_mycalendar instance) {
        log.debug("finding t_mycalendar instance by example");
        try {
            List results = getSession()
                    .createCriteria("t_mycalendar")
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
      log.debug("finding t_mycalendar instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from t_mycalendar as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByDate(Object date
	) {
		return findByProperty(DATE, date
		);
	}
	
	public List findByWeek(Object week
	) {
		return findByProperty(WEEK, week
		);
	}
	
	public List findByWorkday(Object workday
	) {
		return findByProperty(WORKDAY, workday
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	

	public List findAll() {
		log.debug("finding all t_mycalendar instances");
		try {
			String queryString = "from t_mycalendar";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public t_mycalendar merge(t_mycalendar detachedInstance) {
        log.debug("merging t_mycalendar instance");
        try {
            t_mycalendar result = (t_mycalendar) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(t_mycalendar instance) {
        log.debug("attaching dirty t_mycalendar instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(t_mycalendar instance) {
        log.debug("attaching clean t_mycalendar instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /**
	 * 根据日期查询当月最后一天
	 * @param date
	 * @return
	 */
	public String findEndDateByDate(String date)
	{
		log.debug("finding all t_mycalendar instances");
		try {
			String queryString = "from t_mycalendar as mc where mc.date like '"+date.substring(0,6)+"__' order by mc.date desc";
	         Query queryObject = getSession().createQuery(queryString);
	         List<t_mycalendar> list = queryObject.list();
	         if(list.isEmpty())
	         {
	        	 return null;
	         }
	         else
	         {
	        	 return list.get(0).getDate();
	         }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    /**
     * 传入8位日期
     * 返回是否是工作日
     * @param date
     * @return true 工作日 false 非工作日
     */
    public boolean ifWorkDay(String date) {
		log.debug("finding all t_mycalendar instances");
		try {
			 String queryString = "from t_mycalendar as mc where mc.date='"+date+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         t_mycalendar calendar = (t_mycalendar) queryObject.list().get(0);
	         if(calendar.getWorkday()==1)
	         {
	        	 return true;
	         }
	         else
	         {
	        	 return false;
	         }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    
    public t_mycalendar findByDate(String date) {
		log.debug("finding all t_mycalendar instances");
		try {
			String queryString = "from t_mycalendar as mc where mc.date='"+date+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 return (t_mycalendar) queryObject.list().get(0);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    /**
     * 根据起始截止日期工作日查询所有
     * @param begindate
     * @param enddate
     * @param workday 1工作日，0非工作日 2全部
     * @return
     */
    public List<t_mycalendar> findByBeginAndEnd(String begindate,String enddate,int workday) {
		log.debug("finding all t_mycalendar instances");
		try {
			String queryString = "";
			if(workday==2)
			{
				queryString = "from t_mycalendar as mc where mc.date>='"+begindate+"' and mc.date<='"+enddate+"'";
			}
			else
			{
				queryString = "from t_mycalendar as mc where mc.date>='"+begindate+"' and mc.date<='"+enddate+"' and mc.workday="+workday;
			}
			 Query queryObject = getSession().createQuery(queryString);
			 return  queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    /**
     * 根据起始截止日期halfday查询加班可抵用天数（国家法定节假日1比2）
     * @param begindate
     * @param enddate
     * @param workday 1工作日，0非工作日 2全部
     * @param halfday 0无，1第一天下午，2最后一天上午，3=1+2
     * @return
     */
    public double findJbdaysByBeginAndEnd(String begindate,String enddate,int halfday) {
		log.debug("finding all t_mycalendar instances");
		try {
			double jbdays = 0;
			String queryString = "";
			queryString = "from t_mycalendar as mc where mc.date>='"+begindate+"' and mc.date<='"+enddate+"'";
			Query queryObject = getSession().createQuery(queryString);
			List<t_mycalendar> list = queryObject.list();
			
			if(begindate.equals(enddate))//只有一天
			{
				t_mycalendar mc = list.get(0);
				double tempday = 0;
				if(halfday==1||halfday==3)
				{
					tempday = 0.5;
				}
				else
				{
					tempday = 1;
				}
				if(mc.getRemark().equals("1"))
				{
					tempday = tempday*2;
				}
				jbdays+=tempday;
			}
			else//一天以上
			{
				for(int i=0;i<list.size();i++)
				{
					t_mycalendar mc = list.get(i);
					if(mc.getDate().equals(begindate))//第一天
					{
						double tempday = 0;
						if(halfday==1||halfday==3)
						{
							tempday=0.5;
						}
						else
						{
							tempday=1;
						}
						if(mc.getRemark().equals("1"))
						{
							tempday = tempday*2;
						}
						jbdays+=tempday;
					}
					else if(mc.getDate().equals(enddate))//最后一天
					{
						double tempday = 0;
						if(halfday==2||halfday==3)
						{
							tempday=0.5;
						}
						else
						{
							tempday=1;
						}
						if(mc.getRemark().equals("1"))
						{
							tempday = tempday*2;
						}
						jbdays+=tempday;
					}
					else//中间天数
					{
						double tempday = 1;
						if(mc.getRemark().equals("1"))
						{
							tempday = tempday*2;
						}
						jbdays+=tempday;
					}
				}
			}
			System.out.println(begindate+"---"+enddate+":"+jbdays);
			return jbdays;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}