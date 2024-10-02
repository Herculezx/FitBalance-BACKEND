package br.itb.projeto.fitBalance.model.entity;

import java.time.LocalDate;
import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table
@Entity
public class CodigoRecuperacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDate expiracao;
	@ManyToOne
	private Usuario conta;
	private int codigo;
	public CodigoRecuperacao() {}
	public CodigoRecuperacao(Usuario conta) {
		this.conta = conta;
		this.codigo = new Random().nextInt(9999 - 1000 + 1) + 1000;
		this.expiracao = LocalDate.now().plusDays(2);
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDate getExpiracao() {
		return expiracao;
	}
	public void setExpiracao(LocalDate expiracao) {
		this.expiracao = expiracao;
	}
	public Usuario getConta() {
		return conta;
	}
	public void setConta(Usuario conta) {
		this.conta = conta;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}
