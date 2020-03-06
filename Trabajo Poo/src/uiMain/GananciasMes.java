package uiMain;
import gestorAplicacion.Cliente;
import java.awt.AWTException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
public class GananciasMes extends OpcionDeMenu{
    MenuDeConsola menuFunciones;
    Scanner input= new Scanner(System.in);
    String mes= ""; 
    RecolectarDatos recolectarDatos;
    String[] meses= new String[12];
    GananciasMes(MenuDeConsola menuFunciones, RecolectarDatos recolectarDatos){
      this.menuFunciones= menuFunciones;
      this.recolectarDatos= recolectarDatos;
      nombreOpcion= "Ganancias mes";
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
      mes= meses[recolectarDatos.i];  
      System.out.println("****************************\n   Ganancias mes " + mes+"\n****************************");
      double gananciasLuz= 0;
      double gananciasAcueducto= 0;
      double gananciasAlcantarillado= 0;
      double gananciasGas= 0;
      for(int i= 0; i<Cliente.listaClientes.size(); i++){
      gananciasAcueducto+= Cliente.listaClientes.get(i).servicioAcueducto.pilaPagar.lastElement();
      gananciasAlcantarillado= Cliente.listaClientes.get(i).servicioAlcantarillado.pilaPagar.lastElement();
      gananciasGas= Cliente.listaClientes.get(i).servicioGas.pilaPagar.lastElement();
      }
      
      System.out.println("Ganancias por el cobro del servio de luz: "+ gananciasLuz);
      System.out.println("Ganancias por el cobro del servio de Acueducto: "+ gananciasAcueducto);
      System.out.println("Ganancias por el cobro del servio de Alcantarillado: "+ gananciasAlcantarillado);
      System.out.println("Ganancias por el cobro del servio de Gas: "+ gananciasGas);
      double suma= gananciasLuz+gananciasAcueducto+gananciasAlcantarillado+gananciasGas;
      System.out.println("Ganancias por el cobro total de servicios : "+ suma);
      System.out.println("Cantidad de clientes de la empresa: "+ Cliente.listaClientes.size());
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
            
      
      menuFunciones.lanzarMenu();
    }
}
}