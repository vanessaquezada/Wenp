
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
@Table (name = "instituciones")
public class Institucion{
	
	@Id
	@NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_institucion;
	
	@NotNull(message = "campo requerido")
	private String nombre;
	
	@NotNull(message = "campo requerido")
	private String direccion;
	
	@NotNull(message = "campo requerido")
	private String telefono;
	
	@NotNull(message = "campo requerido")
	private String email;
	
	@NotNull(message = "campo requerido")
	private String codigo;
	
	@JoinColumn(name="id_usuario",referencedColumnName = "id_usuario",nullable = false)
	@ManyToOne(optional = false ,fetch = FetchType.EAGER)
	private Usuario usuario;
	
	public Institucion() {
		// TODO Auto-generated constructor stub
	}

	public Institucion(Integer id_institucion, @NotNull(message = "campo requerido") String nombre,
			@NotNull(message = "campo requerido") String direccion,
			@NotNull(message = "campo requerido") String telefono, @NotNull(message = "campo requerido") String email,
			@NotNull(message = "campo requerido") String codigo) {
		super();
		this.id_institucion = id_institucion;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.codigo = codigo;
	}

	public Integer getId_institucion() {
		return id_institucion;
	}

	public void setId_institucion(Integer id_institucion) {
		this.id_institucion = id_institucion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
