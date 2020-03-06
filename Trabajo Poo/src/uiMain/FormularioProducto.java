package uiMain;
//Clase para registrar producto
import gestorAplicacion.Producto;
import java.awt.AWTException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import java.util.Scanner;

public class FormularioProducto extends Formulario {
    Scanner input= new Scanner(System.in);
    FormularioProducto(MenuDeConsola anteriorMenu, String nombreOpcion){
      super(anteriorMenu,nombreOpcion);
      this.respuestas= new String[3];
      this.preguntas= new String[3];
      preguntas[0]="Digite el nombre del producto";
      preguntas[1]= "Digite el costo del producto";
      preguntas[2]= "Digite la garantia del producto";
    }
    
    public void ejecutar(){
     try {
       RobotPresiona.limpiarpantalla();
     } catch (AWTException ex) {
       Logger.getLogger(SiguienteMenu.class.getName()).log(Level.SEVERE, null, ex);
     }
    
    int i = 0;
    while(i<preguntas.length){ 
       System.out.println(preguntas[i]);
       respuestas[i]= input.nextLine();
       i++;
    }
    
    try {
             RobotPresiona.limpiarpantalla();
         } catch (AWTException ex) {
             Logger.getLogger(SiguienteMenu.class.getName()).log(Level.SEVERE, null, ex);
         }
    
    
        //try {
         new Producto(respuestas[0], Integer.parseInt(respuestas[1]), respuestas[2]);
        //} catch (JSONException ex) {
          //  Logger.getLogger(FormularioOperario.class.getName()).log(Level.SEVERE, null, ex);
        //}
            
    anteriorMenu.lanzarMenu();
   
   } 
}


