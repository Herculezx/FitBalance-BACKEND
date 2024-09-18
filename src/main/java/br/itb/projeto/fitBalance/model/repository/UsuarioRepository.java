package br.itb.projeto.fitBalance.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.itb.projeto.fitBalance.model.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	@Query(value = "select u.* from usuario as u where email = :email", nativeQuery = true)
	Usuario obterPorEmail(String email);
	@Query(value = "select u.* from usuario as u where email = :email and senha = :senha and nome = :nome", nativeQuery = true)
	Usuario logar(String email, String senha , String nome);
}
