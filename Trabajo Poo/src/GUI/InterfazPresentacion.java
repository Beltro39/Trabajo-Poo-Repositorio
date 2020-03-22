package GUI;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.util.*;



public class InterfazPresentacion extends Application {

    Scene scene1;
    Image fotos,  logo2, mundo, agua, luz, gas, ESP ;
    Label label1,CVsebas, crea, bien ;
    Button siguiente, descripcion;
    Alert alerta;
    ImageView  imagen;
    static int contador=0;
    

    int velocidad =2; //segundos

    Timer timer;
    TimerTask tarea;
    int velmil= velocidad*1000;

    
    public static void main(String[] args) {
        launch(args);
        


    }
    
    

    @Override
	public void start(Stage myStage) throws Exception {

		myStage.setTitle("Empresa de Servicios Publicos");
		imagen = new ImageView("images/ESP.png");
		agua = new Image("images/agua.jpg");
		luz = new Image("images/luz.jpg");
		gas = new Image("images/gas.jpg");
		mundo = new Image ("images/mundo.jpg");
		logo2= new Image ("images/yinier.jpg");
		ESP= new Image ("images/ESP.png");
		

		
		
		bien = new Label("Bienvenido al Software de Empresa de servicios Publicos  \r\n "
				+ "                         ESP-PARA TODOS");
		bien.setContentDisplay(ContentDisplay.BOTTOM);
        bien.setOnMouseEntered(mouseHandler);

		
        label1 = new Label("Empresa de Servicios Publicos, mas conocida como\r\n"
				+ " ESP, es una empresa prestadora de servicios \r\n" + 
				"colombiana creada en febrero del  2020.\r\n" + 
				"Los servicios que presta son: Luz, acueducto,\r\n"+
				" alcantarillado y gas.\r\n"+
				"\r\n" );
        label1.setAlignment(Pos.CENTER);
        
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
        Button botonsalir = new Button ("Salir");
		botonsalir.setOnAction(e -> System.exit(0));
		botonsalir.setContentDisplay(ContentDisplay.BOTTOM);
		siguiente = new Button("Siguiente");
		descripcion = new Button("Descripcion");
		Label desc = new Label (" Descripcion : Con este software usted podra:   \r\n" + 
				"\r\n"+
				"1.Registrar datos de :        \r\n" + 
				"Cientes, operarios y productos.  \r\n" + 
				"2. Usar funciones como :          \r\n" + 
				"Recoleccion de datos, calcular las ganacias del mes,\r\n" + 
				"calcularlas ganancias de los ultimos seis meses y  \r\n" + 
				"obtener elempleado del mes.    \r\n" + 
				"3. Guardar datos, de los clientes, operarios y productos \r\n" + 
				"en un archivo TXT");

        
		fotos = new Image("images/compas.jpeg");
		crea = new Label("Creadores del Programa", new ImageView(fotos));
		crea.setContentDisplay(ContentDisplay.BOTTOM);
		
		
		//menu de inicio:
		MenuBar	 BarraMenu = new MenuBar();
		Menu MenuInicio = new Menu ("Menu");
		BarraMenu.getMenus().add(MenuInicio);
		MenuItem opcion1 = new MenuItem("Salir");
		MenuItem opcion2 = new MenuItem("Descripcion");
		SeparatorMenuItem separator = new SeparatorMenuItem();
		MenuInicio.getItems().add(opcion1);
		MenuInicio.getItems().add(opcion2);
		opcion1.setOnAction(e -> System.exit(0));

		Label lbl = new Label ("Presione un menu"); 
		
		HBox menu = new HBox(BarraMenu);
		menu.getChildren().addAll(lbl);

		
		VBox vertical1 = new VBox ();
		vertical1.getChildren().addAll( menu, bien, imagen, label1);
		VBox vertical2 = new VBox (crea, CVsebas, botonsalir, siguiente, descripcion);
		descripcion.setOnAction(e -> vertical1.getChildren().add(desc));

        imagen.setOnMouseEntered(mouseHandler);


		opcion2.setOnAction(e ->vertical1.getChildren().add(desc));

		
		HBox horizontal = new HBox( vertical1,vertical2);
		Scene scene = new Scene(horizontal, 600, 550);
		
		
        myStage.setScene(scene);
		myStage.show();
		
		
		
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
				CVsebas.setText("Juan Jose Correa CC. 1152469256\r\n"+
						"\r\n" + 

				"Estudiante de sexto Semestre de  de Ingenieria de Sistemas\r\n" + 
				" e Informatica de la Universidad Nacional de Colombia \r\n" + 
				" sede Medellin Actualmente derarolla este Software como \r\n" + 
				" practica del curso de Programacion Orientado a Objetos (POO)\r\n" + 
				"Idiomas :Espanol e Ingles\"\r\n\""+
				"\r\n" + 

				"Informacion de contacto: \r\n" + 
				"\r\n" + 

						"Email: XXXXXXXXXXXXXX@unal.edu.co\r\n"+ 
						"Telefono: +57 317 7501170\r\n");
			}else if(s.equals("Juan Jose Correa CC. 1152469256\r\n"+
					"\r\n" + 

				"Estudiante de sexto Semestre de  de Ingenieria de Sistemas\r\n" + 
				" e Informatica de la Universidad Nacional de Colombia \r\n" + 
				" sede Medellin Actualmente derarolla este Software como \r\n" + 
				" practica del curso de Programacion Orientado a Objetos (POO)\r\n" + 
				"Idiomas :Espanol e Ingles\"\r\n\""+
				"\r\n" +   

				"Informacion de contacto: \r\n" + 
				"\r\n" + 

						"Email: XXXXXXXXXXXXXX@unal.edu.co\r\n"+ 
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
    			/*List<Image> img = new ArrayList<Image>();
    			img.add(agua);
    			img.add(luz);
    			img.add(gas);
    			img.add(mundo);
    			img.add(logo2);
    			img.add(ESP);
    			for(int i =0; i<6; i++) {
					imagen.setImage(img.get(i));
					imagen.sc*/
    				tarea = new TimerTask() {

						@Override
						public void run() {
		    				switch(contador) {
		        			case 0:
		        				contador=1;
		        				imagen.setImage(agua);
		        				break;
		        			
		        			case 1:
		        				contador=2;
		        				imagen.setImage(gas);
		        				break;
		        			case 2:
		        				contador=3;
		        				imagen.setImage(luz);
		        				break;
		        			case 3:
		        				contador=4;
		        				imagen.setImage(mundo);
		        				break;
		        			case 4:
		        				contador=0;
		        				imagen.setImage(ESP);
		        				break;
		    				
		    			}							
						}
    					
    				};
    				timer = new Timer();
    				timer.schedule(tarea, velmil, velmil);

    			
 
    			}
    		
   
    		

    };
    	
    };
    
}
