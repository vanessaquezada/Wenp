package com.cds.proyecto.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cds.proyecto.entidades.Institucion;

@Repository
public interface IInstitucionRepository extends CrudRepository<Institucion, Integer>{

}
