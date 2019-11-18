package com.cds.proyecto.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cds.proyecto.entidades.Nota;

@Repository
public interface INotaRepository extends CrudRepository<Nota, Integer>{

}
