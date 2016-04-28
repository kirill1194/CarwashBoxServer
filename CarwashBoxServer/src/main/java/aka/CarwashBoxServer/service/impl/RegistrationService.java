package aka.CarwashBoxServer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import aka.CarwashBoxServer.db.entity.User;
import aka.CarwashBoxServer.db.service.dao.interfaces.IUserDao;
import aka.CarwashBoxServer.rest.exceptions.RegistrationException;
import aka.CarwashBoxServer.rest.response.Token;
import aka.CarwashBoxServer.service.Utile.PasswordSecurity;
import aka.CarwashBoxServer.service.interfaces.IRegistrationService;

@Controller
public class RegistrationService implements IRegistrationService
{
	@Autowired
	public IUserDao userDao;

	//	@Transactional
	@Override
	public Token registrate(String phone, String pass) throws RegistrationException
	{
		System.out.println(userDao == null);
		User user = userDao.findByPhone(phone);
		if (user != null)
			throw new RuntimeException();
		user = new User();
		user.setPhone(phone);
		user.setPass(PasswordSecurity.encryptPass(pass));
		String accessToken = PasswordSecurity.buildAccessToken(phone, pass);
		user.setAccessToken(accessToken);
		userDao.save(user);
		return new Token(accessToken);
	}
}
