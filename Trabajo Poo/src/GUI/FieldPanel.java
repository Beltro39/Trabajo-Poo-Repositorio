package GUI;
import gestorAplicacion.Cliente;
import gestorAplicacion.Operario;
import gestorAplicacion.Producto;
import gestorAplicacion.ServiciosPublicos;
import java.util.Vector;
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
   private String[] respuestas;
   private TextField[] campos;
   GridPane gpane;
   
   FieldPanel(String nombreCriterio, String[] criterios, String nombreValor, String[] valores){
     this.nombreCriterio= nombreCriterio;
     this.criterios= criterios;
     this.nombreValor= nombreValor;
     this.valores= valores;
     this.campos= new TextField[criterios.length];
     
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
       campos[i]= textField;
     }
     
    
   }
   
  
   
   public void crearObjeto(){
     this.respuestas= new String[criterios.length];
     
     for(int i= 0; i<criterios.length; i++){
       respuestas[i]= campos[i].getText();
     }
     
     if(criterios.length== 6){
       new Cliente(respuestas[0], respuestas[1], Integer.parseInt(respuestas[2]), respuestas[3], Integer.parseInt(respuestas[4]),  respuestas[5], new ServiciosPublicos(new Vector<>(), new Vector<>() ), new ServiciosPublicos(new Vector<>(), new Vector<>()), new ServiciosPublicos(new Vector<>(), new Vector<>()), new ServiciosPublicos(new Vector<>(), new Vector<>()), new Vector<String>());
     }
     
     if(criterios.length== 5){
       new Operario(respuestas[0], respuestas[1], Integer.parseInt(respuestas[2]), respuestas[3], respuestas[4], new Vector<Double>());
     }
     
     if(criterios.length== 3){
      new Producto(respuestas[0], Integer.parseInt(respuestas[1]), respuestas[2]);
     }
   }
   public void borrarTodo(){
     for(int i= 0; i<criterios.length; i++){
        campos[i].setText(null);
        campos[i].requestFocus();
     }
   }
}
