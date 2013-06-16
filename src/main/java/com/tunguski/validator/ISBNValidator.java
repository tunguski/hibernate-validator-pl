package com.tunguski.validator;

import javax.validation.ConstraintValidatorContext;


/**
 * Hibernet Validator for ISBN
 *
 * @author marian
 */
public class ISBNValidator extends ValidatorBase<ISBN, String> {

	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}

		String alpha = null;

		if (value instanceof String) {
			alpha = value;
			ISBNValidatorImpl val = new ISBNValidatorImpl();

			if (val.isValid(alpha)) {
				return true;
			}
		}
		return false;
	}

}
