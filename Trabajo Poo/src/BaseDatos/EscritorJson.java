package BaseDatos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import gestorAplicacion.*;

//import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



public class EscritorJson {
	static JSONObject obj;
	static JSONArray listaOperarios = new JSONArray();
	static JSONArray listaClientes = new JSONArray();
	static JSONArray catalogoCantidad = new JSONArray();
	static JSONArray catalogoPrecio = new JSONArray();
	static JSONArray listaServiciosPublicos = new JSONArray();
	
	
	//"CONSTRUCTORES"
	static public void agregarPersona(JSONObject obj, String cedula, String nombre, int edad, String telefono, String direccion) {
		obj.put("cedula",cedula);
		obj.put("nombre",nombre);
		obj.put("edad",edad);
		obj.put("telefono",telefono);
		obj.put("direccion",direccion);
	}
	
	static public void crearCliente(int estrato, String cedula, String nombre, int edad, String telefono, String direccion, ServiciosPublicos luz, ServiciosPublicos acueducto, ServiciosPublicos alcantarillado, ServiciosPublicos gas) {
		obj = new JSONObject();
		obj.put("estrato", estrato);
                obj.put("luz", luz);
                obj.put("agua", acueducto);
                obj.put("acueducto", alcantarillado) ;
                obj.put("gas", gas);

		agregarPersona(obj,cedula,nombre,edad,telefono,direccion);
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
	static public void crearOperario(double gananciasGeneradas, String cedula,String nombre, int edad, String telefono, String direccion) {
		obj = new JSONObject();
		agregarPersona(obj,cedula,nombre,edad,telefono,direccion);
		obj.put("gananciasGeneradas", gananciasGeneradas);
		listaOperarios.add(obj);
	}
	static public void crearProductoCatalogo() {
		catalogoCantidad.
	}

	static public void guardarDatos() {
			try{
				File dir = new File("documentos/clientes");
				dir.mkdirs();
				File temporal = new File(dir, "clientes.json");
				temporal.createNewFile();
				FileWriter archivo = new FileWriter(temporal);
				archivo.write(listaClientes.toJSONString());
				archivo.flush();
				archivo.close();
				listaClientes.clear();
			}catch(IOException e) {
				System.out.println(e.getMessage());
			}try {
				File dir = new File("documentos/operarios");
				dir.mkdir();
				File temporal = new File(dir, "operarios.json");
				temporal.createNewFile();
				FileWriter archivo = new FileWriter(temporal);
				archivo.write(listaOperarios.toJSONString());
				archivo.flush();
				archivo.close();
				listaOperarios.clear();
			}catch(IOException e) {
				System.out.println(e.getMessage());
			}
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
			try {
				File dir = new File("documentos/serviciosPublicos");
				dir.mkdir();
				File temporal = new File(dir, "serviciosPublicos.json");
				temporal.createNewFile();
				FileWriter archivo = new FileWriter(temporal);
				archivo.write(listaServiciosPublicos.toJSONString());
				archivo.flush();
				archivo.close();
				listaServiciosPublicos.clear();
			}catch(IOException e) {
				System.out.println(e.getMessage());
			}
			break;
		}
		
	}
	
	
	
	
}
