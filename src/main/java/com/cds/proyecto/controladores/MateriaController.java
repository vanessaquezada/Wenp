package com.cds.proyecto.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.cds.proyecto.entidades.Materia;
import com.cds.proyecto.repositorios.IMateriaRepository;

@Controller
@RequestMapping("materias")
public class MateriaController {

	@Autowired
	IMateriaRepository erMateria;
	
	@GetMapping("index")
	public String listar(Model m) {
		m.addAttribute("items", (List<Materia>) erMateria.findAll());
		return "/materia/listMat";
    }
	
	@GetMapping("guardar")
	public String VistaGuardar() {
		return "/materia/addMat";
    }
	
	@PostMapping("guardar")
	public String guardar(@RequestParam String nombre, @RequestParam String descripcion, @RequestParam String especialidad) {
		
		//Procesando peticion
		Materia e= new Materia();		
		e.setNombre(nombre);
		e.setDescripcion(descripcion);
		e.setEspecialidad(especialidad);
		
		erMateria.save(e);
		return "redirect:/materias/index";
	}
	
	@GetMapping(value="modificar/{id_materia}")
	 public String modificarVista( @PathVariable Integer id_materia,Model m) {
		 Materia ma=erMateria.findById(id_materia).get();
		 m.addAttribute("item", ma);
		 return new String("materia/updateMat");
	 }
	
	 @PostMapping(value="modificar")
	 public String modificar(@RequestParam Integer id_materia ,@RequestParam String nombre, @RequestParam String descripcion, @RequestParam String especialidad){
		  //creando objeto de docente a modificar
		  Materia e=new Materia();
	      e.setId_materia(id_materia);
		  e.setNombre(nombre); //asignando nombre
		  e.setDescripcion(descripcion);
		  e.setEspecialidad(especialidad);
	 
		  erMateria.save(e); //guardando el docent    
		 
		 return "redirect:/materias/index";
	 }
	 
	//Eliminar
	 @GetMapping("eliminar/{id_materia}")
	 public String eliminar(@PathVariable Integer id_materia) {
		 Materia e=erMateria.findById(id_materia).get();
		 erMateria.deleteById(id_materia);
		 return "redirect:/materias/index";
	 }
}
