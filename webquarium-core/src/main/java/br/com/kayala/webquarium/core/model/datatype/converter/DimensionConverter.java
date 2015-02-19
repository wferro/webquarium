package br.com.kayala.webquarium.core.model.datatype.converter;

import br.com.kayala.webquarium.core.model.datatype.Dimension;
import java.math.BigDecimal;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * jpa dimension datatype converter
 *
 * @author kayala
 */
@Converter(autoApply = true)
public class DimensionConverter implements AttributeConverter<Dimension, BigDecimal> {

	@Override
	public BigDecimal convertToDatabaseColumn(Dimension x) {
		if (x == null) {
			return null;
		} else {
			return x.getRawValue();
		}
	}

	@Override
	public Dimension convertToEntityAttribute(BigDecimal y) {
		if (y == null) {
			return null;
		} else {
			return new Dimension(y);
		}
	}

}
