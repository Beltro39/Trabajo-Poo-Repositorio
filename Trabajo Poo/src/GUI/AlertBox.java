package GUI;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
    public static void ejecutar(String titulo, String mensaje){
      Stage stage= new Stage();
      stage.initModality(Modality.APPLICATION_MODAL);
      stage.setTitle(titulo);
      
      Label label= new Label();
      label.setText(mensaje); label.setId("letra-blanca");
      Button closeButton= new Button("Aceptar");  closeButton.getStyleClass().add("boton-azul");
      closeButton.setOnAction(e -> stage.close());
      
      VBox layout= new VBox();
      layout.getChildren().addAll(label, closeButton);
      layout.setAlignment(Pos.CENTER);
      layout.setSpacing(10);
      
      Scene scene= new Scene(layout, 250, 75);
      stage.setScene(scene);
      scene.getStylesheets().add("GUI/Viper.css");
      stage.showAndWait();
      
      
    }
}
