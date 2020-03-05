package uiMain;
import gestorAplicacion.Cliente;
import gestorAplicacion.Producto;
import java.awt.AWTException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class RecolectarDatos extends OpcionDeMenu{
    MenuDeConsola menuFunciones;
    Scanner input= new Scanner(System.in);
    public int i= -1;
     String[] meses= new String[12];
    RecolectarDatos(MenuDeConsola menuFunciones){
      this.menuFunciones= menuFunciones;
      nombreOpcion= "Recolectar datos";
      
    }
    
    
    
   public void ejecutar(){
       
     try {
             RobotPresiona.limpiarpantalla();
         } catch (AWTException ex) {
             Logger.getLogger(SiguienteMenu.class.getName()).log(Level.SEVERE, null, ex);
         }  
     Iterator itr= Cliente.listaClientes.iterator();
     while(itr.hasNext()){
       Cliente cliente= (Cliente)itr.next();
       double estrato= cliente.getEstrato();
       if(cliente.servicioLuz!= null){
         //Se lanza un numero entre 600 y 100 
         double consumo= Math.floor(Math.random()*(600-100+1)+100);  
         cliente.servicioLuz.pilaConsumo.add(consumo);
         double costo= 150;
         cliente.servicioLuz.pilaPagar.add(consumo*costo+estrato*consumo);
       }
       if(cliente.servicioAcueducto!= null){
         //Se lanza un numero entre 600 y 100  
         double consumo= Math.floor(Math.random()*(23-4+1)+4);  
         cliente.servicioAcueducto.pilaConsumo.add(consumo);
         double cargoFijo= 800;
         double costo= 650;
         cliente.servicioAcueducto.pilaPagar.add(cargoFijo*Math.pow(2, estrato)+costo*estrato);
       }
       if(cliente.servicioAlcantarillado!= null){
  
           double consumo= Math.floor(Math.random()*(23-4+1)+4);  
           cliente.servicioAlcantarillado.pilaConsumo.add(consumo);
            double cargoFijo= 500; 
          double costo= 600;
           cliente.servicioAlcantarillado.pilaPagar.add(cargoFijo*Math.pow(2, estrato)+costo*estrato);
       }
       if(cliente.servicioGas!= null){
           double consumo= Math.floor(Math.random()*(25-8+1)+8);  
           cliente.servicioGas.pilaConsumo.add(consumo);
            double cargoFijo= 400; 
          double costo= 400;
           cliente.servicioGas.pilaPagar.add(cargoFijo*Math.pow(2, estrato)+costo*estrato);
       }
       
       for(int i= 0; i<30; i++){
         if(Math.random()<0.1){
           double indice=  Math.floor(Math.random()*(Producto.listaProducto.size()+1)+0);
           cliente.listaProducto.add(Producto.listaProducto.get((int)indice));
           System.out.println(cliente.getNombre()+ "ha comprado "+ Producto.listaProducto.get((int)indice));
         }
       }
       
       
     }
     
     
     
     
     
     
     this.i++;
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