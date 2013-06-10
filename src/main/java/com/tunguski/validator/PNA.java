package com.tunguski.validator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Constraint(validatedBy={PNAValidator.class})
@Target( { METHOD, FIELD })
@Retention(RUNTIME)
@Documented
public @interface PNA {
	String message() default "invalid PNA value";
  Class[] groups() default {};
  Class[] payload() default {};
}
