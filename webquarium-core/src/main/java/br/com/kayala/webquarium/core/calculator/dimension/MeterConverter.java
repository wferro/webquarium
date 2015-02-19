package br.com.kayala.webquarium.core.calculator.dimension;

import java.math.BigDecimal;

/**
 * Meter unit converter
 *
 * @author kayala
 */
public class MeterConverter implements DimensionUnitConverter {

	private static final BigDecimal CONVERSION_CONSTANT = BigDecimal.valueOf(100D);

	@Override
	public BigDecimal convertedValue(BigDecimal rawValue) {
		return rawValue.divide(CONVERSION_CONSTANT);
	}

	@Override
	public BigDecimal rawValue(BigDecimal convertedValue) {
		return convertedValue.multiply(CONVERSION_CONSTANT);
	}

}
