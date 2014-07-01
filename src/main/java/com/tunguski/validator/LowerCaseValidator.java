package com.tunguski.validator;

import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidatorContext;

/**
 * Hibernet Validator for String that contains only lower case letters.
 *
 * http://jakarta.apache.org/commons/lang/api/org/apache/commons/lang/StringUtils.html
 *
 * @author marian
 */
public class LowerCaseValidator extends ValidatorBase<LowerCase, String> {


	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}

		if (!(value instanceof String)) {
			return false;
		}

		String alpha = value;

		if (!alpha.equals(StringUtils.lowerCase(alpha))) {
			return false;
		}

		return true;

	}
}
