package br.com.kayala.webquarium.core.unitconverter.temperature;

import java.math.BigDecimal;

/**
 * Centimeter unit converter
 *
 * @author kayala
 */
public class FahrenheitUnitConverter implements TemperatureUnitConverter {

	@Override
	public BigDecimal convertedValue(BigDecimal rawValue) {
		// C  x  9/5 + 32 = F
		return rawValue
				.multiply(BigDecimal.valueOf(9))
				.divide(BigDecimal.valueOf(5))
				.add(BigDecimal.valueOf(32));
	}

	@Override
	public BigDecimal rawValue(BigDecimal convertedValue) {
		// (F  -  32)  x  5/9 = C
		return convertedValue
				.subtract(BigDecimal.valueOf(32))
				.multiply(BigDecimal.valueOf(5))
				.divide(BigDecimal.valueOf(9));
	}

}
