//Clase que permite la funcion ganancia en los ultimos 6 mesese
// Hace un resumen del consumo y las ganancias en esos mese
package uiMain;
import gestorAplicacion.Cliente;
import java.awt.AWTException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GananciasSemestre extends OpcionDeMenu{
    MenuDeConsola menuFunciones;
      Scanner input= new Scanner(System.in);
      String mes= ""; 
      RecolectarDatos recolectarDatos;
      String[] meses= new String[12];
      
      GananciasSemestre(MenuDeConsola menuFunciones, RecolectarDatos recolectarDatos){
      this.menuFunciones= menuFunciones;
      this.recolectarDatos= recolectarDatos;
      nombreOpcion= "Ganancias ultimos seis meses";
      meses[0]= "Enero";
      meses[1]= "Febrero";
      meses[2]= "Marzo";
      meses[3]= "Abril";
      meses[4]= "Mayo";
      meses[5]= "Junio";
      meses[6]= "Julio";
      meses[7]= "Agosto";
      meses[8]= "Septiembre";
      meses[9]= "Octubre";
      meses[10]= "Noviembre";
      meses[11]= "Diciembre";
    }
    public void ejecutar(){
        try {
             RobotPresiona.limpiarpantalla();
         } catch (AWTException ex) {
             Logger.getLogger(SiguienteMenu.class.getName()).log(Level.SEVERE, null, ex);
         }
      int i= RecolectarDatos.getI();
      if(i>4){
        System.out.println("********************************************************\n   Ganancias meses " + meses[i-5]+" "+meses[i-4]+" "+meses[i-3]+" "+meses[i-2]+" "+meses[i-1]+" "+meses[i]+" "+"\n********************************************************");
        double gananciasLuz= 0;
        double gananciasAcueducto= 0;
        double gananciasAlcantarillado= 0;
        double gananciasGas= 0;
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
        double consumoLuz= 0;
        double consumoAcueducto= 0;
        double consumoAlcantarillado= 0;
        double consumoGas= 0;
      
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
          System.out.println("Ganancias por el cobro del servio de luz en estos 6 meses: "+ gananciasLuz);
          System.out.println("Ganancias por el cobro del servio de Acueducto en estos 6 meses: "+ gananciasAcueducto);
          System.out.println("Ganancias por el cobro del servio de Alcantarillado en estos 6 meses: "+ gananciasAlcantarillado);
          System.out.println("Ganancias por el cobro del servio de Gas en estos 6 meses: "+ gananciasGas);
          double suma= gananciasLuz+gananciasAcueducto+gananciasAlcantarillado+gananciasGas;
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
        System.out.println("Deben haber datos de 6 meses por lo menos para activar esta funcion");
        
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
}
