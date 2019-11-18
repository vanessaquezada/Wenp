
package com.cds.proyecto.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "materias")
public class Materia{

	@Id
	@NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_materia;
	private String nombre;
	private String descripcion;
	private String especialidad;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "materia")
    private List<Actividad> materias = new ArrayList<Actividad>(0);
	
	public Materia() {
		// TODO Auto-generated constructor stub
	}

	public Materia(Integer id_materia, String nombre, String descripcion, String especialidad) {
		super();
		this.id_materia = id_materia;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.especialidad = especialidad;
	}

	public Integer getId_materia() {
		return id_materia;
	}

	public void setId_materia(Integer id_materia) {
		this.id_materia = id_materia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
}
