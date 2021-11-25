package br.com.MaterialController.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.MaterialController.beans.User;
import br.com.MaterialController.dao.UserDAO;

@Controller
public class UserController {
	
	@Autowired
	private UserDAO dao;
	
	// LISTA TODOS OS MATERIAIS REGISTRADOS NO BANCO DE DADOS
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAll() {
		List<User> studentList = (List<User>) dao.findAll();
		
		if(studentList.size() == 0) {
			return ResponseEntity.status(404).build();
		}
		
		return ResponseEntity.ok(studentList);
	}
	
	// MOSTRA TODOS OS DADOS RELACIONADOS AO MATERIAL ESCOLHIDO (INSOMNIA)
	@PostMapping("/user/login")
	public ResponseEntity<User> getUserByName(@RequestBody User userLogin) {
		User userResponse = dao.findByName(userLogin.getName());
		System.out.println(userResponse);
		if(userResponse == null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(userResponse);
	}
	
	// CADASTRA UM NOVO ALUNO NO BANCO DE DADOS (INSOMNIA)
	@PostMapping("/user/novo-user")
	public ResponseEntity<User> saveUser(@RequestBody User newStudent) {
		try {
			dao.save(newStudent);
			return ResponseEntity.ok(newStudent);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
	}

	
}