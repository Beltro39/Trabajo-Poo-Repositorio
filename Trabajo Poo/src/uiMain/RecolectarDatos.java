//Esta clase simula el paso de un mes en el programa, recogiendo datos de los servicios publicos
// o la compra de productos
package uiMain;
import gestorAplicacion.Cliente;
import gestorAplicacion.Factura;
import gestorAplicacion.Operario;
import gestorAplicacion.Producto;
import java.awt.AWTException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
import java.util.Vector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RecolectarDatos extends OpcionDeMenu{
    MenuDeConsola menuFunciones;
    Scanner input= new Scanner(System.in);
    private static int i= 0;
    int puntuacion= 0;
    private static ObservableList<Factura> facturas;
   public void ejecutar(){}
   
    
    public static ObservableList<Factura> ejecutar2(){
     ObservableList<Factura> facturas= FXCollections.observableArrayList();
     if(Cliente.listaClientes.size()>0){
     Iterator itr= Cliente.listaClientes.iterator();
     int j= 0;
     while(itr.hasNext()){
       Cliente cliente= (Cliente)itr.next();
       double estrato= cliente.getEstrato();
       if(cliente.getServicioLuz()!= null){
         //Se lanza un numero entre 600 y 100 
         double consumo= Math.floor(Math.random()*(600-100+1)+100);  
         cliente.getServicioLuz().getPilaConsumo().add(consumo);
         double costo= 150;
         cliente.getServicioLuz().getPilaPagar().add(consumo*costo+estrato*consumo);
       }
       if(cliente.getServicioAcueducto()!= null){
         //Se lanza un numero entre 600 y 100  
         double consumo= Math.floor(Math.random()*(23-4+1)+4);  
         cliente.getServicioAcueducto().getPilaConsumo().add(consumo);
         double cargoFijo= 800;
         double costo= 650;
         cliente.getServicioAcueducto().getPilaPagar().add(cargoFijo*Math.pow(2, estrato)+costo*consumo);
       }
       if(cliente.getServicioAlcantarillado()!= null){
  
           double consumo= Math.floor(Math.random()*(23-4+1)+4);  
           cliente.getServicioAlcantarillado().getPilaConsumo().add(consumo);
            double cargoFijo= 500; 
          double costo= 600;
           cliente.getServicioAlcantarillado().getPilaPagar().add(cargoFijo*Math.pow(2, estrato)+costo*consumo);
       }
       if(cliente.getServicioGas()!= null){
           double consumo= Math.floor(Math.random()*(25-8+1)+8);  
           cliente.getServicioGas().getPilaConsumo().add(consumo);
            double cargoFijo= 400; 
          double costo= 400;
           cliente.getServicioGas().getPilaPagar().add(cargoFijo*Math.pow(2, estrato)+costo*consumo);
       }
         

       //PARTE PRODUCTO
       if(Producto.listaProducto.size()>0  && Operario.listaOperario.size()>0){
       for(int i= 0; i<30; i++){
         if(Math.random()<0.05){
           int tamaño= Producto.listaProducto.size()-1;
           int indice=  (int)Math.floor(Math.random()*(tamaño-0+1)+0);
           //System.out.println("indice producto " + indice+" tama�o producto "+Producto.listaProducto.size() );
           cliente.getListaProducto().add(Producto.listaProducto.get((int)indice).getNombre());
           tamaño= Operario.listaOperario.size()-1;
           int indices= (int)Math.floor(Math.random()*(tamaño-0+1)+0);
           //System.out.println("indice Operario "+ indices+" tama�o operario "+Operario.listaOperario.size());
           Operario operario= Operario.listaOperario.get(indices);
           double puntuacion= Math.floor(Math.random()*(5-0+1)+0);
           operario.getListaPuntuacion().add(puntuacion);
           //System.out.println(cliente.getNombre()+ " ha comprado "+ Producto.listaProducto.get((int)indice).getNombre()+" y ha puntuado con "+puntuacion+" a "+operario.getNombre() );
           facturas.add(new Factura(cliente.getNombre(), Producto.listaProducto.get((int)indice).getNombre(), String.valueOf(puntuacion), operario.getNombre()));
         }
       }
       } 
  }
       }
      i++;
    return facturas;}
    
    public static int getI(){
      return i;
    } 
    public static void setI(int z){
      i= z;
    } 
}
     