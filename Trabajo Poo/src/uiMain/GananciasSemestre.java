//Clase que permite la funcion ganancia en los ultimos 6 mesese
// Hace un resumen del consumo y las ganancias en esos mese
package uiMain;
import gestorAplicacion.Cliente;
import java.awt.AWTException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GananciasSemestre extends OpcionDeMenu{
   Scanner input= new Scanner(System.in);
   static String mes= ""; 
   static String[] meses= new String[12];
      
   static double gananciasLuz;
   static double gananciasAcueducto;
   static double gananciasAlcantarillado;
   static double gananciasGas;
   
   static double suma;
   
   static double consumoLuz;
   static double consumoAcueducto;
   static double consumoAlcantarillado;
   static double consumoGas;
     
    public void ejecutar(){}
      public static void ejecutar2(){
          
        
      int i= RecolectarDatos.getI();
      if(i>4){
        
        int p= i-5;
        for(int j= 0; j<Cliente.listaClientes.size(); j++){
          for(int k= p; k<Cliente.listaClientes.get(j).getServicioLuz().getPilaPagar().size(); k++){  
          //System.out.println(Cliente.listaClientes.get(j).servicioLuz.pilaPagar.get(k));
          gananciasLuz+= Cliente.listaClientes.get(j).getServicioLuz().getPilaPagar().get(k);
          gananciasAcueducto+= Cliente.listaClientes.get(j).getServicioAcueducto().getPilaPagar().get(k);
          gananciasAlcantarillado+= Cliente.listaClientes.get(j).getServicioAlcantarillado().getPilaPagar().get(k);
          gananciasGas+= Cliente.listaClientes.get(j).getServicioGas().getPilaPagar().get(k);
          }
        }
        
      
        for(int j= 0; j<Cliente.listaClientes.size(); j++){
          for(int k= p; k<Cliente.listaClientes.get(j).getServicioLuz().getPilaConsumo().size(); k++){  
              
          consumoLuz+= Cliente.listaClientes.get(j).getServicioLuz().getPilaConsumo().get(k);
          consumoAcueducto+= Cliente.listaClientes.get(j).getServicioAcueducto().getPilaConsumo().get(k);
          consumoAlcantarillado+= Cliente.listaClientes.get(j).getServicioAlcantarillado().getPilaConsumo().get(k);
          consumoGas+= Cliente.listaClientes.get(j).getServicioGas().getPilaConsumo().get(k);
          }
        }
        consumoLuz= consumoLuz/(Cliente.listaClientes.size()*6);
        consumoAcueducto= consumoAcueducto/(Cliente.listaClientes.size()*6);
        consumoAlcantarillado= consumoAlcantarillado/(Cliente.listaClientes.size()*6);
        consumoGas= consumoGas/(Cliente.listaClientes.size()*6);
         suma= gananciasLuz+gananciasAcueducto+gananciasAlcantarillado+gananciasGas;
         System.out.println(suma);
        
        /*
          System.out.println("Ganancias por el cobro del servio de luz en estos 6 meses: "+ gananciasLuz);
          System.out.println("Ganancias por el cobro del servio de Acueducto en estos 6 meses: "+ gananciasAcueducto);
          System.out.println("Ganancias por el cobro del servio de Alcantarillado en estos 6 meses: "+ gananciasAlcantarillado);
          System.out.println("Ganancias por el cobro del servio de Gas en estos 6 meses: "+ gananciasGas);
          
          System.out.println("Ganancias por el cobro total de servicios en estos 6 meses: "+ suma);
          System.out.println("");
          
          System.out.println("Consumo promedio de luz en kwh en estos 6 meses: "+ consumoLuz);
          System.out.println("Consumo promedio de agua del acueducto en m3 en estos 6 meses: "+ consumoAcueducto);
          System.out.println("Consumo promedio de agua del alcantarillado en m3 en estos 6 meses: "+ consumoAlcantarillado);
          System.out.println("Consumo promedio de gas en m3 en estos 6 meses: "+ consumoGas);
          System.out.println("");
      
          System.out.println("Cantidad de clientes de la empresa: "+ Cliente.listaClientes.size());
          System.out.println("");
      }else{
                */
        //System.out.println("Deben haber datos de 6 meses por lo menos para activar esta funcion");
         
      }else{
        gananciasLuz= 0;
        gananciasAcueducto= 0;
        gananciasAlcantarillado= 0;
        gananciasGas= 0;
        
        consumoLuz= 0;
        consumoAcueducto= 0;
        consumoAlcantarillado= 0;
        consumoGas= 0;
        suma= 0;
        
      }
      
      
    }
       public static String getMes2(){  
      meses[0]= "GANANCIAS MES DE ENERO";
      meses[1]= "GANANCIAS MES DE FEBRERO";
      meses[2]= "GANANCIAS MES DE MARZO";
      meses[3]= "GANANCIAS MES DE ABRIL";
      meses[4]= "GANANCIAS MES DE MAYO";
      meses[5]= "GANANCIAS MES DE JUNIO";
      meses[6]= "GANANCIAS MES DE JULIO";
      meses[7]= "GANANCIAS MES DE AGOSTO";
      meses[8]= "GANANCIAS MES DE SEPTIEMBRE";
      meses[9]= "GANANCIAS MES DE OCTUBRE";
      meses[10]= "GANANCIAS MES DE NOVIEMBRE";
      meses[11]= "GANANCIAS MES DE DICIEMBRE"; 
      mes= meses[RecolectarDatos.getI()];
      return mes;
    }
       
       public static double getConsumoLuz(){
        return consumoLuz;
    }
    
    public static double getConsumoAcueducto(){
        return consumoAcueducto;
    }
    public static double getConsumoAlcantarillado(){
       return consumoAlcantarillado;
    }
    public static double getConsumoGas(){
        return consumoGas;
    }
    
    public static double getGananciasLuz(){
        return gananciasLuz;
    }
    
    public static double getGananciasAcueducto(){
        return gananciasAcueducto;
    }
    public static double getGananciasAlcantarillado(){
        return gananciasAlcantarillado;
    }
    public static double getGananciasGas(){
          return gananciasGas;
    }
    
    public static double getSuma(){
          return suma;
    }
}
