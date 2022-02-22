package org.viceri.toDo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_postagem")
public class Postagem {

	// ---> Chave Primária / Identificação unica da tarefa
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	// ---> Cadastrar o nome da tarefa
	@NotNull(message = "Esse campo é obrigatório!")
	private String nome;

	// ---> Cadastrar a descrição da tarefa
	@NotNull(message = "Esse campo é obrigatório!")
	private String descricao;

	// ---> Chave estrangeira / Relacionamento de muitos para um, postagem ->
	// usuario
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Usuario usuario;
	
	// ---> Cadastrar prioridade da tarefa (Baixa prioridade, Média prioridade, Alta
	// prioridade)
	@NotNull(message = "Esse campo é obrigatório!")
	private String prioridade; //tipo

	// ---> Chave estrangeira / Relacionamento de muitos para um, postagem ->
	// categoria
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
