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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class EmpleadoDelMes extends OpcionDeMenu {
    private static double promedioMax;
    
     public void ejecutar(){}
    
    public static ObservableList<Operario> ejecutar2(){ 
      ObservableList<Operario> operarios= FXCollections.observableArrayList();
      ArrayList<Double> listaPromedio= new ArrayList<>();
     // ArrayList<Double> listaPromedio= new ArrayList<Double>();  
     
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
       operarios.add(Operario.listaOperario.get(maximoIndice));
       promedioMax= maximoValor;
       return operarios;
      
    
  }
    
    public static String getPromedioMax(){
      return "Con un puntaje promedio de: "+ String.valueOf(promedioMax);
    }
    }
