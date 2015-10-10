package pl.matsuo.validator;

import javax.validation.Constraint;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Constraint(validatedBy={NIPValidator.class})
@Target( { METHOD, FIELD })
@Retention(RUNTIME)
@Documented
@Pattern(regexp = "(([0-9]{10})|([0-9]{3}-[0-9]{3}-[0-9]{2}-[0-9]{2})|([0-9]{3}-[0-9]{2}-[0-9]{2}-[0-9]{3}))?")
public @interface NIP {
	String message() default "invalid NIP value";
  Class[] groups() default {};
  Class[] payload() default {};
}
