package br.com.kayala.webquarium.core.model.datatype.converter;

import br.com.kayala.webquarium.core.model.datatype.TankPosition;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.apache.commons.lang3.StringUtils;

/**
 * tank position enum jpa data type converter
 *
 * @author kayala
 */
@Converter(autoApply = true)
public class TankPositionConverter implements AttributeConverter<TankPosition, String> {

	@Override
	public String convertToDatabaseColumn(TankPosition x) {
		if (x == null) {
			return null;
		} else {
			return x.getDatabaseFlag();
		}
	}

	@Override
	public TankPosition convertToEntityAttribute(String y) {
		if (StringUtils.trimToNull(y) == null) {
			return null;
		} else {
			return TankPosition.getEnumByFlag(y);
		}
	}

}
