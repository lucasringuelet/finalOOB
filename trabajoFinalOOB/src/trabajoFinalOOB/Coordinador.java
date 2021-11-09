package trabajoFinalOOB;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Coordinador extends Donante {
	private List<Donacion> coleccionDonacion = new ArrayList<Donacion>();
	public Coordinador(String n, int dni, int tel, int leg) {
		super(n, dni, tel, leg);
		// TODO Auto-generated constructor stub
		
	}
	
	public boolean soyYo(String nom) {
		return this.getNombre().equalsIgnoreCase(nom);
	}
	
	//recibir donacion
	public void recibirDonacion(Donacion d) {
		this.coleccionDonacion.add(d);
	}
	
	//ingreso totales por mes independientemente de la organizacion
	@SuppressWarnings("deprecation")
	public double totalIndependiente(int mes) {
		double tot = 0;
		if(!this.coleccionDonacion.isEmpty()) {
			List<Donacion> filter = new ArrayList<Donacion>(); 
			filter.addAll(this.coleccionDonacion);
			filter.removeIf(d -> d.getFecha().getMonth()!=mes);
			
			for(Donacion d: filter) {
				tot+=d.getMonto();
			}
		}
		
		return tot;
	}
	//ingreso totales por mes dependiendo cada organizacion:
	@SuppressWarnings("deprecation")
	public double totalPorMesParaUnaOrganizacion(int mes, String denominacion) {
		double tot = 0;
		if(!this.coleccionDonacion.isEmpty()) {
			List<Donacion> filter = new ArrayList<Donacion>(); 
			filter.addAll(this.coleccionDonacion);
			filter.removeIf(d -> d.getFecha().getMonth()!=mes);
			filter.removeIf(d -> d.getOrganizacion().getDenominacion()!=denominacion);
			for(Donacion d: filter) {
				tot+=d.getMonto();
			}
		}
		
		return tot;
	}
	//donantes de un mes particular
	@SuppressWarnings("deprecation")
	public ArrayList<Donante> donantesSegunMes (int mes){
		List<Donante> listaDonantes = new ArrayList<Donante>(); 
		if(!this.coleccionDonacion.isEmpty()) {
			List<Donacion> filter = new ArrayList<Donacion>(); 
			filter.addAll(this.coleccionDonacion);
			filter.removeIf(d -> d.getFecha().getMonth()!=mes);
			
			for(Donacion d: filter) {
				listaDonantes.add(d.getDonante());
			}
			
		}
		return (ArrayList<Donante>) listaDonantes;
	}
	//donaciones de un mes particular
	@SuppressWarnings("deprecation")
	public ArrayList<Donacion> donacionesSegunMes (int mes){
		List<Donacion> filter = new ArrayList<Donacion>();
		if(!this.coleccionDonacion.isEmpty()) {
			 
			filter.addAll(this.coleccionDonacion);
			filter.removeIf(d -> d.getFecha().getMonth()!=mes);
			
			
		}
		return (ArrayList<Donacion>) filter;
	}
	@SuppressWarnings("deprecation")
	public ArrayList<Donacion> donacionesParaAñoDeUnDonante (double numDonante,int año){
		List<Donacion> filter = new ArrayList<Donacion>();
		if(!this.coleccionDonacion.isEmpty()) {
			 
			filter.addAll(this.coleccionDonacion);
			filter.removeIf(d -> d.getDonante().getNumDonante()!=numDonante);
			filter.removeIf(d -> d.getFecha().getYear()!=año);
		}
		return (ArrayList<Donacion>) filter;
	}
	
	public ArrayList<DonanteYDonacion> donanteYDonacionesSegunFechaDeUnaOrg(String nomOrg, Date fecha){
		List<DonanteYDonacion> listAux = new ArrayList<DonanteYDonacion>();
		if(!this.coleccionDonacion.isEmpty()) {
			for(Donacion d: this.coleccionDonacion) {
				if((d.getFecha().equals(fecha))&&(d.getOrganizacion().getDenominacion().equalsIgnoreCase(nomOrg))) {
					DonanteYDonacion dYd=new DonanteYDonacion(d.getDonante().getNombre(),d.getMonto());
					listAux.add(dYd);
				}
				
			}
		}
		return (ArrayList<DonanteYDonacion>) listAux;
	}
	
	public double montoRecibidoEntreFechas(Date fecha1, Date fecha2) {
		double monto=0;
		List<Donacion> filter = new ArrayList<Donacion>();
		if(!this.coleccionDonacion.isEmpty()) {
			 
			filter.addAll(this.coleccionDonacion);
			filter.removeIf(d -> d.getFecha().after(fecha1) || d.getFecha().before(fecha2));
			for(Donacion d: filter) {
				monto+=d.getMonto();
			}
		}
		return monto;
	}
	
}
