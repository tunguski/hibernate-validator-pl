package com.tunguski.validator;

import java.lang.annotation.Annotation;

import javax.validation.ConstraintValidator;


public abstract class ValidatorBase<A extends Annotation, B> implements ConstraintValidator<A, B> {


  protected A annotation;


  public void initialize(A configuration) {
    annotation = configuration;
  }


  protected String removeNonDigit(String input) {
		return input.replaceAll("\\D*", "");
	}
}

