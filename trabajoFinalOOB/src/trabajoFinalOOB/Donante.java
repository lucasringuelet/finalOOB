package trabajoFinalOOB;

public class Donante {
	private String nombre;
	private int dni ;
	private int telefono;
	private int legajo;
	
	public Donante(String n, int dni, int tel, int leg) {
		this.setNombre(n);
		this.setDni(dni);
		this.setTelefono(tel);
		this.setLegajo(leg);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	
	
	
	
}
