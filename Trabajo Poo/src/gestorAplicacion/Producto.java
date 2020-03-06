package gestorAplicacion;

import java.util.ArrayList;

public class Producto {
    int costo;
    String garantia; 
    String nombre; 
    public static ArrayList<Producto> listaProducto= new ArrayList<Producto>();
    public Producto(String nombre, int costo, String garantia){
      this.nombre= nombre;
      this.costo= costo;
      this.garantia= garantia;
      listaProducto.add(this);
      BaseDatos.EscritorJson.crearProducto(nombre, costo, garantia);
    }
    
    public String toString(){
    return nombre;
    }
}
