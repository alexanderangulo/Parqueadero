package com.co.ceiba.parqueadero.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ParqueaderoCarro {
	private Long id;
	private Carro carro;
	private Date fechaIngreso;

	public ParqueaderoCarro(Long id, Carro carro, Date fechaIngreso) {
		super();
		this.id = id;
		this.carro = carro;
		this.fechaIngreso = fechaIngreso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

}
