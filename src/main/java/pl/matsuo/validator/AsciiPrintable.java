package pl.matsuo.validator;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Constraint(validatedBy={AsciiPrintableValidator.class})
@Target( { METHOD, FIELD })
@Retention(RUNTIME)
@Documented
public @interface AsciiPrintable {

	String message() default "invalid unicode letters";
  Class[] groups() default {};
  Class[] payload() default {};
}
