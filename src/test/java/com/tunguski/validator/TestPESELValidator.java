package com.tunguski.validator;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestPESELValidator extends AbstractValidatorTest {


  @Test
  public void testIsInvalid() throws Exception {
    model.setPesel("fdsd");
    isValid(validator.validateProperty(model, "pesel"),
        "invalid PESEL value",
        "must match \"[0-9]{11}\"");
  }


  @Test
  public void testIsValid() throws Exception {
    model.setPesel("90103105720");
    assertTrue(validator.validateProperty(model, "pesel").isEmpty());
  }
}

