package br.com.kayala.webquarium.core.textsearch.impl;

import br.com.kayala.webquarium.core.model.entity.FaunaSpecies;
import br.com.kayala.webquarium.core.textsearch.FaunaSpeciesTextSearch;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kayala
 */
@Repository
public class FuanaSpeciesTextSearchImpl extends TextSearchImpl<FaunaSpecies> implements FaunaSpeciesTextSearch {

	public FuanaSpeciesTextSearchImpl() {
		super(FaunaSpecies.class);
	}

	@Override
	@Transactional
	public List<FaunaSpecies> findInAllFields(String keyword) {
		String[] fields = {
			"kigdom",
			"phylum",
			"speciesClass",
			"speciesOrder",
			"family",
			"subfamily",
			"genus",
			"species",
			"habitat",
			"characteristics",
			"behavior",
			"food",
			"sexualDimorphism",
			"reproduction",
			"otherInformation",
			"commonNames.name",
			"sources.sourceName"};

		return findByKeywords(fields, keyword);
	}

}
