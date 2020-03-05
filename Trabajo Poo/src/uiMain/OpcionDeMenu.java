package uiMain;


public abstract class OpcionDeMenu {
    String nombreOpcion;
    abstract public void ejecutar();
    public String toString(){
    return this.nombreOpcion;
    };
}
