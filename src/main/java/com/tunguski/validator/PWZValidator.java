package com.tunguski.validator;

import javax.validation.ConstraintValidatorContext;


/**
 * Hibernet Validator for PWZ (Prawo Wykonywania Zawodu)
 * http://www.nil.org.pl/rejestry/centralny-rejestr-lekarzy/zasady-weryfikowania-nr-prawa-wykonywania-zawodu
 * @author tunguski <tunguskii@gmail.com>
 */
public class PWZValidator extends ValidatorBase<PWZ, String> {


	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}

		return Validators.isValidPWZ(removeNonDigit(value));
	}
}
