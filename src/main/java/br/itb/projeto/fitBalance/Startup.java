package br.itb.projeto.fitBalance;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.itb.projeto.fitBalance.model.entity.Exercicios;
import br.itb.projeto.fitBalance.service.ExerciciosService;


@SpringBootApplication
public class Startup {

	@Autowired ExerciciosService exerciciosService;
	public static void main(String[] args) {
		SpringApplication.run(Startup.class, args);
	}
	
	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			if (exerciciosService.findAll().size() == 0) {
				exerciciosService.create(new Exercicios("Alongamento estático" , "Iniciante" , 1 , 20 , ""));				
				exerciciosService.create(new Exercicios("Agachamentos" , "Iniciante" , 1 , 8 , ""));
				exerciciosService.create(new Exercicios("Flexão com o joelho apoiado" , "Iniciante" , 1 , 10 , ""));
				exerciciosService.create(new Exercicios("Prancha" , "Iniciante" , 1 , 30 , ""));
				exerciciosService.create(new Exercicios("Polichinelos" , "Iniciante" , 1 , 30 , ""));
				exerciciosService.create(new Exercicios("Passada afundo" , "Iniciante" , 1 , 10 , ""));
				exerciciosService.create(new Exercicios("Abdominais" , "Iniciante" , 2 , 10 , ""));
				exerciciosService.create(new Exercicios("Mergulho Na Cadeira" , "Iniciante" , 2 , 10 , ""));
				exerciciosService.create(new Exercicios("Pular corda" , "Iniciante" , 2 , 100 , ""));
				
				exerciciosService.create(new Exercicios("Alongamento estático" , "Intermediário" , 2 , 30 , ""));				
				exerciciosService.create(new Exercicios("Agachamentos" , "Intermediário" , 2 , 15 , ""));
				exerciciosService.create(new Exercicios("Flexão com o joelho apoiado" , "Intermediário" , 2 , 15 , ""));
				exerciciosService.create(new Exercicios("Prancha" , "Intermediário" , 2 , 45 , ""));
				exerciciosService.create(new Exercicios("Polichinelos" , "Intermediário" , 2 , 30 , ""));
				exerciciosService.create(new Exercicios("Passada afundo" , "Intermediário" , 2 , 20 , ""));
				exerciciosService.create(new Exercicios("Abdominais" , "Intermediário" , 2 , 25 , ""));
				exerciciosService.create(new Exercicios("Mergulho Na Cadeira" , "Intermediário" , 3 , 10 , ""));
				exerciciosService.create(new Exercicios("Pular corda" , "Intermediário" , 4 , 100 , ""));
				exerciciosService.create(new Exercicios("Mountain Climbers" , "Intermediário" , 3 , 30 , ""));
				exerciciosService.create(new Exercicios("Flexão De Braço" , "Intermediário" , 2 , 10 , ""));
				exerciciosService.create(new Exercicios("Abdominal com pernas elevadas" , "Intermediário" , 2 , 10 , ""));
				
				exerciciosService.create(new Exercicios("Alongamento estático" , "Avançado" , 4 , 30 , ""));				
				exerciciosService.create(new Exercicios("Agachamentos" , "Avançado" , 4 , 20 , ""));
				exerciciosService.create(new Exercicios("Flexão com o joelho apoiado" , "Avançado" , 2 , 15 , ""));
				exerciciosService.create(new Exercicios("Prancha" , "Avançado" , 4 , 30 , ""));
				exerciciosService.create(new Exercicios("Polichinelos" , "Avançado" , 5 , 30 , ""));
				exerciciosService.create(new Exercicios("Passada afundo" , "Avançado" , 4 , 15 , ""));
				exerciciosService.create(new Exercicios("Abdominais" , "Avançado" , 3 , 25 , ""));
				exerciciosService.create(new Exercicios("Mergulho Na Cadeira" , "Avançado" , 3 , 20 , ""));
				exerciciosService.create(new Exercicios("Pular corda" , "Avançado" , 6 , 100 , ""));
				exerciciosService.create(new Exercicios("Mountain Climbers" , "Avançado" , 5 , 30 , ""));
				exerciciosService.create(new Exercicios("Flexão De Braço" , "Avançado" , 4 , 10 , ""));
				exerciciosService.create(new Exercicios("Abdominal com pernas elevadas" , "Avançado" , 4 , 10 , ""));
				exerciciosService.create(new Exercicios("Flexão diamante" , "Avançado" , 2 , 10 , ""));
				exerciciosService.create(new Exercicios("Burpees" , "Avançado" , 2 , 10 , ""));
				exerciciosService.create(new Exercicios("Alongamento Cobra" , "Avançado" , 3 , 20 , ""));

			}
		};
	}

}
