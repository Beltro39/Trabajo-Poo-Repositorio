package uiMain;
import BaseDatos.*;
import gestorAplicacion.*;
import java.util.Scanner;

public class TrabajoPoo {
  public static void main(String[] args) {
        //Scanner input= new Scanner(System.in);
        //Menus De inicio de sesion
        MenuDeConsola menuPrincipal= new MenuDeConsola("**********************************\n   Empresa de servicios públicos\n**********************************");
        MenuDeConsola menuRegistrar= new MenuDeConsola("*******************************\n   Menu de registro de datos\n*******************************");
        MenuDeConsola menuFunciones= new MenuDeConsola("**********************\n   Menu de funcionesn**********************");
        
        SiguienteMenu btnMenuRegistrar= new SiguienteMenu(menuRegistrar, "Registrar datos");
        SiguienteMenu btnMenuFunciones= new SiguienteMenu(menuRegistrar, "Usar funciones");
        SiguienteMenu btnMenuPrincipal= new SiguienteMenu(menuPrincipal, "Regresar");
        
        menuPrincipal.añadirOpcion(btnMenuRegistrar);
        menuPrincipal.añadirOpcion(btnMenuFunciones);
        
        
        
        FormularioOperario btnFormularioOperarios= new FormularioOperario(menuRegistrar, "Registrar un operario");
        FormularioCliente btnFormularioClientes= new FormularioCliente(menuRegistrar, "Registrar un cliente");
        
        
        menuRegistrar.añadirOpcion(btnFormularioOperarios);
        menuRegistrar.añadirOpcion(btnFormularioClientes);
        menuRegistrar.añadirOpcion(btnMenuPrincipal);
        
        menuPrincipal.lanzarMenu();
    }
    
}
