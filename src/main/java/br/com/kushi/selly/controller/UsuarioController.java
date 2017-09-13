package br.com.kushi.selly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.kushi.selly.model.Usuario;
import br.com.kushi.selly.repository.UsuarioRepository;

@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioRepository repository;
		
	@RequestMapping("/save")
	public String save(){
		for (int i = 0; i < 5; i++) {
			Usuario user = new Usuario();
			user.setLogin("teste " + i);
			repository.save(user);
		}
		
		return "Sucesso";
	}
	
	@ResponseBody 
	@RequestMapping("/get")
	public String findAll(){
		String result = "<html>";
		
		for(Usuario usuario : repository.findAll()){
			result += "<div>" + usuario.toString() + "</div>";
		}
		
		return result + "</html>";
	}
	
	@RequestMapping("/login")
	public Usuario findByLogin(@RequestParam(value="login") String login) {
		Usuario usuario = repository.findByLogin(login);
		return usuario;		
	}

}
