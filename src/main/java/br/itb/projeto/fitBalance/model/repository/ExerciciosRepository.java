package br.itb.projeto.fitBalance.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.itb.projeto.fitBalance.model.entity.Exercicios;

@Repository
public interface ExerciciosRepository extends JpaRepository<Exercicios, Long> {

}
