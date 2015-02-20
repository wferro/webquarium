package br.com.kayala.webquarium.core.model.datatype;

import br.com.kayala.webquarium.core.unitconverter.temperature.CelsiusUnitConverter;
import br.com.kayala.webquarium.core.unitconverter.temperature.FahrenheitUnitConverter;
import br.com.kayala.webquarium.core.unitconverter.temperature.TemperatureUnitConverter;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * temperature measure unit datatype
 *
 * @author kayala
 */
public class Temperature implements MeasureUnit {

	private BigDecimal rawValue;

	@Override
	public BigDecimal getRawValue() {
		return rawValue;
	}

	/**
	 *
	 */
	public Temperature() {
	}

	/**
	 *
	 * @param rawValue raw value in celsius
	 */
	public Temperature(BigDecimal rawValue) {
		this.rawValue = rawValue;
	}

	/**
	 *
	 * @param temperatureUnit temperature unit for converted value
	 * @param convertedValue
	 */
	public Temperature(TemperatureUnit temperatureUnit, BigDecimal convertedValue) {
		this.rawValue = temperatureUnit.getCalculator().rawValue(convertedValue);
	}

	/**
	 * get converted value from raw value to the specified unit
	 *
	 * @param temperatureUnit target temperature unit
	 * @return converted value
	 */
	public BigDecimal getConvertedValue(TemperatureUnit temperatureUnit) {
		return temperatureUnit.getCalculator().convertedValue(rawValue);
	}

	/**
	 * set converted value of a specified unit
	 *
	 * @param temperatureUnit target temperature unit
	 * @param convertedValue
	 */
	public void setCalculatedValue(TemperatureUnit temperatureUnit, BigDecimal convertedValue) {
		this.rawValue = temperatureUnit.getCalculator().rawValue(convertedValue);
	}

	@Override
	public String toString() {
		return getRawValue().toPlainString();
	}

	public enum TemperatureUnit {

		Celsius(CelsiusUnitConverter.class),
		Fahrenheit(FahrenheitUnitConverter.class);

		private TemperatureUnitConverter temperatureCalculator;

		private TemperatureUnit(Class temperatureCalculator) {
			try {
				this.temperatureCalculator = (TemperatureUnitConverter) temperatureCalculator.newInstance();
			} catch (InstantiationException | IllegalAccessException ex) {
				Logger.getLogger(Temperature.class.getName()).log(Level.SEVERE, null, ex);
				this.temperatureCalculator = new CelsiusUnitConverter();
			}
		}

		private TemperatureUnitConverter getCalculator() {
			return temperatureCalculator;
		}
	}
}
