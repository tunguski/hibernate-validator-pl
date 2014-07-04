package com.tunguski.validator;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestNIPValidator extends AbstractValidatorTest {


  @Test
  public void testIsInvalid() throws Exception {
    model.setNip("3835720417");
    isValid(validator.validateProperty(model, "nip"),
        "invalid NIP value");

    model.setNip("38357204171");
    isValid(validator.validateProperty(model, "nip"),
        "invalid NIP value",
        "must match \"(([0-9]{10})|([0-9]{3}-[0-9]{3}-[0-9]{2}-[0-9]{2})|([0-9]{3}-[0-9]{2}-[0-9]{2}-[0-9]{3}))?\"");
  }


  @Test
  public void testIsValid() throws Exception {
    model.setNip("3835720416");
    assertTrue(validator.validateProperty(model, "nip").isEmpty());
  }
}

