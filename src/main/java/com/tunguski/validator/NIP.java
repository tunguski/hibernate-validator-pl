package com.tunguski.validator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Constraint(validatedBy={NIPValidator.class})
@Target( { METHOD, FIELD })
@Retention(RUNTIME)
@Documented
public @interface NIP {
	String message() default "invalid NIP value";
  Class[] groups() default {};
  Class[] payload() default {};
}
