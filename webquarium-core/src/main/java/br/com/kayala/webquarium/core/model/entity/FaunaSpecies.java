package br.com.kayala.webquarium.core.model.entity;

import br.com.kayala.webquarium.core.model.datatype.TankPosition;
import br.com.kayala.webquarium.core.validator.annotation.CompareNumber;
import br.com.kayala.webquarium.core.validator.annotation.CompareOperator;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// TODO: Full-text Search
/**
 * Fauna species entity
 *
 * @author kayala
 */
@CompareNumber.List({
	@CompareNumber(field1 = "phMin", operator = CompareOperator.LOWER_THAN_OR_EQUALS, field2 = "phMax"),
	@CompareNumber(field1 = "ghMin", operator = CompareOperator.LOWER_THAN_OR_EQUALS, field2 = "ghMax"),
	@CompareNumber(field1 = "khMin", operator = CompareOperator.LOWER_THAN_OR_EQUALS, field2 = "khMax"),
	@CompareNumber(field1 = "temperatureMin", operator = CompareOperator.LOWER_THAN_OR_EQUALS, field2 = "temperatureMax")})
@Entity
public class FaunaSpecies implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Size(max = 150)
	@Column
	private String kigdom;

	@Size(max = 150)
	@Column
	private String phylum;

	@Size(max = 150)
	@Column
	private String speciesClass;

	@Size(max = 150)
	@Column
	private String speciesOrder;

	@Size(max = 150)
	@Column
	private String family;

	@Size(max = 150)
	@Column
	private String subfamily;

	@NotNull
	@Size(min = 3, max = 150)
	@Column
	private String genus;

	@NotNull
	@Size(min = 3, max = 150)
	@Column
	private String species;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "faunaSpecies")
	List<FaunaSpeciesCommonName> commonNames = new ArrayList<>();

	@Column
	private String habitat;

	@Column
	private String characteristics;

	@Column
	@Size(max = 3000)
	private String behavior;

	@Column
	@NotNull
	private TankPosition tankPosition;

	@Column
	@NotNull
	@Min(1)
	@Max(15)
	private BigDecimal phMin;

	@Column
	@NotNull
	@Min(1)
	@Max(15)
	private BigDecimal phMax;

	@Column
	@NotNull
	@Min(0)
	@Max(15)
	private Integer ghMin;

	@Column
	@NotNull
	@Min(0)
	@Max(15)
	private Integer ghMax;

	@Column
	@NotNull
	@Min(0)
	@Max(15)
	private Integer khMin;

	@Column
	@NotNull
	@Min(0)
	@Max(15)
	private Integer khMax;

	@Column
	@NotNull
	@Min(0)
	@Max(60)
	private Integer temperatureMin;

	@Column
	@NotNull
	@Min(0)
	@Max(60)
	private Integer temperatureMax;

	@Column
	@NotNull
	private BigDecimal adultSize;

	@Column
	private String food;

	@Column
	private String sexualDimorphism;

	@Column
	private String reproduction;

	@Column
	private String otherInformation;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "faunaSpecies")
	private List<Source> sources = new ArrayList<>();

	@Column
	@NotNull
	private String imagePath;

	/**
	 *
	 */
	public FaunaSpecies() {

	}

	/**
	 *
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 *
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 *
	 * @return
	 */
	public String getKigdom() {
		return kigdom;
	}

	/**
	 *
	 * @param kigdom
	 */
	public void setKigdom(String kigdom) {
		this.kigdom = kigdom;
	}

	/**
	 *
	 * @return
	 */
	public String getPhylum() {
		return phylum;
	}

	/**
	 *
	 * @param phylum
	 */
	public void setPhylum(String phylum) {
		this.phylum = phylum;
	}

	/**
	 *
	 * @return
	 */
	public String getSpeciesClass() {
		return speciesClass;
	}

	/**
	 *
	 * @param speciesClass
	 */
	public void setSpeciesClass(String speciesClass) {
		this.speciesClass = speciesClass;
	}

	/**
	 *
	 * @return
	 */
	public String getSpeciesOrder() {
		return speciesOrder;
	}

	/**
	 *
	 * @param speciesOrder
	 */
	public void setSpeciesOrder(String speciesOrder) {
		this.speciesOrder = speciesOrder;
	}

	/**
	 *
	 * @return
	 */
	public String getFamily() {
		return family;
	}

	/**
	 *
	 * @param family
	 */
	public void setFamily(String family) {
		this.family = family;
	}

	/**
	 *
	 * @return
	 */
	public String getSubfamily() {
		return subfamily;
	}

	/**
	 *
	 * @param subfamily
	 */
	public void setSubfamily(String subfamily) {
		this.subfamily = subfamily;
	}

	/**
	 *
	 * @return
	 */
	public String getGenus() {
		return genus;
	}

	/**
	 *
	 * @param genus
	 */
	public void setGenus(String genus) {
		this.genus = genus;
	}

	/**
	 *
	 * @return
	 */
	public String getSpecies() {
		return species;
	}

	/**
	 *
	 * @param species
	 */
	public void setSpecies(String species) {
		this.species = species;
	}

	/**
	 *
	 * @return
	 */
	public List<FaunaSpeciesCommonName> getCommonNames() {
		return commonNames;
	}

	/**
	 *
	 * @param commonNames
	 */
	public void setCommonNames(List<FaunaSpeciesCommonName> commonNames) {
		this.commonNames = commonNames;
	}

	/**
	 *
	 * @return
	 */
	public String getHabitat() {
		return habitat;
	}

	/**
	 *
	 * @param habitat
	 */
	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	/**
	 *
	 * @return
	 */
	public String getCharacteristics() {
		return characteristics;
	}

	/**
	 *
	 * @param characteristics
	 */
	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}

	/**
	 *
	 * @return
	 */
	public String getBehavior() {
		return behavior;
	}

	/**
	 *
	 * @param behavior
	 */
	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}

	/**
	 *
	 * @return
	 */
	public TankPosition getTankPosition() {
		return tankPosition;
	}

	/**
	 *
	 * @param tankPosition
	 */
	public void setTankPosition(TankPosition tankPosition) {
		this.tankPosition = tankPosition;
	}

	/**
	 *
	 * @return
	 */
	public BigDecimal getPhMin() {
		return phMin;
	}

	/**
	 *
	 * @param phMin
	 */
	public void setPhMin(BigDecimal phMin) {
		this.phMin = phMin;
	}

	/**
	 *
	 * @return
	 */
	public BigDecimal getPhMax() {
		return phMax;
	}

	/**
	 *
	 * @param phMax
	 */
	public void setPhMax(BigDecimal phMax) {
		this.phMax = phMax;
	}

	/**
	 *
	 * @return
	 */
	public Integer getGhMin() {
		return ghMin;
	}

	/**
	 *
	 * @param ghMin
	 */
	public void setGhMin(Integer ghMin) {
		this.ghMin = ghMin;
	}

	/**
	 *
	 * @return
	 */
	public Integer getGhMax() {
		return ghMax;
	}

	/**
	 *
	 * @param ghMax
	 */
	public void setGhMax(Integer ghMax) {
		this.ghMax = ghMax;
	}

	/**
	 *
	 * @return
	 */
	public Integer getKhMin() {
		return khMin;
	}

	/**
	 *
	 * @param khMin
	 */
	public void setKhMin(Integer khMin) {
		this.khMin = khMin;
	}

	/**
	 *
	 * @return
	 */
	public Integer getKhMax() {
		return khMax;
	}

	/**
	 *
	 * @param khMax
	 */
	public void setKhMax(Integer khMax) {
		this.khMax = khMax;
	}

	/**
	 *
	 * @return
	 */
	public Integer getTemperatureMin() {
		return temperatureMin;
	}

	/**
	 *
	 * @param temperatureMin
	 */
	public void setTemperatureMin(Integer temperatureMin) {
		this.temperatureMin = temperatureMin;
	}

	/**
	 *
	 * @return
	 */
	public Integer getTemperatureMax() {
		return temperatureMax;
	}

	/**
	 *
	 * @param temperatureMax
	 */
	public void setTemperatureMax(Integer temperatureMax) {
		this.temperatureMax = temperatureMax;
	}

	/**
	 *
	 * @return
	 */
	public BigDecimal getAdultSize() {
		return adultSize;
	}

	/**
	 *
	 * @param adultSize
	 */
	public void setAdultSize(BigDecimal adultSize) {
		this.adultSize = adultSize;
	}

	/**
	 *
	 * @return
	 */
	public String getFood() {
		return food;
	}

	/**
	 *
	 * @param food
	 */
	public void setFood(String food) {
		this.food = food;
	}

	/**
	 *
	 * @return
	 */
	public String getSexualDimorphism() {
		return sexualDimorphism;
	}

	/**
	 *
	 * @param sexualDimorphism
	 */
	public void setSexualDimorphism(String sexualDimorphism) {
		this.sexualDimorphism = sexualDimorphism;
	}

	/**
	 *
	 * @return
	 */
	public String getReproduction() {
		return reproduction;
	}

	/**
	 *
	 * @param reproduction
	 */
	public void setReproduction(String reproduction) {
		this.reproduction = reproduction;
	}

	/**
	 *
	 * @return
	 */
	public String getOtherInformation() {
		return otherInformation;
	}

	/**
	 *
	 * @param otherInformation
	 */
	public void setOtherInformation(String otherInformation) {
		this.otherInformation = otherInformation;
	}

	/**
	 *
	 * @return
	 */
	public List<Source> getSources() {
		return sources;
	}

	/**
	 *
	 * @param sources
	 */
	public void setSources(List<Source> sources) {
		this.sources = sources;
	}

	/**
	 *
	 * @return
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 *
	 * @param imagePath
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
