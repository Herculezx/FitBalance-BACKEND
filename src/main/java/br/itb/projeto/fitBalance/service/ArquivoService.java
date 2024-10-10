package br.itb.projeto.fitBalance.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.itb.projeto.fitBalance.model.entity.Arquivo;
import br.itb.projeto.fitBalance.model.repository.ArquivoRepository;
import jakarta.transaction.Transactional;

@Service
public class ArquivoService {

	private ArquivoRepository arquivoRepository;

	public ArquivoService(ArquivoRepository arquivoRepository) {
		super();
		this.arquivoRepository = arquivoRepository;
	}
	
	public Arquivo findById(long id) {
		Optional<Arquivo> _arquivo = arquivoRepository.findById(id);
		if (_arquivo.isPresent()) {
			Arquivo arquivos = _arquivo.get();
			return arquivos;
		}
		return null;
	}
	
	@Transactional
	public Arquivo create(Arquivo arquivo) {
		return arquivoRepository.save(arquivo);
	}
}
