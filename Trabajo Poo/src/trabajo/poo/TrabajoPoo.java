package trabajo.poo;
public class TrabajoPoo {
  public static void main(String[] args) {
        MenuDeConsola menuInicioSesion= new MenuDeConsola("**********************\n   Inicio de sesion\n**********************");
        MenuDeConsola menuCrearUsuario= new MenuDeConsola("**********************\n   Crear Usuario\n**********************");
        SiguienteMenu crearUsuario= new SiguienteMenu(menuCrearUsuario, "crearUsuario");
        menuInicioSesion.añadirOpcion(crearUsuario);
        menuInicioSesion.lanzarMenu();
        //MenuInicioSesion.añadirOpcion();
        
        //MenuInicioSesion.añadirOpcion();
        
    }
    
}
