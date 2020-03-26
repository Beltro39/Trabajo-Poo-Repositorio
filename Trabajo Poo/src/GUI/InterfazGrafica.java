package GUI;

import BaseDatos.LectorJson;
import gestorAplicacion.Cliente;
import gestorAplicacion.Factura;
import gestorAplicacion.Operario;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import uiMain.GananciasMes;
import uiMain.GananciasSemestre;
import uiMain.RecolectarDatos;


public class InterfazGrafica extends Application{
    //Escenas que usa el programa
    private static Scene sceneInicio;
    private static Scene sceneUsuario;
    private static Scene sceneRegistrarClientes;
    private static Scene sceneRegistrarOperarios;
    private static Scene sceneRegistrarProductos;
    private static Scene sceneEmpleadoDelMes;
    private static Scene sceneRecolectarDatos;
    private static Scene sceneGananciasMes;
    private static Scene sceneGananciasSemestre;
    private static Stage stage;
    //Text Fields que se actualizan mientras se usa el programa
    public static TextField mes;
    public static TextField mes2;
    public static TextField mes3;
    public static TextField textFieldEmpleadoDelMes;
    public static TextField[] textFieldGananciasMes;
    //Tablas para la funcion RecolectarDatos y Empleado del mes
   public static TableView<Factura> tablaFactura;
   public static TableView<Operario> tablaOperario;
    
   static VBox vertical1;
    Image fotos,  logo2, mundo, agua, luz, gas, ESP ;
     Label CVsebas, crea, bien ;
     static Label label1;
    Button siguiente, descripcion;
    Alert alerta;
    static ImageView  imagen;
    static int contador=0;
    

    int velocidad =2; //segundos

