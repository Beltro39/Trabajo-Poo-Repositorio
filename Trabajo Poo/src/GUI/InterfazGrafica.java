package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class InterfazGrafica extends Application{
    private static Scene sceneUsuario;
    private static Scene sceneRegistrarClientes;
    private static Scene sceneRegistrarOperarios;
    private static Scene sceneRegistrarProductos;
    private static Stage stage;

    @Override
    public void start(Stage stage){
        this.stage= stage;
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
       
            
        //Formulario Clientes
        FieldPanel fpaneRegistrarClientes= new FieldPanel("         DATOS", new String[]{"Cédula", "Nombre", "Edad", "Teléfono", "Estrato","Direccion"}, "         VALOR", new String[]{"        9 Dígitos", "Nombre completo", "          Años", "      10 Dígitos", "           1 - 5"," Cll, Av, Cra, Diag "});
        Formulario formularioClientes= new Formulario("              REGISTRAR clientes", fpaneRegistrarClientes, 95 );
        this.sceneRegistrarClientes= new Scene(formularioClientes, 350, 525);
        sceneRegistrarClientes.getStylesheets().add("GUI/Viper.css");
        
        //Formulario Operarios
        FieldPanel fpaneRegistrarOperarios= new FieldPanel("         DATOS", new String[]{"Cédula", "Nombre", "Edad", "Teléfono","Direccion"}, "         VALOR", new String[]{"        9 Dígitos", "Nombre completo", "          Años", "      10 Dígitos"," Cll, Av, Cra, Diag "}); 
        Formulario formularioOperarios= new Formulario("            REGISTRAR operarios", fpaneRegistrarOperarios, 95 );
        this.sceneRegistrarOperarios= new Scene(formularioOperarios, 350, 468);
        sceneRegistrarOperarios.getStylesheets().add("GUI/Viper.css");
        
        //Formulario Productos
        FieldPanel fpaneRegistrarProductos= new FieldPanel("           DATOS", new String[]{"Nombre del producto", "Precio del producto", "Años garantia"}, "           VALOR", new String[]{"", "          COP", " "}); 
        Formulario formularioProductos= new Formulario("             REGISTRAR productos", fpaneRegistrarProductos, 150 );
        this.sceneRegistrarProductos= new Scene(formularioProductos, 350, 370);
        sceneRegistrarProductos.getStylesheets().add("GUI/Viper.css");
        
        /*
        
        
        
     
     
     
    //Menu Registrar Productos
        BorderPane bpaneRegistrarProductos= new BorderPane();
        bpaneRegistrarProductos.setPadding(new Insets(0,0,20,0));
        bpaneRegistrarProductos.setTop(new MenuSuperior());
        VBox vBoxRegistrarProductos= new VBox();
        text1= new Label("             REGISTRAR productos");
        text1.setStyle("-fx-font-size: 16pt");
        text1.setId("letra-blanca");
        text1.setAlignment(Pos.CENTER_RIGHT);
        this.sceneRegistrarProductos= new Scene(bpaneRegistrarProductos, 350, 370);
        sceneRegistrarProductos.getStylesheets().add("GUI/Viper.css");
       
        FieldPanel fpaneRegistrarProductos= new FieldPanel("           DATOS", new String[]{"Nombre del producto", "Precio del producto", "Años garantia"}, "           VALOR", new String[]{"", "          COP", " "}); 
      
        vBoxRegistrarProductos.getChildren().add(new Label("            "));
        vBoxRegistrarProductos.getChildren().add(text1);
        vBoxRegistrarProductos.getChildren().add(new Label("            "));
        vBoxRegistrarProductos.getChildren().add(fpaneRegistrarProductos.gpane);
        bpaneRegistrarProductos.setCenter(vBoxRegistrarProductos);
        
        hbox= new HBox();
        hbox.getChildren().addAll(boton= new Button("Aceptar"),  boton2=new Button("Borrar")); boton.getStyleClass().add("boton-azul"); boton2.getStyleClass().add("boton-rojo");
        hbox.setAlignment(Pos.BOTTOM_CENTER);
        hbox.setSpacing(150);
        bpaneRegistrarProductos.setBottom(hbox);
        
       
        */
        //Layout menu principal
        BorderPane layoutPrincipal= new BorderPane();
        layoutPrincipal.setTop(new MenuSuperior());
        stage.setTitle("Empresa de servicios públicos");
        Scene scene= new Scene(layoutPrincipal, 350, 400);
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
}
