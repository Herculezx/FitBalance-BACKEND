package br.itb.projeto.fitBalance.rest.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.itb.projeto.fitBalance.model.entity.Arquivo;
import br.itb.projeto.fitBalance.service.ArquivoService;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class ArquivoController {

	private ArquivoService arquivoService;

	public ArquivoController(ArquivoService arquivoService) {
		super();
		this.arquivoService = arquivoService;
	}
	
	@GetMapping("/arquivo/{id}")
	public ResponseEntity<byte[]> Arquivo(@PathVariable long id, HttpServletResponse response){
		Arquivo arquivo = arquivoService.findById(id);
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", arquivo.getExtensao());
		
		return new ResponseEntity<byte[]> ( arquivo.getConteudo(), header, HttpStatus.OK);
	}
}
