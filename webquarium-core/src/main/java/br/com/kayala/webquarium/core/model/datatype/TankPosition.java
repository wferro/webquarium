package br.com.kayala.webquarium.core.model.datatype;

import java.util.HashMap;
import java.util.Map;

/**
 * Fauna spicies tank position enum
 *
 * @author kayala
 */
public enum TankPosition {

	AllTank("AT", "enum.tankposition.alltank"),
	Top("T", "enum.tankposition.top"),
	TopMiddle("TM", "enum.tankposition.topmiddle"),
	Middle("M", "enum.tankposition.middle"),
	BottomMiddle("BM", "enum.tankposition.bottommiddle"),
	Bottom("B", "enum.tankposition.bottom"),
	Unknown("U", "enum.tankposition.unkown");

	private String databaseFlag;

	private String descriptionBundleKey;

	private static final Map<String, TankPosition> map;

	static {
		map = new HashMap<>();
		for (TankPosition v : TankPosition.values()) {
			map.put(v.databaseFlag, v);
		}
	}

	private TankPosition(String databaseFlag, String descriptionKey) {
		this.databaseFlag = databaseFlag;
		this.descriptionBundleKey = descriptionKey;
	}

	/**
	 * get database stored flag
	 *
	 * @return database stored flag
	 */
	public String getDatabaseFlag() {
		return databaseFlag;
	}

	/**
	 * set database stored flag
	 *
	 * @param databaseFlag database stored flag
	 */
	public void setDatabaseFlag(String databaseFlag) {
		this.databaseFlag = databaseFlag;
	}

	/**
	 * get description bundle key
	 *
	 * @return bundle key
	 */
	public String getDescriptionBundleKey() {
		return descriptionBundleKey;
	}

	/**
	 * set description bundle key
	 *
	 * @param descriptionBundleKey bundle key
	 */
	public void setDescriptionBundleKey(String descriptionBundleKey) {
		this.descriptionBundleKey = descriptionBundleKey;
	}

	/**
	 * get enum instance based on database flag
	 *
	 * @param databaseFlag database stored flag
	 * @return enum instance
	 */
	public static TankPosition getEnumByFlag(String databaseFlag) {
		return map.get(databaseFlag);
	}
}
