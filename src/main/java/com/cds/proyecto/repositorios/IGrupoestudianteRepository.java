package com.cds.proyecto.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cds.proyecto.entidades.Estudiante;
import com.cds.proyecto.entidades.Grupoestudiante;

@Repository
public interface IGrupoestudianteRepository extends CrudRepository<Grupoestudiante, Integer>{

	@Query("select ge from Grupoestudiante ge where ge.grupo.materia.nombre like %:materia and ge.grupo.grupo like %:grupo")
	public List<Grupoestudiante>  getEstudiantesGruposMaterias(String materia,String grupo);
}
