package com.streaming.streaming.repositorio;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.streaming.streaming.modelo.Genero;

@Sql(value="/populate_database.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value="/clean_database.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource("classpath:application-test.properties")
public class GeneroRepositoryTest {

	@Autowired
	private GeneroRepository generoRepository;
	
	@Test
	public void deveBuscarGeneroPorDescricao() throws Exception {
		Optional<Genero> optional = generoRepository.findByDescricao("Fantasia");
		
		assertThat(optional.isPresent()).isTrue();
		
		Genero genero = optional.get();
		assertThat(genero.getDescricao()).isEqualTo("Fantasia");
		assertThat(genero.getId()).isEqualTo(2L);
	}

}
