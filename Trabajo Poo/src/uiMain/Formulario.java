package uiMain;
//Clase padre de todos los formularios
import gestorAplicacion.* ;
public abstract class  Formulario extends OpcionDeMenu{
    MenuDeConsola anteriorMenu;
    String preguntas[];
    String respuestas[];
    
 Formulario(MenuDeConsola anteriorMenu, String nombreOpcion){
    this.anteriorMenu= anteriorMenu;
    this.nombreOpcion= nombreOpcion;
    }
             
    public abstract void ejecutar();

    
}
