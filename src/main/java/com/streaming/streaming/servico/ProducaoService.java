package com.streaming.streaming.servico;

import com.streaming.streaming.modelo.Producao;
import com.streaming.streaming.servico.exception.AnoFuturoProducaoException;
import com.streaming.streaming.servico.exception.DuplicidadeProducaoException;
import com.streaming.streaming.servico.exception.ProducaoNotFoundException;

public interface ProducaoService {

	Producao salvar(Producao producao) throws DuplicidadeProducaoException, AnoFuturoProducaoException;

	boolean isAnoFuturoProducao(Producao producao);

	Producao buscarPorGenero(String genero) throws ProducaoNotFoundException;
}
