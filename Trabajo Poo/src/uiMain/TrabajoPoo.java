package uiMain;
import BaseDatos.*;
import gestorAplicacion.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;

public class TrabajoPoo {
  public static void main(String[] args) {
      try {
          //Scanner input= new Scanner(System.in);
          //Menus De inicio de sesion
          LectorJson.leerBaseDatos();
      } catch (JSONException ex) {
          Logger.getLogger(TrabajoPoo.class.getName()).log(Level.SEVERE, null, ex);
      }
      
        MenuDeConsola menuPrincipal= new MenuDeConsola("**********************************\n   Empresa de servicios públicos\n**********************************");
        MenuDeConsola menuRegistrar= new MenuDeConsola("*******************************\n   Menu de registro de datos\n*******************************");
        MenuDeConsola menuFunciones= new MenuDeConsola("**********************\n   Menu de funciones\n**********************");
        
        SiguienteMenu btnMenuRegistrar= new SiguienteMenu(menuRegistrar, "Registrar datos");
        SiguienteMenu btnMenuFunciones= new SiguienteMenu(menuFunciones, "Usar funciones");
        GuardarDatos btnGuardarDatos= new GuardarDatos(menuPrincipal);
        SiguienteMenu btnMenuPrincipal= new SiguienteMenu(menuPrincipal, "Regresar");
        
        menuPrincipal.añadirOpcion(btnMenuRegistrar);
        menuPrincipal.añadirOpcion(btnMenuFunciones);
        menuPrincipal.añadirOpcion(btnGuardarDatos);
        
        
        FormularioCliente btnFormularioClientes= new FormularioCliente(menuRegistrar, "Registrar un cliente");
        FormularioOperario btnFormularioOperarios= new FormularioOperario(menuRegistrar, "Registrar un operario");
        FormularioProducto btnFormularioProductos= new FormularioProducto(menuRegistrar, "Registrar un producto");
        
        RecolectarDatos recolectarDatos= new RecolectarDatos(menuFunciones);
        GananciasMes gananciasMes= new GananciasMes(menuFunciones, recolectarDatos);
        
        menuFunciones.añadirOpcion(recolectarDatos);
        menuFunciones.añadirOpcion(gananciasMes);
        menuFunciones.añadirOpcion(btnMenuPrincipal);
        
        
        
        menuRegistrar.añadirOpcion(btnFormularioClientes);
        menuRegistrar.añadirOpcion(btnFormularioOperarios);
        menuRegistrar.añadirOpcion(btnFormularioProductos);
        menuRegistrar.añadirOpcion(btnMenuPrincipal);
        
        
        menuPrincipal.lanzarMenu();
    }
    
}
