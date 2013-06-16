package com.tunguski.validator;

import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang.StringUtils;

/**
 * Hibernet Validator for String that contains only ASCII printable characters
 *
 * http://jakarta.apache.org/commons/lang/api/org/apache/commons/lang/StringUtils.html
 *
 * @author marian
 */
public class AsciiPrintableValidator extends ValidatorBase<AsciiPrintable, String> {


	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}

		String ascii = null;

		if (value instanceof String) {
			ascii = value;
		} else {
      return false;
    }

		if (!StringUtils.isAsciiPrintable(ascii)) {
			return false;
		}

		return true;

	}
}
