package gestorAplicacion;
import BaseDatos.EscritorJson;
import org.json.JSONException;

public class Cliente extends Persona {
    int estrato;
    int saldo;
    int añosServicio;
    public Cliente(int estrato, int saldo, int añosServicio,String cedula, String nombre, int edad, String telefono, String direccion)throws JSONException{
    	super(cedula,nombre,edad,telefono,direccion);
    	this.estrato = estrato;
    	this.saldo = saldo;
    	this.añosServicio = añosServicio;
    	EscritorJson.crearCliente(estrato,saldo,añosServicio,cedula,nombre,edad,telefono,direccion);    	
    }
    public int getEstrato() {
    	return this.estrato;
    }
    public int getSaldo(){
    	return this.saldo;
    }
    public int getAñosServicio() {
    	return this.añosServicio;
    }
}
