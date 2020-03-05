package BaseDatos;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import gestorAplicacion.Cliente;
import gestorAplicacion.Operario;
import gestorAplicacion.Producto;
import gestorAplicacion.ServiciosPublicos;

abstract public class LectorJson {
	public static ArrayList<Operario> operariosGuardados = new ArrayList<Operario>();
	public static ArrayList<Cliente> clientesGuardados = new ArrayList<Cliente>();
	
	public static void leerBaseDatos()throws JSONException{
		JSONParser jsonParser = new JSONParser();
		FileReader lector;
		File tmp;
		File dir;
		Object obj;
		
		//lee operarios
		try {
		dir = new File("documentos/operarios");
		dir.mkdirs();
		tmp = new File(dir, "operarios.txt");
		lector = new FileReader(tmp);
		obj = jsonParser.parse(lector);
		EscritorJson.listaOperarios = (JSONArray) obj;
		EscritorJson.listaOperarios.forEach(operario -> parseOperarioObject((JSONObject) operario));
		lector.close();
		
		// lee clientes
		dir = new File("documentos/clientes");
		dir.mkdirs();
		tmp = new File(dir, "clientes.txt");
		lector = new FileReader(tmp);
		obj = jsonParser.parse(lector);
		EscritorJson.listaClientes = (JSONArray) obj;
		EscritorJson.listaClientes.forEach(cliente -> parseClienteObject((JSONObject) cliente));

		//lee productos
		dir = new File("documentos/productos");
		dir.mkdirs();
		tmp = new File(dir, "productos.txt");
		lector = new FileReader(tmp);
		obj = jsonParser.parse(lector);
		EscritorJson.listaProductos = (JSONArray) obj;
		EscritorJson.listaProductos.forEach(servicio -> parseProducto((JSONObject) servicio));
	}catch(IOException e) {
		System.out.println(e.getStackTrace());
	} catch (org.json.simple.parser.ParseException e) {
		e.printStackTrace();
	}
	}
	//metodos para pasar de json a objetos
	private static void parseOperarioObject(JSONObject operario){
		try {
		String cedula = (String) operario.get("cedula");
		String nombre = (String) operario.get("nombre");
		int edad = (int) operario.get("edad");
		String telefono = (String) operario.get("telefono");
		String direccion = (String) operario.get("direccion");
		double gananciasGeneradas = (double) operario.get("gananciasGeneradas");
		operariosGuardados.add(new Operario(gananciasGeneradas,cedula,nombre,edad,telefono,direccion));
		}catch(JSONException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void parseClienteObject(JSONObject cliente){
		try {
		String cedula = (String) cliente.get("cedula");
		String nombre = (String) cliente.get("nombre");
		int edad = (int) cliente.get("edad");
		String telefono = (String) cliente.get("telefono");
		String direccion = (String) cliente.get("direccion");
		int estrato = (int) cliente.get("estrato");
		ServiciosPublicos luz = (ServiciosPublicos) cliente.get("luz");
		ServiciosPublicos acueducto = (ServiciosPublicos) cliente.get("acueducto");
		ServiciosPublicos alcantarillado = (ServiciosPublicos) cliente.get("alcantarillado");
		ServiciosPublicos gas  = (ServiciosPublicos) cliente.get("gas");
		
		clientesGuardados.add(new Cliente(cedula,nombre,edad,telefono,estrato,direccion,luz, acueducto,alcantarillado,gas));
		}catch(JSONException e) {
			System.out.println(e.getStackTrace());
		}
	}
	private static void parseProducto(JSONObject producto) {
		int costo = (int) producto.get("costo");
		String garantia = (String) producto.get("garantia"); 
		String nombre = (String) producto.get("nombre"); 
		Producto.listaProducto.add(new Producto(garantia,costo,nombre));
	}

}