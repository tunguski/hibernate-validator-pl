package pl.matsuo.validator;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Constraint(validatedBy={ISBNValidator.class})
@Target( { METHOD, FIELD })
@Retention(RUNTIME)
@Documented
public @interface ISBN {

	String message() default "invalid ISBN number";
  Class[] groups() default {};
  Class[] payload() default {};
}