package pl.matsuo.validator;

import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidatorContext;

/**
 * Hibernet Validator for String that contains only ASCII printable characters
 *
 * http://jakarta.apache.org/commons/lang/api/org/apache/commons/lang/StringUtils.html
 *
 * @author marian
 */
public class AsciiPrintableValidator extends ValidatorBase<AsciiPrintable, String> {


	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value == null || StringUtils.isAsciiPrintable(value);
	}
}
