package uiMain;
import gestorAplicacion.* ;
public abstract class  Formulario extends OpcionDeMenu{
    MenuDeConsola anteriorMenu;
    String nombreOpcion;
    String preguntas[];
    String respuestas[];
    
    //int intervencion;
    
    
    Formulario(MenuDeConsola anteriorMenu, String nombreOpcion){
    this.anteriorMenu= anteriorMenu;
    this.nombreOpcion= nombreOpcion;
    }
            
    public String toString(){
      return this.nombreOpcion;
    }
    
    public abstract void ejecutar();
    
   // public void setMensajeIntroductorio(String mensaje, int intervencion){
     // this.mensaje= mensaje;
      //this.intervencion= intervencion;
    //}
    
}
