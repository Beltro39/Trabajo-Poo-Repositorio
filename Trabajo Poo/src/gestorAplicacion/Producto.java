package gestorAplicacion;
//Clase que define lo que es un producto
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
      //BaseDatos.EscritorJson.crearProducto(nombre, costo, garantia);
    }
    
    public String toString(){
    return nombre+" "+ String.valueOf(costo)+ " "+ garantia;
    }
    
    public String getNombre(){
     return nombre;
}
}
