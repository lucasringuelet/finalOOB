package trabajoFinalOOB;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Sistema {
	public Organizacion org;
	public Donante donante;
	public Coordinador coor;
	public Donacion donacion;
	public MedioPago medioPago;
	public double pozo;
	
	public List<Organizacion> coleccionOrganizacion = new ArrayList<Organizacion>();
	public List<Donante> coleccionDonantes = new ArrayList<Donante>();
	public List<Coordinador> coleccionCoordinador = new ArrayList<Coordinador>();
	public List<Donacion> coleccionDonacion = new ArrayList<Donacion>();
	public List<MedioPago> coleccionMedioPago = new ArrayList<MedioPago>();
	
	public void hacerDonacion(Coordinador c, Donante donante, Organizacion org, Donacion donacion, MedioPago medio ) {
		Scanner in = new Scanner(System.in);
		//info donante:
		String nom=in.nextLine();
		int dni= in.nextInt();
		int tel=in.nextInt();
		int leg=in.nextInt();
		this.donante=new Donante(nom,dni,tel,leg);
		//info org:
		String deno=in.nextLine();
		String repre=in.nextLine();
		String direc=in.nextLine();
		this.org= new Organizacion(deno,repre,direc,this.donante);
		//info 
	}
	
	
}
