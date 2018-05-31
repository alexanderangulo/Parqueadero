package com.co.ceiba.parqueadero.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.co.ceiba.parqueadero.entity.Carro;

public interface ICarroRepository extends CrudRepository<Carro, Long>{
	
	Optional<Carro> findById(Long id);

}
