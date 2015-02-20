package br.com.kayala.webquarium.core.model.datatype.converter;

import br.com.kayala.webquarium.core.model.datatype.Temperature;
import br.com.kayala.webquarium.core.model.datatype.Volume;
import java.math.BigDecimal;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * jpa temperature datatype attribute converter
 *
 * @author kayala
 */
@Converter(autoApply = true)
public class TemperatureAttributeConverter implements AttributeConverter<Temperature, BigDecimal> {

	@Override
	public BigDecimal convertToDatabaseColumn(Temperature x) {
		if (x == null) {
			return null;
		} else {
			return x.getRawValue();
		}
	}

	@Override
	public Temperature convertToEntityAttribute(BigDecimal y) {
		if (y == null) {
			return null;
		} else {
			return new Temperature(y);
		}
	}

}
