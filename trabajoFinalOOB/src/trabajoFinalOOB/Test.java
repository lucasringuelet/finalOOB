package trabajoFinalOOB;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Test {
	public static void main(String[] args){
		Coordinador coor1=new Coordinador("juan",123456,221477,123);
		Coordinador coor2=new Coordinador("pepe",42095,221522,321);
		Sistema sistema = new Sistema(coor1,coor2);
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		// donantes :
		
		double numDonante1=sistema.altaDonante("lucas",Math.random()*7,Math.random()*5,Math.random()*3);
		double numDonante2=sistema.altaDonante("martin",Math.random()*7,Math.random()*5,Math.random()*3);
		double numDonante3=sistema.altaDonante("flor",Math.random()*7,Math.random()*5,Math.random()*3);
		double numDonante4=sistema.altaDonante("alex",Math.random()*7,Math.random()*5,Math.random()*3);
		
		
		// Organizaciones :
		sistema.altaOrg("mcdonalds","donald","calle 7 ");
		sistema.altaOrg("cocacola","antonio","calle 13  ");
		sistema.altaOrg("pepsi","pedro","calle 25 ");
		
		sistema.agregarDonanteAOrg("mcdonalds", numDonante1);
		sistema.agregarDonanteAOrg("mcdonalds", numDonante2);
		sistema.agregarDonanteAOrg("cocacola", numDonante3);
		
		
		Date fecha= new Date();
		//pago
		boolean pagoExitoso1 = sistema.pago(numDonante1,fecha , "efectivo", 1500, "pepe");
		boolean pagoExitoso2 = sistema.pago(numDonante2,fecha , "transferencia bancaria", 200, "juan");
		boolean pagoExitoso3 = sistema.pago(numDonante3,fecha , "pago facil", 1000, "pepe");
		boolean pagoExitoso4 = sistema.pago(numDonante4,fecha , "pago facil", 200, "juan");
		
		System.out.println("el donante: "+numDonante1+" el pago fue: "+ pagoExitoso1 );
		System.out.println("el donante: "+numDonante2+" el pago fue: "+ pagoExitoso2 );
		System.out.println("el donante: "+numDonante3+" el pago fue: "+ pagoExitoso3 );
		System.out.println("el donante: "+numDonante4+" el pago fue: "+ pagoExitoso4 );
		
		
		// totales: 
		System.out.println("total independientemente de la organizacion del mes 10: ");
		System.out.println(sistema.saberTotalMesIndependiente(10));
		
		System.out.println("total de la organizacion mcdonalds en el mes 10: ");
		System.out.println(sistema.totalMesDeOrganizacion(10,"mcdonalds"));
		
		System.out.println("todos los donantes del mes 10: ");
		ArrayList<Donante> donantes= sistema.donantesDeUnMes(10);
		for(Donante d: donantes) {
			System.out.println(d.getNombre());
		}
		
		System.out.println("todas las donaciones del mes 10: ");
		ArrayList<Donacion> donaciones= sistema.donacionesDeUnMes(10);
		for(Donacion d: donaciones) {
			System.out.println(d.getDonante().getNombre()+" "+ d.getMonto());
		}
		
		System.out.println("todas las donaciones de" + numDonante1+ " en el año: "+ fecha.getYear());
		ArrayList<Donacion> donacionesAux= sistema.donacionesDeUnDonanteEnUnAño(numDonante1, fecha.getYear());
		for(Donacion d: donacionesAux) {
			System.out.println(d.getDonante().getNombre()+" "+ d.getMonto());
		}
		
		System.out.println("donantes y donaciones de una organizacion en la fecha: "+ fecha);
		ArrayList<DonanteYDonacion> dYD= sistema.donanteYDonacionesSegunFechaDeUnaOrg("mcdonalds", fecha);
		for(DonanteYDonacion dd: dYD) {
			System.out.println(dd.getDonante()+" "+ dd.getDonacion());
		}
		
		//problema con las fechas
		Date fecha1= new Date(12,2,3);
		Date fecha2= new Date(1030,2,3);
		System.out.println("monto recibido entre "+ fecha1+ " y "+ fecha2);
		System.out.println(sistema.montoRecibidoEntreFechas(fecha1, fecha2));
		
		System.out.println("insertar monto necesitado para la emergencia");
		double montoEmergencia =in.nextDouble();
		sistema.emergencia(montoEmergencia);
		
		
		
		
	}
}
