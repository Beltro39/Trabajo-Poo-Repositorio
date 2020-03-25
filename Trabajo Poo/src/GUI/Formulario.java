package GUI;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sun.font.TextLabel;


public class Formulario extends BorderPane{
    
    FieldPanel fpane;
    // Registro de clientes
    Formulario(String titulo, FieldPanel fpane, int distancia){
      this.fpane= fpane;  
      this.setPadding(new Insets(0,0,20,0));
      this.setTop(new MenuSuperior());
      //Centro del BorderPane
      VBox vBox= new VBox();
      Label text1= new Label(titulo); text1.setStyle("-fx-font-size: 16pt"); text1.setId("negrilla"); text1.setAlignment(Pos.CENTER_RIGHT);
      vBox.getChildren().add(new Label("            "));
      vBox.getChildren().add(text1);
      vBox.getChildren().add(new Label("            "));
      vBox.getChildren().add(fpane.gpane);
      this.setCenter(vBox);
      //Parte inferior del BorderPane
      HBox hbox= new HBox();
      Button botonRegistrar,botonConsultar, botonEditar, botonBorrar;
   
      hbox.getChildren().addAll(botonRegistrar= new Button("Registrar"), botonConsultar=new Button("Consultar"), botonEditar=new Button("Editar"),  botonBorrar=new Button("Borrar"));
      botonRegistrar.getStyleClass().add("boton-azul"); botonConsultar.getStyleClass().add("boton-azul"); botonEditar.getStyleClass().add("boton-azul");botonBorrar.getStyleClass().add("boton-rojo");
      //Lambda expression de los botones
      botonRegistrar.setOnAction(e -> fpane.crearObjeto());
      botonConsultar.setOnAction(e-> fpane.consultarObjeto());
      botonEditar.setOnAction(e-> {  boolean editar= ConfirmBox.ejecutar("Aviso", "¿Está seguro de que quiere editar?");
              if(editar){
              fpane.editarObjeto();
              }});
      botonBorrar.setOnAction(e-> fpane.borrarTodo());
      
      hbox.setAlignment(Pos.BOTTOM_CENTER);
      hbox.setSpacing(distancia);
      this.setBottom(hbox);
      
      
      
      
    }
    // Ganancias
    Formulario(TextField textField, FieldPanel fpane, int distancia){
      this.fpane= fpane;  
      this.setPadding(new Insets(0,0,20,0));
      this.setTop(new MenuSuperior());
      //Centro del BorderPane
      HBox hbox2= new HBox();
      
      VBox vBox= new VBox();
     
      vBox.getChildren().add(new Label("            "));
      vBox.getChildren().add(textField);
      vBox.getChildren().add(new Label("            "));
      vBox.getChildren().add(fpane.gpane);
      this.setCenter(vBox);
      //Parte inferior del BorderPane
      
      HBox hbox= new HBox();
      Button boton; Button boton2;
      hbox.getChildren().addAll(boton= new Button("Aceptar"),  boton2=new Button("Borrar")); boton.getStyleClass().add("boton-azul"); boton2.getStyleClass().add("boton-rojo");
      boton.setOnAction(e -> {fpane.crearObjeto();
                              AlertBox.ejecutar("Aviso", "Se ha registrado satisfactoriamente", 250, 75);});
      boton2.setOnAction(e-> fpane.borrarTodo());
      hbox.setAlignment(Pos.BOTTOM_CENTER);
      hbox.setSpacing(distancia);
      this.setBottom(hbox);
    
      
    
    }
  
}
