package aka.CarwashBoxServer.service;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import aka.CarwashBoxServer.db.entity.User;
import aka.CarwashBoxServer.db.service.dao.interfaces.IUserDao;
import aka.CarwashBoxServer.rest.response.TokenResponse;
import aka.CarwashBoxServer.service.Utile.PasswordSecurity;

public class SigninService
{

	@Autowired
	@Qualifier("userDao")
	public IUserDao userDao;
	public TokenResponse signin(String pass, String phone)
	{
		User user = userDao.findByPhone(phone);
		if (user == null)
			throw new ClientErrorException("Пользователь с таким телефоном не найден", Status.FORBIDDEN);
		String encryptedPass = PasswordSecurity.encryptPass(pass);
		if (!encryptedPass.equals(user.getPass()))
			throw new ClientErrorException("Неверный пароль", Status.FORBIDDEN);
		String newAccessToken = PasswordSecurity.buildAccessToken(phone, pass);
		user.setAccessToken(newAccessToken);
		userDao.update(user);
		return new TokenResponse(newAccessToken);
	}
}
