package pl.matsuo.validator;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestPWZValidator extends AbstractValidatorTest {


  @Test
  public void testIsInvalid() throws Exception {
    model.setPwz("54257411");
    isValid(validator.validateProperty(model, "pwz"),
        "invalid PWZ value",
        "must match \"[1-9][0-9]{6}\"");

    model.setPwz("5425741");
    isValid(validator.validateProperty(model, "pwz"),
        "invalid PWZ value");
  }


  @Test
  public void testIsValid() throws Exception {
    model.setPwz("5425740");
    assertTrue(validator.validateProperty(model, "pwz").isEmpty());
  }
}

