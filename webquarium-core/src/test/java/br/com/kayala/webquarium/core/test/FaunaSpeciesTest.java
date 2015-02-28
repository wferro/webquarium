package br.com.kayala.webquarium.core.test;

import br.com.kayala.webquarium.core.model.datatype.TankPosition;
import br.com.kayala.webquarium.core.model.datatype.Temperature;
import br.com.kayala.webquarium.core.model.entity.FaunaSpecies;
import br.com.kayala.webquarium.core.model.entity.FaunaSpeciesCommonName;
import br.com.kayala.webquarium.core.model.entity.Source;
import br.com.kayala.webquarium.core.repository.FaunaSpeciesRepository;
import br.com.kayala.webquarium.core.textsearch.FaunaSpeciesTextSearch;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Fauna species unit test
 *
 * @author kayala
 */
public class FaunaSpeciesTest extends BaseTest {

	@Autowired
	private FaunaSpeciesRepository repo;

	@Autowired
	private FaunaSpeciesTextSearch search;

	private Long generatedId;

	@Autowired
	private Validator validator;

	@Before
	public void before() {
		generatedId = createFaunaSpecies();
	}

	private Long createFaunaSpecies() {
		FaunaSpecies faunaSpecies = new FaunaSpecies();

		faunaSpecies.setAdultSize(BigDecimal.valueOf(5.5D));
		faunaSpecies.setBehavior("Comportamento junit");
		faunaSpecies.setCharacteristics("Caracteristicas junit");

		faunaSpecies.getCommonNames().add(new FaunaSpeciesCommonName("Nomo popular 1 junit", faunaSpecies));
		faunaSpecies.getCommonNames().add(new FaunaSpeciesCommonName("Nomo popular 2 junit", faunaSpecies));
		faunaSpecies.getCommonNames().add(new FaunaSpeciesCommonName("Nomo popular 3 junit", faunaSpecies));
		faunaSpecies.getCommonNames().add(new FaunaSpeciesCommonName("Nomo popular 4 junit", faunaSpecies));

		faunaSpecies.setFamily("Familia junit");
		faunaSpecies.setFood("Alimentação junit");
		faunaSpecies.setGenus("Gênero junit");
		faunaSpecies.setGhMax(7);
		faunaSpecies.setGhMin(1);
		faunaSpecies.setHabitat("Habitat natural junit");
		faunaSpecies.setImagePath("/teste/imagem");
		faunaSpecies.setKhMax(9);
		faunaSpecies.setKhMin(1);
		faunaSpecies.setKigdom("Reino junit");
		faunaSpecies.setSpeciesOrder("Ordem junit");
		faunaSpecies.setOtherInformation("Outras informações junit");
		faunaSpecies.setPhMax(BigDecimal.valueOf(8.5D));
		faunaSpecies.setPhMin(BigDecimal.valueOf(6.5D));
		faunaSpecies.setPhylum("Filo junit");
		faunaSpecies.setReproduction("Reprodução junit");
		faunaSpecies.setSexualDimorphism("Dimorfismo sexual junit");

		Source source1 = new Source("Source 1 junit");
		source1.getFaunaSpecies().add(faunaSpecies);

		Source source2 = new Source("Source 2 junit");
		source2.getFaunaSpecies().add(faunaSpecies);

		Source source3 = new Source("Source 3 junit");
		source3.getFaunaSpecies().add(faunaSpecies);

		Source source4 = new Source("Source 4 junit");
		source4.getFaunaSpecies().add(faunaSpecies);

		faunaSpecies.getSources().add(source1);
		faunaSpecies.getSources().add(source2);
		faunaSpecies.getSources().add(source3);
		faunaSpecies.getSources().add(source4);

		faunaSpecies.setSpecies("Espécie junit");
		faunaSpecies.setSpeciesClass("Classe junit");
		faunaSpecies.setSubfamily("Sub-família junit");
		faunaSpecies.setTankPosition(TankPosition.TopMiddle);
		faunaSpecies.setTemperatureMax(new Temperature(BigDecimal.valueOf(28)));
		faunaSpecies.setTemperatureMin(new Temperature(BigDecimal.valueOf(23)));

		return repo.save(faunaSpecies).getId();
	}

	@After
	public void after() {
		FaunaSpecies faunaSpecies = repo.findOne(generatedId);
		if (faunaSpecies != null) {
			repo.delete(faunaSpecies);
		}
	}

	@Test
	public void compareNumberValidator() {
		FaunaSpecies faunaSpecies = repo.findOne(generatedId);
		faunaSpecies.setPhMin(BigDecimal.TEN);
		faunaSpecies.setPhMax(BigDecimal.ONE);
		faunaSpecies.setGhMin(10);
		faunaSpecies.setGhMax(1);
		faunaSpecies.setKhMin(10);
		faunaSpecies.setKhMax(1);
		faunaSpecies.setTemperatureMin(new Temperature(BigDecimal.TEN));
		faunaSpecies.setTemperatureMax(new Temperature(BigDecimal.ONE));

		Set<ConstraintViolation<FaunaSpecies>> violations = validator.validate(faunaSpecies);

		Assert.assertNotNull(violations);
		Assert.assertEquals(4, violations.size());
	}

	@Test
	public void fullTextSearch() {
		List<FaunaSpecies> list = search.findInAllFields("informasoes");

		Assert.assertNotNull(list);
		Assert.assertEquals(1, list.size());
	}
}
