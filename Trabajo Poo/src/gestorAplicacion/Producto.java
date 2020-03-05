package gestorAplicacion;

import java.util.ArrayList;

public class Producto {
    int costo;
    int garantia; 
    String nombre; 
    public static ArrayList<Producto> listaProducto= new ArrayList<Producto>();
    Producto(String nombre, int costo, int garantia){
      this.nombre= nombre;
      this.costo= costo;
      this.garantia= garantia;
      listaProducto.add(this);
    }
    
    public String toString(){
    return nombre;
    }
}
