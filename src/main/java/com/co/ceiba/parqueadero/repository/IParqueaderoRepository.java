package com.co.ceiba.parqueadero.repository;

import org.springframework.data.repository.CrudRepository;

import com.co.ceiba.parqueadero.entity.Parqueadero;

public interface IParqueaderoRepository extends CrudRepository<Parqueadero, Long> {

}
