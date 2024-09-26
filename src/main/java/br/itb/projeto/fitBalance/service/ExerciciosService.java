package br.itb.projeto.fitBalance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.itb.projeto.fitBalance.model.entity.Exercicios;
import br.itb.projeto.fitBalance.model.repository.ExerciciosRepository;
import jakarta.transaction.Transactional;

@Service
public class ExerciciosService {

	private ExerciciosRepository exerciciosRepository;

	public ExerciciosService(ExerciciosRepository exerciciosRepository) {
		super();
		this.exerciciosRepository = exerciciosRepository;
	}
	
	public List<Exercicios> findAll(){
		List<Exercicios> exercicios = exerciciosRepository.findAll();
		return exercicios;
	}
	
	@Transactional
	public Exercicios create(Exercicios produto) {
		
		return exerciciosRepository.save(produto);
	}
	
	@Transactional
	public Exercicios inativar(long id) {
		Optional<Exercicios> _exercicios = 
				exerciciosRepository.findById(id);
		return null;
	}
	
	@Transactional
	public Exercicios alterar( Exercicios exercicios) {
		return exerciciosRepository.save(exercicios);
		
	}
}
