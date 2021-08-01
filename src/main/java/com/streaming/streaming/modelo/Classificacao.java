package com.streaming.streaming.modelo;

public enum Classificacao {

	LIVRE	(0), 
	AZUL	(10), 
	AMARELO	(12), 
	LARANJA	(14), 
	VERMELHO(16), 
	PRETO	(18);
	
	private int idade;

	private Classificacao(int idade) {
		this.idade = idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public int getIdade() {
		return idade;
	}
}
