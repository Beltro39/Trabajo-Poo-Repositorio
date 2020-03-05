package gestorAplicacion;

import java.util.ArrayList;

public class Producto {
    private int costo;
    private String garantia; 
    private String nombre; 
    public static ArrayList<Producto> listaProducto= new ArrayList<Producto>();
    public Producto(String nombre, int costo, String garantia){
      this.nombre= nombre;
      this.costo= costo;
      this.garantia= garantia;
      listaProducto.add(this);
      BaseDatos.EscritorJson.crearProducto(garantia, costo, nombre);
    }
    
    public String toString(){
    return nombre;
    }
    public int getCosto() {
    	return this.costo;
    }
    public String getGarantia() {
    	return this.garantia;
    }
    public String getNombre() {
    	return this.nombre;
    }
    public void setCosto(int costo){
    	this.costo = costo;
    }
    public void setGarantia(String garantia) {
    	this.garantia = garantia;
    }
    public void setNombre(String nombre) {
    	this.nombre = nombre;
    }
}
