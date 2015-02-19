package br.com.kayala.webquarium.core.calculator.volume;

import java.math.BigDecimal;

/**
 * Gallon unit converter
 *
 * @author kayala
 */
public class GallonUnitConverter implements VolumeCalculator {

	private static final BigDecimal CONVERSION_CONSTANT = BigDecimal.valueOf(0.26417D);

	@Override
	public BigDecimal convertedValue(BigDecimal rawValue) {
		return rawValue.multiply(CONVERSION_CONSTANT);
	}

	@Override
	public BigDecimal rawValue(BigDecimal convertedValue) {
		return convertedValue.divide(CONVERSION_CONSTANT);
	}

}
