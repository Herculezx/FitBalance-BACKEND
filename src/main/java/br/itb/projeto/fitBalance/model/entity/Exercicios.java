package br.itb.projeto.fitBalance.model.entity;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Exercicios")
public class Exercicios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String nivel;
	private long serie;
	private long repeticoes;
	private String instrucoes;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public Exercicios() {
		super();
	}
	
	public Exercicios( String nome, String nivel, long serie, long repeticoes, String instrucoes) {
		super();
		this.nome = nome;
		this.nivel = nivel;
		this.serie = serie;
		this.repeticoes = repeticoes;
		this.instrucoes = instrucoes;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public long getSerie() {
		return serie;
	}
	public void setSerie(long serie) {
		this.serie = serie;
	}
	public long getRepeticoes() {
		return repeticoes;
	}
	public void setRepeticoes(long repeticoes) {
		this.repeticoes = repeticoes;
	}
	public String getInstrucoes() {
		return instrucoes;
	}
	public void setInstrucoes(String instrucoes) {
		this.instrucoes = instrucoes;
	}
	
	

}
