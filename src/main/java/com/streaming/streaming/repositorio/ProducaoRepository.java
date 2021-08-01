package com.streaming.streaming.repositorio;

import java.util.Optional;

import com.streaming.streaming.modelo.Producao;

public interface ProducaoRepository {

	Producao save(Producao producao);

	Optional<Producao> findByTituloAndAno(String titulo, int ano);

	Optional<Producao> findByGenero(String generoDescricao);
	
	
}
