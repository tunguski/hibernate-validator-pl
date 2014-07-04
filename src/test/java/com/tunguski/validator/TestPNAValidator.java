package com.tunguski.validator;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestPNAValidator extends AbstractValidatorTest {


  @Test
  public void testIsInvalid() throws Exception {
      model.setPna("43-43-33");
    isValid(validator.validateProperty(model, "pna"),
        "invalid PNA value");
  }


  @Test
  public void testIsValid() throws Exception {
    model.setPna("43-43-3");
    assertTrue(validator.validateProperty(model, "pna").isEmpty());
  }
}

