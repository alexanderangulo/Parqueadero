package com.co.ceiba.parqueadero.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.co.ceiba.parqueadero.entity.Ingreso;
import com.co.ceiba.parqueadero.repository.IIngresoRepository;

@RestController

@RequestMapping("/listado")
public class ListadoVehiculos {

	@Autowired
	public IIngresoRepository ingresorepository;

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/ingresosvehiculos", method = RequestMethod.GET)
	public List<Ingreso> listarIngresoVehiculos() {
		List<Ingreso> ingreso = new ArrayList<>();
		ingresorepository.findAll().forEach(ingreso::add);
		return ingreso;
	}

}
