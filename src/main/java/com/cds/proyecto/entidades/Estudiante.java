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
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "estudiantes")
public class Estudiante{

	@Id
	@NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_estudiante;
	
	@NotNull(message = "campo requerido")
	private String nombre;
	
	@NotNull(message = "campo requerido")
	private String apellido;
	
	@NotNull(message = "campo requerido")
	private String telefono;
	
	@NotNull(message = "campo requerido")
	private String email;
	
	@JoinColumn(name="id_institucion",referencedColumnName = "id_institucion",nullable = false)
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	private Institucion institucion;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "id_grupoestudiante")
    private List<Grupoestudiante> grupoestudiante = new ArrayList<Grupoestudiante>(0);
	
	public Estudiante() {
		// TODO Auto-generated constructor stub
	}

	public Estudiante(Integer id_estudiante, @NotNull(message = "campo requerido") String nombre,
			@NotNull(message = "campo requerido") String apellido,
			@NotNull(message = "campo requerido") String telefono, @NotNull(message = "campo requerido") String email) {
		super();
		this.id_estudiante = id_estudiante;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
	}

	public Integer getId_estudiante() {
		return id_estudiante;
	}

	public void setId_estudiante(Integer id_estudiante) {
		this.id_estudiante = id_estudiante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Institucion getInstitucion() {
		return institucion;
	}

	public void setInstitucion(Institucion institucion) {
		this.institucion = institucion;
	}
	
}
