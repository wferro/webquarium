package br.com.kayala.webquarium.core.calculator;

import java.math.BigDecimal;

/**
 * Unit conversion calculator interface
 *
 * @author kayala
 */
public interface UnitConverter {

	/**
	 * Converted from application raw value (liters) to desired unit
	 *
	 * @param rawValue raw value in liters
	 * @return calculated unit value
	 */
	public BigDecimal convertedValue(BigDecimal rawValue);

	/**
	 * Calculate from unit to application raw value (liters)
	 *
	 * @param convertedValue calculated value to convert to raw
	 * @return raw value in liters
	 */
	public BigDecimal rawValue(BigDecimal convertedValue);

}
