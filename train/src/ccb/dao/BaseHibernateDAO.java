package ccb.dao;
// default package

import ccb.hibernate.HibernateSessionFactory;
import javax.persistence.Entity;
import org.hibernate.Session;


/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
@Entity
public class BaseHibernateDAO implements IBaseHibernateDAO {
	
	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}
	
}