package com.streaming.streaming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.streaming.streaming.modelo.Classificacao;

@SpringBootApplication
public class StreamingApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamingApplication.class, args);
		for (Classificacao idade : Classificacao.values()) {
			System.out.println(idade.getIdade());
		}
	}

}
