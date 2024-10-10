package br.itb.projeto.fitBalance.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.itb.projeto.fitBalance.model.entity.Exercicios;

@Repository
public interface ExerciciosRepository extends JpaRepository<Exercicios, Long> {
@Override
@Query(value = "select id, nome, nivel, serie, repeticoes, instrucoes, imagem, null as \"video\" from Exercicios" , nativeQuery = true)
List<Exercicios> findAll();
}
