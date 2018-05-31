package com.co.ceiba.parqueadero.unitarioTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.co.ceiba.parqueadero.business.ParqueaderoBusiness;

@SpringBootTest
public class ParqueaderoTest {

	@Test
	public void DisponibilidadCarroTest() {
		//Arrange
		int numMaxCarro=20;
		ParqueaderoBusiness nparqueadero = new ParqueaderoBusiness();
		//Act
		boolean disponible =nparqueadero.disponibilidadParqueaderoCarros(numMaxCarro);
		
		//Assert
		
		assertTrue(disponible);
				
	}

	@Test
	public void test() {
		
	}
	
	@Test
	public void DisponibilidadMotoTest() {
		//Arrange
		
		int numMaxMoto=10;
		ParqueaderoBusiness nparqueadero = new ParqueaderoBusiness();
		//Act
		boolean disponible =nparqueadero.disponibilidadParqueaderoMotos(numMaxMoto);
		
		//Assert
		
		assertTrue(disponible);
				
	}
}
