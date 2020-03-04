package gestorAplicacion;

import org.json.JSONException;
import org.json.simple.JSONObject;

public class Operario extends Persona{
	private double gananciasGeneradas;
public Operario(double gananciasGeneradas, String cedula,String nombre,int edad,String telefono, String direccion)throws JSONException{
	super(cedula,nombre,edad,telefono,direccion);
	BaseDatos.EscritorJson.crearOperario(gananciasGeneradas, cedula, nombre, edad, telefono, direccion);
    BaseDatos.EscritorJson.guardarDatos("operarios");
}

}
