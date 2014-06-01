package com.tunguski.validator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.constraints.Pattern;

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
