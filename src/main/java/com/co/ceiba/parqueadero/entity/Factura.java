package com.co.ceiba.parqueadero.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Ingreso idingreso;
	private Calendar fechaSalida;
	private double costo;

	public Factura() {
	}

	public Factura(Long id, Ingreso idingreso, Calendar fechaSalida, double costo) {
		this.id = id;
		this.idingreso = idingreso;
		this.fechaSalida = fechaSalida;
		this.costo = costo;
	}

	public Ingreso getIdingreso() {
		return idingreso;
	}

	public void setIdingreso(Ingreso idingreso) {
		this.idingreso = idingreso;
	}

	public Long getId() {
		return id;
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
