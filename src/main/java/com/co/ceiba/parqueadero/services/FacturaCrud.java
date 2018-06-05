package com.co.ceiba.parqueadero.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.co.ceiba.parqueadero.business.FacturaBusiness;

import com.co.ceiba.parqueadero.entity.Factura;
import com.co.ceiba.parqueadero.repository.IFacturaRepository;
import com.co.ceiba.parqueadero.repository.IIngresoRepository;
import com.co.ceiba.parqueadero.repository.IParqueaderoRepository;

@RestController
@RequestMapping("/factura")
public class FacturaCrud {

	@Autowired
	public IFacturaRepository facturarepository;

	@Autowired
	public IIngresoRepository ingresorepository;

	@Autowired
	public IParqueaderoRepository parqueaderorepository;

	@Autowired
	public FacturaBusiness facturaBuss;

	@RequestMapping(value = "/salida", consumes = "application/json", method = RequestMethod.POST)
	public Factura salidaregistro(@RequestBody String placa) throws Exception {
		return facturaBuss.registroFactura(placa);
	}

}
