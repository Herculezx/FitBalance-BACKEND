package br.itb.projeto.fitBalance.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.itb.projeto.fitBalance.model.entity.Mensagem;
import br.itb.projeto.fitBalance.model.repository.MensagemRepository;
import jakarta.transaction.Transactional;

@Service
public class MensagemService {

	private MensagemRepository mensagemRepository;

	public MensagemService(MensagemRepository mensagemRepository) {
		super();
		this.mensagemRepository = mensagemRepository;
	}
	
	public List<Mensagem> findAll(String emissorMensagem) {
		List<Mensagem> mensagens = new ArrayList<Mensagem>();
		if (emissorMensagem == null) {
			mensagens = mensagemRepository.findAll();
		}
		else {
			mensagens = mensagemRepository.findByEmail(emissorMensagem);
		}
		return mensagens;
	}
	
	public Mensagem findById(long id) {
		Optional<Mensagem> _mensagem = mensagemRepository.findById(id);
		if (_mensagem.isPresent()) {
			Mensagem mensagem = _mensagem.get();
			return mensagem;
		}
		return null;
	}
		
	@Transactional
	public Mensagem create(Mensagem mensagem) {
		
		mensagem.setDataMensagem(LocalDateTime.now()); 
		mensagem.setStatusMensagem("ATIVO");
		
		return mensagemRepository.save(mensagem);
	}
	
	@Transactional
	public Mensagem update(long id) {
		Optional<Mensagem> _mensagem = 
				mensagemRepository.findById(id);
		
		if (_mensagem.isPresent()) {
			Mensagem mensagemAtualizada = _mensagem.get();
			mensagemAtualizada.setStatusMensagem("LIDA");
			
			return mensagemRepository.save(mensagemAtualizada);
		}
		return null;
	}
	
	@Transactional
	public Mensagem inativar(long id) {
		Optional<Mensagem> _mensagem = 
				mensagemRepository.findById(id);
		
		if (_mensagem.isPresent()) {
			Mensagem mensagemAtualizada = _mensagem.get();
			mensagemAtualizada.setStatusMensagem("INATIVO");
			
			return mensagemRepository.save(mensagemAtualizada);
		}
		return null;
	}
	
	@Transactional
	public Mensagem marcarComoLida(long id) {
		Optional<Mensagem> _mensagem = 
				mensagemRepository.findById(id);
		
		if (_mensagem.isPresent()) {
			Mensagem mensagemAtualizada = _mensagem.get();
			mensagemAtualizada.setStatusMensagem("LIDA");
			
			return mensagemRepository.save(mensagemAtualizada);
		}
		return null;
	}
	
	
}
