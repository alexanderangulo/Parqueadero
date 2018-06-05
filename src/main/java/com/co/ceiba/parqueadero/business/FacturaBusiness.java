package com.co.ceiba.parqueadero.business;

import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.ceiba.parqueadero.entity.Factura;
import com.co.ceiba.parqueadero.entity.Ingreso;
import com.co.ceiba.parqueadero.entity.Parqueadero;
import com.co.ceiba.parqueadero.repository.IFacturaRepository;
import com.co.ceiba.parqueadero.repository.IIngresoRepository;
import com.co.ceiba.parqueadero.repository.IParqueaderoRepository;
@Service
public class FacturaBusiness {
	
	public static final int VALORHORACARRO = 1000;
	public static final int VALORDIACARRO = 8000;
	public static final int VALORHORAMOTO = 500;
	public static final int VALORDIAMOTO = 4000;
	public static final int VALORCILINDRAJE = 2000;
	
	public static final int CARRO = 1;
	public static final int MOTO = 2;
	
	@Autowired
	public IFacturaRepository facturarepository;

	@Autowired
	public IIngresoRepository ingresorepository;

	@Autowired
	public IParqueaderoRepository parqueaderorepository;
	
	public static String calcularDuracion(Calendar fechaIngre, Calendar fechaSalida) {

		long diferenciaSegundos = 0;
		long diferenciaMinutos = 0;
		long diferenciaHoras = 0;
		long diferenciaDias = 0;

		diferenciaSegundos = (fechaSalida.get(Calendar.SECOND) - fechaIngre.get(Calendar.SECOND));
		diferenciaMinutos = (fechaSalida.get(Calendar.MINUTE) - fechaIngre.get(Calendar.MINUTE));
		diferenciaHoras = (fechaSalida.get(Calendar.HOUR_OF_DAY) - fechaIngre.get(Calendar.HOUR_OF_DAY));
		diferenciaDias = (fechaSalida.get(Calendar.DAY_OF_YEAR) - fechaIngre.get(Calendar.DAY_OF_YEAR));

		if (diferenciaMinutos != 0 || diferenciaSegundos != 0) {
			++diferenciaHoras;
		}
		if (diferenciaHoras >= 9 && diferenciaHoras <= 24) {
			diferenciaHoras = 0;
			++diferenciaDias;
		}
		return (diferenciaDias + " " + diferenciaHoras);
	}

	public static int calculoDcobro(int tipoVehiculo, Calendar fechaIngre, Calendar fechaSalida, int cilindraje) {
		int costo = 0;
		if (tipoVehiculo == CARRO) {
			String[] resultado = calcularDuracion(fechaIngre, fechaSalida).split(" ");
			String dia = resultado[0];
			String hora = resultado[1];
			int costoDCarro = Integer.parseInt(dia) * VALORDIACARRO;
			int costoHCarro = Integer.parseInt(hora) * VALORHORACARRO;
			return costoDCarro + costoHCarro;

		} else if (tipoVehiculo == MOTO) {

			String[] resultado = calcularDuracion(fechaIngre, fechaSalida).split(" ");
			String dia = resultado[0];
			String hora = resultado[1];
			int costoDMoto = Integer.parseInt(dia) * VALORDIAMOTO;
			int costoHMoto = Integer.parseInt(hora) * VALORHORAMOTO;
			if (cilindraje <= 500) {
				return costoDMoto + costoHMoto;
			}
			return costoDMoto + costoHMoto + VALORCILINDRAJE;
		}
		return costo;
	}
	
	public  Factura registroFactura(String placa) throws Exception {
		Factura factura = new Factura();

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

		parqueadero = parqueaderorepository.findById((long) 1);

		if (!parqueadero.isPresent()) {
			throw new Exception("Parqueadero no encontrado");
		}

		
		

		if (tipoVehiculo == CARRO) {
			int contadorCarros = parqueadero.get().getContadorCarros();
			contadorCarros = ParqueaderoBusiness.restarCarros(contadorCarros);
			parqueadero.get().setContadorCarros(contadorCarros);

			parqueaderorepository.save(parqueadero.get());
			
			ingresorepository.deleteById(ingreso.get().getId());

			facturarepository.deleteById(factura.getId());

		} else {
			
			int contadorMotos = parqueadero.get().getContadorMotos();
			contadorMotos = ParqueaderoBusiness.restarMotos(contadorMotos);
			parqueadero.get().setContadorMotos(contadorMotos);

			parqueaderorepository.save(parqueadero.get());

			ingresorepository.deleteById(ingreso.get().getId());

			facturarepository.deleteById(factura.getId());
		}
		return factura;
		
	}
}