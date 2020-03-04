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
import gestorAplicacion.ServiciosPublicos;

abstract public class LectorJson {
	public static ArrayList<Operario> operariosGuardados = new ArrayList<Operario>();
	public static ArrayList<Cliente> clientesGuardados;
	public static ArrayList<ServiciosPublicos> serviciosPublicosGuardados;
	
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
		tmp = new File(dir, "operarios.json");
		lector = new FileReader(tmp);
		obj = jsonParser.parse(lector);
		EscritorJson.listaOperarios = (JSONArray) obj;
		EscritorJson.listaOperarios.forEach(operario -> parseOperarioObject((JSONObject) operario));
		lector.close();
		//IOException ParseException
		// lee clientes
		dir = new File("documentos/clientes");
		dir.mkdirs();
		tmp = new File(dir, "clientes.json");
		lector = new FileReader(tmp);
		obj = jsonParser.parse(lector);
		EscritorJson.listaClientes = (JSONArray) obj;
		EscritorJson.listaClientes.forEach(cliente -> parseClienteObject((JSONObject) cliente));

		//lee servicios publicos
		dir = new File("documentos/serviciosPublicos");
		dir.mkdirs();
		tmp = new File(dir, "serviciosPublicos.json");
		lector = new FileReader(tmp);
		obj = jsonParser.parse(lector);
		EscritorJson.listaServiciosPublicos = (JSONArray) obj;
		EscritorJson.listaServiciosPublicos.forEach(servicio -> parseServicioObject((JSONObject) servicio));
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
		int saldo = (int) cliente.get("saldo");
		clientesGuardados.add(new Cliente(estrato,saldo,cedula,nombre,edad,telefono,direccion));
		}catch(JSONException e) {
			System.out.println(e.getStackTrace());
		}
	}
	private static void parseServicioObject(JSONObject servicio){
		String nombre = (String) servicio.get("nombre");
		int costoFijo = (int) servicio.get("costoFijo");
		double consumo = (double) servicio.get("consumo");
		String fecha = (String) servicio.get("fecha");
		serviciosPublicosGuardados.add(new ServiciosPublicos(nombre,costoFijo,consumo,fecha));
	}

}

