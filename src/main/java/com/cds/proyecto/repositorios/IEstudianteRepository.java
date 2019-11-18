package com.cds.proyecto.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cds.proyecto.entidades.Estudiante;

@Repository
public interface IEstudianteRepository extends CrudRepository<Estudiante, Integer>{

	
}
