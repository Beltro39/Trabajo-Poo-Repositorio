package gestorAplicacion;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ServiciosPublicos {
	String nombre;
	int costoFijo;
	double consumo;
	Date fecha;
	DateTimeFormatter miFormatoFechas = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public ServiciosPublicos(String nombre, int costoFijo, double consumo, String fecha){
		this.nombre = nombre;
		this.costoFijo = costoFijo;
		this.consumo = consumo;
		try {
		this.fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
		}catch(Exception e) {
			System.out.println("fecha no válida");
		}
		
	}
}
