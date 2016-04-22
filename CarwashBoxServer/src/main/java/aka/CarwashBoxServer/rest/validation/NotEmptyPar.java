package aka.CarwashBoxServer.rest.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

import org.hibernate.validator.constraints.NotEmpty;

@Documented
@Constraint(validatedBy = {})
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@NotEmpty
@ReportAsSingleViolation
public @interface NotEmptyPar {
	public abstract String label();
	public abstract Class<?>[] groups() default {};
	public abstract String message() default "{NotEmptyPar.message}";
	public abstract Class<? extends Payload>[] payload() default {};
}