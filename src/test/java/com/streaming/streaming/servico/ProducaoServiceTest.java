package com.streaming.streaming.servico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.streaming.streaming.modelo.Producao;
import com.streaming.streaming.repositorio.ProducaoRepository;
import com.streaming.streaming.servico.exception.AnoFuturoProducaoException;
import com.streaming.streaming.servico.exception.DuplicidadeProducaoException;
import com.streaming.streaming.servico.impl.ProducaoServiceImpl;

@ExtendWith(SpringExtension.class)
public class ProducaoServiceTest {
	
	private static final Long ID = 1L;
	private static final String TITULO = "A Lagoa Azul";
	private static final int ANO = 1980;
	private static final int ANO_FUTURO = 2030;
		
	@MockBean
	private ProducaoRepository producaoRepository;
	
	private ProducaoService producaoService;
	
	private Producao producao;
	
	
	@BeforeEach
	public void setup() throws Exception {
		producaoService = new ProducaoServiceImpl(producaoRepository);
		producao = new Producao();
		producao.setId(ID);
		producao.setTitulo(TITULO);
		producao.setAno(ANO);
		
		Mockito.when(producaoRepository.findByProducaoTituloAndProducaoAno(TITULO, ANO))
				.thenReturn(Optional.empty());
	}
	
	
	@Test
	public void deveSalvarProducaoNoRepositorio() throws Exception {
		producaoService.salvar(producao);
		
		Mockito.verify(producaoRepository).save(producao);
	}
	
	
	@Test
	public void naoDeveSalvarProducoesComMesmoTituloEAno() throws Exception {
		assertThrows(DuplicidadeProducaoException.class, () -> {
			Mockito.when(producaoRepository.findByProducaoTituloAndProducaoAno(TITULO, ANO))
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
		
		mensagemEsperada = "Erro nos dados: Produção se encontra com ano de fabricação futuro!"; 
		mensagemAtual = excecao.getMessage();
		assertEquals(mensagemEsperada, mensagemAtual);  
	}
	
	
	
}
