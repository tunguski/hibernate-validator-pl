package com.tunguski.validator;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestREGONValidator extends AbstractValidatorTest {


  @Test
  public void testIsInvalid() throws Exception {
    model.setRegon("732065813");
    isValid(validator.validateProperty(model, "regon"),
        "invalid regon value");

    model.setRegon("73206581411");
    isValid(validator.validateProperty(model, "regon"),
        "invalid regon value",
        "must match \"[0-9]{9}|[0-9]{14}\"");
  }


  @Test
  public void testIsValid() throws Exception {
    model.setRegon("732065814");
    assertTrue(validator.validateProperty(model, "regon").isEmpty());
    model.setRegon("23511332857188");
    assertTrue(validator.validateProperty(model, "regon").isEmpty());
  }
}

