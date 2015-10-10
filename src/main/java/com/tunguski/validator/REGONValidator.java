package pl.matsuo.validator;

import javax.validation.ConstraintValidatorContext;

import static pl.matsuo.validator.Validators.*;
import static org.apache.commons.lang.StringUtils.*;


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
    return value == null || (annotation.digitsOnly() && !isNumeric(value)) || isValidREGON(removeNonDigit(value));
	}
}
