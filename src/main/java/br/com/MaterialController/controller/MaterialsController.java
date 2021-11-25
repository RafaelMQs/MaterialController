package br.com.MaterialController.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.MaterialController.beans.Materials;
import br.com.MaterialController.dao.MaterialsDAO;

@Controller
@SpringBootApplication
public class MaterialsController {

	@Autowired
	private MaterialsDAO materialDao;
	
	@GetMapping("/cadastrarUsuarioPage")
	public String registerPage() {
		return "Cadastro";
	}
	
	@GetMapping("/logarUsuarioPage")
	public String loginPage() {
		return "Login";
	}
	
	@GetMapping("/addMaterialPage")
	public String addPage() {
		return "addMaterial";
	}
	
	@GetMapping("/listaMaterialPage")
	public String listMaterials() {
		return "Lista_Material";
	}
	
	@RequestMapping("/novoEmprestimoPage")
	public ModelAndView addEmprestimo() {
		ModelAndView mv = new ModelAndView("Novo_Emprestimo");
		Iterable<Materials> itens = materialDao.findAll();
		mv.addObject("materials", itens);
		return mv;
	}
	
	@RequestMapping("/iframePage")
	public ModelAndView getAllMaterials() {
		ModelAndView mv = new ModelAndView("/iframes/iframe");
		Iterable<Materials> itens = materialDao.findAll();
		mv.addObject("materials", itens);
		return mv;
	}
	

	
	// CADASTRA UM NOVO ITEM NO BANCO DE DADOS (INSOMNIA)
	@PostMapping("/materiais/novo-material")
	public ResponseEntity<Materials> addMaterial(@RequestBody Materials newMaterial) {
		try {
			materialDao.save(newMaterial);
			return ResponseEntity.ok(newMaterial);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
	}
}
