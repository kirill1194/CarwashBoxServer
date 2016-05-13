package aka.CarwashBoxServer.rest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aka.CarwashBoxServer.db.service.dao.interfaces.IUserDao;

@Service
public class TokenValidator
{
	@Autowired
	public IUserDao userDao;

	public User validate(String token) throws AutorizationException
	{
		aka.CarwashBoxServer.db.entity.User dbUser = userDao.findByAccessToken(token);
		if (dbUser == null)
			throw new AutorizationException("un autorication");
		User user = new User();
		user.setId(dbUser.getId());
		user.setPass(dbUser.getPass());
		user.setPhone(dbUser.getPhone());

		return user;
	}
}
