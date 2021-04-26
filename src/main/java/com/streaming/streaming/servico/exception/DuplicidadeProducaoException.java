package com.streaming.streaming.servico.exception;

import com.streaming.streaming.servico.exception.message.MessageException;

public class DuplicidadeProducaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicidadeProducaoException() {
		super(MessageException.DUPLICIDADE_PRODUCAO_EXCEPTION_MESSAGE);
	}
}
