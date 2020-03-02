package gestorAplicacion;

import org.json.JSONException;
import org.json.simple.JSONObject;

public class Operario extends Persona{
	private JSONObject seguroAccidentes;
	private String tipoJornada;
	private double gananciasGeneradas;
public Operario(String[] seguroAccidentes, String tipoJornada, double gananciasGeneradas, String cedula,String nombre,int edad,String telefono, String direccion)throws JSONException{
	super(cedula,nombre,edad,telefono,direccion);
	this.seguroAccidentes = BaseDatos.EscritorJson.crearSeguroAccidentes(seguroAccidentes);
	BaseDatos.EscritorJson.crearOperario(this.seguroAccidentes, tipoJornada, gananciasGeneradas, cedula, nombre, edad, telefono, direccion);
}

}
