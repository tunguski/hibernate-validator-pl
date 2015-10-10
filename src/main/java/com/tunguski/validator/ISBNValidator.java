package pl.matsuo.validator;

import javax.validation.ConstraintValidatorContext;


/**
 * Hibernet Validator for ISBN
 *
 * @author marian
 */
public class ISBNValidator extends ValidatorBase<ISBN, String> {

	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value == null || new ISBNValidatorImpl().isValid(value);
	}

}
