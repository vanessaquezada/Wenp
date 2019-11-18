package com.cds.proyecto.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cds.proyecto.entidades.Grupo;

@Repository
public interface IGrupoRepository extends CrudRepository<Grupo, Integer>{

}
