package com.tunguski.validator;

import javax.validation.Constraint;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Constraint(validatedBy={REGONValidator.class})
@Target( { METHOD, FIELD })
@Retention(RUNTIME)
@Documented
@Pattern(regexp = "[0-9]{9}|[0-9]{14}")
public @interface REGON {

	boolean digitsOnly() default false;

	String message() default "invalid regon value";
  Class[] groups() default {};
  Class[] payload() default {};
}
