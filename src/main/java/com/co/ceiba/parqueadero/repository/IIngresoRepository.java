package com.co.ceiba.parqueadero.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.co.ceiba.parqueadero.entity.Ingreso;

public interface IIngresoRepository extends CrudRepository<Ingreso, Long> {

	Optional<Ingreso> findByPlaca(String placa);

}
