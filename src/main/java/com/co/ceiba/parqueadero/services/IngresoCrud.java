package com.co.ceiba.parqueadero.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.co.ceiba.parqueadero.business.IngresoBusiness;
import com.co.ceiba.parqueadero.entity.Ingreso;

@RestController
@RequestMapping("/registro")
public class IngresoCrud {

	@Autowired
	public IngresoBusiness ingresoBuss;

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/addIngreso", method = RequestMethod.POST)
	public String guardar(@RequestBody Ingreso ingreso) {
		return ingresoBuss.Registrar(ingreso);
	}

}
