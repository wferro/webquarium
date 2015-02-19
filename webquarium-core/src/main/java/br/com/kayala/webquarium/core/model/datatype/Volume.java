package br.com.kayala.webquarium.core.model.datatype;

import br.com.kayala.webquarium.core.unitconverter.volume.CubicCentimeterUnitConverter;
import br.com.kayala.webquarium.core.unitconverter.volume.FluidOuncesUnitConverter;
import br.com.kayala.webquarium.core.unitconverter.volume.GallonUnitConverter;
import br.com.kayala.webquarium.core.unitconverter.volume.LiterUnitConverter;
import br.com.kayala.webquarium.core.unitconverter.volume.MilliliterUnitConverter;
import br.com.kayala.webquarium.core.unitconverter.volume.VolumeUnitConverter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Embeddable;
import javax.validation.constraints.Min;

/**
 * volume measure unit datatype
 *
 * @author kayala
 */
@Embeddable
public class Volume implements Serializable {

	@Min(1)
	private BigDecimal rawValue;

	/**
	 * application base value. in liters
	 *
	 * @return
	 */
	public BigDecimal getRawValue() {
		return rawValue;
	}

	/**
	 *
	 */
	public Volume() {
	}

	/**
	 *
	 * @param rawValue raw value in liters
	 */
	public Volume(BigDecimal rawValue) {
		this.rawValue = rawValue;
	}

	/**
	 *
	 * @param volumeUnit volume unit for converted value
	 * @param convertedValue
	 */
	public Volume(VolumeUnit volumeUnit, BigDecimal convertedValue) {
		this.rawValue = volumeUnit.getCalculator().rawValue(convertedValue);
	}

	/**
	 * get converted value from raw value to the specified unit
	 *
	 * @param volumeUnit target volume unit
	 * @return converted value
	 */
	public BigDecimal getConvertedValue(VolumeUnit volumeUnit) {
		return volumeUnit.getCalculator().convertedValue(rawValue);
	}

	/**
	 * set converted value of a specified unit
	 *
	 * @param volumeUnit target volume unit
	 * @param convertedValue
	 */
	public void setCalculatedValue(VolumeUnit volumeUnit, BigDecimal convertedValue) {
		this.rawValue = volumeUnit.getCalculator().rawValue(convertedValue);
	}

	public enum VolumeUnit {

		FluidOunces(FluidOuncesUnitConverter.class),
		Gallon(GallonUnitConverter.class),
		Liter(LiterUnitConverter.class),
		Milliliter(MilliliterUnitConverter.class),
		CubicCentimeter(CubicCentimeterUnitConverter.class);

		private VolumeUnitConverter volumeCalculator;

		private VolumeUnit(Class volumeCalculator) {
			try {
				this.volumeCalculator = (VolumeUnitConverter) volumeCalculator.newInstance();
			} catch (InstantiationException | IllegalAccessException ex) {
				Logger.getLogger(Volume.class.getName()).log(Level.SEVERE, null, ex);
				this.volumeCalculator = new LiterUnitConverter();
			}
		}

		private VolumeUnitConverter getCalculator() {
			return volumeCalculator;
		}
	}
}
