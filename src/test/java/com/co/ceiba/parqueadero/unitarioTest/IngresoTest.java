package com.co.ceiba.parqueadero.unitarioTest;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.co.ceiba.parqueadero.business.IngresoBusiness;

@SpringBootTest
public class IngresoTest {

	@Test
	public void verificarDiaNoPermitidoPlacaATest() {

		// Arrange
		String placa = "ABC133";
		Calendar fechaIngre = new GregorianCalendar(2018, 4, 27, 13, 24, 56);

		// Act
		boolean diaNoPermitido = IngresoBusiness.validarDiaIngreso(fechaIngre, placa);

		// Assert
		assertTrue(diaNoPermitido);
	}

	@Test
	public void verificarDiaPermitidoPlacaATest() {
		// Arrange

		String placa = "BAC133";
		Calendar fechaIngre = new GregorianCalendar(2018, 4, 27, 13, 24, 56);

		// Act
		boolean diaPermitido = IngresoBusiness.validarDiaIngreso(fechaIngre, placa);

		// Assert
		Assert.assertFalse(diaPermitido);

	}
}
