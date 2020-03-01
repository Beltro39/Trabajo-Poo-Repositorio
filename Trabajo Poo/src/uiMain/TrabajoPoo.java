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
        
        menuPrincipal.a�adirOpcion(btnMenuRegistrar);
        menuPrincipal.a�adirOpcion(btnMenuFunciones);
        
        
        String[] preguntasOperario= new String[5];
        preguntasOperario[0]= "Digite su cédula"; 
        preguntasOperario[1]= "Digite su nombre";
        preguntasOperario[2]= "Digite su edad";
        preguntasOperario[3]= "Digite su número de celular";
        preguntasOperario[4]= "Digite su dirección";
        Formulario btnFormularioOperarios= new Formulario(menuRegistrar, "Registrar un operario", preguntasOperario);
        
        String[] preguntasCliente= new String[9];
        for(int i= 0; i<5; i++){
          preguntasCliente[i]= preguntasOperario[i];
        }
        
        preguntasCliente[5]= "¿Desea suscribirse al servicio público de luz?";
        preguntasCliente[6]= "¿Desea suscribirse al servicio público de agua?";
        preguntasCliente[7]= "¿Desea suscribirse al servicio público de acueducto?";
        preguntasCliente[8]= "¿Desea suscribirse al servicio público de gas?";
        
        Formulario btnFormularioClientes= new Formulario(menuRegistrar, "Registrar un cliente", preguntasCliente);
        btnFormularioClientes.setMensajeIntroductorio("Escriba si o no para las siguientes preguntas", 5);
        
        menuRegistrar.a�adirOpcion(btnFormularioOperarios);
        menuRegistrar.a�adirOpcion(btnFormularioClientes);
        menuRegistrar.a�adirOpcion(btnMenuPrincipal);
        
        menuPrincipal.lanzarMenu();
    }
    
}
