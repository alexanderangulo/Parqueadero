package com.co.ceiba.parqueadero.business;

import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.co.ceiba.parqueadero.entity.Ingreso;
import com.co.ceiba.parqueadero.entity.Parqueadero;
import com.co.ceiba.parqueadero.repository.IIngresoRepository;
import com.co.ceiba.parqueadero.repository.IParqueaderoRepository;

@Service
public class IngresoBusiness {

	public static final int CARRO = 1;

	@Autowired
	public IParqueaderoRepository parqueaderorepository;
	@Autowired
	public IIngresoRepository ingresorepository;

	public static boolean validarDiaIngreso(Calendar fechaIngre, String placa) {
		return ((!(fechaIngre.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
				|| fechaIngre.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY)) && (placa.charAt(0) == "A".charAt(0)));
	}

	public void actualizarParqueaderoCarros(int contadorCarros, Optional<Parqueadero> parqueadero) {
		contadorCarros = ParqueaderoBusiness.contadorDCarros(contadorCarros);
		parqueadero.get().setContadorCarros(contadorCarros);

		parqueaderorepository.save(parqueadero.get());
	}

	public void actualizarParqueaderoMotos(int contadorMotos, Optional<Parqueadero> parqueadero) {
		contadorMotos = ParqueaderoBusiness.contadorDMotos(contadorMotos);
		parqueadero.get().setContadorMotos(contadorMotos);

		parqueaderorepository.save(parqueadero.get());
	}

	public String registroCarro(Optional<Parqueadero> parqueadero, Ingreso ingreso) {
		int contadorCarros = parqueadero.get().getContadorCarros();
		boolean disponibilidad = ParqueaderoBusiness.disponibilidadParqueaderoCarros(contadorCarros);

		if (disponibilidad) {

			actualizarParqueaderoCarros(contadorCarros, parqueadero);

			ingreso.setCilindraje(-1);
			ingresorepository.save(ingreso);

			return " Se registro el ingreso del carro";
		} else {
			return "No hay disponibilidad de paraqueadero para carros";
		}
	}

	public String registroMoto(Optional<Parqueadero> parqueadero, Ingreso ingreso) {
		int contadorMotos = parqueadero.get().getContadorMotos();
		boolean disponibilidad = ParqueaderoBusiness.disponibilidadParqueaderoMotos(contadorMotos);

		if (disponibilidad) {

			actualizarParqueaderoMotos(contadorMotos, parqueadero);

			ingresorepository.save(ingreso);

			return " Se registro el ingreso del moto";
		} else {
			return "No hay disponibilidad de paraqueadero para motos";
		}
	}

	public String registrarIngreso(Ingreso ingreso) {
		
		try {
			ingreso.setFechaIngreso(Calendar.getInstance());
			int tipo = ingreso.getTipoVehiculo();
			boolean vingreso = IngresoBusiness.validarDiaIngreso(ingreso.getFechaIngreso(), ingreso.getPlaca());
			
			Optional<Parqueadero> parqueadero;
			parqueadero = parqueaderorepository.findById((long) 1);
			
			if (!parqueadero.isPresent()) {
				throw new Exception("El parquedero es nulo");
			}
			if (tipo == CARRO) {
				if (!vingreso) {
					return registroCarro(parqueadero, ingreso);
				} else {
					return "No esta autorizado a ingresar el carro el dia de hoy";
				}
			} else {
				return registroMoto(parqueadero, ingreso);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "error en el registro";
	}
}
