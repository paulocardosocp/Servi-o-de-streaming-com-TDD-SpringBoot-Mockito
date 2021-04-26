package com.streaming.streaming.servico.exception;

import com.streaming.streaming.servico.exception.message.MessageException;

public class DuplicidadeGeneroException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicidadeGeneroException() {
		super(MessageException.DUPLICIDADE_GENERO_EXCEPTION_MESSAGE);
	}
}
