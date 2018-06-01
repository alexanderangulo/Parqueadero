package com.co.ceiba.parqueadero.services;

import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.co.ceiba.parqueadero.business.IngresoBusiness;
import com.co.ceiba.parqueadero.business.ParqueaderoBusiness;
import com.co.ceiba.parqueadero.entity.Carro;
import com.co.ceiba.parqueadero.entity.Ingreso;
import com.co.ceiba.parqueadero.entity.Moto;
import com.co.ceiba.parqueadero.entity.Parqueadero;
import com.co.ceiba.parqueadero.repository.ICarroRepository;
import com.co.ceiba.parqueadero.repository.IFacturaRepository;
import com.co.ceiba.parqueadero.repository.IIngresoRepository;
import com.co.ceiba.parqueadero.repository.IMotoRepository;
import com.co.ceiba.parqueadero.repository.IParqueaderoRepository;

@RestController
@RequestMapping("/registro")
public class IngresoCrud {

	public static final int CARRO = 1;
	public static final int MOTO = 2;

	@Autowired
	public IIngresoRepository ingresorepository;

	@Autowired
	public ICarroRepository carrorepository;

	@Autowired
	public IMotoRepository motorepository;

	@Autowired
	public IParqueaderoRepository parqueaderorepository;
	
	@Autowired
	public IFacturaRepository facturarepository;

	@RequestMapping(value = "/addIngreso", consumes = "application/json", method = RequestMethod.POST)
	public String save(@RequestBody Ingreso ingreso) {

		Moto moto = new Moto();
		Carro carro = new Carro();
		Optional<Parqueadero> parqueadero;
		try {

			ingreso.setFechaIngreso(Calendar.getInstance());
			int tipo = ingreso.getTipoVehiculo();
			boolean vingreso = IngresoBusiness.validarDiaIngreso(ingreso.getFechaIngreso(), ingreso.getPlaca());

			parqueadero = parqueaderorepository.findById((long) 23);
			if (!parqueadero.isPresent()) {
				throw new Exception("El parquedero es nulo");
			}
			int contadorMotos = parqueadero.get().getContadorMotos();
			int contadorCarros = parqueadero.get().getContadorCarros();

			if (tipo == CARRO) {
				if (!vingreso) {

					boolean disponibilidad = ParqueaderoBusiness.disponibilidadParqueaderoCarros(contadorCarros);
					if (disponibilidad) {

						carro.setPlaca(ingreso.getPlaca());

						carrorepository.save(carro);

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

					moto.setPlaca(ingreso.getPlaca());
					moto.setCilindraje(ingreso.getCilindraje());

					motorepository.save(moto);

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
