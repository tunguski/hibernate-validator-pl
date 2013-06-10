package com.tunguski.validator;

import javax.validation.ConstraintValidatorContext;


/**
 * Hibernet Validator for PESEL (Powszechny Elektroniczny System Ewidencji
 * Ludnosci)
 *
 * http://pl.wikipedia.org/wiki/PESEL
 *
 * @author marian
 * @version 0.3
 */
public class PESELValidator extends ValidatorBase<PESEL> {


	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}

		return Validators.isValidPESEL(removeNonDigit(value));
	}
}
