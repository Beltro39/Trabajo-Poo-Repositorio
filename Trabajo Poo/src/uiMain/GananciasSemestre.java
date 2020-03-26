//Clase que permite la funcion ganancia en los ultimos 6 mesese
// Hace un resumen del consumo y las ganancias en esos mese
package uiMain;
import gestorAplicacion.Cliente;
import java.awt.AWTException;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
      meses[5]= "GANANCIAS EN LOS MESES ENTRE ENERO Y JUNIO";
      meses[6]= "GANANCIAS EN LOS MESES ENTRE FEBRERO Y JULIO";
      meses[7]= "GANANCIAS EN LOS MESES ENTRE MARZO Y AGOSTO";
      meses[8]= "GANANCIAS EN LOS MESES ENTRE ABRIL Y SEPTIEMBRE";
      meses[9]= "GANANCIAS EN LOS MESES ENTRE JUNIO Y OCTUBRE";
      meses[10]= "GANANCIAS EN LOS MESES ENTRE JUNIO Y NOVIEMBRE";
      meses[11]= "GANANCIAS EN LOS MESES ENTRE JULIO Y DICIEMBRE"; 
      mes= meses[RecolectarDatos.getI()];
      return mes;
    }
       
       public static double getConsumoLuz(){
        return new BigDecimal(consumoLuz).setScale(2,RoundingMode.HALF_EVEN).doubleValue();
    }
    
    public static double getConsumoAcueducto(){
        return new BigDecimal(consumoAcueducto).setScale(2,RoundingMode.HALF_EVEN).doubleValue();
    }
    public static double getConsumoAlcantarillado(){
       return new BigDecimal(consumoAlcantarillado).setScale(2,RoundingMode.HALF_EVEN).doubleValue(); 
    }
    public static double getConsumoGas(){
        return new BigDecimal(consumoGas).setScale(2,RoundingMode.HALF_EVEN).doubleValue();
    }
    
    public static double getGananciasLuz(){
        return new BigDecimal(gananciasLuz).setScale(0,RoundingMode.HALF_EVEN).doubleValue(); 
    }
    
    public static double getGananciasAcueducto(){
        return new BigDecimal(gananciasAcueducto).setScale(0,RoundingMode.HALF_EVEN).doubleValue();
    }
    public static double getGananciasAlcantarillado(){
        return  new BigDecimal(gananciasAlcantarillado).setScale(0,RoundingMode.HALF_EVEN).doubleValue();
    }
    public static double getGananciasGas(){
          return  new BigDecimal(gananciasGas).setScale(0,RoundingMode.HALF_EVEN).doubleValue(); 
    }
    
    public static double getSuma(){
          return new BigDecimal(suma).setScale(0,RoundingMode.HALF_EVEN).doubleValue(); 
    }
}
