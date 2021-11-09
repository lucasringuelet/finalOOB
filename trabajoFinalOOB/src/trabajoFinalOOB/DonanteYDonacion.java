package trabajoFinalOOB;

public class DonanteYDonacion {
	private String donante;
	private double donacion;
	
	public DonanteYDonacion(String donante,double donacion) {
		this.donacion=donacion;
		this.donante=donante;
	}

	public String getDonante() {
		return donante;
	}

	public double getDonacion() {
		return donacion;
	}
	
	
}
