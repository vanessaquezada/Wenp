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

import com.cds.proyecto.entidades.Estudiante;
import com.cds.proyecto.entidades.Institucion;
import com.cds.proyecto.repositorios.IEstudianteRepository;
import com.cds.proyecto.repositorios.IInstitucionRepository;

@Controller
@RequestMapping("estudiantes")
public class EstudianteController {
	
	@Autowired
	IEstudianteRepository erEstudiante;
	@Autowired
	IInstitucionRepository erInstitucion;
	
	//tabla de estudiantess
	@GetMapping("index")
	public String index(Model m) {
		m.addAttribute("items",(List<Estudiante>) erEstudiante.findAll());
		return "estudiante/listEstu";
	}
	
		//vista de guardar
		@GetMapping("guardar")
		public String Viewguardar(Model model){
			List<Institucion> instituciones=(List<Institucion>) erInstitucion.findAll();
			model.addAttribute("instituciones", instituciones);
			return "estudiante/addEstu";
		}
		//envio de datos para guardar
		@PostMapping(value="guardar")
		public String Postguardar(
				@RequestParam Integer institucion, 
				@RequestParam String nombre,
				@RequestParam String apellido,
				@RequestParam String telefono,
				@RequestParam String email) {
			@Valid Estudiante e=new Estudiante();
			Institucion i=erInstitucion.findById(institucion).get();
				e.setInstitucion(i);
				e.setNombre(nombre);
				e.setApellido(apellido);
				e.setTelefono(telefono);
				e.setEmail(email);
			erEstudiante.save(e);
			return "redirect:/estudiantes/index";
		}
		//vista de Modificar
		@GetMapping("modificar/{id_estudiante}")
		public String Viewmodificar(
				@PathVariable Integer id_estudiante,
				Model model){
			Estudiante e = erEstudiante.findById(id_estudiante).get();
				model.addAttribute("item", e);
			List<Institucion> instituciones=(List<Institucion>) erInstitucion.findAll();
				model.addAttribute("instituciones", instituciones);
			return "/estudiante/updateEstu";
		}
		//envio de datos a modificar
		@PostMapping(value="modificar")
		public String modificar(
				@RequestParam Integer institucion,
				@RequestParam Integer id_estudiante,
				@RequestParam String nombre,
				@RequestParam String apellido,
				@RequestParam String telefono,
				@RequestParam String email) {
			
			Estudiante e = new Estudiante();
			Institucion i=erInstitucion.findById(institucion).get();
				e.setInstitucion(i);
				e.setId_estudiante(id_estudiante);
				e.setNombre(nombre);
				e.setApellido(apellido);
				e.setTelefono(telefono);
				e.setEmail(email);
			erEstudiante.save(e);
			return "redirect:/estudiantes/index";
		}
		//eliminar
		@GetMapping("eliminar/{id_estudiante}")
		public String eliminar(@PathVariable Integer id_estudiante) {
			Estudiante e = erEstudiante.findById(id_estudiante).get();
			erEstudiante.deleteById(id_estudiante);
			return "redirect:/estudiantes/index";
		}
}
