package GUI;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class FieldPanel extends Pane{
   private String nombreCriterio;
   private String nombreValor;
   private String[] criterios;
   private String[] valores;
   GridPane gpane;
   
   FieldPanel(String nombreCriterio, String[] criterios, String nombreValor, String[] valores){
     this.nombreCriterio= nombreCriterio;
     this.criterios= criterios;
     this.nombreValor= nombreValor;
     this.valores= valores;
     
     Label label;
     
     this.gpane= new GridPane();
     gpane.setVgap(30);
     gpane.setHgap(80);
     gpane.add(label= new Label(nombreCriterio), 0, 0); label.setId("letra-blanca"); 
     gpane.add(label= new Label(nombreValor), 1, 0);  label.setId("letra-blanca"); 
     gpane.setAlignment(Pos.CENTER);
         
     int i= 0;
     for( i= 0; i<criterios.length; i++){
       gpane.add(label= new Label(criterios[i]), 0, i+1);label.setId("letra-blanca");
       TextField textField= new TextField();
       textField.setPromptText(valores[i]);
       
       textField.setFocusTraversable(false);
       textField.setMaxSize(115, 15);
       gpane.add(textField, 1, i+1);
     }
     
     //Button boton;
     //gpane.add(new Button("Aceptar"), 0, i+1);
     //gpane.add(boton= new Button("           Borrar          "), 1, i+1);
    
     
   }
   
   
}
