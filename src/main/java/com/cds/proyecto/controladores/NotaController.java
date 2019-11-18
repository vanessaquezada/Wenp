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
import com.cds.proyecto.entidades.Grupoestudiante;
import com.cds.proyecto.entidades.Nota;
import com.cds.proyecto.repositorios.IActividadRepository;
import com.cds.proyecto.repositorios.IGrupoestudianteRepository;
import com.cds.proyecto.repositorios.INotaRepository;

@Controller
@RequestMapping("notas")
public class NotaController {
	
	@Autowired
	INotaRepository erNota;
	
	@Autowired
	IActividadRepository erActividad;
	
	@Autowired
	IGrupoestudianteRepository erGrupoestudiante;
	
	@GetMapping("index")
	public String Listar(Model m) {
		m.addAttribute("items", (List<Nota>) erNota.findAll());
		return "/nota/listNota";
	}
	//vista de guardar
	@GetMapping("guardar")
	public String Guardar(Model model) {
		List<Actividad> actividades=(List<Actividad>) erActividad.findAll();
		model.addAttribute("actividades", actividades);
		List<Grupoestudiante> gruposestudiantes=(List<Grupoestudiante>) erGrupoestudiante.findAll();
		model.addAttribute("gruposestudiantes", gruposestudiantes);
		return "/nota/addNota";
	}
	@PostMapping(value="guardar")
	public String guardar(@RequestParam Integer actividad, @RequestParam Integer grupoestudiante, @RequestParam Double nota, @RequestParam String observaciones) {
		
		@Valid Nota n=new Nota();
		n.setNota(nota);
		Actividad a=erActividad.findById(actividad).get();
		n.setActividad(a);
		Grupoestudiante g=erGrupoestudiante.findById(grupoestudiante).get();
		n.setGrupoestudiante(g);
		n.setObservaciones(observaciones);		
		erNota.save(n);
		return "redirect:/notas/index";
	}
	@GetMapping(value="modificar/{id_nota}")
	public String VistaModificar(@PathVariable Integer id_nota, Model model) {
		Nota n=erNota.findById(id_nota).get();
		model.addAttribute("item", n);
		List<Actividad> actividades=(List<Actividad>) erActividad.findAll();
		model.addAttribute("actividades", actividades);
		List<Grupoestudiante> grupoestudiantes=(List<Grupoestudiante>) erGrupoestudiante.findAll();
		model.addAttribute("gruposestudiantes", grupoestudiantes);
		return "/nota/updateNota";
	}
	@PostMapping(value="modificar")
	public String modificar(@RequestParam Integer actividad, @RequestParam Integer grupoestudiante, @RequestParam Integer id_nota, @RequestParam Double nota, @RequestParam String observaciones) {
		Nota n =new Nota();
		Actividad a=erActividad.findById(actividad).get();
		n.setActividad(a);
		Grupoestudiante g=erGrupoestudiante.findById(grupoestudiante).get();
		n.setGrupoestudiante(g);
		n.setId_nota(id_nota);
		n.setNota(nota);
		n.setObservaciones(observaciones);
		erNota.save(n);
		return "redirect:/notas/index";	
	}
	@GetMapping(value="eliminar/{id_nota}")
	public String eliminar(@PathVariable Integer id_nota) {
		Nota n=erNota.findById(id_nota).get();
		erNota.deleteById(id_nota);
		return "redirect:/notas/index";
	}
}
