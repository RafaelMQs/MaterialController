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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.MaterialController.beans.Materials;
import br.com.MaterialController.beans.Students;
import br.com.MaterialController.dao.StudentsDAO;

@Controller
public class StudentsController {
	
	@Autowired
	private StudentsDAO studentDao;
	
	@RequestMapping("/iframeEmprestimosPage")
	public ModelAndView iframeEmprestimos() {
		ModelAndView mv = new ModelAndView("/iframes/iframe_emprestimos");
		Iterable<Students> itens = studentDao.findAll();
		mv.addObject("students", itens);
		return mv;
	}
	
	@GetMapping("/listaEmprestimoPage")
	public String listEmprestimos() {
		return "Lista_Emprestimo";
	}
	
	// LISTA TODOS OS MATERIAIS REGISTRADOS NO BANCO DE DADOS
	@GetMapping("/alunos")
	public ResponseEntity<List<Students>> getAll() {
		List<Students> studentList = (List<Students>) studentDao.findAll();
		
		if(studentList.size() == 0) {
			return ResponseEntity.status(404).build();
		}
		
		return ResponseEntity.ok(studentList);
	}
	
	// MOSTRA TODOS OS DADOS RELACIONADOS AO MATERIAL ESCOLHIDO (INSOMNIA)
	@GetMapping("/alunos/{name}")
	public ResponseEntity<Object> getStudentByName(@PathVariable(value = "name") String name) {
		Students studentResponse = studentDao.findByName(name);
		if(studentResponse == null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(studentResponse);
	}
	
	// CADASTRA UM NOVO ALUNO NO BANCO DE DADOS (INSOMNIA)
	@PostMapping("/alunos/novo-aluno")
	public ResponseEntity<Students> addStudents(@RequestBody Students newStudent) {
		try {
			studentDao.save(newStudent);
			return ResponseEntity.ok(newStudent);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
	}

	
}
