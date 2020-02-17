package trabajo.poo;
import java.util.*;

public class MenuDeConsola {
    String mensajeMenu;
    MenuDeConsola(String mensajeMenu){
      this.mensajeMenu= mensajeMenu;
    }
    
    ArrayList<OpcionDeMenu> listaOpciones= new ArrayList();
    
    
    public void añadirOpcion(OpcionDeMenu op){
      listaOpciones.add(op);
    }
    
    public void lanzarMenu(){
       System.out.println(this);
       int opcionElegida= input.nextInt();
       listaOpciones.get(opcionElegida).ejecutar();
    }
    
    public String toString(){
      Iterator itr= listaOpciones.iterator();
      String menu= mensajeMenu;
      while(itr.hasNext()){
        int i = 0;
        menu= menu+ "\n"+ itr.next().toString()+": "+ i;
      }  
      
      return menu ;
    }
    
    Scanner input= new Scanner(System.in);
}

