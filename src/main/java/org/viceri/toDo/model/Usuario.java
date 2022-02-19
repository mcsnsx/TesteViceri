package org.viceri.toDo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import io.swagger.annotations.ApiModelProperty;

@Entity
@Table (name = "tb_usuario")
public class Usuario {
	
	// ---> Chave Primária / Identificação unica do usuário
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	// ---> Cadastrar o nome do usuário
	@NotBlank(message = "Este campo é obrigatório!")
	private String nome;
	
	// ---> Cadastrar email do usuário
	//@ApiModelProperty(exaple = "email@email.com.br")
	@NotBlank(message = "Este campo é obrigatório!")
	@Email
	private String usuario;
	
	// ---> Cadastrar senha do usuário
	@NotBlank
	private String senha;
	
	// ---> Chave estrangeira / Relacionamento de um para muitos, usuario -> postagem
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"usuario", "postagem"})
	private List <Postagem> postagem;

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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
		
}
