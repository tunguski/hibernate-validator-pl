package com.tunguski.validator;

import javax.validation.Constraint;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Constraint(validatedBy={PESELValidator.class})
@Target( { METHOD, FIELD })
@Retention(RUNTIME)
@Documented
@Pattern(regexp = "[0-9]{11}")
public @interface PESEL {
	String message() default "invalid PESEL value";
  Class[] groups() default {};
  Class[] payload() default {};
}
