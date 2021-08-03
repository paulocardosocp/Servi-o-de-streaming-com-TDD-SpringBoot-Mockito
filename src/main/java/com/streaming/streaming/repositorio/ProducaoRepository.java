package com.streaming.streaming.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.streaming.streaming.modelo.Producao;

public interface ProducaoRepository extends JpaRepository<Producao, Long> {

	Optional<Producao> findByTituloAndAno(String titulo, int ano);

	@Query("SELECT prod FROM Producao prod WHERE prod.genero.descricao = :genero")
	Optional<Producao> findByDescricaoGenero(@Param("genero") String genero);
	
	@Query("SELECT prod FROM Producao prod WHERE 1=1")
	List<Producao> selectByGenero(String descricaoGenero);
}
