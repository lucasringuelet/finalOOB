package trabajoFinalOOB;

public class Donante {
	private String nombre;
	private double dni ;
	private double telefono;
	private double legajo;
	private double numDonante;
	public Donante(String n, double d, double e, double f) {
		this.setNombre(n);
		this.setDni(d);
		this.setTelefono(e);
		this.setLegajo(f);
		this.generarNumeroDonante();
	}
	
	public double getNumDonante() {
		return numDonante;
	}

	private void generarNumeroDonante() {
		this.numDonante=Math.random()*100+1;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getDni() {
		return dni;
	}
	public void setDni(double dni) {
		this.dni = dni;
	}
	public double getTelefono() {
		return telefono;
	}
	public void setTelefono(double telefono) {
		this.telefono = telefono;
	}
	public double getLegajo() {
		return legajo;
	}
	public void setLegajo(double legajo) {
		this.legajo = legajo;
	}
	
	
	
	
}
