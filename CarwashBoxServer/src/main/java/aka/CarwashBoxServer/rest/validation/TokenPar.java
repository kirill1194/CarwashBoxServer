package aka.CarwashBoxServer.rest.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import aka.CarwashBoxServer.rest.validation.validators.TokenParValidator;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {TokenParValidator.class})
public @interface TokenPar
{
	String label() default "token";
	String message() default "Invalid value";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
