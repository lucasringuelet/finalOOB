package trabajoFinalOOB;

import java.util.Date;

public class Donacion {
	private Date fecha;
	private double monto;
	private Organizacion organizacion;
	private Donante donante;
	
	
	
	
	public Donacion(Date fecha, double monto, Organizacion organizacion, Donante donante) {
		super();
		this.fecha = fecha;
		this.monto= monto;
		this.organizacion = organizacion;
		this.donante = donante;
		
	}
	
	
	public Date getFecha() {
		return fecha;
	}
	
	public double getMonto() {
		return monto;
	}
	
	public Organizacion getOrganizacion() {
		return organizacion;
	}
	
	public Donante getDonante() {
		return donante;
	}
	
	
	
	
	
}
