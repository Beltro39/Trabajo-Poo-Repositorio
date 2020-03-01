package uiMain;
import java.awt.AWTException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// Esta es la clase menu del programa
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
     //metodos
    public void añadirOpcion(OpcionDeMenu op){
      listaOpciones.add(op);
    }
    public void lanzarMenu(){
       System.out.println(this);
       try{
         int opcionElegida= input.nextInt(); 
         listaOpciones.get(opcionElegida).ejecutar();
       }catch(Exception e){
           try {
             RobotPresiona.limpiarpantalla();
         } catch (AWTException ex) {
             Logger.getLogger(SiguienteMenu.class.getName()).log(Level.SEVERE, null, ex);
         }
          System.out.println("Elija una opcion valida, presione Enter para reintentar");
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
    
    public void setMensajeMenu(String mensaje){
      this.mensajeMenu+= "\n"+ mensaje;
    }
    
    public void Escuchar(){}
    //recibe el archivo donde se llevara el registro de contraseÃ±as
    public void EscribirContraseña(){};
    //recibe el archivo donde se llevara el registro de cedulas
    public void EscribirCedula(){}
    
    
}

