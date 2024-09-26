package br.itb.projeto.fitBalance.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.itb.projeto.fitBalance.model.entity.Mensagem;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
	List<Mensagem> findAllByEmissorMensagem(String emissorMensagem);
	List<Mensagem> findByEmail(String email);
}
