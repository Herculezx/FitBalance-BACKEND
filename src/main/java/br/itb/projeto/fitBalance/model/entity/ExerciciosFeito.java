package br.itb.projeto.fitBalance.model.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ExerciciosFeito")
public class ExerciciosFeito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn
	@JsonBackReference("Usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn
	@JsonBackReference
	private Exercicios exercicios;
	
	private LocalDate data;

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Exercicios getExercicios() {
		return exercicios;
	}

	public void setExercicios(Exercicios exercicios) {
		this.exercicios = exercicios;
	}
	
	
	
}
