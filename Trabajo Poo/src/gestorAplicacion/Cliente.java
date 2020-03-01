package gestorAplicacion;
import BaseDatos.EscritorJson;
import org.json.JSONException;

public class Cliente extends Persona {
    int estrato;
    int saldo;
    int aņosServicio;
    public Cliente(int estrato, int saldo, int aņosServicio,String cedula, String nombre, int edad, String telefono, String direccion)throws JSONException{
    	super(cedula,nombre,edad,telefono,direccion);
    	this.estrato = estrato;
    	this.saldo = saldo;
    	this.aņosServicio = aņosServicio;
    	EscritorJson.crearCliente(estrato,saldo,aņosServicio,cedula,nombre,edad,telefono,direccion);    	
    }
    public int getEstrato() {
    	return this.estrato;
    }
    public int getSaldo(){
    	return this.saldo;
    }
    public int getAņosServicio() {
    	return this.aņosServicio;
    }
}
