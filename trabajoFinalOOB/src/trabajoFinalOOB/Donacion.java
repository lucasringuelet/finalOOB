package trabajoFinalOOB;

public class Donacion {
	private String fecha;
	private double monto;
	private Organizacion organizacion;
	private Donante donante;
	private Coordinador coordinador;
	private MedioPago medioPago;
	
	
	
	
	public Donacion(String fecha, double monto, Organizacion organizacion, Donante donante, Coordinador coordinador,
			MedioPago medioPago) {
		super();
		this.fecha = fecha;
		this.monto = monto;
		this.organizacion = organizacion;
		this.donante = donante;
		this.coordinador = coordinador;
		this.medioPago = medioPago;
	}
	
	public String getFecha() {
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
	
	public Coordinador getCoordinador() {
		return coordinador;
	}
	
	public MedioPago getMedioPago() {
		return medioPago;
	}
	
	
	
	
}
