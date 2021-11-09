package trabajoFinalOOB;

public class MedioPago {
	private String tipo;
	private double comision;
	private double monto;
	public MedioPago(String tipo, double monto) {
		this.tipo=tipo;
		this.monto=monto;
	}
	public String getTipo() {
		return tipo;
	}
	public double getComision() {
		return comision;
	}
	
	public double saberMontoReal() {
		if(this.tipo.equalsIgnoreCase("efectivo")) {
			this.comision=this.monto;
		}else {
			if(this.tipo.equalsIgnoreCase("transferencia bancaria")) {
				this.comision=((10*this.monto)/100);
				
			}else {
				if(this.tipo.equalsIgnoreCase("pago facil")) {
					this.comision=((15*this.monto)/100);
				}
			}//si se necesitan mas medios de pago se agregan mas if (una mejora podria ser utilizar case)
		}
		return getComision();
	}
	
}
