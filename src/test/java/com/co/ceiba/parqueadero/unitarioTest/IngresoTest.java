package com.co.ceiba.parqueadero.unitarioTest;



import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.co.ceiba.parqueadero.business.IngresoBusiness;

@SpringBootTest
public class IngresoTest {

	@Test
	public void verificarDiaPermitidoPlacaATest() {

		// Arrange
		String placa = "ABC133";
		Calendar fechaIngre = new GregorianCalendar(2018, 4,29, 13, 24, 56);

		// Act
		boolean diaPermitido = IngresoBusiness.validarDiaIngreso(fechaIngre, placa);

		// Assert
		assert(diaPermitido);
	}

	@Test
	public void verificarDiaNoPermitidoPlacaATest() {
		// Arrange

		String placa = "ACC133";
		Calendar fechaIngre = new GregorianCalendar(2018, 4, 27, 13, 24, 56);

		// Act
		boolean diaNoPermitido = IngresoBusiness.validarDiaIngreso(fechaIngre, placa);

		// Assert
		Assert.assertFalse(diaNoPermitido);

	}
	@Test
	public void verificarDiaPermitidoPlacaXTest() {
		// Arrange

		String placa = "XCC133";
		Calendar fechaIngre = new GregorianCalendar(2018, 4, 27, 13, 24, 56);

		// Act
		boolean diaPermitido = IngresoBusiness.validarDiaIngreso(fechaIngre, placa);

		// Assert
		Assert.assertFalse(diaPermitido);

	}
	@Test
	public void verificarDiaDomingoPermitidoPlacaXTest() {
		// Arrange

		String placa = "XCC133";
		Calendar fechaIngre = new GregorianCalendar(2018, 4, 29, 13, 24, 56);

		// Act
		boolean diaPermitido = IngresoBusiness.validarDiaIngreso(fechaIngre, placa);

		// Assert
		Assert.assertFalse(diaPermitido);

	}

}

