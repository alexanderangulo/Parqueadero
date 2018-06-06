package com.co.ceiba.parqueadero.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.co.ceiba.parqueadero.business.FacturaBusiness;

import com.co.ceiba.parqueadero.entity.Factura;

@RestController
@RequestMapping("/factura")
public class FacturaCrud {

	@Autowired
	public FacturaBusiness facturaBuss;
	//@CrossOrigin(origins = "*")
	@RequestMapping(value = "/salida", method = RequestMethod.POST)
	public Factura salidaregistro(@RequestBody String placa) throws Exception {
		return facturaBuss.registroFactura(placa);
	}

}
