package br.com.kayala.webquarium.core.calculator.dimension;

import java.math.BigDecimal;

/**
 * Centimeter unit converter
 *
 * @author kayala
 */
public class CentimeterUnitConverter implements DimensionUnitConverter {

	@Override
	public BigDecimal convertedValue(BigDecimal rawValue) {
		return rawValue;
	}

	@Override
	public BigDecimal rawValue(BigDecimal convertedValue) {
		return convertedValue;
	}

}
