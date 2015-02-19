package br.com.kayala.webquarium.core.model.datatype.converter;

import br.com.kayala.webquarium.core.model.datatype.Volume;
import java.math.BigDecimal;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * jpa volume datatype attribute converter
 *
 * @author kayala
 */
@Converter(autoApply = true)
public class VolumeAttributeConverter implements AttributeConverter<Volume, BigDecimal> {

	@Override
	public BigDecimal convertToDatabaseColumn(Volume x) {
		if (x == null) {
			return null;
		} else {
			return x.getRawValue();
		}
	}

	@Override
	public Volume convertToEntityAttribute(BigDecimal y) {
		if (y == null) {
			return null;
		} else {
			return new Volume(y);
		}
	}

}
