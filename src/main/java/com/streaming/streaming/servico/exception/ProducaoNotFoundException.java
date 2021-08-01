package com.streaming.streaming.servico.exception;

import com.streaming.streaming.servico.exception.message.MessageException;

public class ProducaoNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProducaoNotFoundException() {
		super(MessageException.PRODUCAO_NOT_FOUND_EXCEPTION_MESSAGE);
	}

}
