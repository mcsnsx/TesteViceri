package org.viceri.toDo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

	// ---> Chave Primária / Identificação unica da categoria
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	// ---> Cadastrar prioridade da tarefa (Baixa prioridade, Média prioridade, Alta
	// prioridade)
	@NotNull(message = "Esse campo é obrigatório!")
	private String prioridade;

	// ---> Cadastrar status da tarefa (pendente, cancelada, conluída)
	@NotNull(message = "Esse campo é obrigatório!")
	private String status;

	// ---> Chave estrangeira / Relacionamento de um para muitos, usuario ->
	// postagem
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({ "categoria", "postagem" })
	private List<Postagem> postagem;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

}
