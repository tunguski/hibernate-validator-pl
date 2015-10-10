package pl.matsuo.validator;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestISBNValidator extends AbstractValidatorTest {


  @Test
  public void testIsInvalid() throws Exception {
    model.setIsbn("83-01-01373-7d");
    isValid(validator.validateProperty(model, "isbn"),
        "invalid ISBN number");
  }


  @Test
  public void testIsValid() throws Exception {
    model.setIsbn("83-01-01373-7");
    assertTrue(validator.validateProperty(model, "isbn").isEmpty());
  }
}

