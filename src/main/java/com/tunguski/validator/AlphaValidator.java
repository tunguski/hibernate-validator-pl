package com.tunguski.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * User: <a href="http://javaunderhood.wordpress.com">Maciej Kreft</a><br/>
 * By default allows only Alpha[a-zA-Z] and null, with additional configuration allows digits[0-9]
 * and/or spaces [ \t\n\x0B\f\r]
 */
public class AlphaValidator implements ConstraintValidator<Alpha, String> {

  private boolean allowNumeric;
  private boolean allowSpace;
  private static final String onlyUnicodeLetters = "[\\p{L}]*";
  private static final String unicodeLettersWithDigits = "[\\p{L}\\p{N}]*";
  private static final String unicodeLettersWithDigitsAndWhiteSpaces = "[\\p{L}\\p{N}\\p{Z}]*";
  private static final String unicodeLettersWithSpaces = "[\\p{L}\\p{Z}]*";

  public void initialize(Alpha configuration) {
    allowNumeric = configuration.allowNumeric();
    allowSpace = configuration.allowSpace();
  }

  public boolean isValid(String v, ConstraintValidatorContext context) {
    if (v == null) {
      return true;
    }

    if (!allowNumeric && !allowSpace) {
      return v.matches(onlyUnicodeLetters);
    } else if (allowNumeric && !allowSpace) {
      return v.matches(unicodeLettersWithDigits);
    } else if (allowNumeric && allowSpace) {
      return v.matches(unicodeLettersWithDigitsAndWhiteSpaces);
    } else {
      return v.matches(unicodeLettersWithSpaces);
    }
  }
}
