package com.co.ceiba.parqueadero.repository;




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.co.ceiba.parqueadero.entity.Parqueadero;

public interface IParqueaderoRepository extends CrudRepository<Parqueadero,Long>{
//	Parqueadero findById(Long id);

}
