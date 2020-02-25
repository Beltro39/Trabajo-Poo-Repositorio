package uiMain;

import java.awt.AWTException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class Formulario extends OpcionDeMenu{
    MenuDeConsola anteriorMenu;
    String nombreOpcion;
    String preguntas[];
    String respuestas[];
    Scanner input= new Scanner(System.in);
    String mensaje;
    int intervencion;
    
    
    Formulario(MenuDeConsola anteriorMenu, String nombreOpcion, String[] preguntas){
    this.anteriorMenu= anteriorMenu;
    this.nombreOpcion= nombreOpcion;
    this.preguntas= preguntas;
    respuestas= new String[preguntas.length];
    }
            
    public String toString(){
      return this.nombreOpcion;
    }
    
    public void ejecutar(){
    try {
             RobotPresiona.limpiarpantalla();
         } catch (AWTException ex) {
             Logger.getLogger(SiguienteMenu.class.getName()).log(Level.SEVERE, null, ex);
         }
    int i = 0;
    while(i<preguntas.length){
       if(i== intervencion){
         System.out.println(mensaje);
         try {
             RobotPresiona.limpiarpantalla();
         } catch (AWTException ex) {
             Logger.getLogger(SiguienteMenu.class.getName()).log(Level.SEVERE, null, ex);
         }
       } 
       System.out.println(preguntas[i]);
       respuestas[i]= input.nextLine();
       i++;
    }
    try {
             RobotPresiona.limpiarpantalla();
         } catch (AWTException ex) {
             Logger.getLogger(SiguienteMenu.class.getName()).log(Level.SEVERE, null, ex);
         }
    anteriorMenu.lanzarMenu();
    }
    
    public void setMensajeIntroductorio(String mensaje, int intervencion){
      this.mensaje= mensaje;
      this.intervencion= intervencion;
    }
    
}
