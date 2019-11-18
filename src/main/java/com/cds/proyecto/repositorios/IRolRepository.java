package com.cds.proyecto.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cds.proyecto.entidades.Rol;

@Repository
public interface IRolRepository extends CrudRepository<Rol, Integer>{

}
