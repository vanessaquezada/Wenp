package com.cds.proyecto.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table (name = "grupoestudiante")
public class Grupoestudiante {
	
	@Id
	@NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_grupoestudiante;
	
	@JoinColumn(name="id_grupo",referencedColumnName = "id_grupo",nullable = false)
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	private Grupo grupo;
	
	@JoinColumn(name="id_estudiante",referencedColumnName = "id_estudiante",nullable = false)
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	private Estudiante estudiante;
	
	public Grupoestudiante() {
		// TODO Auto-generated constructor stub
	}

	public Grupoestudiante(Integer id_grupoestudiante) {
		super();
		this.id_grupoestudiante = id_grupoestudiante;
	}

	public Integer getId_grupoestudiante() {
		return id_grupoestudiante;
	}

	public void setId_grupoestudiante(Integer id_grupoestudiante) {
		this.id_grupoestudiante = id_grupoestudiante;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
}
