package com.soap.demo.entity;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "vehiculos")
public class Vehiculo implements Serializable {
	
	@Serial
    private static final long serialVersionUID = -1359540121612959495L;
	
	@Id
    @Column(name = "placa")
    private String placa;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo", nullable = false)
    private int modelo;

    @Column(name = "precio", nullable = false)
    private long precio;

	public Vehiculo() {
		super();
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public long getPrecio() {
		return precio;
	}

	public void setPrecio(long precio) {
		this.precio = precio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	  public Long consultarSeguroTodoRiesgo() {
	        int anios = 2023 - this.modelo;
	        double valorSumar = anios * 100000; 
	        Long ValorSeguro = (long) (valorSumar + precio * 0.1);
	        return ValorSeguro;
	    }
    
}
