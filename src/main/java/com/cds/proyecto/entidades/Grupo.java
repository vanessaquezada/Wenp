
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

@Entity
@Table (name = "grupos")
public class Grupo{

	@Id
	@NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_grupo;
	
	@NotBlank(message = "campo requerido")
	private String grupo;
	
	@JoinColumn(name="id_materia",referencedColumnName = "id_materia",nullable = false)
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	private Materia materia;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "id_grupoestudiante")
    private List<Grupoestudiante> grupoestudiante = new ArrayList<Grupoestudiante>(0);
	
	public Grupo() {
		// TODO Auto-generated constructor stub
	}

	public Grupo(Integer id_grupo, @NotBlank(message = "campo requerido") String grupo) {
		super();
		this.id_grupo = id_grupo;
		this.grupo = grupo;
	}


	public Integer getId_grupo() {
		return id_grupo;
	}

	public void setId_grupo(Integer id_grupo) {
		this.id_grupo = id_grupo;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
}
