/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kayala.webquarium.core.textsearch;

import br.com.kayala.webquarium.core.model.entity.FaunaSpecies;
import java.util.List;

/**
 *
 * @author kayala
 */
public interface FaunaSpeciesTextSearch extends TextSearch<FaunaSpecies> {

	List<FaunaSpecies> findInAllFields(String keyword);
	
}
