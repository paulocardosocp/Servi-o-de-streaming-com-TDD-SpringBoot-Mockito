package com.streaming.streaming.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.streaming.streaming.modelo.Genero;

public interface GeneroRepository extends JpaRepository<Genero, Long> {

	public Optional<Genero> findByDescricao(String descricao);

} 
