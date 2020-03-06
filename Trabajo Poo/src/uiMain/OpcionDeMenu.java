package uiMain;
//Clase padre de todas las opciones de menu
public abstract class OpcionDeMenu {
    String nombreOpcion;
    abstract public void ejecutar();
    public String toString(){
    return this.nombreOpcion;
    };
}
