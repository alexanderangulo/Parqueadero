package com.co.ceiba.parqueadero.services;

import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.co.ceiba.parqueadero.business.FacturaBusiness;

import com.co.ceiba.parqueadero.business.ParqueaderoBusiness;
import com.co.ceiba.parqueadero.entity.Carro;
import com.co.ceiba.parqueadero.entity.Factura;
import com.co.ceiba.parqueadero.entity.Ingreso;
import com.co.ceiba.parqueadero.entity.Moto;
import com.co.ceiba.parqueadero.entity.Parqueadero;
import com.co.ceiba.parqueadero.repository.ICarroRepository;
import com.co.ceiba.parqueadero.repository.IFacturaRepository;
import com.co.ceiba.parqueadero.repository.IIngresoRepository;
import com.co.ceiba.parqueadero.repository.IMotoRepository;
import com.co.ceiba.parqueadero.repository.IParqueaderoRepository;

@RestController
@RequestMapping("/factura")
public class FacturaCrud {

	public static final int CARRO = 1;
	public static final int MOTO = 2;

	@Autowired
	public ICarroRepository carrorepository;

	@Autowired
	public IMotoRepository motorepository;

	@Autowired
	public IFacturaRepository facturarepository;

	@Autowired
	public IIngresoRepository ingresorepository;

	@Autowired
	public IParqueaderoRepository parqueaderorepository;

	@RequestMapping(value = "/salida", consumes = "application/json", method = RequestMethod.POST)
	public void registrodesalida(@RequestBody String placa) throws Exception {

		Factura factura = new Factura();
		Optional<Carro> carro;
		Optional<Moto> moto;
		Optional<Parqueadero> parqueadero;

		Optional<Ingreso> ingreso = ingresorepository.findByPlaca(placa);

		if (!ingreso.isPresent()) {
			throw new Exception("Placa no encontrada");
		}

		factura.setFechaSalida(Calendar.getInstance());

		int tipoVehiculo = ingreso.get().getTipoVehiculo();

		int costo = FacturaBusiness.calculoDcobro(ingreso.get().getTipoVehiculo(), ingreso.get().getFechaIngreso(),
				factura.getFechaSalida(), ingreso.get().getCilindraje());

		factura.setCosto(costo);

		factura.setIdingreso(ingreso.get());
		facturarepository.save(factura);

		parqueadero = parqueaderorepository.findById((long) 23);

		if (!parqueadero.isPresent()) {
			throw new Exception("Parqueadero no encontrado");
		}

		int contadorMotos = parqueadero.get().getContadorMotos();
		int contadorCarros = parqueadero.get().getContadorCarros();

		if (tipoVehiculo == CARRO) {
			contadorCarros = ParqueaderoBusiness.restarCarros(contadorCarros);
			parqueadero.get().setContadorCarros(contadorCarros);

			parqueaderorepository.save(parqueadero.get());

			carro = carrorepository.findByPlaca(placa);

			if (!carro.isPresent()) {
				throw new Exception("carro no encontrado");
			}
			
			carrorepository.deleteById(carro.get().getId());
			ingresorepository.deleteById(ingreso.get().getId());
		//	facturarepository.deleteById(factura.getId());

		} else {

			contadorMotos = ParqueaderoBusiness.restarMotos(contadorMotos);
			parqueadero.get().setContadorMotos(contadorMotos);

			parqueaderorepository.save(parqueadero.get());

			moto = motorepository.findByPlaca(placa);

			if (!moto.isPresent()) {
				throw new Exception("carro no encontrado");
			}
			
			
			carrorepository.deleteById(moto.get().getId());
			ingresorepository.deleteById(ingreso.get().getId());
		//	facturarepository.deleteById(factura.getId());
		}

	}

}
