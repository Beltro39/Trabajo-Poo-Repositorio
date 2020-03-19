package gestorAplicacion;
import java.util.Vector;
public class Factura {
    private String cliente;
    private String producto;
    private String puntuacion;
    private String operario;
    
   public Factura(String cliente,String producto, String puntuacion, String operario ){
      this.cliente= cliente;
      this.operario=operario;
      this.producto=producto;
      this.puntuacion= puntuacion;
      
    }
   
   public String getCliente(){
     return cliente;
   }
   public String getProducto(){
     return producto;
   }
   public String getPuntuacion(){
     return puntuacion;
   }
   public String getOperario(){
     return operario;
   }
}
