package com.co.ceiba.parqueadero.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Moto{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String placa;
	private int cilindraje;
	
	public Moto(long id, String placa, int cilindraje) {
		super();
		this.id = id;
		this.placa = placa;
		this.cilindraje = cilindraje;
	}
	
	public Moto() {
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public int getCilindraje() {
		return cilindraje;
	}
	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}
	
		
	
}
