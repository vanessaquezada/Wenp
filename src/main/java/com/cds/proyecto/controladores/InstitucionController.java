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

import com.cds.proyecto.entidades.Institucion;
import com.cds.proyecto.entidades.Usuario;
import com.cds.proyecto.repositorios.IInstitucionRepository;
import com.cds.proyecto.repositorios.IUsuarioRepository;

@Controller
@RequestMapping("instituciones")
public class InstitucionController {

	@Autowired
	IInstitucionRepository erInstitucion;
	
	@Autowired
	IUsuarioRepository erUsuario;
	
	@GetMapping("index")
	public String Listar(Model m) {
		m.addAttribute("items", (List<Institucion>) erInstitucion.findAll());
		return "/institucion/listIns";
	}
	
	@GetMapping("guardar")
	public String Guardar(Model model) {
		List<Usuario> usuarios=(List<Usuario>) erUsuario.findAll();
		model.addAttribute("usuarios", usuarios);
		return "/institucion/addIns";
	}
	
	@PostMapping(value="guardar")
	public String guardar(@RequestParam Integer usuario, @RequestParam String nombre, @RequestParam String direccion, @RequestParam String telefono, @RequestParam String email, @RequestParam String codigo) {
		
		@Valid Institucion i=new Institucion();
		
		i.setNombre(nombre);
		Usuario u= erUsuario.findById(usuario).get();
		i.setUsuario(u);
		i.setDireccion(direccion);
		i.setTelefono(telefono);
		i.setEmail(email);
		i.setCodigo(codigo);
		
		erInstitucion.save(i);
		return "redirect:/instituciones/index";
	}
	
	@GetMapping(value="modificar/{id_institucion}")
	 public String VistaModificar( @PathVariable Integer id_institucion, Model model) {
		 Institucion i=erInstitucion.findById(id_institucion).get();
		 model.addAttribute("item", i);
		 List<Usuario> usuarios=(List<Usuario>) erUsuario.findAll();
		 model.addAttribute("usuarios", usuarios);
		 return "/institucion/updateIns";
	 }
	
	 @PostMapping(value="modificar")
	 public String modificar(@RequestParam Integer id_institucion, @RequestParam String nombre, @RequestParam String direccion, @RequestParam String telefono, @RequestParam String email, @RequestParam String codigo,@RequestParam Integer usuario){
		  Institucion i=new Institucion(id_institucion, nombre, direccion, telefono, email, codigo);
	      Usuario u=erUsuario.findById(usuario).get();
		  i.setUsuario(u); 
		  erInstitucion.save(i);   
		  return "redirect:/instituciones/index";
	 }
	 
	 @GetMapping(value="eliminar/{id_institucion}")
	 public String eliminar( @PathVariable Integer id_institucion) {
		 Institucion i=erInstitucion.findById(id_institucion).get();
		 erInstitucion.deleteById(id_institucion);
		 return "redirect:/instituciones/index";
	 }
}
