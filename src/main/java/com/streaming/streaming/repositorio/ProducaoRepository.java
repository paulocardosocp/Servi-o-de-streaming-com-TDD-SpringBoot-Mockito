package com.streaming.streaming.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.streaming.streaming.modelo.Producao;

public interface ProducaoRepository extends JpaRepository<Producao, Long> {

	Optional<Producao> findByTituloAndAno(String titulo, int ano);

	Optional<Producao> findByGenero(String generoDescricao);
	
	
}
