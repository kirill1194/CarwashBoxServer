package aka.CarwashBoxServer.rest.validation.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import aka.CarwashBoxServer.rest.validation.NotNullEmptyPar;

public class NotNullEmptyParValidator  implements ConstraintValidator<NotNullEmptyPar, String>
{

	@Override
	public void initialize(NotNullEmptyPar arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(String str, ConstraintValidatorContext context)
	{
		if (str == null)
		{
			context.disableDefaultConstraintViolation();
			context
			.buildConstraintViolationWithTemplate("Don't contains parameter \"{label}\"")
			.addConstraintViolation();
			return false;
		}

		if (str.length() == 0)
		{
			context.disableDefaultConstraintViolation();
			context
			.buildConstraintViolationWithTemplate("Parameter \"{label}\" is empty")
			.addConstraintViolation();
			return false;
		}
		return true;
	}

}
