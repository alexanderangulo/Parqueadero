package com.co.ceiba.parqueadero.business;



public class ParqueaderoBusiness {
	 
	public static final int numMaxCarro=30;
	public static final int numMaxMoto=10;
		
		public int contadorDCarros(int contadorCarros) {			
			return ++contadorCarros;
	}
		public int restarCarros(int contadorCarros) {		
			return --contadorCarros;
	}
		public int contadorDMotos(int contadorMotos) {				
			return ++contadorMotos;
	}
		public int restarMotos(int contadorMotos) {		
			return --contadorMotos;
	}
				 
		public boolean disponibilidadParqueaderoCarros(int contadorCarros) {
			return (contadorCarros<=numMaxCarro);
	}
		
		
		public boolean disponibilidadParqueaderoMotos(int contadorMotos) {
			return (contadorMotos<=numMaxMoto);
	}
		
}
