package com.cds.proyecto.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.cds.proyecto.entidades.Grupo;
import com.cds.proyecto.entidades.Materia;
import com.cds.proyecto.repositorios.IGrupoRepository;
import com.cds.proyecto.repositorios.IMateriaRepository;

@Controller
@RequestMapping("grupos")
public class GrupoController {
	@Autowired
	IGrupoRepository erGrupo;
	@Autowired
	IMateriaRepository erMateria;
	
	@GetMapping("index")
	public String Listar(Model m) {
		m.addAttribute("items", (List<Grupo>) erGrupo.findAll());
		return "/grupo/listGrupo";
	}
	@GetMapping("guardar")
	public String Guardar(Model model) {
		List<Materia> materias=(List<Materia>) erMateria.findAll();
		model.addAttribute("materias", materias);
		return "/grupo/addGrupo";
	}
	@PostMapping(value="guardar")
	public String guardar(@RequestParam Integer materia, @RequestParam String grupo) {
		@Valid Grupo e=new Grupo();		
		Materia m= erMateria.findById(materia).get();
		e.setMateria(m);
		e.setGrupo(grupo);
		erGrupo.save(e);
		return "redirect:/grupos/index";
	}
	@GetMapping(value="modificar/{id_grupo}")
	 public String VistaModificar( @PathVariable Integer id_grupo, Model model) {
		 Grupo e=erGrupo.findById(id_grupo).get();
		 model.addAttribute("item", e);
		 List<Materia> materias=(List<Materia>) erMateria.findAll();
		 model.addAttribute("materias", materias);
		 return "/grupo/updateGrupo";
	 }
	@PostMapping(value="modificar")
	 public String modificar(@RequestParam Integer id_grupo,@RequestParam Integer materia, @RequestParam String grupo){
		  Grupo e=new Grupo();
		  e.setId_grupo(id_grupo);
		  e.setGrupo(grupo);
	      Materia m=erMateria.findById(materia).get();
		  e.setMateria(m);	 
		  erGrupo.save(e);
		 return "redirect:/grupos/index";
	 }
	 @GetMapping(value="eliminar/{id_grupo}")
	 public String eliminar( @PathVariable Integer id_grupo) {
		 Grupo e=erGrupo.findById(id_grupo).get();
		 erGrupo.deleteById(id_grupo);
		 return "redirect:/grupos/index";
	 }
}
