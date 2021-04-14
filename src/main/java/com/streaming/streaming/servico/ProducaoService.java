package com.streaming.streaming.servico;

import com.streaming.streaming.modelo.Producao;
import com.streaming.streaming.servico.exception.DuplicidadeProducaoException;

public interface ProducaoService {

	Producao salvar(Producao producao) throws DuplicidadeProducaoException;

	
}
