package trabajoFinalOOB;

public class Coordinador extends Donante {
	private Donacion donacion;
	public Coordinador(String n, int dni, int tel, int leg, Donacion don) {
		super(n, dni, tel, leg);
		// TODO Auto-generated constructor stub
		this.donacion=don;
	}
	
	//recibir donacion
}
