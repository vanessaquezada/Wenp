package com.cds.proyecto.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cds.proyecto.entidades.Materia;
import com.cds.proyecto.repositorios.IMateriaRepository;

@Controller
@RequestMapping("general")
public class GeneralController {

	@Autowired
	IMateriaRepository erMateria;
	
	@GetMapping("listar")
	public String Vista(Model m) {
		m.addAttribute("materias", (List<Materia>) erMateria.findAll());
		return "general/listGene";
	}
}
