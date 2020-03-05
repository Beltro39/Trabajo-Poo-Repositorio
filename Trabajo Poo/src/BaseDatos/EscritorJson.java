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
	static JSONArray listaProductos = new JSONArray();
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
                agregarPersona(obj,cedula,nombre,edad,telefono,direccion);
		obj.put("estrato", estrato);
        obj.put("luz", luz);
        obj.put("agua", acueducto);
        obj.put("acueducto", alcantarillado) ;
        obj.put("gas", gas);
		
		listaClientes.add(obj);
	}
	
        public static void crearProducto(String nombre, int costo, String garantia){
           obj = new JSONObject();
           obj.put("nombre", nombre);
           obj.put("costo", costo);
           obj.put("garantia", garantia);
           listaProductos.add(obj);
           
        }
	static public void crearOperario( double gananciasGeneradas, String cedula,String nombre, int edad, String telefono, String direccion) {
		obj = new JSONObject();
		agregarPersona(obj,cedula,nombre,edad,telefono,direccion);
		obj.put("gananciasGeneradas", gananciasGeneradas);
		listaOperarios.add(obj);
	}

	static public void guardarDatos() {
		//guarda los clientes
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
			//guarda los operarios
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
			//guarda los productos

			try {
				File dir = new File("documentos/productos");
				dir.mkdir();
				File temporal = new File(dir, "productos.txt");
				temporal.createNewFile();
				FileWriter archivo = new FileWriter(temporal);
				archivo.write(listaProductos.toJSONString());
				archivo.flush();
				archivo.close();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
				
}
