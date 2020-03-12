package gestorAplicacion;
import java.util.ArrayList;
import java.util.Vector;
import org.json.JSONException;
import org.json.simple.JSONObject;

public class Operario extends Persona{
        private Vector<Double> listaPuntuacion;
        public static ArrayList<Operario> listaOperario= new ArrayList<Operario>();
        
public Operario(String cedula,String nombre,int edad,String telefono, String direccion, Vector<Double> listaPuntuacion){
	super(cedula,nombre,edad,telefono,direccion);
        this.listaPuntuacion= listaPuntuacion;
        listaOperario.add(this);
	//BaseDatos.EscritorJson.crearOperario(gananciasGeneradas, cedula, nombre, edad, telefono, direccion, listaPuntuacion);
        
}
public void setListaPuntuacion(Vector<Double> listaPuntuacion) {
	this.listaPuntuacion=listaPuntuacion;
}
public Vector<Double> getListaPuntuacion(){
	return this.listaPuntuacion;
}
public String toString(){
  return this.getCedula()+"  "+this.getNombre()+"  "+ String.valueOf(this.getEdad())+"  "+ this.getTelefono()+"  "+ this.getDireccion()+ "  "+ this.listaPuntuacion;
}
@Override
public JSONObject promedioEdades() {
	double promedio=0;
	int max = 0;
	int min = 0;
	JSONObject obj = new JSONObject();
	for(int i=0; i<listaOperario.size();i++) {
		promedio=+listaOperario.get(i).getEdad();
		if(listaOperario.get(i).getEdad()>max) {
			max=listaOperario.get(i).getEdad();
		}
		if(listaOperario.get(i).getEdad()<min) {
			min=listaOperario.get(i).getEdad();
		}
		
	}
	promedio = promedio/listaOperario.size();
	obj.put("promedio de edades", promedio);
	obj.put("operario mas viejo", max);
	obj.put("operario mas joven", min);
	return obj;
}

}
