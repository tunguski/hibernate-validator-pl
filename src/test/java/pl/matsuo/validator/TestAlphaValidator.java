package pl.matsuo.validator;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestAlphaValidator extends AbstractValidatorTest {


  @Test
  public void testIsValidWhenEmpty() throws Exception {
    model.setAlpha(null);
    assertTrue(validator.validateProperty(model, "alpha").isEmpty());
  }


  @Test
  public void testIsValid() throws Exception {
    model.setAlpha("fdasfda");
    assertTrue(validator.validateProperty(model, "alpha").isEmpty());
  }


  @Test
  public void testIsInvalid_withExclamationMark() throws Exception {
    model.setAlpha("f!da");
    isValid(validator.validateProperty(model, "alpha"), "invalid unicode letters");
  }


  @Test
  public void testIsInvalid_withNumber() throws Exception {
    model.setAlpha("f432da");
    isValid(validator.validateProperty(model, "alpha"), "invalid unicode letters");
  }


  @Test
  public void testIsValid_allowNumber_withNumber() throws Exception {
    model.setAlpha1("ffdadsą432432źłóŚĆŻ");
    isValid(validator.validateProperty(model, "alpha1"));
  }


  @Test
  public void testIsValid_allowSpace_withSpace() throws Exception {
    model.setAlpha2("ffdads ąźłóŚĆŻ");
    isValid(validator.validateProperty(model, "alpha2"));
  }


  @Test
  public void testIsValid_allowSpaceAndNumeric_withSpaceAndNumeric() throws Exception {
    model.setAlpha3("ffdads ąźłóŚĆŻ 432432");
    isValid(validator.validateProperty(model, "alpha3"));
  }
}

