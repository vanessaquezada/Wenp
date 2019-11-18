package com.cds.proyecto.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("control")
public class RolController {
	
	@GetMapping("listar")
	public String lista() {
		return "administration/login";
	}
	@GetMapping("guardar")
	public String guarda() {
	    return "institucion/addIns";
	}
	@GetMapping("prueba")
	public String ejem() {
	    return "components/navbar";
	}
}
