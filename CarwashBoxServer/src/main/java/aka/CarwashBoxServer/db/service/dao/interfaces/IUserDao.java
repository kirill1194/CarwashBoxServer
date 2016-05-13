package aka.CarwashBoxServer.db.service.dao.interfaces;

import aka.CarwashBoxServer.db.entity.User;
import aka.CarwashBoxServer.db.service.dao.IGenericDao;

public interface IUserDao extends IGenericDao<User, Integer>
{
	public User findByPhone(String phone);
	public User findByAccessToken(String accessToken);
}
