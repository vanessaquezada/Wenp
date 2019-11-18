
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
@Table(name = "notas")
public class Nota {

	@Id
	@NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_nota;
    private Double nota;
    private String observaciones;
    
    @JoinColumn(name="id_actividad",referencedColumnName = "id_actividad",nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Actividad actividad;
    
    @JoinColumn(name="id_grupoestudiante",referencedColumnName = "id_grupoestudiante",nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Grupoestudiante grupoestudiante;
    
    public Nota() {
		
	}

	public Nota(Integer id_nota, Double nota, String observaciones, Actividad actividad,
			Grupoestudiante grupoestudiante) {
		super();
		this.id_nota = id_nota;
		this.nota = nota;
		this.observaciones = observaciones;
		this.actividad = actividad;
		this.grupoestudiante = grupoestudiante;
	}

	public Integer getId_nota() {
		return id_nota;
	}

	public void setId_nota(Integer id_nota) {
		this.id_nota = id_nota;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public Grupoestudiante getGrupoestudiante() {
		return grupoestudiante;
	}

	public void setGrupoestudiante(Grupoestudiante grupoestudiante) {
		this.grupoestudiante = grupoestudiante;
	}
}