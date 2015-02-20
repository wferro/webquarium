package br.com.kayala.webquarium.core.unitconverter.temperature;

import java.math.BigDecimal;

/**
 * Centimeter unit converter
 *
 * @author kayala
 */
public class CelsiusUnitConverter implements TemperatureUnitConverter {

	@Override
	public BigDecimal convertedValue(BigDecimal rawValue) {
		return rawValue;
	}

	@Override
	public BigDecimal rawValue(BigDecimal convertedValue) {
		return convertedValue;
	}

}
