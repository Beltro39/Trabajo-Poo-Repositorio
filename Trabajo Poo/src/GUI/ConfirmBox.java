package GUI;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

//Clase para crear ventanas que le piden confirmar una accion
public class ConfirmBox {
    
    static boolean answer;
    public static boolean ejecutar(String titulo, String mensaje){
      Stage stage= new Stage();
        
      stage.initModality(Modality.APPLICATION_MODAL);
      stage.setTitle(titulo);
      
      Label label= new Label();
      label.setText(mensaje); label.setId("letra-blanca");
      Button yesButton= new Button(" Si ");
      yesButton.getStyleClass().add("boton-azul");
      Button noButton= new Button(" No ");
      noButton.getStyleClass().add("boton-rojo");
      yesButton.setMaxSize(100, 10);
      noButton.setMaxSize(100, 10);
       
      yesButton.setOnAction(new EventHandler<ActionEvent>(){
        public void handle(ActionEvent e){
        answer= true;
        stage.close();
        }});
  
      noButton.setOnAction(new EventHandler<ActionEvent>(){
        public void handle(ActionEvent e){
        answer= false;
        stage.close();
        }});
      
      VBox layout= new VBox();
      HBox hbox= new HBox();
      hbox.getChildren().addAll(yesButton, noButton);
      hbox.setAlignment(Pos.BOTTOM_CENTER);
      hbox.setSpacing(10);
      layout.getChildren().addAll(label, hbox);
      layout.setAlignment(Pos.CENTER);
      layout.setSpacing(10);
      
      Scene scene= new Scene(layout, 250, 75);
      stage.setScene(scene);
      scene.getStylesheets().add("GUI/Viper.css");
      stage.showAndWait();
      
      return answer;
    }
}
