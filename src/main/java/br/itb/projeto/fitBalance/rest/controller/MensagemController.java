package br.itb.projeto.fitBalance.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itb.projeto.fitBalance.model.entity.Mensagem;
import br.itb.projeto.fitBalance.rest.exception.ResourceNotFoundException;
import br.itb.projeto.fitBalance.rest.response.MessageResponse;
import br.itb.projeto.fitBalance.service.MensagemService;
import br.itb.projeto.fitBalance.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/mensagem/")
public class MensagemController {

	private MensagemService mensagemService;
	private UsuarioService usuarioService;

	public MensagemController(MensagemService mensagemService, UsuarioService usuarioService) {
		super();
		this.mensagemService = mensagemService;
		this.usuarioService = usuarioService;
	}

	@GetMapping("findAll")
	public ResponseEntity<List<Mensagem>> findAll(HttpServletRequest http) {
		var email = http.getHeader("logado");
		var usuario = usuarioService.findByEmail(email);
		System.out.println(usuario.getNivelAcesso());
		List<Mensagem> mensagens = mensagemService.findAll(usuario.getNivelAcesso().equals("ADMIN") ? null : usuario.getEmail());

		return new ResponseEntity<List<Mensagem>>(mensagens, HttpStatus.OK);
	}
	
	@GetMapping("findById/{id}")
	public ResponseEntity<Mensagem> findById(@PathVariable long id) {

		Mensagem mensagem = mensagemService.findById(id);

		if (mensagem != null) {
			return new ResponseEntity<Mensagem>(mensagem, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("*** Mensagem não encontrada! *** " + "ID: " + id);
		}

	}
	
	@PostMapping("create")
	public ResponseEntity<?> create(@RequestBody Mensagem mensagem) {

		Mensagem _mensagem = mensagemService.create(mensagem);
		
		if (_mensagem == null) {
			return ResponseEntity.badRequest().body(
					new MessageResponse("Mensagem já cadastrado!"));
		}
		return ResponseEntity.ok()
				.body(new MessageResponse("Mensagem enviada com sucesso!"));
	}
	
	@PutMapping("ativar/{id}")
	public ResponseEntity<Mensagem> ativar(@PathVariable long id) {

		Mensagem _mensagem = mensagemService.ativar(id);

		return new ResponseEntity<Mensagem>(_mensagem, HttpStatus.OK);
	}
	
	@PutMapping("inativar/{id}")
	public ResponseEntity<Mensagem> inativar(@PathVariable long id) {

		Mensagem _mensagem = mensagemService.inativar(id);

		return new ResponseEntity<Mensagem>(_mensagem, HttpStatus.OK);
	}
	
	@PutMapping("marcarComoLida/{id}")
	public ResponseEntity<Mensagem> marcarComoLida(@PathVariable long id) {

		Mensagem _mensagem = mensagemService.marcarComoLida(id);

		return new ResponseEntity<Mensagem>(_mensagem, HttpStatus.OK);
	}


}
