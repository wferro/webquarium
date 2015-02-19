package br.com.kayala.webquarium.core.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * common names for a fauna species entity
 *
 * @author kayala
 */
@Entity
public class FaunaSpeciesCommonName implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(optional = false)
	private FaunaSpecies faunaSpecies;

	@NotNull
	@Size(min = 3, max = 150)
	private String name;

	/**
	 *
	 */
	public FaunaSpeciesCommonName() {

	}

	/**
	 *
	 * @param name
	 * @param faunaSpecies
	 */
	public FaunaSpeciesCommonName(String name, FaunaSpecies faunaSpecies) {
		this.name = name;
		this.faunaSpecies = faunaSpecies;
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
	public FaunaSpecies getFaunaSpecies() {
		return faunaSpecies;
	}

	/**
	 *
	 * @param faunaSpecies
	 */
	public void setFaunaSpecies(FaunaSpecies faunaSpecies) {
		this.faunaSpecies = faunaSpecies;
	}

	/**
	 *
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 *
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
