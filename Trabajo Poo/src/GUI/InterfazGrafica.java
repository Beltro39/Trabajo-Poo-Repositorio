package GUI;

import BaseDatos.LectorJson;
import gestorAplicacion.Cliente;
import gestorAplicacion.Factura;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import uiMain.GananciasMes;
import uiMain.GananciasSemestre;
import uiMain.RecolectarDatos;


public class InterfazGrafica extends Application{
    private static Scene sceneUsuario;
    private static Scene sceneRegistrarClientes;
    private static Scene sceneRegistrarOperarios;
    private static Scene sceneRegistrarProductos;
    private static Scene scene;
    private static Scene sceneRecolectarDatos;
    private static Scene sceneGananciasMes;
    private static Scene sceneGananciasSemestre;
    private static Stage stage;
    public static TextField mes;
    public static TextField mes2;
     public static TextField mes3;
    public static TextField[] textFieldGananciasMes;
    
   public static TableView<Factura> tablaFactura;
    

    @Override
    public void start(Stage stage){
        
       LectorJson.leerClientes();
        LectorJson.leerOperarios();
        LectorJson.leerProductos();
        LectorJson.leerMes();
        
        this.stage= stage;
        stage.setOnCloseRequest(e->{
          e.consume();
          closeProgram();
        });
        
        
     //Escena de Usuario 
        //Nodos  
        Button bSalir= new Button("Salir");
        bSalir.setMaxSize(50, 45);
        Label texto= new Label("Empresa de servicios publicos");
        
        //Layout
        BorderPane bpane20= new BorderPane();
        bpane20.setTop(new MenuSuperior());
        bpane20.setCenter(texto);
        bpane20.setBottom(bSalir);
        BorderPane.setAlignment(bSalir, Pos.TOP_CENTER);
        bpane20.setPadding(new Insets(0,0,15,0));
        this.sceneUsuario= new Scene(bpane20, 350,400);
        sceneUsuario.getStylesheets().add("GUI/Viper.css");
       
        //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------   
        //Formulario Clientes
        FieldPanel fpaneRegistrarClientes= new FieldPanel("         DATOS", new String[]{"Cédula", "Nombre", "Edad", "Teléfono", "Estrato","Direccion"}, "         VALOR", new String[]{"        9 Dígitos", "Nombre completo", "          Años", "      10 Dígitos", "           1 - 5"," Cll, Av, Cra, Diag "}, 30, 80, true);
        Formulario formularioClientes= new Formulario("             REGISTRAR clientes", fpaneRegistrarClientes, 95, true );
        this.sceneRegistrarClientes= new Scene(formularioClientes, 350, 525);
        sceneRegistrarClientes.getStylesheets().add("GUI/Viper.css");
        
        //Formulario Operarios
        FieldPanel fpaneRegistrarOperarios= new FieldPanel("         DATOS", new String[]{"Cédula", "Nombre", "Edad", "Teléfono","Direccion"}, "         VALOR", new String[]{"        9 Dígitos", "Nombre completo", "          Años", "      10 Dígitos"," Cll, Av, Cra, Diag "}, 30, 80, true); 
        Formulario formularioOperarios= new Formulario("           REGISTRAR operarios", fpaneRegistrarOperarios, 95, true );
        this.sceneRegistrarOperarios= new Scene(formularioOperarios, 350, 468);
        sceneRegistrarOperarios.getStylesheets().add("GUI/Viper.css");
        
        //Formulario Productos
        FieldPanel fpaneRegistrarProductos= new FieldPanel("           DATOS", new String[]{"Nombre del producto", "Precio del producto", "Años garantia"}, "           VALOR", new String[]{"", "          COP", " "}, 30, 80, true); 
        Formulario formularioProductos= new Formulario("           REGISTRAR productos", fpaneRegistrarProductos, 150, true );
        this.sceneRegistrarProductos= new Scene(formularioProductos, 350, 370);
        sceneRegistrarProductos.getStylesheets().add("GUI/Viper.css");
        
        //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
       
        //Recolectar Datos
        BorderPane layoutRecolectarDatos= new BorderPane();
        layoutRecolectarDatos.setTop(new MenuSuperior());
     
        //Tabla cliente
        TableColumn<Factura, String> clienteColumn= new TableColumn<>("Cliente");
        clienteColumn.setMinWidth(150);
        clienteColumn.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        
        //Tabla producto
        TableColumn<Factura, String> productoColumn= new TableColumn<>("Producto");
        productoColumn.setMinWidth(150);
        productoColumn.setCellValueFactory(new PropertyValueFactory<>("producto"));
        //Tabla puntuacion
        TableColumn<Factura, String> puntuacionColumn= new TableColumn<>("Puntuación");
        puntuacionColumn.setMinWidth(150);
        puntuacionColumn.setCellValueFactory(new PropertyValueFactory<>("puntuacion"));
        //Tabla operario
        TableColumn<Factura, String> operarioColumn= new TableColumn<>("Operario");
        operarioColumn.setMinWidth(150);
        operarioColumn.setCellValueFactory(new PropertyValueFactory<>("operario"));
        //Creacion tabla
        tablaFactura = new TableView<>();    
        tablaFactura.getColumns().addAll(clienteColumn, productoColumn, puntuacionColumn, operarioColumn);
        //Diseño recolectarDatos
        VBox vbox= new VBox();
        mes= new TextField("");
        mes.setEditable(false);
        mes.setId("negrilla");
        mes.setMaxSize(335, 50);
        mes.setAlignment(Pos.TOP_RIGHT);
        vbox.getChildren().addAll(mes,tablaFactura);
        vbox.setSpacing(10);
        layoutRecolectarDatos.setCenter(vbox);
        this.sceneRecolectarDatos= new Scene(layoutRecolectarDatos, 600, 370);
        sceneRecolectarDatos.getStylesheets().add("GUI/Viper.css");
        
        
        //Ganancias Mes
        FieldPanel fpaneGananciasMes= new FieldPanel("           DATOS", new String[]{"Ganancias por el cobro de luz", "Ganancias por el cobro de acueducto", "Ganancias por el cobro de alcantaillado", "Ganancias por el cobro de gas"
        , "Consumo promedio de luz en kwh", "Consumo promedio de agua del acueducto en m3", "Consumo promedio de agua del alcantarillado en m3", "Consumo promedio de gas en m3"}, "           VALOR", 
        new double[]{GananciasMes.getGananciasLuz(),GananciasMes.getGananciasAcueducto() ,GananciasMes.getGananciasAlcantarillado(),GananciasMes.getGananciasGas(), GananciasMes.getConsumoLuz(), GananciasMes.getConsumoAcueducto(), GananciasMes.getConsumoAlcantarillado(), GananciasMes.getConsumoGas() }, 30, 80); 
      
        mes2= new TextField("GANANCIAS MES DE ?");
        mes2.setEditable(false);
        mes2.setId("negrilla");
        mes2.setMaxSize(420, 50);
        mes2.setAlignment(Pos.TOP_RIGHT);
        Formulario formularioGananciasMes= new Formulario(mes2, fpaneGananciasMes, 150, false );
        this.sceneGananciasMes= new Scene(formularioGananciasMes, 600, 600);
        sceneGananciasMes.getStylesheets().add("GUI/Viper.css");
               
        //Ganancias Semestre
       
        FieldPanel fpaneGananciasSemestre= new FieldPanel("           DATOS", new String[]{"Ganancias por el cobro del servio de luz en estos 6 meses", "Ganancias por el cobro del servio de Acueducto en estos 6 meses", "Ganancias por el cobro del servio de Alcantarillado en estos 6 meses", "Ganancias por el cobro del servio de Gas en estos 6 meses", "Ganancias por el cobro total de servicios en estos 6 meses"
        , "Consumo promedio de luz en kwh en estos 6 meses", "Consumo promedio de agua del acueducto en m3 en estos 6 meses", "Consumo promedio de agua del alcantarillado en m3 en estos 6 meses", "Consumo promedio de gas en m3 en estos 6 meses"}, "           VALOR", 
        new double[]{GananciasSemestre.getGananciasLuz(),GananciasSemestre.getGananciasAcueducto() ,GananciasSemestre.getGananciasAlcantarillado(),GananciasSemestre.getGananciasGas(), GananciasSemestre.getSuma(), GananciasSemestre.getConsumoLuz(), GananciasSemestre.getConsumoAcueducto(), GananciasSemestre.getConsumoAlcantarillado(), GananciasSemestre.getConsumoGas() }, 30, 80, true); 
        
        mes3= new TextField("GANANCIAS MES DE ?");
        mes3.setEditable(false);
        mes3.setId("negrilla");
        mes3.setMaxSize(420, 50);
        mes3.setAlignment(Pos.TOP_RIGHT);
        Formulario formularioGananciasSemestre= new Formulario(mes3, fpaneGananciasSemestre, 150, false );
        this.sceneGananciasSemestre= new Scene(formularioGananciasSemestre, 650, 650);
        sceneGananciasSemestre.getStylesheets().add("GUI/Viper.css");
            
        //Layout menu principal
        BorderPane layoutPrincipal= new BorderPane();
        layoutPrincipal.setTop(new MenuSuperior());
        stage.setTitle("Empresa de servicios públicos");
        this.scene= new Scene(layoutPrincipal, 350, 400);
        scene.getStylesheets().add("GUI/Viper.css");
        stage.setScene(scene);
        bSalir.setOnAction(e -> stage.setScene(scene));
        stage.show();
        
        //InterfazGrafica.class.getResource("Viper.css");
             
    }
    
    public static void main(String[] args){
      Application.launch(args);
    }
    
    public static Stage getStage(){
      return stage;
    }
    
    public static Scene getSceneUsuario(){
      return sceneUsuario;
    }
    
    public static Scene getSceneRegistrarCliente(){
      return sceneRegistrarClientes;
    }
    
    public static Scene getSceneRegistrarOperario(){
      return sceneRegistrarOperarios;
    }
    
    public static Scene getSceneRegistrarProducto(){
      return sceneRegistrarProductos;
    }
    
    public static Scene getSceneRecolectarDatos(){
      return sceneRecolectarDatos;
    }
    
    public static Scene getSceneGananciasMes(){
      return sceneGananciasMes;
    }
    
    public static Scene getSceneGananciasSemestre(){
      return sceneGananciasSemestre;
    }
    public void closeProgram(){
      boolean answer= ConfirmBox.ejecutar("Aviso", "¿Desea guardar datos?");
      if(answer== true){
        BaseDatos.EscritorJson.escribirClientes();
        BaseDatos.EscritorJson.escribirOperarios();
        BaseDatos.EscritorJson.escribirProductos();  
        BaseDatos.EscritorJson.escribirMes();
      }
      stage.close();
    }
    
  
    
}
