package br.itb.projeto.fitBalance.model.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.itb.projeto.fitBalance.model.entity.Exercicios;
import br.itb.projeto.fitBalance.model.entity.ExerciciosFeito;
import br.itb.projeto.fitBalance.model.entity.Usuario;

@Repository
public interface ExerciciosFeitoRepository extends JpaRepository<ExerciciosFeito, Long> {
	void deleteByDataAndExerciciosAndUsuario(LocalDate data, Exercicios exercicios, Usuario usuario);
	List<ExerciciosFeito> findAllByExerciciosAndUsuario(Exercicios exercicios, Usuario usuario);
}
