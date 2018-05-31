package com.co.ceiba.parqueadero.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Carro implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String placa;
	
	public Carro() {
		super();
	}
	
	public Carro(Long id, String placa) {
		super();
		this.id = id;
		this.placa = placa;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}

}
