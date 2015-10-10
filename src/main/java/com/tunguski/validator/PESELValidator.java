package pl.matsuo.validator;

import javax.validation.ConstraintValidatorContext;


/**
 * Hibernet Validator for PESEL (Powszechny Elektroniczny System Ewidencji
 * Ludnosci)
 *
 * http://pl.wikipedia.org/wiki/PESEL
 *
 * @author marian
 * @author tunguski <tunguskii@gmail.com>
 */
public class PESELValidator extends ValidatorBase<PESEL, String> {


	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value == null || Validators.isValidPESEL(removeNonDigit(value));
	}
}
