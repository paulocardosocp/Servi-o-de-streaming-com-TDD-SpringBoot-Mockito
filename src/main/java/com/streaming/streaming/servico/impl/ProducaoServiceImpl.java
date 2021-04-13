package com.streaming.streaming.servico.impl;

import com.streaming.streaming.repositorio.ProducaoRepository;
import com.streaming.streaming.servico.ProducaoService;

public class ProducaoServiceImpl implements ProducaoService {

	private ProducaoRepository producaoRepository;

	public ProducaoServiceImpl(ProducaoRepository producaoRepository) {
		this.producaoRepository = producaoRepository;
	}

}
