package gestorAplicacion;
import java.util.ArrayList;
import java.util.Vector;
import org.json.JSONException;
import org.json.simple.JSONObject;


public class Cliente extends Persona {
    public static ArrayList<Cliente> listaClientes= new ArrayList<Cliente>();
    private int estrato;
   private Vector<String> listaProducto;
   private ServiciosPublicos servicioLuz;
   private ServiciosPublicos servicioAcueducto;
   private ServiciosPublicos servicioAlcantarillado;
   private ServiciosPublicos servicioGas;
  
   
   
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
    
    public JSONObject promedioEdades(){
    	double promedio=0;
    	int max = 0;
    	int min = 0;
    	JSONObject obj = new JSONObject();
    	for(int i=0; i<listaClientes.size();i++) {
    		promedio=+listaClientes.get(i).getEdad();
    		if(listaClientes.get(i).getEdad()>max) {
    			max=listaClientes.get(i).getEdad();
    		}
    		if(listaClientes.get(i).getEdad()<min) {
    			min=listaClientes.get(i).getEdad();
    		}
    		
    	}
    	promedio = promedio/listaClientes.size();
    	obj.put("promedio de edades", promedio);
    	obj.put("cliente mas viejo", max);
    	obj.put("cliente mas joven", min);
    	return obj;
    	
    }
    public int getEstrato() {
    	return this.estrato;
    }
    public void setEstrato(int estrato) {
    	this.estrato = estrato;
    }
    public Vector<String> getlistaProducto(){
    	return this.listaProducto;
    }
    public void setListaProducto(Vector<String> listaProducto) {
    	this.listaProducto = listaProducto;
    }
    public ServiciosPublicos getServicioLuz() {
    	return this.servicioLuz;
    }
    public void setServicioLuz(ServiciosPublicos servicioLuz) {
    	this.servicioLuz = servicioLuz;
    }
    public ServiciosPublicos getServicioAcueducto() {
    	return this.servicioAcueducto;
    }
    public void setServicioAcueducto(ServiciosPublicos servicioAcueducto) {
    	this.servicioAcueducto = servicioAcueducto;
    }
    public ServiciosPublicos getServicioAlcantarillado() {
    	return this.servicioAlcantarillado;
    }
    public void setServicioAlcantarillado(ServiciosPublicos servicioAlcantarillado) {
    	this.servicioAlcantarillado=servicioAlcantarillado;
    }
    public ServiciosPublicos getServicioGas() {
    	return this.servicioGas;
    }
    public void setServicioGas(ServiciosPublicos servicioGas) {
    	this.servicioGas=servicioGas;
    }
    
    
    public Vector<String> getListaProducto() {
		return listaProducto;
	}
	public String toString(){
      return this.getCedula()+"  "+this.getNombre()+"  "+ String.valueOf(this.getEdad())+"  "+ this.getTelefono()+"  "+ this.getEstrato()+"  "+ this.getDireccion()+ "  "+ this.servicioLuz.getPilaConsumo()+"  "+this.servicioLuz.getPilaPagar()+"  "+  this.servicioAcueducto.getPilaConsumo()+ "  "+this.servicioAcueducto.getPilaPagar()+ "  "+ this.servicioAlcantarillado.getPilaConsumo()+ "  "+this.servicioAlcantarillado.getPilaPagar()+ "  "+ this.servicioGas.getPilaConsumo()+ "  "+ this.servicioGas.getPilaPagar()+ "  "+ this.listaProducto;
    }
    
    
   
}
