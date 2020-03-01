package gestorAplicacion;
import BaseDatos.EscritorJson;
import org.json.JSONException;

public class Cliente extends Persona {
    int estrato;
    int saldo;
    int a�osServicio;
    public Cliente(int estrato, int saldo, int a�osServicio,String cedula, String nombre, int edad, String telefono, String direccion)throws JSONException{
    	super(cedula,nombre,edad,telefono,direccion);
    	this.estrato = estrato;
    	this.saldo = saldo;
    	this.a�osServicio = a�osServicio;
    	EscritorJson.crearCliente(estrato,saldo,a�osServicio,cedula,nombre,edad,telefono,direccion);    	
    }
    public int getEstrato() {
    	return this.estrato;
    }
    public int getSaldo(){
    	return this.saldo;
    }
    public int getA�osServicio() {
    	return this.a�osServicio;
    }
}
