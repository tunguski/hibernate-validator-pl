package com.tunguski.validator;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestAsciiPrintableValidator extends AbstractValidatorTest {


  @Test
  public void testIsInvalid() throws Exception {
    model.setAsciiPrintable("Ceki G\\u00fclc\\u00fc" + ((char) 222));
    isValid(validator.validateProperty(model, "asciiPrintable"),
        "invalid unicode letters");
  }


  @Test
  public void testIsValid() throws Exception {
    model.setAsciiPrintable("43 ! fdasf da 43243");
    assertTrue(validator.validateProperty(model, "asciiPrintable").isEmpty());
  }
}

