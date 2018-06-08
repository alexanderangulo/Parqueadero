package com.co.ceiba.parqueadero.unitarioTest;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import com.co.ceiba.parqueadero.business.FacturaBusiness;

public class FacturaTest {

	@Test
	public void calculaTiempoTest() {
		// Arrange
		Calendar fechaIngre = new GregorianCalendar(2018, 4, 27, 13, 24, 56);
		Calendar fechaSalida = new GregorianCalendar(2018, 4, 28, 15, 25, 56);

		// Act
		String duracion = FacturaBusiness.calcularDuracion(fechaIngre, fechaSalida);
		// Assert
		assertEquals("1 3", duracion);
	}

	@Test
	public void calcularCostoCarroTest() {
		// Arrange

		int tipoVehiculo = 1;
		int cilindraje = -1;
		Calendar fechaIngre = new GregorianCalendar(2018, 4, 27, 13, 24, 56);
		Calendar fechaSalida = new GregorianCalendar(2018, 4, 28, 15, 25, 56);

		// Act
		int costo = FacturaBusiness.calculoDcobro(tipoVehiculo, fechaIngre, fechaSalida, cilindraje);

		// Assert
		assertEquals(11000, costo);
	}

	@Test
	public void calcularCostoMotoTest() {
		// Arrange

		int tipoVehiculo = 2;
		int cilindraje = 500;
		Calendar fechaIngre = new GregorianCalendar(2018, 4, 27, 13, 24, 56);
		Calendar fechaSalida = new GregorianCalendar(2018, 4, 28, 15, 25, 56);

		// Act
		int costo = FacturaBusiness.calculoDcobro(tipoVehiculo, fechaIngre, fechaSalida, cilindraje);

		// Assert
		assertEquals(5500, costo);
	}

	@Test
	public void calcularCostoMotoCilindrajeMayorTest() {
		// Arrange

		int tipoVehiculo = 2;
		int cilindraje = 600;
		Calendar fechaIngre = new GregorianCalendar(2018, 4, 27, 13, 24, 56);
		Calendar fechaSalida = new GregorianCalendar(2018, 4, 28, 15, 25, 56);

		// Act
		int costo = FacturaBusiness.calculoDcobro(tipoVehiculo, fechaIngre, fechaSalida, cilindraje);

		// Assert
		assertEquals(7500, costo);
	}

}
