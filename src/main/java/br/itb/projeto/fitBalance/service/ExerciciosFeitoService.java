package br.itb.projeto.fitBalance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.itb.projeto.fitBalance.model.entity.ExerciciosFeito;
import br.itb.projeto.fitBalance.model.repository.ExerciciosFeitoRepository;
import jakarta.transaction.Transactional;

@Service
public class ExerciciosFeitoService {

	private ExerciciosFeitoRepository exerciciosFeitoRepository;
	
	public ExerciciosFeitoService(ExerciciosFeitoRepository exercicisFeitoRepository) {
		super();
		this.exerciciosFeitoRepository = exercicisFeitoRepository;
	}

	public List<ExerciciosFeito> findAll(){
		List<ExerciciosFeito> exerciciosFeitos = exerciciosFeitoRepository.findAll();
		return exerciciosFeitos;
	}
	
	@Transactional
	public ExerciciosFeito create(ExerciciosFeito exerciciosFeito) {
		
		return exerciciosFeitoRepository.save(exerciciosFeito);
	}
}
