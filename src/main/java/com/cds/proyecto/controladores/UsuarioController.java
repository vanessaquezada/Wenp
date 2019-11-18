package com.cds.proyecto.controladores;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.cds.proyecto.entidades.Rol;
import com.cds.proyecto.entidades.Usuario;
import com.cds.proyecto.repositorios.IRolRepository;
import com.cds.proyecto.repositorios.IUsuarioRepository;

@Controller
@RequestMapping("usuarios")
public class UsuarioController {
	/** The password encoder. */
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	IUsuarioRepository erUsuario;
	
	@Autowired
	IRolRepository erRol;
	
	@GetMapping("index")
	public String Listar(Model m) {
		m.addAttribute("items", (List<Usuario>) erUsuario.findAll());
		return "/usuario/listUser";
	}
	
	@GetMapping("guardar")
	public String Guardar(Model model) {
		List<Rol> roles=(List<Rol>) erRol.findAll();
		model.addAttribute("roles", roles);
		return "/usuario/addUser";
	}
	
	@PostMapping(value="guardar")
	public String guardar(@RequestParam String nombre, @RequestParam String apellido, @RequestParam String usuario, @RequestParam String password, @RequestParam Integer rol) {
		
		@Valid Usuario u=new Usuario();
		
		Rol r= erRol.findById(rol).get();
		u.setRol(r);
		u.setNombre(nombre);
		u.setApellido(apellido);
		u.setUsuario(usuario);
		u.setPassword(passwordEncoder.encode(password));		
		erUsuario.save(u);
		return "redirect:/usuarios/index";
	}
	
	@GetMapping(value="modificar/{id_usuario}")
	 public String VistaModificar( @PathVariable Integer id_usuario, Model model) {
		 Usuario u=erUsuario.findById(id_usuario).get();
		 model.addAttribute("item", u);
		 List<Rol> rol=(List<Rol>) erRol.findAll();
		 model.addAttribute("roles", rol);
		 return "/usuario/updateUser";
	 }
	
	 @PostMapping(value="modificar")
	 public String modificar(@RequestParam Integer id_usuario, @RequestParam String nombre, @RequestParam String apellido, @RequestParam String usuario, @RequestParam String password, @RequestParam Integer rol){
		  
		  Usuario u=new Usuario(id_usuario, nombre, apellido, usuario, password);
	      
		  Rol r=erRol.findById(rol).get();
		  u.setRol(r); 
	 
		  erUsuario.save(u);   
		 
		 return "redirect:/usuarios/index";
	 }
	 
	 @GetMapping(value="eliminar/{id_usuario}")
	 public String eliminar( @PathVariable Integer id_usuario) {
		 Usuario u=erUsuario.findById(id_usuario).get();
		 erUsuario.deleteById(id_usuario);
		 return "redirect:/usuarios/index";
	 }
}
