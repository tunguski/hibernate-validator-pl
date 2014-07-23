package com.tunguski.validator;

import org.junit.BeforeClass;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public abstract class AbstractValidatorTest {


  protected static Validator validator;
  protected ValidationTestModel model = new ValidationTestModel();


  @BeforeClass
  public static void setup() {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }


  protected void isValid(Set<ConstraintViolation<ValidationTestModel>> violations, String ... messages) throws Exception {
    assertTrue(violations.size() == messages.length);
    Set<String> errors = new HashSet<>();
    for (ConstraintViolation<ValidationTestModel> violation : violations) {
      errors.add(violation.getMessage());
    }

    for (String message : messages) {
      assertTrue("Message not found '" + message + "'", errors.contains(message));
    }
  }
}

