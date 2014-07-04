package com.tunguski.validator;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestLowerCaseValidator extends AbstractValidatorTest {


  @Test
  public void testIsInvalid() throws Exception {
    model.setLowerCase("fdsdRe");
    isValid(validator.validateProperty(model, "lowerCase"),
        "upper case letters exist");
  }


  @Test
  public void testIsValid() throws Exception {
    model.setLowerCase("fdsf");
    assertTrue(validator.validateProperty(model, "lowerCase").isEmpty());
  }
}

