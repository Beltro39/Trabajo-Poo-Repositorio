package GUI;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.applet.AudioClip;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//Clase para hacer ventanas de alerta

public class AlertBox {
    public static void ejecutar(String titulo, String mensaje, int h, int y){
      Stage stage= new Stage();
      stage.initModality(Modality.APPLICATION_MODAL);
      stage.setTitle(titulo);
      
      Label label= new Label();
      label.setText(mensaje); label.setId("letra-blanca");
      Button closeButton= new Button("Aceptar");  closeButton.getStyleClass().add("boton-azul");
      closeButton.setMinSize(75, 35);
     
      
      closeButton.setOnAction(new EventHandler<ActionEvent>(){
        public void handle(ActionEvent e){
        stage.close();
        }
      });
              
              
      
      
      VBox layout= new VBox();
      
      layout.getChildren().addAll(label, closeButton);
      layout.setAlignment(Pos.CENTER);
      layout.setSpacing(10);
      
      Scene scene= new Scene(layout, h, y);
      stage.setScene(scene);
      scene.getStylesheets().add("GUI/Viper.css");
      stage.showAndWait();
      
      
    }
}
