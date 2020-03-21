package GUI;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//Bienvenida y hojas de vida de los creadores del programa

public class InterfazPresentacion extends Application{

@Override
public void start(Stage myStage) throws Exception {
// TODO Auto-generated method stub
myStage.setTitle("Empresa de Servicios Públicos");


BorderPane root = new BorderPane();
Label lab2 = new Label("Bienvenido");
root.setTop(lab2);
Scene myScene = new Scene (root,620,400);
BorderPane layout2= new BorderPane();
BorderPane layout3= new BorderPane();
BorderPane layout4= new BorderPane();


Scene scene2   = new Scene(layout2, 550, 360) ;
Scene scene3   = new Scene(layout3, 550, 360) ;
Scene scene4   = new Scene(layout4, 550, 360) ;


myStage.setScene(myScene);
myStage.show();

GridPane root1 = new GridPane();
root1.setPadding(new Insets(10, 10, 10, 10));
Button boton = new Button ("Siguiente");
Button botonsalir = new Button ("Salir");
botonsalir.setOnAction(e -> System.exit(0));
boton.setOnAction(e -> myStage.setScene(scene2));

root1.add(boton, 0, 0);
root1.add(botonsalir, 1, 0 );
root.setBottom(root1);


GridPane root2 = new GridPane();
root1.setPadding(new Insets(10, 10, 10, 10));

Label descrip = new Label("Empresa de Servicios Públicos, más conocida como ESP,\r\n"
		+ "es una empresa prestadora de servicios colombiana\r\n" + 
		"creada en febrero del  2020.\r\n" + 
		"                                     \r\n"+
		"Es una empresa multilatina prestadora de servicios \r\n" +
		"públicos siendo en total cuatro que son luz, acueducto,\r\n"+
		" alcantarillado y gas. Con este software usted podrá:\r\n"+
		"                                     \r\n"+
		"1.Registrar datos de :                           \r\n"+
		"Cientes, operarios y productos.          \r\n"+
		"2. Usar funciones como :                    \r\n"+
		"Recoleccion de datos, calcular las ganacias del mes, calcular\r\n"+
		"las ganancias de los ultimos seis meses y obtener el\r\n "
		+ "empleado del més.           \r\n"+
		"3. Guardar datos, de los clientes, operarios y productos\r\n "
		+ "en un archivo TXT\r\n "+
		 "                                     \r\n"+
		"En la siguiente pagina encontrará informacion de los creadores\r\n");


root2.add(descrip, 0, 0);
root.setCenter(root2);

GridPane roota = new GridPane();
roota.setPadding(new Insets(10, 10, 10, 10));
Label bien = new Label("Bienvenido al Software de Empresa de servicios Públicos ESP-PARA TODOS");
bien.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
roota.add(bien, 0, 0);
root.setTop(roota);


GridPane gridpane = new GridPane();
Image image = new Image("images/ESP.png");
gridpane.getChildren().add(new ImageView(image));
root.setLeft(gridpane);

//Scene2*********++
//BorderPane layout2= new BorderPane();
GridPane gridpane2 = new GridPane();
gridpane2.setPadding(new Insets(10, 10, 10, 10));

Image imagen2 = new Image("images/esppp.png");
gridpane2.getChildren().add(new ImageView(imagen2));
layout2.setTop(gridpane2);




GridPane botonnes = new GridPane();
botonnes.setPadding(new Insets(10, 10, 10, 10));

Button boton2 = new Button ("Atras");
Button botonsig = new Button ("Siguiente");
boton2.setOnAction(e -> myStage.setScene(myScene));
botonsig.setOnAction(e -> myStage.setScene(scene3));


botonnes.add(boton2, 1, 0);
botonnes.add(botonsig, 0, 0 );
layout2.setBottom(botonnes);
//Presentacion de sebastian
Label CVsebas = new Label("Sebastián Beltrán Arenas CC. 1001366260\r\n"+
		"\r\n" + 

		"Estudiante de Ingeniería de Sistemas e Informática\r\n" + 
		"de la Universidad Nacional de Colombia sede Medellín \r\n" + 
		"Actualmente derarolla este Software como práctica del \r\n" + 
		"curso de Programación Orientado a Objetos (POO)\r\n" + 
		"\r\n" + 

		"Información de contacto: \r\n" + 
		"\r\n" + 

		"Email: sbeltrana@unal.edu.co\r\n"+ 
		"Telefono: +57 300 7904147\r\n" );


		layout2.setCenter(CVsebas); 


GridPane fotoo = new GridPane();
Image foto = new Image("images/sebas.jpg");
fotoo.getChildren().add(new ImageView(foto));
layout2.setLeft(fotoo);

//Presentacion de Juan Jose
GridPane gridpanelogo = new GridPane();
gridpanelogo.setPadding(new Insets(10, 10, 10, 10));

Image imagenlogo = new Image("images/esppp.png");
gridpanelogo.getChildren().add(new ImageView(imagenlogo));
layout3.setTop(gridpanelogo);

GridPane fotojuan = new GridPane();
Image fotoj = new Image("images/juan.jpg");
fotojuan.getChildren().add(new ImageView(fotoj));
layout3.setLeft(fotojuan);

Label CVjuan = new Label("Juan José Correa CC. 1152469256\r\n"+
		"\r\n" + 

		"Estudiante de Ingeniería de Sistemas e Informática\r\n" + 
		"de la Universidad Nacional de Colombia sede Medellín \r\n" + 
		"Actualmente derarolla este Software como práctica del \r\n" + 
		"curso de Programación Orientado a Objetos (POO)\r\n" + 
		"\r\n" + 

		"Información de contacto: \r\n" + 
		"\r\n" + 

		"Email: XXXXXXXXXXXXXX@unal.edu.co\r\n"+ 
		"Telefono: +57 317 7501170\r\n" );


		layout3.setCenter(CVjuan); 
		
		GridPane botonesJuan = new GridPane();
		botonesJuan.setPadding(new Insets(10, 10, 10, 10));

		Button botonj = new Button ("Atras");
		Button botonsigj = new Button ("Siguiente");
		botonj.setOnAction(e -> myStage.setScene(scene2));
		botonsigj.setOnAction(e -> myStage.setScene(scene4));


		botonesJuan.add(botonj, 1, 0);
		botonesJuan.add(botonsigj, 0, 0 );
		layout3.setBottom(botonesJuan);
		
//Presentacion Yinier		
		GridPane gridpanelogoy = new GridPane();
		gridpanelogoy.setPadding(new Insets(10, 10, 10, 10));

		Image imagenlogoy = new Image("images/esppp.png");
		gridpanelogoy.getChildren().add(new ImageView(imagenlogoy));
		layout4.setTop(gridpanelogoy);

		GridPane fotoyinier = new GridPane();
		Image fotoy = new Image("images/yinier.jpg");
		fotoyinier.getChildren().add(new ImageView(fotoy));
		layout4.setLeft(fotoyinier);

		Label CVyinier = new Label("Yinier Ramírez Barahona CC. 1152713100\r\n"+
				"\r\n" + 

				"Estudiante de Ingeniería de Sistemas e Informática\r\n" + 
				"de la Universidad Nacional de Colombia sede Medellín \r\n" + 
				"Actualmente derarolla este Software como práctica del \r\n" + 
				"curso de Programación Orientado a Objetos (POO)\r\n" + 
				"\r\n" + 

				"Información de contacto: \r\n" + 
				"\r\n" + 

				"Email: yiaramirezba@unal.edu.co\r\n"+ 
				"Telefono: +57 302 2834094\r\n" );


				layout4.setCenter(CVyinier); 
				
			GridPane botonesYinier = new GridPane();
			botonesJuan.setPadding(new Insets(10, 10, 10, 10));

			Button botonY = new Button ("Atras");
			Button botonsigY = new Button ("Siguiente");
			botonY.setOnAction(e -> myStage.setScene(scene3));
			//botonsig.setOnAction(e -> myStage.setScene(scene3));

			
			botonesYinier.add(botonY, 1, 0);
			botonesYinier.add(botonsigY, 0, 0 );
			layout4.setBottom(botonesYinier);
}
public static void main(String [] args) {
launch(args);


}

}
