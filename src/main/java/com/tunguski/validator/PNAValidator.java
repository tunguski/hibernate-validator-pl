package com.tunguski.validator;

import javax.validation.ConstraintValidatorContext;


/**
 * Hibernet Validator for Pocztowe Numery Adresowe - PNA
 *
 * http://pl.wikipedia.org/wiki/Kod_pocztowy
 *
 * @author marian
 * @version 0.3
 */
public class PNAValidator extends ValidatorBase<PNA> {


	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}

		if (removeNonDigit(value).length() != 5) {
			return false;
		}

		return true;

	}

}
