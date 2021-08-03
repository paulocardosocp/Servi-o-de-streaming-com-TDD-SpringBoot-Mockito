package com.streaming.streaming.repositorio;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.streaming.streaming.modelo.Genero;
import com.streaming.streaming.modelo.Producao;

@Sql(value="/populate_database.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value="/clean_database.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource("classpath:application-test.properties")
public class ProducaoRepositoryTest {

	private static final Long GENERO_ID = 2L;
	
	private static final String GENERO_DESCRICAO = "Fantasia";
	
	private Genero genero;	

	@Autowired
	private ProducaoRepository producaoRepository;
	
	@BeforeEach
	public void setup() throws Exception {		
		genero = new Genero();
		genero.setId(GENERO_ID);
		genero.setDescricao(GENERO_DESCRICAO);
	}
	
	@Test
	public void deveBuscarProducaoPorGenero() throws Exception {
		Optional<Producao> optional = producaoRepository.findByDescricaoGenero(genero.getDescricao());
		
		assertThat(optional.isPresent()).isTrue();
		
		Producao producao = optional.get();
		assertThat(producao.getTipo().getDescricao()).isEqualTo("Serie");
		assertThat(producao.getTitulo()).isEqualTo("Game of Thrones");
		assertThat(producao.getId()).isEqualTo(3L);
	}

}
