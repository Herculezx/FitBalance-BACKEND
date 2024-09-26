package br.itb.projeto.fitBalance.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.support.RequestPartServletServerHttpRequest;

import br.itb.projeto.fitBalance.model.entity.Exercicios;
import br.itb.projeto.fitBalance.model.entity.Mensagem;
import br.itb.projeto.fitBalance.model.entity.Usuario;
import br.itb.projeto.fitBalance.rest.response.MessageResponse;
import br.itb.projeto.fitBalance.service.ExerciciosService;
import br.itb.projeto.fitBalance.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/exercicios/")
public class ExerciciosController {

	private ExerciciosService exerciciosService;

	private UsuarioService usuarioService;
	
	
	
	public ExerciciosController(ExerciciosService exerciciosService, UsuarioService usuarioService) {
		super();
		this.exerciciosService = exerciciosService;
		this.usuarioService = usuarioService;
	}
	
	@PostMapping("marcar")
	public ResponseEntity<String> Marcar(@RequestBody List<Exercicios> exercicios, HttpServletRequest http){
		String email = http.getHeader("logado");
		Usuario usuario = usuarioService.findByEmail(email);
		usuario.setExercicios(new ArrayList<Exercicios>());
		usuario.setExercicios(exercicios);
		usuarioService.salvar(usuario);
		return new ResponseEntity<String>("Marcado", HttpStatus.OK);
	}

	@GetMapping("findAll")
	public ResponseEntity<List<Exercicios>> findAll() {
		List<Exercicios> exercicios = exerciciosService.findAll();

		return new ResponseEntity<List<Exercicios>>(exercicios, HttpStatus.OK);
	}
	
	@PostMapping("create")
	public ResponseEntity<?> create(@RequestBody Exercicios exercicios) {

		Exercicios _exercicios = exerciciosService.create(exercicios);
		
		if (_exercicios == null) {
			return ResponseEntity.badRequest().body(
					new MessageResponse("Exercicios já cadastrado!"));
		}
		return ResponseEntity.ok()
				.body(new MessageResponse("Exercicios Cadastrado com sucesso!"));
	}

}
