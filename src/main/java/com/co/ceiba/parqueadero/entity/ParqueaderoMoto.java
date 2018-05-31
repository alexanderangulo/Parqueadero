package com.co.ceiba.parqueadero.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ParqueaderoMoto {
	private Long id;
	private Date fechaIngreso;
	private Moto moto;
	
	public ParqueaderoMoto(Long id, Date fechaIngreso, Moto moto) {
		super();
		this.id = id;
		this.fechaIngreso = fechaIngreso;
		this.moto = moto;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	public Moto getMoto() {
		return moto;
	}
	public void setMoto(Moto moto) {
		this.moto = moto;
	}
	
	
}
