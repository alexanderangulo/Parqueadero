package com.co.ceiba.parqueadero.unitarioTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.co.ceiba.parqueadero.business.ParqueaderoBusiness;

@SpringBootTest
public class ParqueaderoTest {

	@Test
	public void DisponibilidadCarroTest() {
		// Arrange
		int numMaxCarro = 20;
		// Act
		boolean disponible = ParqueaderoBusiness.disponibilidadParqueaderoCarros(numMaxCarro);

		// Assert
		assertTrue(disponible);

	}

	@Test
	public void DisponibilidadMotoTest() {
		// Arrange
		int numMaxMoto = 10;
		// Act
		boolean disponible = ParqueaderoBusiness.disponibilidadParqueaderoMotos(numMaxMoto);

		// Assert
		assertTrue(disponible);

	}
}
