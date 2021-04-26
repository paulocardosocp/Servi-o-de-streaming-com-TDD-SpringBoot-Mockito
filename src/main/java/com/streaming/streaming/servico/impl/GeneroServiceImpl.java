package com.streaming.streaming.servico.impl;

import java.util.Optional;

import com.streaming.streaming.modelo.Genero;
import com.streaming.streaming.repositorio.GeneroRepository;
import com.streaming.streaming.servico.GeneroService;
import com.streaming.streaming.servico.exception.DuplicidadeGeneroException;

public class GeneroServiceImpl implements GeneroService {

	private GeneroRepository generoRepository;
	
	public GeneroServiceImpl(GeneroRepository generoRepository) {
		super();
		this.generoRepository = generoRepository;
	}

	@Override
	public Genero salvar(Genero genero) throws DuplicidadeGeneroException {
		Optional<Genero> optional = generoRepository.findByDescricao(genero.getDescricao());
		if (optional.isPresent()) {
			throw new DuplicidadeGeneroException();
		}
		
		return generoRepository.save(genero);
	}

}
