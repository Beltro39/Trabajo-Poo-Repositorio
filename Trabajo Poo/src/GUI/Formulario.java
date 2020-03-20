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
    Formulario(String titulo, FieldPanel fpane, int distancia, boolean parteInferior){
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
      if(parteInferior){
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
    Formulario(TextField textField, FieldPanel fpane, int distancia, boolean parteInferior){
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
      if(parteInferior){
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
  
}
