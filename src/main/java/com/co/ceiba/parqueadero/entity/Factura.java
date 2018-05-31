package com.co.ceiba.parqueadero.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Factura {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private long idingreso;
	private Calendar fechaSalida;
	private double costo;
	
	public Factura(long id, long idingreso, Calendar fechaSalida, double costo) {
		this.id = id;
		this.idingreso = idingreso;
		this.fechaSalida = fechaSalida;
		this.costo = costo;
	}

	public Factura() {
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getIdingreso() {
		return idingreso;
	}


	public void setIdingreso(long idingreso) {
		this.idingreso = idingreso;
	}


	public Calendar getFechaSalida() {
		return fechaSalida;
	}


	public void setFechaSalida(Calendar fechaSalida) {
		this.fechaSalida = fechaSalida;
	}


	public double getCosto() {
		return costo;
	}


	public void setCosto(double costo) {
		this.costo = costo;
	}
}
