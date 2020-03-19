package GUI;
import gestorAplicacion.Cliente;
import gestorAplicacion.Factura;
import gestorAplicacion.Operario;
import gestorAplicacion.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import uiMain.GananciasMes;
import uiMain.RecolectarDatos;

public class MenuSuperior extends MenuBar{
   public MenuSuperior(){
     //Menu Principal   
        Menu archivo= new Menu("Archivo");
        //Todos los items del menu Archivo
          MenuItem usuario= new MenuItem("Usuario");
          MenuItem guardar= new MenuItem("Guardar");
          MenuItem salir= new MenuItem("Salir");
          archivo.getItems().addAll(usuario,guardar, salir);
        //Lambda expressions de los menuItems Archivo
          usuario.setOnAction(e -> InterfazGrafica.getStage().setScene(InterfazGrafica.getSceneUsuario()));
          guardar.setOnAction(e ->{  
           BaseDatos.EscritorJson.escribirClientes();
           BaseDatos.EscritorJson.escribirOperarios();
           BaseDatos.EscritorJson.escribirProductos();
          });
          
          
         Menu procesos= new Menu("Procesos y consultas");
        //Todos los items del menu Procesos y consultas
          MenuItem registrarCliente= new MenuItem("Registrar cliente");
          MenuItem registrarOperario= new MenuItem("Registrar operario");
          MenuItem registrarProducto= new MenuItem("Registrar producto");
          //-------------------------------------------------------------- 
          MenuItem recolectarDatos= new MenuItem("Recolectar datos");
          MenuItem gananciasMes= new MenuItem("Ganancias del mes");
          MenuItem gananciasSemestre= new MenuItem("Ganancias últimos seis meses");
          MenuItem empleadoDelMes= new MenuItem("Empleado del mes");
          procesos.getItems().addAll(registrarCliente, registrarOperario, registrarProducto, new SeparatorMenuItem(),recolectarDatos, gananciasMes, gananciasSemestre, empleadoDelMes);
        //Lambda expressions de los menuItems Procesos y consultas
          registrarCliente.setOnAction(e -> InterfazGrafica.getStage().setScene(InterfazGrafica.getSceneRegistrarCliente()));
          registrarOperario.setOnAction(e -> InterfazGrafica.getStage().setScene(InterfazGrafica.getSceneRegistrarOperario()));
          registrarProducto.setOnAction(e -> InterfazGrafica.getStage().setScene(InterfazGrafica.getSceneRegistrarProducto()));
          //---------------------------------------------------------------
          if(Cliente.listaClientes.size()== 0){
            recolectarDatos.setDisable(true);
      }
          recolectarDatos.setOnAction(e->{
          if(Cliente.listaClientes.size()>0 && Producto.listaProducto.size()>0 && Operario.listaOperario.size()>0){
              ObservableList<Factura> facturas = RecolectarDatos.ejecutar2();
              InterfazGrafica.tablaFactura.setItems(facturas);
              InterfazGrafica.mes.setText(GananciasMes.getMes());
              
            //InterfazGrafica.tablaFactura.setItems(RecolectarDatos.ejecutar2());
          }
                                          InterfazGrafica.getStage().setScene(InterfazGrafica.getSceneRecolectarDatos());
          });
        Menu ayuda= new Menu("Ayuda");
        
          this.getMenus().addAll(archivo, procesos, ayuda);
    
    }
}
