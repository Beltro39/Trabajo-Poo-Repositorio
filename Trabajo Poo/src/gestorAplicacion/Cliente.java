package gestorAplicacion;
import BaseDatos.EscritorJson;
import org.json.JSONException;

public class Cliente extends Persona {
    int estrato;
    int saldo;
    public Cliente(int estrato, int saldo, String cedula, String nombre, int edad, String telefono, String direccion)throws JSONException{
    	super(cedula,nombre,edad,telefono,direccion);
    	this.estrato = estrato;
    	this.saldo = saldo;
    	EscritorJson.crearCliente(estrato,saldo,cedula,nombre,edad,telefono,direccion);    	
    }
    public int getEstrato() {
    	return this.estrato;
    }
    public int getSaldo(){
    	return this.saldo;
    }

}
