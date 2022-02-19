package org.viceri.toDo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_postagem")
public class Postagem {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long id;
	 
	 // ---> Cadastrar o nome da tarefa
	 @NotNull(message = "Esse campo é obrigatório!")
	 private String nome;
	 
	 // ---> Cadastrar a descrição da tarefa
	 @NotNull(message = "Esse campo é obrigatório!")
	 private String descricao;
	 
	 // ---> Cadastrar prioridade da tarefa (Baixa prioridade, Média prioridade, Alta prioridade)
	 @NotNull(message = "Esse campo é obrigatório!")
	 private String prioridade;
	 
	 // ---> Cadastrar status da tarefa (pendente, cancelada, conluída)
	 @NotNull(message = "Esse campo é obrigatório!")
	 private String status;

	public long getId() {
		return id;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	 	 

}
