package com.co.ceiba.parqueadero.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.co.ceiba.parqueadero.entity.Moto;

public interface IMotoRepository extends CrudRepository <Moto,Long> {

	Optional<Moto> findByPlaca(String placa);

	

}
