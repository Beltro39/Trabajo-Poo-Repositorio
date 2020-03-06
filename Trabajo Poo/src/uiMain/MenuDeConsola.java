//Clase que imprime en pantalla todas las opciones de menu con metodo lanzarMenu
package uiMain;
import java.awt.AWTException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MenuDeConsola {
    //atributos
    Scanner input= new Scanner(System.in);
    private String mensajeMenu;
    ArrayList<OpcionDeMenu> listaOpciones= new ArrayList();
    private int i= 0;
    
    //Constructores
    MenuDeConsola(String mensajeMenu){
      this.mensajeMenu= mensajeMenu;
    }
     //Este metodo es el que permite añadir opciones de menu al menu de consola
    public void añadirOpcion(OpcionDeMenu op){
      listaOpciones.add(op);
    }
    //Metodo que esta en constante ejecucion, imprime en pantalla al menuDeConsola correspondiente
    public void lanzarMenu(){
       System.out.println(this);
       try{
         int opcionElegida= input.nextInt(); 
         listaOpciones.get(opcionElegida).ejecutar();
       }catch(ArithmeticException e){
           try {
             RobotPresiona.limpiarpantalla();
         } catch (AWTException ex) {
             Logger.getLogger(SiguienteMenu.class.getName()).log(Level.SEVERE, null, ex);
         }
          System.out.println("Elija una opcion valida, presione Enter para reintentar");
          System.out.println(e);
          String enterKey= input.nextLine();
          String enterKey2= input.nextLine();
          if(enterKey2.isEmpty()){
            try {
             RobotPresiona.limpiarpantalla();
         } catch (AWTException ex) {
             Logger.getLogger(SiguienteMenu.class.getName()).log(Level.SEVERE, null, ex);
         }  
            this.lanzarMenu();
          }

       }
       
    }
    
    public String toString(){
      Iterator itr= listaOpciones.iterator();
      String menu= mensajeMenu;
      int i = 0;
      while(itr.hasNext()){
        menu= menu+ "\n"+ itr.next().toString()+": "+ i;
        i+= 1;
      }  
      this.i= i;
      return menu ;
    }
    
    
    
    
    
}

