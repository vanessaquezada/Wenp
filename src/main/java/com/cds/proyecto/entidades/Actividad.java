package com.cds.proyecto.entidades;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Entity
@Table (name = "actividades")
public class Actividad{
	
	@Id
	@NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_actividad;
	
	
	private String fecha;
	
	@NotBlank(message = "campo requerido")
	private String nombre;
		
	@Nullable
	private String descripcion;
	
	
	private Double ponderacion;
	
	@JoinColumn(name="id_materia",referencedColumnName = "id_materia",nullable = false)
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	private Materia materia;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "nota")
    private List<Nota> Notas = new ArrayList<Nota>(0);
	
	public Actividad() {
		// TODO Auto-generated constructor stub
	}

	public Actividad(Integer id_actividad, String fecha,
			@NotBlank(message = "campo requerido") String nombre,
			@NotBlank(message = "campo requerido") String descripcion,
			Double ponderacion, Materia materia) {
		super();
		this.id_actividad = id_actividad;
		this.fecha = fecha;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.ponderacion = ponderacion;
		this.materia = materia;
	}

	public Integer getId_actividad() {
		return id_actividad;
	}

	public void setId_actividad(Integer id_actividad) {
		this.id_actividad = id_actividad;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
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

	public Double getPonderacion() {
		return ponderacion;
	}

	public void setPonderacion(Double ponderacion) {
		this.ponderacion = ponderacion;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
}
