package pl.matsuo.validator;

import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidatorContext;

/**
 * Hibernet Validator for String that contains only lower case letters.
 *
 * http://jakarta.apache.org/commons/lang/api/org/apache/commons/lang/StringUtils.html
 *
 * @author marian
 */
public class LowerCaseValidator extends ValidatorBase<LowerCase, String> {


	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value == null || value.equals(StringUtils.lowerCase(value));
	}
}
