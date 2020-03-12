// Clase que permite la funcion empleado del mes, , que saca el promedio de 
//las puntuaciones de todos los operarios, e imprime por pantalla aquel con promedio más alto
package uiMain;
import gestorAplicacion.Cliente;
import gestorAplicacion.Operario;
import gestorAplicacion.Producto;
import java.awt.AWTException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
public class EmpleadoDelMes extends OpcionDeMenu {
    MenuDeConsola menu;
    Scanner input= new Scanner(System.in);
    EmpleadoDelMes(MenuDeConsola menu){
    this.menu= menu;
    this.nombreOpcion= "Empleado del mes";
    }
    
    public void ejecutar(){
      try {
             RobotPresiona.limpiarpantalla();
         } catch (AWTException ex) {
             Logger.getLogger(SiguienteMenu.class.getName()).log(Level.SEVERE, null, ex);
         }  
      ArrayList<Double> listaPromedio= new ArrayList<>();
     // ArrayList<Double> listaPromedio= new ArrayList<Double>();  
      if(Operario.listaOperario.size()>0  && Cliente.listaClientes.size()>0 && Producto.listaProducto.size()>0){
      for(int i= 0; i<Operario.listaOperario.size(); i++){
        double promedio= 0; 
        for(int j= 0; j<Operario.listaOperario.get(i).getListaPuntuacion().size(); j++){
          promedio+= Operario.listaOperario.get(i).getListaPuntuacion().get(j);
        }
        promedio= promedio/Operario.listaOperario.get(i).getListaPuntuacion().size();
        listaPromedio.add(promedio);
      }
      int maximoIndice= 0;
      double maximoValor= listaPromedio.get(0);
      for(int j= 1; j<listaPromedio.size(); j++){
        if(listaPromedio.get(j)>maximoValor){
        maximoIndice= j;
        maximoValor= listaPromedio.get(j);
        }
      }
      System.out.println("El empleado del mes es "+ Operario.listaOperario.get(maximoIndice).getNombre()+ " con un puntaje promedio de "+ maximoValor);
    }else{
          if(Operario.listaOperario.size()==0){
          System.out.println("Ingrese antes un operario");
          }
          if(Cliente.listaClientes.size()==0){
          System.out.println("Ingrese antes un cliente");
          }
          if(Producto.listaProducto.size()==0){
          System.out.println("Ingrese antes un producto");
          }
      }
    System.out.println("");
      System.out.println("Presiona Enter para continuar");
      //String enterKey= input.nextLine();
          String enterKey2= input.nextLine();
          if(enterKey2.isEmpty()){
            try {
             RobotPresiona.limpiarpantalla();
         } catch (AWTException ex) {
             Logger.getLogger(SiguienteMenu.class.getName()).log(Level.SEVERE, null, ex);
         }  
            
      
      menu.lanzarMenu();  
}
    }
}