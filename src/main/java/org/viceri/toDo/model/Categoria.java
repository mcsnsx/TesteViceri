package org.viceri.toDo.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

	// ---> Chave Primária / Identificação unica da categoria
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	// ---> Descrição da categoria para classificação das tarefas
	@NotNull(message = "Campo Obrigatório")
	@Size(min = 5, max = 1000, message = "Esse campo deve conter 5 caracteres e no máximo 1000")
	private String descricao;

	// ---> Cadastrar prioridade da tarefa (Baixa prioridade, Média prioridade, Alta
	// prioridade)
	@NotNull(message = "Esse campo é obrigatório!")
	private String prioridade; // tipo

	// ---> Cadastrar status da tarefa (pendente, cancelada, conluída)
	@NotNull(message = "Esse campo é obrigatório!")
	private String status; // palavrachave

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

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

}
