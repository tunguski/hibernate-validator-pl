package com.tunguski.validator;

import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang.StringUtils;

/**
 * Hibernet Validator for String that contains only lower case letters.
 *
 * http://jakarta.apache.org/commons/lang/api/org/apache/commons/lang/StringUtils.html
 *
 * @author marian
 */
public class LowerCaseValidator extends ValidatorBase<LowerCase> {


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
