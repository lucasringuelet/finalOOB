package trabajoFinalOOB;

import java.util.ArrayList;
import java.util.List;

public class Organizacion {
	private String denominacion;
	private String representante;
	private String direccion;
	private List<Donante> coleccionDonantes = new ArrayList<Donante>();
	
	public Organizacion(String denominacion,String repre,String direc) {
		this.setDenominacion(denominacion);
		this.setRepresentante(repre);
		this.setDireccion(direc);
	}
	
	public boolean pertenece(Donante donante) {
		
		return this.coleccionDonantes.contains(donante);
	}
	
	
	public String getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	public String getRepresentante() {
		return representante;
	}
	public void setRepresentante(String representante) {
		this.representante = representante;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void agregarDonante(Donante d) {
		coleccionDonantes.add(d);
	}
	
	
}
