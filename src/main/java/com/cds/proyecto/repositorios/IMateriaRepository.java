package com.cds.proyecto.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cds.proyecto.entidades.Materia;

@Repository
public interface IMateriaRepository extends CrudRepository<Materia, Integer>{

}
