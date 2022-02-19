package org.viceri.toDo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.viceri.toDo.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Long> {
	
	public List <Categoria> findAllByPrioridadeContainingIgnoreCase (String prioridade);
	public List <Categoria> findAllByStatusContainingIgnoreCase (String status);

}
