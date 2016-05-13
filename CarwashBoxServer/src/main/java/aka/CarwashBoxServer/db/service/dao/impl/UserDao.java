package aka.CarwashBoxServer.db.service.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import aka.CarwashBoxServer.db.entity.User;
import aka.CarwashBoxServer.db.service.dao.GenericDao;
import aka.CarwashBoxServer.db.service.dao.interfaces.IUserDao;

public class UserDao extends GenericDao<User, Integer> implements IUserDao
{

	public UserDao( )
	{
		super(User.class);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public User findByPhone(String phone)
	{
		Session session = getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("phone", phone));
		Object o = criteria.uniqueResult();
		trans.commit();
		if (o == null)
			return null;
		else
			return (User) o;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public User findByAccessToken(String accessToken)
	{
		Session session = getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("accessToken", accessToken));
		Object o = criteria.uniqueResult();
		trans.commit();
		if (o == null)
			return null;
		else
			return (User) o;
	}
}
