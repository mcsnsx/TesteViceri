package org.viceri.toDo.Controller;

import java.util.List;

import javax.validation.Valid;

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
import org.viceri.toDo.Model.Categoria;
import org.viceri.toDo.Repository.CategoriaRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	// ---> Buscar todas as categorias
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll() {
		return ResponseEntity.ok(categoriaRepository.findAll());
	}

	// ---> Buscar pelo ID
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable long id) {
		return categoriaRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	// ---> Buscar por prioridade (Baixa prioridade, Média prioridade, Alta
	// prioridade)
	@GetMapping("/prioridade/{prioridade}")
	public ResponseEntity<List<Categoria>> getByPrioridade(@PathVariable String prioridade) {
		return ResponseEntity.ok(categoriaRepository.findAllByPrioridadeContainingIgnoreCase(prioridade));
	}

	// ---> Buscar por prioridade (pendente, cancelada, conluída)
	@GetMapping("/status/{status}")
	public ResponseEntity<List<Categoria>> getByStatus(@PathVariable String status) {
		return ResponseEntity.ok(categoriaRepository.findAllByStatusContainingIgnoreCase(status));
	}
	
	// ---> Cadastrar categoria
	@PostMapping
	public ResponseEntity <Categoria> post(@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
	}
	
	// ---> Alterar categoria 
	@PutMapping
	public ResponseEntity <Categoria> put (@Valid @RequestBody Categoria categoria){
		return categoriaRepository.findById(categoria.getId())
				.map(resp -> {
					return ResponseEntity.ok().body(categoriaRepository.save(categoria));
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	// ---> Deletar categoria
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategoria(@PathVariable long id){
		return categoriaRepository.findById(id)
				.map(resp -> {
					categoriaRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
}
