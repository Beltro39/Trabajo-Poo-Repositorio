//Clase que permite la funcion ganancia en el ultimo mes
// Hace un resumen del consumo y las ganancias en ese mes
package uiMain;
import gestorAplicacion.Cliente;
import java.awt.AWTException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
import uiMain.RecolectarDatos;
public class GananciasMes extends OpcionDeMenu{
    
    MenuDeConsola menuFunciones;
    Scanner input= new Scanner(System.in);
   private static String mes= ""; 
    RecolectarDatos recolectarDatos;
    static  String[]meses= new String[12];
    GananciasMes(MenuDeConsola menuFunciones, RecolectarDatos recolectarDatos){
      this.menuFunciones= menuFunciones;
      this.recolectarDatos= recolectarDatos;
      nombreOpcion= "Ganancias mes";
      
    }
    
    public void ejecutar(){
        try {
             RobotPresiona.limpiarpantalla();
         } catch (AWTException ex) {
             Logger.getLogger(SiguienteMenu.class.getName()).log(Level.SEVERE, null, ex);
         }
      if(Cliente.listaClientes.size()>0  && RecolectarDatos.getI()>=0){  
      mes= meses[RecolectarDatos.getI()];  
      System.out.println("****************************\n   Ganancias mes " + mes+"\n****************************");
      double gananciasLuz= 0;
      double gananciasAcueducto= 0;
      double gananciasAlcantarillado= 0;
      double gananciasGas= 0;
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
      
      double consumoLuz= 0;
      double consumoAcueducto= 0;
      double consumoAlcantarillado= 0;
      double consumoGas= 0;
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
      
      System.out.println("Ganancias por el cobro del servio de luz: "+ gananciasLuz);
      System.out.println("Ganancias por el cobro del servio de Acueducto: "+ gananciasAcueducto);
      System.out.println("Ganancias por el cobro del servio de Alcantarillado: "+ gananciasAlcantarillado);
      System.out.println("Ganancias por el cobro del servio de Gas: "+ gananciasGas);
      double suma= gananciasLuz+gananciasAcueducto+gananciasAlcantarillado+gananciasGas;
      System.out.println("Ganancias por el cobro total de servicios : "+ suma);
      System.out.println("");
      System.out.println("Consumo promedio de luz en kwh: "+ consumoLuz);
      System.out.println("Consumo promedio de agua del acueducto en m3: "+ consumoAcueducto);
      System.out.println("Consumo promedio de agua del alcantarillado en m3: "+ consumoAlcantarillado);
      System.out.println("Consumo promedio de gas en m3: "+ consumoGas);
      System.out.println("");
      System.out.println("Cantidad de clientes de la empresa: "+ Cliente.listaClientes.size());
      System.out.println("");
      System.out.println("Presiona Enter para continuar");
      //String enterKey= input.nextLine();
          
    }else{
      if(Cliente.listaClientes.size()==0){
      System.out.println("Ingresa un cliente para activar esta funcion");
      }else{
      System.out.println("Recolecte datos");
      }
      }
      String enterKey2= input.nextLine();
          if(enterKey2.isEmpty()){
            try {
             RobotPresiona.limpiarpantalla();
         } catch (AWTException ex) {
             Logger.getLogger(SiguienteMenu.class.getName()).log(Level.SEVERE, null, ex);
         }  
            
          }
    menuFunciones.lanzarMenu();  
}
    public static String getMes(){
      meses[0]= "ENERO";
      meses[1]= "FEBRERO";
      meses[2]= "MARZO";
      meses[3]= "ABRIL";
      meses[4]= "MAYO";
      meses[5]= "JUNIO";
      meses[6]= "JULIO";
      meses[7]= "AGOSTO";
      meses[8]= "SEPTIEMBRE";
      meses[9]= "OCTUBRE";
      meses[10]= "NOVIEMBRE";
      meses[11]= "DICIEMBRE";  
      mes= meses[RecolectarDatos.getI()];
      System.out.println(mes);
      return mes;
    }
}