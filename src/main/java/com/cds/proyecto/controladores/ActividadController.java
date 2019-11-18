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

import com.cds.proyecto.entidades.Actividad;
import com.cds.proyecto.entidades.Materia;
import com.cds.proyecto.repositorios.IActividadRepository;
import com.cds.proyecto.repositorios.IMateriaRepository;

@Controller
@RequestMapping("actividades")
public class ActividadController {
	
	@Autowired
	IActividadRepository erActividad;
	
	@Autowired
	IMateriaRepository erMateria;
	
	//listado de actividades
	@GetMapping("index")
	public String index(Model m) {
		m.addAttribute("items", (List<Actividad>) erActividad.findAll());
		return "actividad/listAct";
	}
	//vista guardar
	@GetMapping("guardar")
	public String Viewguardar(Model model) {
		List<Materia> materias=(List<Materia>) erMateria.findAll();
		model.addAttribute("materias", materias);
		return "actividad/addAct";
	}
	
	//envio de datos para guardar
	@PostMapping(value="guardar")
	public String Postguardar(@RequestParam Integer materia,@RequestParam String nombre, @RequestParam String fecha, @RequestParam String descripcion, @RequestParam Double ponderacion) {	
		
		@Valid Actividad a=new Actividad();
		Materia m=erMateria.findById(materia).get();
		a.setMateria(m);
		a.setNombre(nombre);
		a.setFecha(fecha);
		a.setDescripcion(descripcion);
		a.setPonderacion(ponderacion);
		
		erActividad.save(a);
		return "redirect:/actividades/index";
	}
	
	@GetMapping(value="modificar/{id_actividad}")
	 public String VistaModificar( @PathVariable Integer id_actividad, Model model) {
		 Actividad a=erActividad.findById(id_actividad).get();
		 model.addAttribute("item", a);
		 List<Materia> materia=(List<Materia>) erMateria.findAll();
		 model.addAttribute("materias", materia);
		 return "/actividad/updateAct";
	 }
	
	//Vista modificar
	@PostMapping(value="modificar")
	public String modificar(@RequestParam Integer id_actividad,@RequestParam Integer materia, @RequestParam String nombre, @RequestParam String fecha, @RequestParam String descripcion, @RequestParam Double ponderacion) {
		Actividad a=new Actividad();
		Materia m=erMateria.findById(materia).get();
		a.setMateria(m);
		a.setId_actividad(id_actividad);
		a.setNombre(nombre);
		a.setFecha(fecha);
		a.setDescripcion(descripcion);
		a.setPonderacion(ponderacion);
		
		erActividad.save(a);
		
		return "redirect:/actividades/index";
	}
	
	//Eliminar registro
	@GetMapping("eliminar/{id_actividad}")
	public String eliminar(@PathVariable Integer id_actividad) {
		Actividad a= erActividad.findById(id_actividad).get();
		erActividad.deleteById(id_actividad);
		return "redirect:/actividades/index";
	}
}