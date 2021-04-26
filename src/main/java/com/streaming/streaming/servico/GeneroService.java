package com.streaming.streaming.servico;

import com.streaming.streaming.modelo.Genero;
import com.streaming.streaming.servico.exception.DuplicidadeGeneroException;

public interface GeneroService {

	public Genero salvar(Genero genero) throws DuplicidadeGeneroException;

}
