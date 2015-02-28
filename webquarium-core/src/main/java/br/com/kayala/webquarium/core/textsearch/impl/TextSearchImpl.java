package br.com.kayala.webquarium.core.textsearch.impl;

import br.com.kayala.webquarium.core.textsearch.TextSearch;
import java.util.List;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kayala
 */
public class TextSearchImpl<T> implements TextSearch<T> {

	@Autowired
	private FullTextEntityManager ftem;

	private Class<T> clazz;
	
	protected TextSearchImpl(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public List<T> findByKeywords(String[] fields, String keyword) {
		QueryBuilder qb = ftem.getSearchFactory().buildQueryBuilder().forEntity(clazz).get();
		org.apache.lucene.search.Query luceneQuery = qb
				.keyword()
				.onFields(fields)
				.matching(keyword)
				.createQuery();

		// wrap Lucene query in a javax.persistence.Query
		javax.persistence.Query jpaQuery = ftem.createFullTextQuery(luceneQuery, clazz);

		// execute search
		return jpaQuery.getResultList();
	}
}
