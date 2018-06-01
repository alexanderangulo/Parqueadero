package com.co.ceiba.parqueadero.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.co.ceiba.parqueadero.entity.Carro;
import com.co.ceiba.parqueadero.entity.Ingreso;
import com.co.ceiba.parqueadero.entity.Moto;
import com.co.ceiba.parqueadero.repository.ICarroRepository;
import com.co.ceiba.parqueadero.repository.IIngresoRepository;
import com.co.ceiba.parqueadero.repository.IMotoRepository;
@RestController
@RequestMapping("/listado")
public class ListadoVehiculos {

	@Autowired
	public ICarroRepository carrorepository;
	
	@Autowired
	public IMotoRepository motorepository;
	
	@Autowired
	public IIngresoRepository ingresorepository;
	
	
	@RequestMapping(value="/carros", consumes="application/json", method=RequestMethod.GET)
	public List<Carro> listarCarros() {
		List<Carro> carros =new ArrayList<>();
		carrorepository.findAll().forEach(carros::add);
			return carros;
	}
	@RequestMapping(value="/motos", consumes="application/json", method=RequestMethod.GET)
	public List<Moto> listarMotos() {
		List<Moto> motos =new ArrayList<>();
		 motorepository.findAll().forEach(motos::add);
			return motos;
	}
	@RequestMapping(value="/ingresosvehiculos", consumes="application/json", method=RequestMethod.GET)
	public List<Ingreso> listarIngresoVehiculos() {
		List<Ingreso> ingreso =new ArrayList<>();
		 ingresorepository.findAll().forEach(ingreso::add);
			return ingreso;
	}
	
}
