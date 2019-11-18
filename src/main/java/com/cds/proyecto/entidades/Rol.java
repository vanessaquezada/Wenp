
package com.cds.proyecto.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

@Entity
@Table (name = "roles")
public class Rol{

	@Id
	@NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_rol;
	
	@NotNull(message = "campo requerido")
	private String rol;
	
	public Rol() {
		// TODO Auto-generated constructor stub
	}

	public Rol(Integer id_rol, @NotNull(message = "campo requerido") String rol) {
		super();
		this.id_rol = id_rol;
		this.rol = rol;
	}

	public Integer getId_rol() {
		return id_rol;
	}

	public void setId_rol(Integer id_rol) {
		this.id_rol = id_rol;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}
