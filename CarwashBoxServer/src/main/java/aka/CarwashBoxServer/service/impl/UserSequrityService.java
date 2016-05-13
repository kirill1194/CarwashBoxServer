package aka.CarwashBoxServer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import aka.CarwashBoxServer.db.entity.User;
import aka.CarwashBoxServer.db.service.dao.interfaces.IUserDao;
import aka.CarwashBoxServer.rest.exceptions.ClientError;
import aka.CarwashBoxServer.rest.exceptions.Errors;
import aka.CarwashBoxServer.rest.exceptions.RegistrationException;
import aka.CarwashBoxServer.rest.response.TokenResponse;
import aka.CarwashBoxServer.service.Utile.PasswordSecurity;
import aka.CarwashBoxServer.service.interfaces.IUserSecurityService;

@Service
public class UserSequrityService implements IUserSecurityService
{
	@Autowired
	public IUserDao userDao;

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public TokenResponse registrate(String phone, String pass) throws RegistrationException
	{
		User user = userDao.findByPhone(phone);
		if (user != null)
			throw new ClientError(Errors.PHONE_ALREADY_EXIST);
		user = new User();
		user.setPhone(phone);
		user.setPass(PasswordSecurity.encryptPass(pass));
		String accessToken = PasswordSecurity.buildAccessToken(phone, pass);
		user.setAccessToken(accessToken);
		userDao.save(user);
		return new TokenResponse(accessToken);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public TokenResponse signin(String phone, String pass)
	{
		User user = userDao.findByPhone(phone);
		if (user == null)
			throw new ClientError(Errors.PHONE_NOT_EXIST);
		String encryptPass = PasswordSecurity.encryptPass(pass);
		if (encryptPass.equals(user.getPass()))
		{
			String accessToken = user.getAccessToken();
			return new TokenResponse(accessToken);
		}
		else
			throw new ClientError(Errors.PHONE_OR_PASS_IS_INCARRACT);

	}
}
