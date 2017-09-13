package br.com.kushi.selly.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.kushi.selly.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	Iterable<Usuario> findAll(); 
	
	Usuario findByLogin(String login);
}
