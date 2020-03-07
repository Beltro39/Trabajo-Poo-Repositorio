package gestorAplicacion;
import java.util.ArrayList;
import java.util.Vector;
import org.json.JSONException;


public class Cliente extends Persona {
    public static ArrayList<Cliente> listaClientes= new ArrayList<Cliente>();
    private int estrato;
   public Vector<String> listaProducto;
   public ServiciosPublicos servicioLuz;
   public ServiciosPublicos servicioAcueducto;
   public ServiciosPublicos servicioAlcantarillado;
   public ServiciosPublicos servicioGas;
  
   
   
    public Cliente(String cedula, String nombre, int edad, String telefono, int estrato,String direccion, ServiciosPublicos luz, ServiciosPublicos acueducto, ServiciosPublicos alcantarillado, ServiciosPublicos gas, Vector<String> listaProducto){
    	super(cedula,nombre,edad,telefono,direccion);
        this.estrato = estrato;
        this.servicioLuz= luz;
        this.servicioAcueducto=  acueducto;
        this.servicioAlcantarillado= alcantarillado;
        this.servicioGas= gas;
    	this.listaProducto= listaProducto;
    	//BaseDatos.EscritorJson.crearCliente(estrato,cedula,nombre,edad,telefono,direccion, this.servicioLuz, this.servicioAcueducto, this.servicioAlcantarillado,this.servicioGas, listaProducto); 
        listaClientes.add(this);
        
                
    }
    public int getEstrato() {
    	return this.estrato;
    }
    
    public String toString(){
      return this.getCedula()+"  "+this.getNombre()+"  "+ String.valueOf(this.getEdad())+"  "+ this.getTelefono()+"  "+ this.getEstrato()+"  "+ this.getDireccion()+ "  "+ this.servicioLuz.pilaConsumo+"  "+this.servicioLuz.pilaPagar+"  "+  this.servicioAcueducto.pilaConsumo+ "  "+this.servicioAcueducto.pilaPagar+ "  "+ this.servicioAlcantarillado.pilaConsumo+ "  "+this.servicioAlcantarillado.pilaPagar+ "  "+ this.servicioGas.pilaConsumo+ "  "+ this.servicioGas.pilaPagar+ "  "+ this.listaProducto;
    }
    
   
}
