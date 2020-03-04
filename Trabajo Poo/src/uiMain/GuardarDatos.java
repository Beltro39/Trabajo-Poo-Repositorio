package uiMain;

import java.awt.AWTException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GuardarDatos extends OpcionDeMenu{
    MenuDeConsola menuPrincipal;
    GuardarDatos(MenuDeConsola menuPrincipal){
    this.menuPrincipal= menuPrincipal;
    }
    public void ejecutar(){
      BaseDatos.EscritorJson.guardarDatos("clientes");
      BaseDatos.EscritorJson.guardarDatos("operarios");
      menuPrincipal.lanzarMenu();
    }
    public String toString(){
        try {
             RobotPresiona.limpiarpantalla();
         } catch (AWTException ex) {
             Logger.getLogger(SiguienteMenu.class.getName()).log(Level.SEVERE, null, ex);
         }
    return "Guardar datos";
    }
}
