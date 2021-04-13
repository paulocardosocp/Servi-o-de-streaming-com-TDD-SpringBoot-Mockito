package com.streaming.streaming.servico;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.streaming.streaming.modelo.Producao;
import com.streaming.streaming.repositorio.ProducaoRepository;
import com.streaming.streaming.servico.impl.ProducaoServiceImpl;

@ExtendWith(SpringExtension.class)
public class ProducaoServiceTest {
	
	private static final Long ID = 1L;
	private static final String TITULO = "A Lagoa Azul";
	private static final int ANO = 1980;
		
	@MockBean
	private ProducaoRepository producaoRepository;
	
	private ProducaoService producaoService;
	
	private Producao producao;
	
	@BeforeAll
	public void setup() throws Exception {
		producaoService = new ProducaoServiceImpl(producaoRepository);
		producao = new Producao();
		producao.setId(ID);
		producao.setTitulo(TITULO);
		producao.setAno(ANO);
	}
	
	@Test
	public void deveSalvarProducaoNoRepositorio() throws Exception {
		producaoService.salvar(producao);
		
		Mockito.verify(producaoRepository).save(producao);
	}
}
