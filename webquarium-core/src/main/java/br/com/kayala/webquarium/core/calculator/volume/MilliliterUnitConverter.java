package br.com.kayala.webquarium.core.calculator.volume;

import java.math.BigDecimal;

/**
 * Milliliter unit converter
 *
 * @author kayala
 */
public class MilliliterUnitConverter implements VolumeUnitConverter {

	private static final BigDecimal CONVERSION_CONSTANT = BigDecimal.valueOf(0.001D);

	@Override
	public BigDecimal convertedValue(BigDecimal rawValue) {
		return rawValue.divide(CONVERSION_CONSTANT);
	}

	@Override
	public BigDecimal rawValue(BigDecimal convertedValue) {
		return convertedValue.multiply(CONVERSION_CONSTANT);
	}

}
