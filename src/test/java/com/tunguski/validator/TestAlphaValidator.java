package com.tunguski.validator;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestAlphaValidator extends AbstractValidatorTest {


  @Test
  public void testIsInvalid() throws Exception {
    model.setAlpha("f!da");
    isValid(validator.validateProperty(model, "alpha"),
        "invalid unicode letters");
  }


  @Test
  public void testIsValid() throws Exception {
    model.setAlpha("fdasfda");
    assertTrue(validator.validateProperty(model, "alpha").isEmpty());
  }
}

