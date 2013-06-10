package com.tunguski.validator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;


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
