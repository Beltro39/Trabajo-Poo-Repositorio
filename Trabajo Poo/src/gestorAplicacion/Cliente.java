package gestorAplicacion;

import org.json.JSONException;

public class Cliente extends Persona {

    String estrato;
    public Cliente(String cedula, String nombre, int edad, String telefono, String estrato,String direccion, boolean luz, boolean agua, boolean acueducto, boolean gas)throws JSONException{
    	super(cedula,nombre,edad,telefono,direccion);
    	this.estrato = estrato;
    	BaseDatos.EscritorJson.crearCliente(estrato,cedula,nombre,edad,telefono,direccion, luz, agua, acueducto,gas); 
        BaseDatos.EscritorJson.guardarDatos("clientes");   
    }
    public String getEstrato() {
    	return this.estrato;
    }
}
