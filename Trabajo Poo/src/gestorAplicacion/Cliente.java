package gestorAplicacion;
import java.util.ArrayList;
import java.util.Vector;
import org.json.JSONException;


public class Cliente extends Persona {

    public static ArrayList<Cliente> listaClientes= new ArrayList<Cliente>();
    private int estrato;
   
   public ServiciosPublicos servicioLuz;
   public ServiciosPublicos servicioAcueducto;
   public ServiciosPublicos servicioAlcantarillado;
   public ServiciosPublicos servicioGas;
    
    public Cliente(String cedula, String nombre, int edad, String telefono, int estrato,String direccion, ServiciosPublicos luz, ServiciosPublicos acueducto, ServiciosPublicos alcantarillado, ServiciosPublicos gas)throws JSONException{
    	super(cedula,nombre,edad,telefono,direccion);
        this.estrato = estrato;
        this.servicioLuz= luz;
        this.servicioAcueducto=  acueducto;
        this.servicioAlcantarillado= alcantarillado;
        this.servicioGas= gas;
    	
    	BaseDatos.EscritorJson.crearCliente(estrato,cedula,nombre,edad,telefono,direccion, this.servicioLuz, this.servicioAcueducto, this.servicioAlcantarillado,this.servicioGas); 
        listaClientes.add(this);
        
                

    }
    public int getEstrato() {
    	return this.estrato;
    }

}
