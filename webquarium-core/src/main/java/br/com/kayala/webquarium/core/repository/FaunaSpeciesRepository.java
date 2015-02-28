package br.com.kayala.webquarium.core.repository;

import br.com.kayala.webquarium.core.model.entity.FaunaSpecies;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * fauna species repository
 *
 * @author kayala
 */
public interface FaunaSpeciesRepository extends JpaRepository<FaunaSpecies, Long> {

}
