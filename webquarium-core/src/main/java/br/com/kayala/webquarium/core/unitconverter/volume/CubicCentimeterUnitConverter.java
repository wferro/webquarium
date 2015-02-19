package br.com.kayala.webquarium.core.unitconverter.volume;

import java.math.BigDecimal;

/**
 * Cubic centimeter unit converter
 *
 * @author kayala
 */
public class CubicCentimeterUnitConverter implements VolumeUnitConverter {

	private static final BigDecimal CONVERSION_CONSTANT = BigDecimal.valueOf(1000D);

	@Override
	public BigDecimal convertedValue(BigDecimal rawValue) {
		return rawValue.multiply(CONVERSION_CONSTANT);
	}

	@Override
	public BigDecimal rawValue(BigDecimal convertedValue) {
		return convertedValue.divide(CONVERSION_CONSTANT);
	}

}
