//Clase para registrar operario
package uiMain;
import java.awt.AWTException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
import gestorAplicacion.Operario;
import java.util.ArrayList;
import org.json.JSONException;
public class FormularioOperario extends Formulario{
    Scanner input= new Scanner(System.in);
    FormularioOperario(MenuDeConsola anteriorMenu, String nombreOpcion){
      super(anteriorMenu,nombreOpcion);
      this.respuestas= new String[5];
      this.preguntas= new String[5];
      preguntas[0]= "Digite su cédula"; 
      preguntas[1]= "Digite su nombre";
      preguntas[2]= "Digite su edad";
      preguntas[3]= "Digite su número de celular";
      preguntas[4]= "Digite su dirección";
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
    
    
        try {
            new Operario(0, respuestas[0], respuestas[1], Integer.parseInt(respuestas[2]), respuestas[3], respuestas[4], new ArrayList<Double>());
        } catch (JSONException ex) {
            Logger.getLogger(FormularioOperario.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    anteriorMenu.lanzarMenu();
   
   } 
}
