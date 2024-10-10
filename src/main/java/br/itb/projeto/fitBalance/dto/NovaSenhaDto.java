package br.itb.projeto.fitBalance.dto;

import br.itb.projeto.fitBalance.model.entity.Usuario;

public class NovaSenhaDto {
    private Usuario conta;
    private String senha;

    public Usuario getConta() {
        return conta;
    }

    public void setConta(Usuario conta) {
        this.conta = conta;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    NovaSenhaDto() {

    }

    
    public String getSenha() {
        return senha;
    }

}

