package br.itb.projeto.fitBalance.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	@Column(unique = true)
	private String email;
	private String senha;
	private String nivelAcesso = "USER";
	
	@Column(name = "foto_id", insertable = false, updatable = false, nullable = true)
	private Long fotoId;
	
	@Lob
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
	@JoinColumn
	@JsonBackReference("Foto")
	private Arquivo foto;
	
	
	public Long getFotoId() {
		return fotoId;
	}
	public void setFotoId(Long fotoId) {
		this.fotoId = fotoId;
	}
	@ManyToMany(cascade = CascadeType.REMOVE )
	@JoinTable(name = "ExercicioMarcado" ,  joinColumns = @JoinColumn(name = "usuarioId") , inverseJoinColumns = @JoinColumn(name = "exerciciosId"))
	private List<Exercicios> exercicios = new ArrayList<>();
	
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
