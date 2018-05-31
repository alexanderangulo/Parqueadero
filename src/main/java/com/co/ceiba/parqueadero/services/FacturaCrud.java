package com.co.ceiba.parqueadero.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.co.ceiba.parqueadero.repository.IFacturaRepository;
import com.co.ceiba.parqueadero.repository.IIngresoRepository;

@RestController
@RequestMapping("/Factura")
public class FacturaCrud {
	
	@Autowired
	public IFacturaRepository facturarepository;
	
	@Autowired
	public IIngresoRepository ingresorepository;
	
	
	
	
	

}
