package com.streaming.streaming.repositorio;

import java.util.Optional;

import com.streaming.streaming.modelo.Genero;

public interface GeneroRepository {

	public Genero save(Genero genero);
	
	public Optional<Genero> findByDescricao(String descricao);

}
