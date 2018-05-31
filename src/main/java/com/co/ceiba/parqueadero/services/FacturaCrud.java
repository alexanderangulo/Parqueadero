package com.co.ceiba.parqueadero.services;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.co.ceiba.parqueadero.business.FacturaBusiness;
import com.co.ceiba.parqueadero.entity.Factura;
import com.co.ceiba.parqueadero.repository.IFacturaRepository;
import com.co.ceiba.parqueadero.repository.IIngresoRepository;

@RestController
@RequestMapping("/Factura")
public class FacturaCrud {

	@Autowired
	public IFacturaRepository facturarepository;

	@Autowired
	public IIngresoRepository ingresorepository;

	@RequestMapping(value = "/Salida", consumes = "application/json", method = RequestMethod.POST)
	public void registrodesalida(@RequestBody Factura factura) {
		factura.setFechaSalida(Calendar.getInstance());
		int tipoVehiculo = factura.getIdingreso().getTipoVehiculo();
		Calendar fechaIngre = factura.getIdingreso().getFechaIngreso();
		int cilindraje = factura.getIdingreso().getCilindraje();
		int costo = FacturaBusiness.calculoDcobro(tipoVehiculo, fechaIngre, factura.getFechaSalida(), cilindraje);
		factura.setCosto(costo);

	}

}
