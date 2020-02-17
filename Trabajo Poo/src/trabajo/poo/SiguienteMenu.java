package trabajo.poo;
public class SiguienteMenu extends OpcionDeMenu {
     MenuDeConsola proximoMenu;
     String nombreOpcion;
    
    SiguienteMenu(MenuDeConsola proximoMenu, String nombreOpcion){
      this.proximoMenu= proximoMenu;
      this.nombreOpcion= nombreOpcion;
    }
    
   
    public void ejecutar(){
     System.out.print("\u001b[2J");  
      
      proximoMenu.lanzarMenu();
    }
    
    public String toString(){
      return this.nombreOpcion;
    }
    
    
}
