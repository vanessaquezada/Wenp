package com.cds.proyecto.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cds.proyecto.entidades.Estudiante;
import com.cds.proyecto.entidades.Grupo;
import com.cds.proyecto.entidades.Grupoestudiante;
import com.cds.proyecto.repositorios.IEstudianteRepository;
import com.cds.proyecto.repositorios.IGrupoRepository;
import com.cds.proyecto.repositorios.IGrupoestudianteRepository;

@Controller
@RequestMapping("grupoestudiantes")
public class GrupoEstudianteController {

	@Autowired
	IGrupoestudianteRepository erGrupoestudiante;
	
	@Autowired
	IEstudianteRepository erEstudiante;
	
	@Autowired
	IGrupoRepository erGrupo;
	
	@GetMapping("index")
	public String Listar(Model m) {
		m.addAttribute("items", (List<Grupoestudiante>) erGrupoestudiante.findAll());
		return "/grupoEstu/listGrupEst";
	}
	
	@GetMapping("guardar")
	public String VistaGuardar (Model model) {
		List<Estudiante> estudiantes=(List<Estudiante>) erEstudiante.findAll();
		model.addAttribute("estudiantes", estudiantes);
		List<Grupo> grupos=(List<Grupo>) erGrupo.findAll();
		model.addAttribute("grupos", grupos);
		return "/grupoEstu/addGrupEst";
	}
	
	@PostMapping(value="guardar")
	public String Guardar (@RequestParam Integer estudiante, @RequestParam Integer grupo) {
		@Valid Grupoestudiante ge = new Grupoestudiante();
		
		Estudiante e = erEstudiante.findById(estudiante).get();
		ge.setEstudiante(e);
		Grupo g = erGrupo.findById(grupo).get();
		ge.setGrupo(g);
		
		erGrupoestudiante.save(ge);
		return "redirect:/grupoestudiantes/index";
	}
	
	@GetMapping(value="modificar/{id_grupoestudiante}")
	public String VistaModificar(@PathVariable Integer id_grupoestudiante, Model model) {
		Grupoestudiante ge = erGrupoestudiante.findById(id_grupoestudiante).get();
		model.addAttribute("item", ge);
		List<Estudiante> estudiantes = (List<Estudiante>) erEstudiante.findAll();
		model.addAttribute("estudiantes", estudiantes);
		List<Grupo> grupos = (List<Grupo>) erGrupo.findAll();
		model.addAttribute("grupos", grupos);
		
		return "/grupoEstu/updateGrupEst";
	}
	
	@PostMapping(value="modificar")
	public String Modificar(@RequestParam Integer id_grupoestudiante, @RequestParam Integer estudiante, @RequestParam Integer grupo) {
		Grupoestudiante ge = new Grupoestudiante(id_grupoestudiante);
		Estudiante e = erEstudiante.findById(estudiante).get();
		ge.setEstudiante(e);
		Grupo g = erGrupo.findById(grupo).get();
		ge.setGrupo(g);
		erGrupoestudiante.save(ge);
		return "redirect:/grupoestudiantes/index";
	}
	
	@GetMapping("eliminar/{id_grupoestudiante}")
	public String eliminar(@PathVariable Integer id_grupoestudiante) {
		Grupoestudiante ge = erGrupoestudiante.findById(id_grupoestudiante).get();
		erGrupoestudiante.deleteById(id_grupoestudiante);
		return "redirect:/grupoestudiantes/index";
	}
	
	@GetMapping(value = "reporteEstudiante",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Grupoestudiante> reporte(@RequestParam String materia, @RequestParam String grupo){
		return	erGrupoestudiante.getEstudiantesGruposMaterias(materia,grupo);
	}
}
