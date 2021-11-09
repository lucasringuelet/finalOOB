package trabajoFinalOOB;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Sistema {
	
	private List<Organizacion> coleccionOrganizacion = new ArrayList<Organizacion>();
	private List<Donante> coleccionDonantes = new ArrayList<Donante>();
	private List<Donacion> coleccionDonacion = new ArrayList<Donacion>();
	private double pozo=0;
	private Coordinador coordinadores[]= new Coordinador[2];
	
	public Sistema(Coordinador coor1, Coordinador coor2) {
		this.coordinadores[0]=coor1;
		this.coordinadores[1]=coor2;
	}
	

	public double altaDonante(String nom,double dni, double tel, double leg) {
		Donante donante = new Donante(nom,dni,tel,leg);
		this.coleccionDonantes.add(donante);
		return donante.getNumDonante();
	}
	public void agregarDonanteAOrg(String nomOrg, double numDonante) {
		Donante aux = null;
		for(Donante d: this.coleccionDonantes) {
			if(d.getNumDonante()==numDonante) {
				aux=d;
				break;
			}
		}
		Organizacion org = null;
		for(Organizacion o: this.coleccionOrganizacion) {
			
			if(o.getDenominacion().equalsIgnoreCase(nomOrg)) {
				org=o;
				break;
			}
		}
		org.agregarDonante(aux);
		
		
		
	}
	
	private void agregarDonacionACoordinador(String nomCoordinador,Donacion donacion) {
		if(this.coordinadores[0].getNombre()==nomCoordinador) {
			this.coordinadores[0].recibirDonacion(donacion);
		}else {
			if(this.coordinadores[1].getNombre()==nomCoordinador) {
				this.coordinadores[1].recibirDonacion(donacion);
			}else {
				System.out.println("el nombre del coordinador no es correcto");
			}
		}

	}
	
	public boolean pago(double numDonante, Date fecha, String formaPago, double monto,String nomCoordinador) {
		boolean realizado=false;
		//me fijo que el donante este en el sistema, si no esta devuelvo false porque no esta en el sistema o el numero de donante es incorrecto
		boolean ok = false;
		Donante donante = null;
		for(Donante d: this.coleccionDonantes) {
			if(d.getNumDonante()==numDonante) {
				donante = d;
				ok=true;
				break;
			}
		}
		//una vez que se que el donante esta en el sistema quiero ver si esta en alguna organizacion
		if(ok) {
			List<Organizacion> coleccionOrganizacionAux = new ArrayList<Organizacion>();
			for(Organizacion org: this.coleccionOrganizacion) {
				if(org.pertenece(donante)) {
					coleccionOrganizacionAux.add(org);
					
				}
			}
			//si la coleccion esta vacia quiere decir que el donante no esta en ninguna organizacion
			if(!coleccionOrganizacionAux.isEmpty()) {
				double nuevoMonto= monto/coleccionOrganizacionAux.size();
				MedioPago medio = new MedioPago(formaPago,nuevoMonto);
				
				for(Organizacion org: coleccionOrganizacionAux) {
					Donacion donacion= new Donacion(fecha,medio.saberMontoReal(),org,donante);
					this.agregarDonacionACoordinador(nomCoordinador, donacion);
					this.coleccionDonacion.add(donacion);
					realizado=true;
				}
			}else//si el donante no tiene ninguna organizacion, se desina al pozo 
				{
				Organizacion org=new Organizacion("Donacion general","Donacion general","Donacion general");
				MedioPago medio = new MedioPago(formaPago,monto);
				
				Donacion donacion= new Donacion(fecha,medio.saberMontoReal(),org,donante);
				this.coleccionDonacion.add(donacion);
				this.agregarDonacionACoordinador(nomCoordinador, donacion);
				this.pozo+=medio.saberMontoReal();
				realizado=true;
			}
			
		}
		return realizado;
	}
	public void altaOrg(String deno, String repre,String direc) {
		Organizacion org= new Organizacion(deno,repre,direc);
		this.coleccionOrganizacion.add(org);
	}
	
	
	//totales:
	
	public double saberTotalMesIndependiente(int mes){
		double tot = this.coordinadores[0].totalIndependiente(mes) + this.coordinadores[1].totalIndependiente(mes);
		return tot;
	}
	public double totalMesDeOrganizacion(int mes, String denominacion) {
		double tot = this.coordinadores[0].totalPorMesParaUnaOrganizacion(mes, denominacion) + this.coordinadores[1].totalPorMesParaUnaOrganizacion(mes, denominacion);
		return tot;
	}
	public ArrayList<Donante> donantesDeUnMes(int mes){//puedo devolver la lista sin instanciarla (sin hacer el new)?
		ArrayList<Donante> listaAux= new ArrayList<Donante>(this.coordinadores[0].donantesSegunMes(mes));
		listaAux.addAll(this.coordinadores[1].donantesSegunMes(mes));
		return listaAux;
		
	}
	public ArrayList<Donacion> donacionesDeUnMes(int mes){
		ArrayList<Donacion> listaAux= new ArrayList<Donacion>(this.coordinadores[0].donacionesSegunMes(mes));
		listaAux.addAll(this.coordinadores[1].donacionesSegunMes(mes));
		return listaAux;
	}
	public ArrayList<Donacion> donacionesDeUnDonanteEnUnAño(double numDonante, int año){
		ArrayList<Donacion> listaAux= new ArrayList<Donacion>(this.coordinadores[0].donacionesParaAñoDeUnDonante(numDonante,año));
		listaAux.addAll(this.coordinadores[1].donacionesParaAñoDeUnDonante(numDonante, año));
		return listaAux;
	}
	public ArrayList<DonanteYDonacion> donanteYDonacionesSegunFechaDeUnaOrg(String nomOrg,Date fecha){
		ArrayList<DonanteYDonacion> listaAux= new ArrayList<DonanteYDonacion>(this.coordinadores[0].donanteYDonacionesSegunFechaDeUnaOrg(nomOrg,fecha));
		listaAux.addAll(this.coordinadores[1].donanteYDonacionesSegunFechaDeUnaOrg(nomOrg,fecha));
		return listaAux;
	}
	public double montoRecibidoEntreFechas(Date fecha1, Date fecha2) {
		return (this.coordinadores[0].montoRecibidoEntreFechas(fecha1, fecha2)+this.coordinadores[1].montoRecibidoEntreFechas(fecha1, fecha2));
		
	}
	public void emergencia(double montoNecesitado) {
		
		if(this.pozo<montoNecesitado) {
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			double auxTotal=montoNecesitado-this.pozo;
			double auxMonto=auxTotal/this.coleccionDonantes.size();
			String siNo;
			System.out.println("monto que tiene que pagar cada uno: "+ auxMonto);
			for(Donante d: this.coleccionDonantes) {
				System.out.println(d.getNombre()+" puede Pagar?");
				siNo=in.nextLine();
				if(siNo.equalsIgnoreCase("si")) {
					Organizacion org=new Organizacion("Donacion general","Donacion general","Donacion general");
					Date fecha=new Date();
					Donacion donacion = new Donacion(fecha,auxMonto,org,d);
					this.coleccionDonacion.add(donacion);
					this.pozo+=auxMonto;
				}
			}
			
			System.out.println("el pozo es de: "+this.pozo);
		}
	}


	
	
}
