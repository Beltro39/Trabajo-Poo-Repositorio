//Clase que permite la funcion ganancia en el ultimo mes
// Hace un resumen del consumo y las ganancias en ese mes
package uiMain;
import gestorAplicacion.Cliente;
import java.awt.AWTException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
import uiMain.RecolectarDatos;
public class GananciasMes extends OpcionDeMenu{
    //Atributos
   private static String mes= ""; 
   static  String[]meses= new String[13];
   
   static double gananciasLuz;
   static double gananciasAcueducto;
   static double gananciasAlcantarillado;
   static double gananciasGas;
   
   static double consumoLuz;
   static double consumoAcueducto;
   static double consumoAlcantarillado;
   static double consumoGas;
   
   public void ejecutar(){}
    
    public static void ejecutar2(){
     
      mes= meses[RecolectarDatos.getI()];  
      gananciasLuz= 0;
      gananciasAcueducto= 0;
      gananciasAlcantarillado= 0;
      gananciasGas= 0;
      for(int i= 0; i<Cliente.listaClientes.size(); i++){
    	  gananciasLuz+= Cliente.listaClientes.get(i).getServicioLuz().getPilaPagar().lastElement();
          //gananciasLuz+= Cliente.listaClientes.get(i).servicioLuz.pilaPagar.lastElement();
    	  gananciasAcueducto+= Cliente.listaClientes.get(i).getServicioAcueducto().getPilaPagar().lastElement();
    	  //gananciasAcueducto+= Cliente.listaClientes.get(i).servicioAcueducto.pilaPagar.lastElement();
    	  gananciasAlcantarillado+=Cliente.listaClientes.get(i).getServicioAlcantarillado().getPilaPagar().lastElement();
          //gananciasAlcantarillado= Cliente.listaClientes.get(i).servicioAlcantarillado.pilaPagar.lastElement();
    	  gananciasGas+=Cliente.listaClientes.get(i).getServicioGas().getPilaPagar().lastElement();
          //gananciasGas= Cliente.listaClientes.get(i).servicioGas.pilaPagar.lastElement();
      }
      
      consumoLuz= 0;
      consumoAcueducto= 0;
      consumoAlcantarillado= 0;
      consumoGas= 0;
      for(int i= 0; i<Cliente.listaClientes.size(); i++){
        consumoLuz+= Cliente.listaClientes.get(i).getServicioLuz().getPilaConsumo().lastElement();
        consumoAcueducto+= Cliente.listaClientes.get(i).getServicioAcueducto().getPilaConsumo().lastElement();
        consumoAlcantarillado+= Cliente.listaClientes.get(i).getServicioAlcantarillado().getPilaConsumo().lastElement();
        consumoGas+= Cliente.listaClientes.get(i).getServicioGas().getPilaConsumo().lastElement();
      }
      consumoLuz= consumoLuz/Cliente.listaClientes.size();
      consumoAcueducto= consumoAcueducto/Cliente.listaClientes.size();
      consumoAlcantarillado= consumoAlcantarillado/Cliente.listaClientes.size();
      consumoGas= consumoGas/Cliente.listaClientes.size();
      
      
     
}
    public static String getMes(){ 
      meses[0]= "                                                                ENERO";
      meses[1]= "                                                               FEBRERO";
      meses[2]= "                                                                MARZO";
      meses[3]= "                                                                ABRIL";
      meses[4]= "                                                                MAYO";
      meses[5]= "                                                                JUNIO";
      meses[6]= "                                                                JULIO";
      meses[7]= "                                                               AGOSTO";
      meses[8]= "                                                           SEPTIEMBRE";
      meses[9]= "                                                              OCTUBRE";
      meses[10]= "                                                           NOVIEMBRE";
      meses[11]= "                                                           DICIEMBRE"; 
      mes= meses[RecolectarDatos.getI()];
      return mes;
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
        return new BigDecimal(consumoLuz).setScale(3,RoundingMode.HALF_EVEN).doubleValue();
    }
    
    public static double getConsumoAcueducto(){
        return new BigDecimal(consumoAcueducto).setScale(3,RoundingMode.HALF_EVEN).doubleValue();
    }
    public static double getConsumoAlcantarillado(){
       return new BigDecimal(consumoAlcantarillado).setScale(3,RoundingMode.HALF_EVEN).doubleValue(); 
    }
    public static double getConsumoGas(){
        return new BigDecimal(consumoGas).setScale(3,RoundingMode.HALF_EVEN).doubleValue();  
    }
    
    public static double getGananciasLuz(){
        return new BigDecimal(gananciasLuz).setScale(0,RoundingMode.HALF_EVEN).doubleValue(); 
    }
    
    public static double getGananciasAcueducto(){
        return new BigDecimal(gananciasAcueducto).setScale(0,RoundingMode.HALF_EVEN).doubleValue();
    }
    public static double getGananciasAlcantarillado(){
        return new BigDecimal(gananciasAlcantarillado).setScale(0,RoundingMode.HALF_EVEN).doubleValue(); 
    }
    public static double getGananciasGas(){
          return new BigDecimal(gananciasGas).setScale(0,RoundingMode.HALF_EVEN).doubleValue();  
    }
  
}