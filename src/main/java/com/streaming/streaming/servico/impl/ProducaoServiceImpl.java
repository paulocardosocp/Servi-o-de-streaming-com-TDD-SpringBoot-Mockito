package com.streaming.streaming.servico.impl;

import java.util.Optional;

import com.streaming.streaming.modelo.Producao;
import com.streaming.streaming.repositorio.ProducaoRepository;
import com.streaming.streaming.servico.ProducaoService;
import com.streaming.streaming.servico.exception.DuplicidadeProducaoException;

public class ProducaoServiceImpl implements ProducaoService {

	private ProducaoRepository producaoRepository;

	public ProducaoServiceImpl(ProducaoRepository producaoRepository) {
		this.producaoRepository = producaoRepository;
	}

	@Override
	public Producao salvar(Producao producao) throws DuplicidadeProducaoException {
		Optional<Producao> optional = producaoRepository.findByProducaoTituloAndProducaoAno(producao.getTitulo(), 
				producao.getAno());
		if (optional.isPresent()) {
			throw new DuplicidadeProducaoException();
		}
		
		return producaoRepository.save(producao);
	}

}
