package br.com.kayala.webquarium.core.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.search.annotations.Field;

/**
 * source and reference for fauna species information
 *
 * @author kayala
 */
@Entity
public class Source implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToMany
	private List<FaunaSpecies> faunaSpecies = new ArrayList<>();

	@Field
	@NotNull
	@Size(min = 3, max = 1000)
	private String sourceName;

	@Size(max = 1000)
	private String sourceUrl;

	/**
	 *
	 */
	public Source() {
		this.sourceName = sourceName;
	}

	/**
	 *
	 * @param source
	 * @param faunaSpecies
	 */
	public Source(String source) {
		this.sourceName = source;
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
	public List<FaunaSpecies> getFaunaSpecies() {
		return faunaSpecies;
	}

	/**
	 *
	 * @param faunaSpecies
	 */
	public void setFaunaSpecies(List<FaunaSpecies> faunaSpecies) {
		this.faunaSpecies = faunaSpecies;
	}

	/**
	 *
	 * @return
	 */
	public String getSourceName() {
		return sourceName;
	}

	/**
	 *
	 * @param sourceName
	 */
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	/**
	 *
	 * @return
	 */
	public String getSourceUrl() {
		return sourceUrl;
	}

	/**
	 *
	 * @param sourceUrl
	 */
	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

}
