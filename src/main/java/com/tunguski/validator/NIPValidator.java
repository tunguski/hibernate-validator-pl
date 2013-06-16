package com.tunguski.validator;

import javax.validation.ConstraintValidatorContext;


/**
 * Hibernete Validator for NIP (Numer Identyfikacji Podatkowej)
 *
 * http://pl.wikipedia.org/wiki/NIP
 *
 * @author marian
 * @version 0.3
 */
public class NIPValidator extends ValidatorBase<NIP, String> {

	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}

		return Validators.isValidNIP(removeNonDigit(value));
	}
}
