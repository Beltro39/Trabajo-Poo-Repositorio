package gestorAplicacion;
import java.util.ArrayList;
import java.util.Vector;
import org.json.JSONException;
import org.json.simple.JSONObject;

public class Operario extends Persona{
        public Vector<Double> listaPuntuacion;
        public static ArrayList<Operario> listaOperario= new ArrayList<Operario>();
        
public Operario(String cedula,String nombre,int edad,String telefono, String direccion, Vector<Double> listaPuntuacion){
	super(cedula,nombre,edad,telefono,direccion);
        this.listaPuntuacion= listaPuntuacion;
        listaOperario.add(this);
	//BaseDatos.EscritorJson.crearOperario(gananciasGeneradas, cedula, nombre, edad, telefono, direccion, listaPuntuacion);
        
}
 
public String toString(){
  return this.getCedula()+"  "+this.getNombre()+"  "+ String.valueOf(this.getEdad())+"  "+ this.getTelefono()+"  "+ this.getDireccion()+ "  "+ this.listaPuntuacion;
}

}
