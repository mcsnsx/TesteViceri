package org.viceri.toDo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.viceri.toDo.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);
	
	public List<Usuario> findById(String id);
	
	public List<Usuario> findByUsuario(String usuario);
	
	public List<Usuario> findByNome(String nome);	

}
