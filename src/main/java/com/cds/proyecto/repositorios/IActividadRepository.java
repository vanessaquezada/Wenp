package com.cds.proyecto.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cds.proyecto.entidades.Actividad;

@Repository
public interface IActividadRepository extends CrudRepository<Actividad, Integer>{

}
