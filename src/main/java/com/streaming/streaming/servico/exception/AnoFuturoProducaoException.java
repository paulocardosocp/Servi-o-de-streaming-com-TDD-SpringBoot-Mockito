package com.streaming.streaming.servico.exception;

import com.streaming.streaming.servico.exception.message.MessageException;

public class AnoFuturoProducaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AnoFuturoProducaoException() {
		super(MessageException.ANO_FUTURO_PRODUCAO_EXCEPTION_MESSAGE);
	}
}
