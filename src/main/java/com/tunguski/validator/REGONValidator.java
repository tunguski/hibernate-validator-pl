package com.tunguski.validator;

import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang.StringUtils;


/**
 * Hibernet Validator for REGON (Rejestr Gospodarki Narodowej)
 *
 * http://pl.wikipedia.org/wiki/REGON
 *
 * @author marian <mariuszs@gmail.com>
 * @author tunguski <tunguskii@gmail.com>
 */
public class REGONValidator extends ValidatorBase<REGON, String> {


	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}

		String regon = null;

		if (annotation.digitsOnly()) {
			regon = value;
			if (!StringUtils.isNumeric(regon)) {
				return false;
			}

		} else {
			regon = removeNonDigit(value);
		}

		return Validators.isValidREGON(regon);
	}
}
