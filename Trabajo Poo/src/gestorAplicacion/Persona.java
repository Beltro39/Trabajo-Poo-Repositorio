package gestorAplicacion;
import java.util.Vector;

import org.json.simple.JSONObject;
public abstract class Persona {
    private String cedula;
    private String nombre;
    private int edad;
    private String telefono;
    private String direccion;
    
    Persona(String cedula, String nombre, int edad, String telefono, String direccion){
    	this.cedula = cedula;
    	this.nombre = nombre;
    	this.edad = edad;
    	this.telefono = telefono;
    	this.direccion = direccion;
    	
    }
    public String getCedula() {
    	return this.cedula;
    }
    public String getNombre() {
    	return this.nombre;
    }
    public int getEdad() {
    	return this.edad;
    }
    public String getTelefono() {
    	return this.telefono;
    }
    public String getDireccion() {
    	return this.direccion;
    }
    
     public void setCedula(String cedula) {
    	this.cedula= cedula;
    }
     
    public void setNombre(String nombre) {
    	this.nombre= nombre;
    }
    
    public void setEdad(String edad) {
    	this.edad= Integer.parseInt(edad);
    }
    
    public void setTelefono(String telefono) {
    	this.telefono= telefono;
    }
    
    public void setDireccion(String direccion) {
    	this.direccion= direccion;
    }
   
    public abstract JSONObject promedioEdades();
}
