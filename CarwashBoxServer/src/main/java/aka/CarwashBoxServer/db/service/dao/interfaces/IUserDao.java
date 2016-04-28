package aka.CarwashBoxServer.db.service.dao.interfaces;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

import aka.CarwashBoxServer.db.entity.User;

public interface IUserDao extends GenericDAO<User, Integer> {
	public User findByPhone(String phone);
}