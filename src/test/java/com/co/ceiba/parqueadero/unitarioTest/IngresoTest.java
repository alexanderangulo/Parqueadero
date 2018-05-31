package com.co.ceiba.parqueadero.unitarioTest;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.co.ceiba.parqueadero.business.IngresoBusiness;
import com.co.ceiba.parqueadero.entity.Ingreso;

@SpringBootTest
public class IngresoTest {

	@Test
	public void ingresoCarrosTest (){
		//Arrange
		long id=1;
		int tipoVehiculo= 1;
		Calendar fechaIngre= Calendar.getInstance();
		String placa="ABC123";
		int cilindraje =-1;
		
		//Act
		Ingreso ingreso = new Ingreso(id, fechaIngre,tipoVehiculo,placa,cilindraje);
		
		//Assert
		Assert.assertNotNull(ingreso);
	}
	
	@Test
	public void verificarDiaNoPermitidoPlacaATest() {
		
		//Arrange
		String placa="ABC133";
		Calendar fechaIngre = new GregorianCalendar(2018,4,27,13,24,56);
		IngresoBusiness ningreso = new IngresoBusiness();
		
		//Act
		boolean diaNoPermitido = ningreso.validarDiaIngreso(fechaIngre, placa);

		//Assert
		assertTrue(diaNoPermitido);
	}
	
	@Test
	public void verificarDiaPermitidoPlacaATest() {
		//Arrange
				
				String placa="BAC133";
				Calendar fechaIngre = new GregorianCalendar(2018,4,27,13,24,56);
				IngresoBusiness ningreso = new IngresoBusiness();
					
		//Act
				boolean diaPermitido =ningreso.validarDiaIngreso(fechaIngre, placa);

		//Assert
				Assert.assertFalse(diaPermitido);
					
	}
}
