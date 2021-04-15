package com.experis.springboot.app.clientes.models.request;

public class KpiClientesRequest {
	private double promedio;
	private double desviacion;
	public double getPromedio() {
		return promedio;
	}
	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
	public double getDesviacion() {
		return desviacion;
	}
	public void setDesviacion(double desviacion) {
		this.desviacion = desviacion;
	}
}
