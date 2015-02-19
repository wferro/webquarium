package br.com.kayala.webquarium.core.calculator.volume;

import java.math.BigDecimal;

/**
 * Fluid ounces unit converter
 *
 * @author kayala
 */
public class FluidOuncesUnitConverter implements VolumeUnitConverter {

	private static final BigDecimal CONVERSION_CONSTANT = BigDecimal.valueOf(33.814D);

	@Override
	public BigDecimal convertedValue(BigDecimal rawValue) {
		return rawValue.multiply(CONVERSION_CONSTANT);
	}

	@Override
	public BigDecimal rawValue(BigDecimal convertedValue) {
		return convertedValue.divide(CONVERSION_CONSTANT);
	}

}
