package br.com.kayala.webquarium.core.unitconverter.volume;

import java.math.BigDecimal;

/**
 * Liter unit converter
 *
 * @author kayala
 */
public class LiterUnitConverter implements VolumeUnitConverter {

	@Override
	public BigDecimal convertedValue(BigDecimal rawValue) {
		return rawValue;
	}

	@Override
	public BigDecimal rawValue(BigDecimal convertedValue) {
		return convertedValue;
	}

}