    Timer timer;
    TimerTask tarea;
    int velmil= velocidad*1000;
    @Override
    
    
    public void start(Stage stage){
        //Lectura de datos en los archivos
        LectorJson.leerClientes();
        LectorJson.leerOperarios();
        LectorJson.leerProductos();
        LectorJson.leerMes();
        
        this.stage= stage;
        //Confimar si se quiere guardar datos mientras se cierra el programa
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
        Formulario formularioClientes= new Formulario("              CONTROL clientes", fpaneRegistrarClientes, 23);
        this.sceneRegistrarClientes= new Scene(formularioClientes, 350, 515);
        sceneRegistrarClientes.getStylesheets().add("GUI/Viper.css");
        
        //Formulario Operarios
        FieldPanel fpaneRegistrarOperarios= new FieldPanel("         DATOS", new String[]{"Cédula", "Nombre", "Edad", "Teléfono","Direccion"}, "         VALOR", new String[]{"        9 Dígitos", "Nombre completo", "          Años", "      10 Dígitos"," Cll, Av, Cra, Diag "}, 30, 80, true); 
        Formulario formularioOperarios= new Formulario("            CONTROL operarios", fpaneRegistrarOperarios, 23);
        this.sceneRegistrarOperarios= new Scene(formularioOperarios, 350, 460);
        sceneRegistrarOperarios.getStylesheets().add("GUI/Viper.css");
        
        //Formulario Productos
        FieldPanel fpaneRegistrarProductos= new FieldPanel("           DATOS", new String[]{"Nombre del producto", "Precio del producto", "Años garantia"}, "           VALOR", new String[]{"", "          COP", " "}, 30, 80, true); 
        Formulario formularioProductos= new Formulario("            CONTROL productos", fpaneRegistrarProductos, 23);
        this.sceneRegistrarProductos= new Scene(formularioProductos, 350, 350);
        sceneRegistrarProductos.getStylesheets().add("GUI/Viper.css");
        
        //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
       
        //Recolectar Datos
        BorderPane layoutRecolectarDatos= new BorderPane();
        layoutRecolectarDatos.setTop(new MenuSuperior());
     
        //Tabla cliente
        TableColumn<Factura, String> clienteColumn= new TableColumn<>("Cliente");
        clienteColumn.setMinWidth(150);
        clienteColumn.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        
        //Columna producto
        TableColumn<Factura, String> productoColumn= new TableColumn<>("Producto");
        productoColumn.setMinWidth(150);
        productoColumn.setCellValueFactory(new PropertyValueFactory<>("producto"));
        //Columna puntuacion
        TableColumn<Factura, String> puntuacionColumn= new TableColumn<>("Puntuación");
        puntuacionColumn.setMinWidth(150);
        puntuacionColumn.setCellValueFactory(new PropertyValueFactory<>("puntuacion"));
        //Columna operario
        TableColumn<Factura, String> operarioColumn= new TableColumn<>("Operario");
        operarioColumn.setMinWidth(150);
        operarioColumn.setCellValueFactory(new PropertyValueFactory<>("operario"));
        //Creacion tabla
        tablaFactura = new TableView<>();
        tablaFactura.setMaxWidth(600);
        tablaFactura.getColumns().addAll(clienteColumn, productoColumn, puntuacionColumn, operarioColumn);
        //Diseño recolectarDatos
        VBox vbox= new VBox();
        mes= new TextField("");
        mes.setEditable(false);
        mes.setId("negrilla");
        mes.setMaxSize(600, 50);
        mes.setAlignment(Pos.TOP_LEFT);
        vbox.getChildren().addAll(mes,tablaFactura);
        vbox.setSpacing(10);
        layoutRecolectarDatos.setCenter(vbox);
        this.sceneRecolectarDatos= new Scene(layoutRecolectarDatos, 600, 370);
        sceneRecolectarDatos.getStylesheets().add("GUI/Viper.css");
        
        //Ganancias Mes
        FieldPanel fpaneGananciasMes= new FieldPanel("           DATOS", new String[]{"Ganancias por el cobro de luz", "Ganancias por el cobro de acueducto", "Ganancias por el cobro de alcantaillado", "Ganancias por el cobro de gas"
        , "Consumo promedio de luz en kwh", "Consumo promedio de agua del acueducto en m3", "Consumo promedio de agua del alcantarillado en m3", "Consumo promedio de gas en m3"}, "           VALOR", 
        new double[]{GananciasMes.getGananciasLuz(),GananciasMes.getGananciasAcueducto() ,GananciasMes.getGananciasAlcantarillado(),GananciasMes.getGananciasGas(), GananciasMes.getConsumoLuz(), GananciasMes.getConsumoAcueducto(), GananciasMes.getConsumoAlcantarillado(), GananciasMes.getConsumoGas() }, 30, 80, true); 
      
        mes2= new TextField("GANANCIAS MES DE ?");
        mes2.setEditable(false);
        mes2.setId("negrilla");
        mes2.setMaxSize(420, 50);
        mes2.setAlignment(Pos.TOP_RIGHT);
        Formulario formularioGananciasMes= new Formulario(mes2, fpaneGananciasMes, 150);
        this.sceneGananciasMes= new Scene(formularioGananciasMes, 600, 625);
        sceneGananciasMes.getStylesheets().add("GUI/Viper.css");
               
        //Ganancias Semestre
       
        FieldPanel fpaneGananciasSemestre= new FieldPanel("           DATOS", new String[]{"Ganancias por el cobro del servio de luz en estos 6 meses", "Ganancias por el cobro del servio de Acueducto en estos 6 meses", "Ganancias por el cobro del servio de Alcantarillado en estos 6 meses", "Ganancias por el cobro del servio de Gas en estos 6 meses", "Ganancias por el cobro total de servicios en estos 6 meses"
        , "Consumo promedio de luz en kwh en estos 6 meses", "Consumo promedio de agua del acueducto en m3 en estos 6 meses", "Consumo promedio de agua del alcantarillado en m3 en estos 6 meses", "Consumo promedio de gas en m3 en estos 6 meses"}, "           VALOR", 
        new double[]{GananciasSemestre.getGananciasLuz(),GananciasSemestre.getGananciasAcueducto() ,GananciasSemestre.getGananciasAlcantarillado(),GananciasSemestre.getGananciasGas(), GananciasSemestre.getSuma(), GananciasSemestre.getConsumoLuz(), GananciasSemestre.getConsumoAcueducto(), GananciasSemestre.getConsumoAlcantarillado(), GananciasSemestre.getConsumoGas() }, 30, 80, false); 
        
        mes3= new TextField("GANANCIAS MES DE ?");
        mes3.setEditable(false);
        mes3.setId("negrilla");
        mes3.setMaxSize(520, 50);
        mes3.setAlignment(Pos.TOP_RIGHT);
        Formulario formularioGananciasSemestre= new Formulario(mes3, fpaneGananciasSemestre, 150 );
        this.sceneGananciasSemestre= new Scene(formularioGananciasSemestre, 650, 675);
        sceneGananciasSemestre.getStylesheets().add("GUI/Viper.css");
            
        //Empleado del mes
        
        VBox vBoxEmpleadoDelMes= new VBox();
        vBoxEmpleadoDelMes.setSpacing(5);
        HBox hBoxEmpleadoDelMes= new HBox();
        hBoxEmpleadoDelMes.setSpacing(10);
        Image trofeo= new Image("images/trofeo.png");
        Label textoEmpleadoDelMes= new Label("EL EMPLEADO DEL MES ES:"); textoEmpleadoDelMes.setId("negrilla2"); textoEmpleadoDelMes.setMinSize(100,100);
       
        TableColumn<Operario, String> cedulaColumn= new TableColumn<>("Cédula");
        cedulaColumn.setMinWidth(120);
        cedulaColumn.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        
        //Columna nombre
        TableColumn<Operario, String> nombreColumn= new TableColumn<>("Nombre");
        nombreColumn.setMinWidth(118);
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        //Columna edad
        TableColumn<Operario, Integer> edadColumn= new TableColumn<>("Edad");
        edadColumn.setMinWidth(118);
        edadColumn.setCellValueFactory(new PropertyValueFactory<>("edad"));
        //Columna telefono
        TableColumn<Operario, String> telefonoColumn= new TableColumn<>("Teléfono");
        telefonoColumn.setMinWidth(118);
        telefonoColumn.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        //Columna direccion
        TableColumn<Operario, String> direccionColumn= new TableColumn<>("Dirección");
        direccionColumn.setMinWidth(118);
        direccionColumn.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        //Creacion tabla
        tablaOperario = new TableView<>();
        tablaOperario.setMaxSize(600,60);
        tablaOperario.getColumns().addAll(cedulaColumn, nombreColumn, edadColumn, telefonoColumn, direccionColumn);
        
        
        textFieldEmpleadoDelMes= new TextField("Con un puntaje promedio de:  0.0");
        textFieldEmpleadoDelMes.setEditable(false);
        textFieldEmpleadoDelMes.setId("negrilla");
        textFieldEmpleadoDelMes.setMaxSize(280, 50);
        textFieldEmpleadoDelMes.setAlignment(Pos.TOP_RIGHT);
        
        hBoxEmpleadoDelMes.getChildren().addAll(new ImageView(trofeo), textoEmpleadoDelMes); 
        vBoxEmpleadoDelMes.getChildren().addAll(new MenuSuperior(),hBoxEmpleadoDelMes, tablaOperario, textFieldEmpleadoDelMes);
        this.sceneEmpleadoDelMes= new Scene(vBoxEmpleadoDelMes, 600, 240);
        sceneEmpleadoDelMes.getStylesheets().add("GUI/Viper.css");
        
        //----------------------------------------------------------------------------------------------------------------------------
       
        
       
       //Escena usuario
        BorderPane layoutPrincipal= new BorderPane();
        layoutPrincipal.setTop(new MenuSuperior());
        Image foto= new Image("images/ESP2.jpg");
        layoutPrincipal.setCenter(new ImageView(foto));
        stage.setTitle("Empresa de servicios públicos");
        this.sceneUsuario= new Scene(layoutPrincipal, 350, 400);
        sceneUsuario.getStylesheets().add("GUI/Viper.css");
        
        //Escena incio
       
        
        imagen = new ImageView("images/ESP.jpg");
		agua = new Image("images/agua.jpg");
		luz = new Image("images/luz.jpg");
		gas = new Image("images/gas.jpg");
		mundo = new Image ("images/mundo.jpg");
		logo2= new Image ("images/yinier.jpg");
		ESP= new Image ("images/ESP.jpg");
		

		
		
		bien = new Label("                 Bienvenido al Software de \r\n "
				+ " Empresa de servicios Publicos ESP-PARA TODOS");
		bien.setContentDisplay(ContentDisplay.BOTTOM);
                bien.setId("negrilla");
        bien.setOnMouseEntered(mouseHandler);

		
        label1 = new Label("Empresa de Servicios Publicos, mas conocida como\r\n"
				+ "ESP, es una empresa prestadora de servicios \r\n" + 
				"colombiana creada en febrero del  2020.\r\n \r\n" + 
				"Los servicios que presta son: luz, acueducto,\r\n"+
				"alcantarillado y gas.\r\n"+
				"\r\n" );
        label1.setAlignment(Pos.CENTER);
        label1.setId("letra-blanca");
        
         CVsebas = new Label("Sebastian Beltran Arenas CC. 1001366260\r\n"+
				"\r\n" + 

				"Estudiante de Ingenieria de Sistemas e Informatica\r\n" + 
				"de la Universidad Nacional de Colombia sede Medellin \r\n" + 
				"Actualmente derarolla este Software como practica del \r\n" + 
				"curso de Programacion Orientado a Objetos (POO)\r\n" + 
				"\r\n" + 

				"Informacion de contacto: \r\n" + 
				"\r\n" + 

				"Email: sbeltrana@unal.edu.co\r\n"+ 
				"Telefono: +57 300 7904147\r\n" );
        CVsebas.setOnMouseClicked(mouseHandler);
        CVsebas.setId("letra-blanca");
        Button botonsalir = new Button ("Salir"); botonsalir.getStyleClass().add("boton-rojo");
		botonsalir.setOnAction(e -> System.exit(0));
		botonsalir.setContentDisplay(ContentDisplay.BOTTOM);
		siguiente = new Button("Siguiente");  siguiente.getStyleClass().add("boton-azul"); siguiente.setMinSize(75, 30);
                siguiente.setOnAction(new EventHandler<ActionEvent>(){
                  public void handle(ActionEvent e){
                   InterfazGrafica.getStage().setScene(getSceneUsuario());
                }});
		descripcion = new Button("Descripcion"); descripcion.getStyleClass().add("boton-azul");
		Label desc = new Label (" Descripcion : Con este software usted podra:   \r\n" + 
				"1.Registrar datos de :        \r\n" + 
				"Cientes, operarios y productos.  \r\n" + 
				"2. Usar funciones como :          \r\n" + 
				"Recoleccion de datos, calcular las ganacias del mes,\r\n" + 
				"calcularlas ganancias de los ultimos seis meses y  \r\n" + 
				"obtener elempleado del mes.    \r\n" + 
				"3. Guardar datos, de los clientes, operarios y productos \r\n" + 
				"en un archivo TXT");
                
                desc.setId("letra-blanca");
        
		fotos = new Image("images/compas.jpeg");
		crea = new Label("Creadores del Programa", new ImageView(fotos));
		crea.setContentDisplay(ContentDisplay.BOTTOM);
                crea.setId("negrilla");
		
		
		//menu de inicio:
		MenuBar	 BarraMenu = new MenuBar();
 
		Menu MenuInicio = new Menu ("Inicio");
              
               
                
		BarraMenu.getMenus().add(MenuInicio);
		MenuItem opcion1 = new MenuItem("Salir");
		MenuItem opcion2 = new MenuItem("Descripcion");
		SeparatorMenuItem separator = new SeparatorMenuItem();
		MenuInicio.getItems().add(opcion1);
		MenuInicio.getItems().add(opcion2);
		opcion1.setOnAction(e -> System.exit(0));

		
		
		
		

		HBox hbox= new HBox();
                hbox.getChildren().addAll(siguiente);
                hbox.setSpacing(15);
                hbox.setAlignment(Pos.BOTTOM_CENTER);
	        vertical1 = new VBox ();
                vertical1.setMinWidth(380);
		vertical1.getChildren().addAll( bien, imagen, label1);
                vertical1.setSpacing(5);
                vertical1.setAlignment(Pos.CENTER);
		VBox vertical2 = new VBox ( crea, CVsebas);
                
                vertical2.setSpacing(10);
                vertical2.setAlignment(Pos.CENTER);

        imagen.setOnMouseEntered(mouseHandler);
        


		opcion2.setOnAction(e ->{vertical1.getChildren().remove(label1);
                    
                    vertical1.getChildren().add(desc);});

		
		HBox horizontal = new HBox( vertical1,vertical2);
                horizontal.setPadding(new Insets(0,10,10,0));
                horizontal.setSpacing(0);
                VBox vertical3= new VBox(BarraMenu, horizontal, hbox );
                vertical3.setSpacing(5);
                vertical3.setPadding(new Insets(0,0,20,0));
	        sceneInicio = new Scene(vertical3, 710, 500);
		sceneInicio.getStylesheets().add("GUI/Viper.css");
                
        stage.setScene(getSceneInicio());      
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
    public static Scene getSceneInicio(){
      return sceneInicio;
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
    
    public static Scene getSceneEmpleadoDelMes(){
      return sceneEmpleadoDelMes;
    }
    
    public static void closeProgram(){
      boolean answer= ConfirmBox.ejecutar("Aviso", "¿Desea guardar datos?");
      if(answer== true){
        BaseDatos.EscritorJson.escribirClientes();
        BaseDatos.EscritorJson.escribirOperarios();
        BaseDatos.EscritorJson.escribirProductos();  
        BaseDatos.EscritorJson.escribirMes();
      }
      stage.close();
    }
    
  EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>(){
    	public void handle(MouseEvent mouseEvent) {
    		String tipo=  mouseEvent.getEventType().toString();
    		if (tipo.contentEquals("MOUSE_CLICKED")) {
    		String s = CVsebas.getText().toString();
			if(s.equals("Sebastian Beltran Arenas CC. 1001366260\r\n"+
					"\r\n" + 

				"Estudiante de Ingenieria de Sistemas e Informatica\r\n" + 
				"de la Universidad Nacional de Colombia sede Medellin \r\n" + 
				"Actualmente derarolla este Software como practica del \r\n" + 
				"curso de Programacion Orientado a Objetos (POO)\r\n" + 
				"\r\n" + 

				"Informacion de contacto: \r\n" + 
				"\r\n" + 
					"Email: sbeltrana@unal.edu.co\r\n"+ 
					"Telefono: +57 300 7904147\r\n" )) {
				CVsebas.setText("Juan José Correa Hurtado CC. 1152459256\r\n"+
					"\r\n" + 
                                "Estudiante de Ingenieria de Sistemas e Informatica\r\n" + 
				"de la Universidad Nacional de Colombia sede Medellin \r\n" + 
				"Actualmente derarolla este Software como practica del \r\n" + 
				"curso de Programacion Orientado a Objetos (POO)\r\n" + 
				"\r\n" + 

				"Informacion de contacto: \r\n" + 
				"\r\n" + 

						"Email: jjcorreahu@unal.edu.co\r\n"+ 
						"Telefono: +57 317 7501170\r\n");
			}else if(s.equals("Juan José Correa Hurtado CC. 1152459256\r\n"+
					"\r\n" + 
                                "Estudiante de Ingenieria de Sistemas e Informatica\r\n" + 
				"de la Universidad Nacional de Colombia sede Medellin \r\n" + 
				"Actualmente derarolla este Software como practica del \r\n" + 
				"curso de Programacion Orientado a Objetos (POO)\r\n" + 
				"\r\n" + 

				"Informacion de contacto: \r\n" + 
				"\r\n" + 

						"Email: jjcorreahu@unal.edu.co\r\n"+ 
						"Telefono: +57 317 7501170\r\n")){
				CVsebas.setText("Yinier Ramirez Barahona CC. 1152713100\r\n"+
						"\r\n" + 

				"Estudia Ingenieria de Sistemas e Informatica en la\r\n" + 
				"Universidad Nacional de Colombia sede Medellin. \r\n" + 
				"Actualmente derarolla este Software como practica del \r\n" + 
				"curso de Programacion Orientado a Objetos (POO)\r\n" + 
				"\r\n" + 

				"Informacion de contacto: \r\n" + 
				"\r\n" + 

						"Email: yiaramirezba@unal.edu.co\r\n"+ 
						"Telefono: +57 302 2834094\r\n");
			}
			else if(s.equals("Yinier Ramirez Barahona CC. 1152713100\r\n"+
					"\r\n" + 

				"Estudia Ingenieria de Sistemas e Informatica en la\r\n" + 
				"Universidad Nacional de Colombia sede Medellin. \r\n" + 
				"Actualmente derarolla este Software como practica del \r\n" + 
				"curso de Programacion Orientado a Objetos (POO)\r\n" + 
				"\r\n" + 

				"Informacion de contacto: \r\n" + 
				"\r\n" + 

					"Email: yiaramirezba@unal.edu.co\r\n"+ 
					"Telefono: +57 302 2834094\r\n")){
				CVsebas.setText("Sebastian Beltran Arenas CC. 1001366260\r\n"+
						"\r\n" + 

				"Estudiante de Ingenieria de Sistemas e Informatica\r\n" + 
				"de la Universidad Nacional de Colombia sede Medellin \r\n" + 
				"Actualmente derarolla este Software como practica del \r\n" + 
				"curso de Programacion Orientado a Objetos (POO)\r\n" + 
				"\r\n" + 

				"Informacion de contacto: \r\n" + 
				"\r\n" + 

						"Email: sbeltrana@unal.edu.co\r\n"+ 
						"Telefono: +57 300 7904147\r\n");
			}
			
		}
    		if (tipo.contentEquals("MOUSE_ENTERED")) {
    			

						
		    				switch(contador) {
		        			case 0:
                                                        contador= 1;
		        				vertical1.getChildren().remove(label1);
                                                        vertical1.getChildren().remove(imagen);
                                                        imagen.setImage(agua);
                                                        vertical1.getChildren().add(imagen);
                                                        vertical1.getChildren().add(label1);
                                                        
		        				break;
		        			
		        			case 1:
		        				contador=2;
		        				vertical1.getChildren().remove(label1);
                                                        vertical1.getChildren().remove(imagen);
                                                        imagen.setImage(gas);
                                                        vertical1.getChildren().add(imagen);
                                                        vertical1.getChildren().add(label1);
		        				break;
		        			case 2:
		        				contador=3;
		        				vertical1.getChildren().remove(label1);
                                                        vertical1.getChildren().remove(imagen);
                                                        imagen.setImage(luz);
                                                        vertical1.getChildren().add(imagen);
                                                        vertical1.getChildren().add(label1);
		        				break;
		        			case 3:
		        				contador=4;
		        				vertical1.getChildren().remove(label1);
                                                        vertical1.getChildren().remove(imagen);
                                                        imagen.setImage(mundo);
                                                        vertical1.getChildren().add(imagen);
                                                        vertical1.getChildren().add(label1);
		        				break;
		        			case 4:
		        				contador=0;
		        				vertical1.getChildren().remove(label1);
                                                        vertical1.getChildren().remove(imagen);
                                                        imagen.setImage(ESP);
                                                        vertical1.getChildren().add(imagen);
                                                        vertical1.getChildren().add(label1);
		        				break;
		    				
		    			        }							
						
    					
    				};
    				

    			
 
    			}
    		
   
    		

    };
    	
    };
    

