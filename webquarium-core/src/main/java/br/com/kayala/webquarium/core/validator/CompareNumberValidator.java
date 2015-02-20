package br.com.kayala.webquarium.core.validator;

import br.com.kayala.webquarium.core.validator.annotation.CompareNumber;
import br.com.kayala.webquarium.core.validator.annotation.CompareOperator;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.EnumSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

// TODO: melhorar validador
/**
 * validator to define cross-field number comparison validation
 *
 * @author kayala
 */
public class CompareNumberValidator implements ConstraintValidator<CompareNumber, Object> {

	private String field1;
	private String field2;
	private CompareOperator operator;

	/**
	 *
	 * @param a
	 */
	@Override
	public void initialize(CompareNumber a) {
		this.field1 = a.field1();
		this.field2 = a.field2();
		this.operator = a.operator();
	}

	/**
	 *
	 * @param t
	 * @param cvc
	 * @return
	 */
	@Override
	public boolean isValid(Object t, ConstraintValidatorContext cvc) {
		boolean isValid = false;

		if (t == null) {
			return true;
		}
	
		EnumSet<CompareOperator> negativeResult = EnumSet.of(CompareOperator.LOWER_THAN, CompareOperator.LOWER_THAN_OR_EQUALS);
		EnumSet<CompareOperator> zeroResult = EnumSet.of(CompareOperator.EQUALS, CompareOperator.LOWER_THAN_OR_EQUALS, CompareOperator.GREATER_THAN_OR_EQUALS);
		EnumSet<CompareOperator> positiveResult = EnumSet.of(CompareOperator.GREATER_THAN, CompareOperator.GREATER_THAN_OR_EQUALS);

		try {

			BigDecimal value1 = new BigDecimal(StringUtils.trimToEmpty(BeanUtils.getProperty(t, field1)));
			BigDecimal value2 = new BigDecimal(StringUtils.trimToEmpty(BeanUtils.getProperty(t, field2)));

			if (value1.compareTo(value2) < 0 && negativeResult.contains(operator)) {
				isValid = true;
			} else if (value1.compareTo(value2) == 0 && zeroResult.contains(operator)) {
				isValid = true;
			} else if (value1.compareTo(value2) > 0 && positiveResult.contains(operator)) {
				isValid = true;
			} else {
				isValid = false;
			}

		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
			Logger.getLogger(CompareNumberValidator.class.getName()).log(Level.SEVERE, null, ex);
			throw new RuntimeException(ex.getMessage(), ex);
		}

		return isValid;
	}
}
