package BaseDatos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import gestorAplicacion.*;
import java.util.ArrayList;

//import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



public class EscritorJson {
	static JSONObject obj;
	static JSONArray listaOperarios = new JSONArray();
	static JSONArray listaClientes = new JSONArray();
        static JSONArray listaProductos = new JSONArray();
	//static JSONArray catalogo = new JSONArray(); SI VAMOS A HACER LO QUE USTE DICE DE VARIOS CATALOGOS NECESITARIAMOS ESTA LISTA
	static JSONArray listaServiciosPublicos = new JSONArray();
        
	
	//"CONSTRUCTORES"
	static public void agregarPersona(JSONObject obj, String cedula, String nombre, int edad, String telefono, String direccion) {
		obj.put("cedula",cedula);
		obj.put("nombre",nombre);
		obj.put("edad",edad);
		obj.put("telefono",telefono);
		obj.put("direccion",direccion);
	}
	
	static public void crearCliente(int estrato, String cedula, String nombre, int edad, String telefono, String direccion, ServiciosPublicos luz, ServiciosPublicos acueducto, ServiciosPublicos alcantarillado, ServiciosPublicos gas, ArrayList<Producto> listaProducto) {
		obj = new JSONObject();
                agregarPersona(obj,cedula,nombre,edad,telefono,direccion);
		obj.put("estrato", estrato);
                obj.put("luz", luz);
                obj.put("agua", acueducto);
                obj.put("acueducto", alcantarillado) ;
                obj.put("gas", gas);
                obj.put("productos", listaProducto);
		
		listaClientes.add(obj);
	}
	
	public static void crearServiciosPublicos(String nombre, int precioFijo, double consumo, Date fecha) {
		obj = new JSONObject();
		obj.put("nombre", nombre);
		obj.put("precioFijo", precioFijo);
		obj.put("consumo", consumo);
		obj.put("fecha", fecha);
		listaServiciosPublicos.add(obj);
	}
        public static void crearProducto(String nombre, int costo, String garantia){
           obj = new JSONObject();
           obj.put("nombre", nombre);
           obj.put("costo", costo);
           obj.put("garantia", garantia);
           listaProductos.add(obj);
        }
	static public void crearOperario( double gananciasGeneradas, String cedula,String nombre, int edad, String telefono, String direccion, ArrayList<Double> listaPuntuacion) {
		obj = new JSONObject();
		agregarPersona(obj,cedula,nombre,edad,telefono,direccion);
		obj.put("gananciasGeneradas", gananciasGeneradas);
                obj.put("puntuacion", listaPuntuacion);
		listaOperarios.add(obj);
	}

	// todavia no se como vamos a hacer lo de seguro de accidentes
		static public JSONObject crearSeguroAccidentes(String[] seguroAccidente) {
			obj = new JSONObject();
			for (String acc : seguroAccidente) {
				obj.put("seguro", acc);
			}
			return obj;
		}
	static public void guardarDatos(String dato) {
		switch(dato) {
		case "clientes":
			try{
				File dir = new File("documentos/clientes");
				dir.mkdirs();
				File temporal = new File(dir, "listaClientes.txt");
				temporal.createNewFile();
				FileWriter archivo = new FileWriter(temporal);
				archivo.write(listaClientes.toJSONString());
				archivo.flush();
				archivo.close();
			}catch(IOException e) {
				System.out.println(e.getMessage());
			}
			break;
		case "operarios":
			try {
				File dir = new File("documentos/operarios");
				dir.mkdir();
				File temporal = new File(dir, "listaOperarios.txt");
				temporal.createNewFile();
				FileWriter archivo = new FileWriter(temporal);
				archivo.write(listaOperarios.toJSONString());
				archivo.flush();
				archivo.close();
			}catch(IOException e) {
				System.out.println(e.getMessage());
			}
			break;
		/*case "catalogo":
			try {
				File dir = new File("documentos/catalogo");
				dir.mkdir();
				File temporal = new File(dir, "catalogo.txt");
				temporal.createNewFile();
				FileWriter archivo = new FileWriter(temporal);
				archivo.write(catalogo.toJSONString());
				archivo.flush();
				archivo.close();
			}catch(IOException e) {
				System.out.println(e.getMessage());
			}
			break;
			*/
		case "productos":
			try {
				File dir = new File("documentos/productos");
				dir.mkdir();
				File temporal = new File(dir, "listaProductos.txt");
				temporal.createNewFile();
				FileWriter archivo = new FileWriter(temporal);
				archivo.write(listaProductos.toJSONString());
				archivo.flush();
				archivo.close();
			}catch(IOException e) {
				System.out.println(e.getMessage());
			}
			break;
		}
		
	}
	
	
	
	
}
