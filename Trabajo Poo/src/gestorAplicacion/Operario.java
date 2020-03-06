package gestorAplicacion;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.simple.JSONObject;

public class Operario extends Persona{
	private double gananciasGeneradas;
        public ArrayList<Double> listaPuntuacion;
        public static ArrayList<Operario> listaOperario= new ArrayList<Operario>();
        
public Operario(double gananciasGeneradas, String cedula,String nombre,int edad,String telefono, String direccion, ArrayList<Double> listaPuntuacion)throws JSONException{
	super(cedula,nombre,edad,telefono,direccion);
        this.listaPuntuacion= listaPuntuacion;
        listaOperario.add(this);
	BaseDatos.EscritorJson.crearOperario(gananciasGeneradas, cedula, nombre, edad, telefono, direccion, listaPuntuacion);
        
}

}
