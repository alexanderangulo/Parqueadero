package com.co.ceiba.parqueadero.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Parqueadero {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private int contadorCarros;
	private int contadorMotos;

	public Parqueadero() {
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public int getContadorCarros() {
		return contadorCarros;
	}

	public void setContadorCarros(int contadorCarros) {
		this.contadorCarros = contadorCarros;
	}

	public int getContadorMotos() {
		return contadorMotos;
	}

	public void setContadorMotos(int contadorMotos) {
		this.contadorMotos = contadorMotos;
	}



}
