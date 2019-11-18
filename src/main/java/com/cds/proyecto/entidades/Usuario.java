
package com.cds.proyecto.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

@Entity
@Table (name = "usuarios")
public class Usuario{

	@Id
	@NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_usuario;
	
	@NotNull(message = "campo requerido")
	private String nombre;
	
	@NotNull(message = "campo requerido")
	private String apellido;
	
	@NotNull(message = "campo requerido")
	private String usuario;
	
	@NotNull(message = "campo requerido")
	private String password;
	
	@JoinColumn(name="id_rol",referencedColumnName = "id_rol",nullable = false)
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	private Rol rol;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(Integer id_usuario, @NotNull(message = "campo requerido") String nombre,
			@NotNull(message = "campo requerido") String apellido, @NotNull(message = "campo requerido") String usuario,
			@NotNull(message = "campo requerido") String password) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.password = password;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
}
