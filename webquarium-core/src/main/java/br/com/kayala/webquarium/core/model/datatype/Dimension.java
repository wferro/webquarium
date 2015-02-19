package br.com.kayala.webquarium.core.model.datatype;

import br.com.kayala.webquarium.core.calculator.dimension.CentimeterUnitConverter;
import br.com.kayala.webquarium.core.calculator.dimension.DimensionUnitConverter;
import br.com.kayala.webquarium.core.calculator.dimension.FeetUnitConverter;
import br.com.kayala.webquarium.core.calculator.dimension.MeterUnitConverter;
import br.com.kayala.webquarium.core.calculator.dimension.MillimeterUnitConverter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Embeddable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * dimension measure unit datatype
 *
 * @author kayala
 */
@Embeddable
public class Dimension implements Serializable {

	@NotNull
	@Min(1)
	private BigDecimal rawValue;

	/**
	 * application base value. in meters
	 *
	 * @return
	 */
	public BigDecimal getRawValue() {
		return rawValue;
	}

	/**
	 *
	 */
	public Dimension() {

	}

	/**
	 *
	 * @param rawValue raw value in meters
	 */
	public Dimension(BigDecimal rawValue) {
		this.rawValue = rawValue;
	}

	/**
	 *
	 * @param dimensionUnit dimension unit for converted value
	 * @param convertedValue converted value
	 */
	public Dimension(DimensionUnit dimensionUnit, BigDecimal convertedValue) {
		this.rawValue = dimensionUnit.getCalculator().rawValue(convertedValue);
	}

	/**
	 * get converted value from raw value to the specified unit
	 *
	 * @param dimensionUnit target dimension unit
	 * @return converted value
	 */
	public BigDecimal getConvertedValue(DimensionUnit dimensionUnit) {
		return dimensionUnit.getCalculator().convertedValue(rawValue);
	}

	/**
	 * set converted value of a specified unit
	 *
	 * @param dimensionUnit target dimension unit
	 * @param value
	 */
	public void setCalculatedValue(DimensionUnit dimensionUnit, BigDecimal value) {
		this.rawValue = dimensionUnit.getCalculator().rawValue(value);
	}

	public enum DimensionUnit {

		Centimeter(CentimeterUnitConverter.class),
		Feet(FeetUnitConverter.class),
		Meter(MeterUnitConverter.class),
		Millimeter(MillimeterUnitConverter.class);

		private DimensionUnitConverter dimensionCalculator;

		private DimensionUnit(Class dimensionCalculator) {
			try {
				this.dimensionCalculator = (DimensionUnitConverter) dimensionCalculator.newInstance();
			} catch (InstantiationException | IllegalAccessException ex) {
				Logger.getLogger(Dimension.class.getName()).log(Level.SEVERE, null, ex);
				this.dimensionCalculator = new CentimeterUnitConverter();
			}
		}

		private DimensionUnitConverter getCalculator() {
			return dimensionCalculator;
		}
	}
}
