package BaseDatos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EscritorJson {
	static JSONArray operarios = new JSONArray();
	static JSONObject obj;
	static JSONArray clientes = new JSONArray();
	static public void agregarPersona(JSONObject obj, String cedula, String nombre, int edad, String telefono, String direccion) {
		try {
		obj.put("cedula",cedula);
		obj.put("nombre",nombre);
		obj.put("edad",edad);
		obj.put("telefono",telefono);
		obj.put("direccion",direccion);
		}catch(JSONException e) {
			System.out.println("error, datos de persona no válidos "+ e.getMessage());
		}
	}
	
	static public void crearCliente(int estrato, int saldo, int añosServicio, String cedula, String nombre, int edad, String telefono, String direccion) {
		obj = new JSONObject();
		try {
			obj.put("estrato", estrato);
			obj.put("saldo", saldo);
			obj.put("añosServicio", añosServicio);
			agregarPersona(obj,cedula,nombre,edad,telefono,direccion);
			clientes.put(obj);
		}catch(JSONException e) {
			System.out.println("error, datos de cliente no válidos "+ e.getMessage());
		}
	}
	
}
