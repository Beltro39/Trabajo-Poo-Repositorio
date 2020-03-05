package uiMain;

import uiMain.RobotPresiona;
import uiMain.OpcionDeMenu;
import uiMain.MenuDeConsola;
import java.awt.AWTException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SiguienteMenu extends OpcionDeMenu {
     MenuDeConsola proximoMenu;
     
    
    SiguienteMenu(MenuDeConsola proximoMenu, String nombreOpcion){
      this.proximoMenu= proximoMenu;
      this.nombreOpcion= nombreOpcion;
    }
    
   
    public void ejecutar(){
         try {
             RobotPresiona.limpiarpantalla();
         } catch (AWTException ex) {
             Logger.getLogger(SiguienteMenu.class.getName()).log(Level.SEVERE, null, ex);
         }
      //proximoMenu.menuAnterior= this;   
     // proximoMenu.menuAnteriorMetodo() 
         
      proximoMenu.lanzarMenu();
    }
    
    
    
    
    
    
}
