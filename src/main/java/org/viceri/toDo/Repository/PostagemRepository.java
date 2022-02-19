package org.viceri.toDo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.viceri.toDo.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>{
	
	public List <Postagem> findAllByNomeContainingIgnoreCase (String nome);
	public List <Postagem> findAllByPrioridadeContainingIgnoreCase (String prioridade);

}
