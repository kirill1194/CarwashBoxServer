package aka.CarwashBoxServer.db.exceptions;

import org.hibernate.exception.ConstraintViolationException;

public class NotUniqueException extends RuntimeException
{
	public NotUniqueException(ConstraintViolationException e)
	{
		super(e);
	}
}
