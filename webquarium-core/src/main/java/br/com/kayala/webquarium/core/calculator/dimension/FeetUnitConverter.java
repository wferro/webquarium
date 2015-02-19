package br.com.kayala.webquarium.core.calculator.dimension;

import java.math.BigDecimal;

/**
 * Feet unit converter
 *
 * @author kayala
 */
public class FeetUnitConverter implements DimensionUnitConverter {

	private static final BigDecimal CONVERSION_CONSTANT = BigDecimal.valueOf(2.54D);

	@Override
	public BigDecimal convertedValue(BigDecimal rawValue) {
		return rawValue.divide(CONVERSION_CONSTANT);
	}

	@Override
	public BigDecimal rawValue(BigDecimal convertedValue) {
		return convertedValue.multiply(CONVERSION_CONSTANT);
	}

}
