package br.com.kayala.webquarium.core.unitconverter.dimension;

import java.math.BigDecimal;

/**
 * Millimeter unit converter
 * @author kayala
 */
public class MillimeterUnitConverter implements DimensionUnitConverter {

	private static final BigDecimal CONVERSION_CONSTANT = BigDecimal.valueOf(10D);

	@Override
	public BigDecimal convertedValue(BigDecimal rawValue) {
		return rawValue.multiply(CONVERSION_CONSTANT);
	}

	@Override
	public BigDecimal rawValue(BigDecimal convertedValue) {
		return convertedValue.divide(CONVERSION_CONSTANT);
	}

}
