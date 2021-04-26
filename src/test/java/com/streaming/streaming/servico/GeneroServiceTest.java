package com.streaming.streaming.servico;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.streaming.streaming.modelo.Genero;
import com.streaming.streaming.modelo.Producao;
import com.streaming.streaming.repositorio.GeneroRepository;
import com.streaming.streaming.servico.exception.DuplicidadeGeneroException;
import com.streaming.streaming.servico.impl.GeneroServiceImpl;

@ExtendWith(SpringExtension.class)
public class GeneroServiceTest {
	
	private static final Long ID = 1L;
	private static final String DESCRICAO = "Suspense";
	
	@MockBean
	private GeneroRepository generoRepository;
	
	private GeneroService generoService;
	
	private Genero genero;

	
	@BeforeEach
	public void setup() {
		generoService = new GeneroServiceImpl(generoRepository);
		
		genero = new Genero();
		genero.setId(ID);
		genero.setDescricao(DESCRICAO);
		genero.setProducoes(new ArrayList<Producao>());
	}
	
	
	@Test
	public void deveSalvarGeneroNoRepositorio() throws Exception {
		generoService.salvar(genero);
		
		verify(generoRepository).save(genero);
	}
	
	
	@Test
	public void naoDeveSalvarGenerosComMesmoNome() throws Exception {
		assertThrows(DuplicidadeGeneroException.class, () -> {
			when(generoRepository.findByDescricao(DESCRICAO))
					.thenReturn(Optional.of(genero));
			generoService.salvar(genero);
	    });
	}

}
