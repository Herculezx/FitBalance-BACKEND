package br.itb.projeto.fitBalance.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario {

	@Id
	@GeneratedValue
		(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String email;
	private String senha;
	private String nivelAcesso = "USER";
	
	@Column(name = "foto_id", insertable = false, updatable = false, nullable = true)
	private Long foto_id;
	
	@Lob
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, optional = true)
	@JoinColumn
	private Arquivo foto;
	
	
	public long getFoto_id() {
		return foto_id == null ? 0 : foto_id;
	}
	public void setFoto_id(long foto_id) {
		this.foto_id = foto_id;
	}
	
	
	@ManyToMany
	@JoinTable(name = "ExercicioMarcado" , joinColumns = @JoinColumn(name = "usuarioId") , inverseJoinColumns = @JoinColumn(name = "exerciciosId"))
	private List<Exercicios> exercicios;
	
	public List<Exercicios> getExercicios() {
		return exercicios;
	}
	public void setExercicios(List<Exercicios> exercicios) {
		this.exercicios = exercicios;
	}
	private LocalDate dataNascimento;
	private String statusUsuario;
	// Source -> Generate Getters and Setters...
	public long getId() {
		return id;
	}
	
	public Usuario() {
		
	}
	public Usuario(String nome, String email, String senha, String nivelAcesso, 
			LocalDate dataNascimento, String statusUsuario) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.nivelAcesso = nivelAcesso;
		this.dataNascimento = dataNascimento;
		this.statusUsuario = statusUsuario;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNivelAcesso() {
		return nivelAcesso;
	}
	public void setNivelAcesso(String nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}
	
	public Arquivo getFoto() {
		return foto;
	}
	public void setFoto(Arquivo foto) {
		this.foto = foto;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getStatusUsuario() {
		return statusUsuario;
	}
	public void setStatusUsuario(String statusUsuario) {
		this.statusUsuario = statusUsuario;
	}
}
