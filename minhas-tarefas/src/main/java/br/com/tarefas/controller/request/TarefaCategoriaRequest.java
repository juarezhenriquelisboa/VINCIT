package br.com.tarefas.controller.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TarefaCategoriaRequest {

	@NotBlank(message = "campo nome não pode estar vazio")
	@Size(max = 50, message = "campo nome deve ter no máximo 50 letras")
	@Column(length = 50)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
