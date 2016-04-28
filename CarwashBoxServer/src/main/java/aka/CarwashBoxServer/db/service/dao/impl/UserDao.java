package aka.CarwashBoxServer.db.service.dao.impl;

import org.hibernate.SessionFactory;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.googlecode.genericdao.search.Search;

import aka.CarwashBoxServer.db.entity.User;
import aka.CarwashBoxServer.db.service.dao.interfaces.IUserDao;


public class UserDao extends GenericDAOImpl<User, Integer> implements IUserDao
{
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public User findByPhone(String phone)
	{
		Search search = new Search();
		search.addFilterEqual("phone", phone);
		return searchUnique(search);
	}
}
