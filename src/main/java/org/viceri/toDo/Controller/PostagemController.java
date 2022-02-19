package org.viceri.toDo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.viceri.toDo.Model.Postagem;
import org.viceri.toDo.Repository.PostagemRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository postagemRepository;
	
	// ---> Buscar pelo ID
	@GetMapping ("/{id}")
	public ResponseEntity<Postagem> getById (@PathVariable long id){
		return postagemRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	// ---> Buscar todas as tarefas
	@GetMapping
	public ResponseEntity <List<Postagem>> getAll(){
		return ResponseEntity.ok(postagemRepository.findAll());
	}
	
	
	// ---> Buscar pelo nome
	@GetMapping("/nome/{nome}")
	public ResponseEntity <List<Postagem>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(postagemRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	// ---> Buscar por prioridade (Baixa prioridade, Média prioridade, Alta prioridade)
	@GetMapping("/prioridade/{prioridade}")
	public ResponseEntity <List<Postagem>> getByPrioridade(@PathVariable String prioridade){
		return ResponseEntity.ok(postagemRepository.findAllByPrioridadeContainingIgnoreCase(prioridade));
	}
	
	// ---> Cadastrar tarefas
	@PostMapping
	public ResponseEntity<Postagem> post(@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
	}
	
	// ---> Alterar tarefas
	@PutMapping
	public ResponseEntity<Postagem> put(@RequestBody Postagem postagem){
		return postagemRepository.findById(postagem.getId())
				.map(resp -> {
					return ResponseEntity.ok().body(postagemRepository.save(postagem));
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	// ---> Deletar tarefas
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduto(@PathVariable long id){
		return postagemRepository.findById(id)
				.map(resp -> {
					postagemRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}

}
