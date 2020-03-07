//Esta clase simula el paso de un mes en el programa, recogiendo datos de los servicios publicos
// o la compra de productos
package uiMain;
import gestorAplicacion.Cliente;
import gestorAplicacion.Operario;
import gestorAplicacion.Producto;
import java.awt.AWTException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class RecolectarDatos extends OpcionDeMenu{
    MenuDeConsola menuFunciones;
    Scanner input= new Scanner(System.in);
    public static int i= 0;
    int puntuacion= 0;
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
     if(Cliente.listaClientes.size()>0){
     Iterator itr= Cliente.listaClientes.iterator();
     int j= 0;
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
         cliente.servicioAcueducto.pilaPagar.add(cargoFijo*Math.pow(2, estrato)+costo*consumo);
       }
       if(cliente.servicioAlcantarillado!= null){
  
           double consumo= Math.floor(Math.random()*(23-4+1)+4);  
           cliente.servicioAlcantarillado.pilaConsumo.add(consumo);
            double cargoFijo= 500; 
          double costo= 600;
           cliente.servicioAlcantarillado.pilaPagar.add(cargoFijo*Math.pow(2, estrato)+costo*consumo);
       }
       if(cliente.servicioGas!= null){
           double consumo= Math.floor(Math.random()*(25-8+1)+8);  
           cliente.servicioGas.pilaConsumo.add(consumo);
            double cargoFijo= 400; 
          double costo= 400;
           cliente.servicioGas.pilaPagar.add(cargoFijo*Math.pow(2, estrato)+costo*consumo);
       }
         

       //PARTE PRODUCTO
       if(Producto.listaProducto.size()>0  && Operario.listaOperario.size()>0){
       for(int i= 0; i<30; i++){
         if(Math.random()<0.1){
           int tamaño= Producto.listaProducto.size()-1;
           int indice=  (int)Math.floor(Math.random()*(tamaño-0+1)+0);
           //System.out.println("indice producto " + indice+" tamaño producto "+Producto.listaProducto.size() );
           cliente.listaProducto.add(Producto.listaProducto.get((int)indice).getNombre());
           tamaño= Operario.listaOperario.size()-1;
           int indices= (int)Math.floor(Math.random()*(tamaño-0+1)+0);
           //System.out.println("indice Operario "+ indices+" tamaño operario "+Operario.listaOperario.size());
           Operario operario= Operario.listaOperario.get(indices);
           double puntuacion= Math.floor(Math.random()*(5-0+1)+0);
           operario.listaPuntuacion.add(puntuacion);
           System.out.println(cliente.getNombre()+ " ha comprado "+ Producto.listaProducto.get((int)indice).getNombre()+" y ha puntuado con "+puntuacion+" a "+operario.getNombre() );
             
           
           
         }
       }
       }else{
           if(j==0 && Producto.listaProducto.size()==0 ){
             System.out.println("No hay prodcutos que ofrecer");
           }
           if(j==0 && Operario.listaOperario.size()==0 ){
             System.out.println("No hay operarios disponibles");
           }
       }
      }
     }else{
       System.out.println("No hay clientes para recolectar datos");
     }
     
     
     
     
     
     
     this.i++;
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
