package com.tunguski.validator;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.validation.Errors;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.ValidationUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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

