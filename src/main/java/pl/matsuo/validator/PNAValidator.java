package pl.matsuo.validator;

import javax.validation.ConstraintValidatorContext;


/**
 * Hibernet Validator for Pocztowe Numery Adresowe - PNA
 *
 * http://pl.wikipedia.org/wiki/Kod_pocztowy
 *
 * @author marian
 * @author tunguski <tunguskii@gmail.com>
 */
public class PNAValidator extends ValidatorBase<PNA, String> {


	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value == null || removeNonDigit(value).length() == 5;

	}

}
