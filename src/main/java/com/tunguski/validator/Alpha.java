package pl.matsuo.validator;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;


@Constraint(validatedBy={AlphaValidator.class})
@Target( { METHOD, FIELD })
@Retention(RUNTIME)
@Documented
public @interface Alpha {

	boolean allowNumeric() default false;

	boolean allowSpace() default false;

	String message() default "invalid unicode letters";
  Class[] groups() default {};
  Class[] payload() default {};
}
