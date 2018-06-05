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

	public String registrarIngreso(Ingreso ingreso) {
		Optional<Parqueadero> parqueadero;
		try {

			ingreso.setFechaIngreso(Calendar.getInstance());
			int tipo = ingreso.getTipoVehiculo();
			boolean vingreso = IngresoBusiness.validarDiaIngreso(ingreso.getFechaIngreso(), ingreso.getPlaca());

			parqueadero = parqueaderorepository.findById((long) 1);
			if (!parqueadero.isPresent()) {
				throw new Exception("El parquedero es nulo");
			}
			int contadorMotos = parqueadero.get().getContadorMotos();
			int contadorCarros = parqueadero.get().getContadorCarros();

			if (tipo == CARRO) {
				if (!vingreso) {

					boolean disponibilidad = ParqueaderoBusiness.disponibilidadParqueaderoCarros(contadorCarros);
					if (disponibilidad) {

						contadorCarros = ParqueaderoBusiness.contadorDCarros(contadorCarros);
						parqueadero.get().setContadorCarros(contadorCarros);

						parqueaderorepository.save(parqueadero.get());

						ingreso.setCilindraje(-1);

						ingresorepository.save(ingreso);

						return " Se registro el ingreso del carro";

					} else {
						return "No hay disponibilidad de paraqueadero para carros";
					}

				} else {
					return "No esta autorizado a ingresar el carro el dia de hoy";
				}

			} else {

				boolean disponibilidad = ParqueaderoBusiness.disponibilidadParqueaderoMotos(contadorMotos);
				if (disponibilidad) {

					contadorMotos = ParqueaderoBusiness.contadorDMotos(contadorMotos);
					parqueadero.get().setContadorMotos(contadorMotos);

					parqueaderorepository.save(parqueadero.get());

					ingresorepository.save(ingreso);

					return " Se registro el ingreso del moto";
				} else {
					return "No hay disponibilidad de paraqueadero para motos";
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "error";
	}
}
