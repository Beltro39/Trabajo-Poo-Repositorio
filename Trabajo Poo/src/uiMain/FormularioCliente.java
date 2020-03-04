package uiMain;
import java.awt.AWTException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
import gestorAplicacion.Cliente;
import org.json.JSONException;

public class FormularioCliente extends Formulario {
    private int intervencion= 5;
    Scanner input= new Scanner(System.in);
    boolean[] listaBoolean= new boolean[4];
    
    
    FormularioCliente(MenuDeConsola anteriorMenu, String nombreOpcion){
      super(anteriorMenu,nombreOpcion);
      this.respuestas= new String[6];
      this.preguntas= new String[10];
      preguntas[0]= "Digite su cédula"; 
      preguntas[1]= "Digite su nombre";
      preguntas[2]= "Digite su edad";
      preguntas[3]= "Digite su número de telefono";
      preguntas[4]= "Digite el estrato al que pertenece";
      preguntas[5]= "Digite su dirección";
      preguntas[6]= "¿Desea suscribirse al servicio público de luz?";
      preguntas[7]= "¿Desea suscribirse al servicio público de agua?";
      preguntas[8]= "¿Desea suscribirse al servicio público de acueducto?";
      preguntas[9]= "¿Desea suscribirse al servicio público de gas?";
    }
    
    public void ejecutar(){
    
        try {
            RobotPresiona.limpiarpantalla();
        } catch (AWTException ex) {
            Logger.getLogger(SiguienteMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int i = 0;
        while(i<preguntas.length){
            if(i== 6){
                System.out.println("Escriba si o no para las siguientes preguntas");
                try {
                    RobotPresiona.limpiarpantalla();
                } catch (AWTException ex) {
                    Logger.getLogger(SiguienteMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println(preguntas[i]);
            if(i<6){
                respuestas[i]= input.nextLine();
            }else{
                String valor= input.nextLine();
                if(valor.toLowerCase().equals("si")){
                    listaBoolean[i-6]= true;
                }
                if(valor.toLowerCase().equals("no")){
                    listaBoolean[i-6]= false;
                }
            }
            i++;
        }
        
        try {
            RobotPresiona.limpiarpantalla();
        } catch (AWTException ex) {
            Logger.getLogger(SiguienteMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
        new Cliente(respuestas[0], respuestas[1], Integer.parseInt(respuestas[2]), respuestas[3], respuestas[4],  respuestas[5], listaBoolean[0], listaBoolean[1], listaBoolean[2], listaBoolean[3]);
        } catch (JSONException ex) {
             Logger.getLogger(FormularioCliente.class.getName()).log(Level.SEVERE, null, ex);
         }
        anteriorMenu.lanzarMenu();
    }
    
    
}