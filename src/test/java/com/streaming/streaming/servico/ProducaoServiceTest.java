package com.streaming.streaming.servico;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.streaming.streaming.modelo.Genero;
import com.streaming.streaming.modelo.Producao;
import com.streaming.streaming.repositorio.ProducaoRepository;
import com.streaming.streaming.servico.exception.AnoFuturoProducaoException;
import com.streaming.streaming.servico.exception.DuplicidadeProducaoException;
import com.streaming.streaming.servico.exception.ProducaoNotFoundException;
import com.streaming.streaming.servico.exception.message.MessageException;
import com.streaming.streaming.servico.impl.ProducaoServiceImpl;

@ExtendWith(SpringExtension.class)
public class ProducaoServiceTest {
	
	private static final Long ID = 1L;
	private static final String TITULO = "O Poderoso Chefão";
	private static final int ANO = 1972;
	private static final int ANO_FUTURO = 2050;
	
	private static final Long GENERO_ID = 1L;
	private static final String GENERO_DESCRICAO = "Policial";
		
	@MockBean
	private ProducaoRepository producaoRepository;
	
	private ProducaoService producaoService;
	
	private Producao producao;
	
	private Genero genero;
	
	
	@BeforeEach
	public void setup() throws Exception {
		producaoService = new ProducaoServiceImpl(producaoRepository);
		producao = new Producao();
		producao.setId(ID);
		producao.setTitulo(TITULO);
		producao.setAno(ANO);
		
		genero = new Genero();
		genero.setId(GENERO_ID);
		genero.setDescricao(GENERO_DESCRICAO);
		
		when(producaoRepository.findByTituloAndAno(TITULO, ANO))
				.thenReturn(Optional.empty());
	}
	
	
	@Test
	public void deveSalvarProducaoNoRepositorio() throws Exception {
		producaoService.salvar(producao);
		
		verify(producaoRepository).save(producao);
	}
	
	
	@Test
	public void naoDeveSalvarProducoesComMesmoTituloEAno() throws Exception {
		assertThrows(DuplicidadeProducaoException.class, () -> {
			Mockito.when(producaoRepository.findByTituloAndAno(TITULO, ANO))
					.thenReturn(Optional.of(producao));
			producaoService.salvar(producao);
	    });
	}
	
	
	@Test
	public void naoDeveSalvarProducaoComAnoFuturo() throws Exception {
		String mensagemEsperada, mensagemAtual = null;
		
		producao.setAno(ANO_FUTURO);
		
		Throwable excecao = assertThrows(AnoFuturoProducaoException.class, () -> { 
			producaoService.salvar(producao);
		});
		
		mensagemEsperada = MessageException.ANO_FUTURO_PRODUCAO_EXCEPTION_MESSAGE; 
		mensagemAtual = excecao.getMessage();
		assertEquals(mensagemEsperada, mensagemAtual);  
	}
	
	
	@Test
	public void deveBuscarProducoesPorGenero() throws Exception {
		when(producaoRepository.findByGenero(GENERO_DESCRICAO)).thenReturn(Optional.of(producao));
		
		Producao producaoTeste = producaoService.buscarPorGenero(genero);
		
		verify(producaoRepository).findByGenero(GENERO_DESCRICAO);
		
		assertThat(producaoTeste).isNotNull();
		assertThat(producaoTeste.getTitulo()).isEqualTo(TITULO);
		assertThat(producaoTeste.getAno()).isEqualTo(ANO);
	}
	
	
	@Test
	public void deveRetornarExcecaoQuandoNaoEncontrarAProducaoPeloGenero() throws Exception {
		String mensagemEsperada, mensagemAtual = null;
		
		when(producaoRepository.findByGenero(GENERO_DESCRICAO)).thenReturn(Optional.of(producao));
		
		genero.setDescricao("Comédia");
		
		Throwable excecao = assertThrows(ProducaoNotFoundException.class, () -> { 
			producaoService.buscarPorGenero(genero);
		});
		mensagemEsperada = MessageException.PRODUCAO_NOT_FOUND_EXCEPTION_MESSAGE; 
		mensagemAtual = excecao.getMessage();
		assertEquals(mensagemEsperada, mensagemAtual);  
	}
	
}
