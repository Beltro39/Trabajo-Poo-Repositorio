package GUI;
import gestorAplicacion.Cliente;
import gestorAplicacion.Operario;
import gestorAplicacion.Producto;
import gestorAplicacion.ServiciosPublicos;
import java.util.Vector;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import uiMain.GananciasMes;
import uiMain.GananciasSemestre;
import ErroresAplicacion.*;

public class FieldPanel extends Pane{
   private String nombreCriterio;
   private String nombreValor;
   private String[] criterios;
   private String[] valores;
   private double[] valoresDouble;
   private String[] respuestas;
   private TextField[] campos;
   private static TextField[] camposGananciasMes;
   private static double[] valoresGananciasMes;
   private static TextField[] camposGananciasSemestre;
   private static double[] valoresGananciasSemestre;
   private static int tamaño;
   private static int tamaño2;
   private Metodos metodos = new Metodos();
   Alert alerta;
   
   GridPane gpane;
   
   FieldPanel(String nombreCriterio, String[] criterios, String nombreValor, String[] valores, int vgap, int hgap, boolean registroConsulta){
     this.nombreCriterio= nombreCriterio;
     this.criterios= criterios;
     this.nombreValor= nombreValor;
     this.valores= valores;
     this.campos= new TextField[criterios.length];
     
     Label label;
     
     this.gpane= new GridPane();
     gpane.setVgap(vgap);
     gpane.setHgap(hgap);
     gpane.add(label= new Label(nombreCriterio), 0, 0); label.setId("letra-blanca"); 
     gpane.add(label= new Label(nombreValor), 1, 0);  label.setId("letra-blanca"); 
     gpane.setAlignment(Pos.CENTER);
         
     int i= 0;
     
     //registroConsulta= true -> Formulario registro 
     //registroConsulta= false -> Formulario consulta 
     if(registroConsulta){
     for( i= 0; i<criterios.length; i++){
       gpane.add(label= new Label(criterios[i]), 0, i+1);label.setId("letra-blanca");
       TextField textField= new TextField();
       textField.setPromptText(valores[i]);
       
       textField.setFocusTraversable(false);
       textField.setMaxSize(115, 15);
       gpane.add(textField, 1, i+1);
       campos[i]= textField;
     }
     }else{
         gpane.add(label= new Label(criterios[i]), 0, i+1);label.setId("letra-blanca");
         TextField textField= new TextField();
         textField.setPromptText(valores[i]);
         textField.setFocusTraversable(false);
         textField.setMaxSize(115, 15);
       
         gpane.add(textField, 1, i+1);
         campos[i]= textField;
         
     for( i= 1; i<criterios.length; i++){
       gpane.add(label= new Label(criterios[i]), 0, i+1);label.setId("letra-blanca");
       textField= new TextField();
      // textField.setText(valores[i]);
       textField.setFocusTraversable(false);
       textField.setMaxSize(115, 15);
       textField.setEditable(false);
       gpane.add(textField, 1, i+1);
       campos[i]= textField;
     }
     
     }
     
     
    
   }
   FieldPanel(String nombreCriterio, String[] criterios, String nombreValor, double[] valores, int vgap, int hgap, boolean mesSemestre){
     this.nombreCriterio= nombreCriterio;
     this.criterios= criterios;
     this.nombreValor= nombreValor;
     //mesSemestre= true -> Constructor Ganancias del mes
     //mesSemestre= false -> Constructor Ganancias del semestre
     
     if(mesSemestre){
       valoresGananciasMes= valores;
       camposGananciasMes= new TextField[criterios.length];
     }else{
       valoresGananciasSemestre= valores;
       camposGananciasSemestre= new TextField[criterios.length];
     }
     Label label;
     
     this.gpane= new GridPane();
     gpane.setVgap(vgap);
     gpane.setHgap(hgap);
     gpane.add(label= new Label(nombreCriterio), 0, 0); label.setId("letra-blanca"); 
     gpane.add(label= new Label(nombreValor), 1, 0);  label.setId("letra-blanca"); 
     gpane.setAlignment(Pos.CENTER);
     if(mesSemestre){  
     for(int i= 0; i<criterios.length; i++){
       gpane.add(label= new Label(criterios[i]), 0, i+1);label.setId("letra-blanca");
       TextField textField= new TextField();
       textField.setText(String.valueOf(valoresGananciasMes[i]));
       textField.setFocusTraversable(false);
       textField.setMaxSize(115, 15);
       textField.setEditable(false);
       gpane.add(textField, 1, i+1);
       camposGananciasMes[i]= textField;
     }
     tamaño= criterios.length;
     }else{
         for(int i= 0; i<criterios.length; i++){
       gpane.add(label= new Label(criterios[i]), 0, i+1);label.setId("letra-blanca");
       TextField textField= new TextField();
       textField.setText(String.valueOf(valoresGananciasSemestre[i]));
       textField.setFocusTraversable(false);
       textField.setMaxSize(115, 15);
       textField.setEditable(false);
       gpane.add(textField, 1, i+1);
       camposGananciasSemestre[i]= textField;
       }
         tamaño2= criterios.length;
     
     }
     
 }
     public void crearObjeto(){
     this.respuestas= new String[criterios.length];
     for(int i= 0; i<criterios.length; i++){
       respuestas[i]= campos[i].getText();
     }
     
     
     if(criterios.length== 6){
    	 try {
    		 metodos.espacioVacio(respuestas[0], "Cedula");
    		 metodos.espacioVacio(respuestas[1], "Nombre");
    		 metodos.espacioVacio(respuestas[2], "Edad");
    		 metodos.espacioVacio(respuestas[3], "Telefono");
    		 metodos.espacioVacio(respuestas[4], "Estrato");
    		 metodos.espacioVacio(respuestas[5], "Direccion");
    		 metodos.cedulaCorrecta(respuestas[0]);
    		 metodos.telefonoCorrecto(respuestas[3]);
    		 metodos.estratoCorrecto(respuestas[4]);
    		 new Cliente(respuestas[0], respuestas[1], Integer.parseInt(respuestas[2]), respuestas[3], Integer.parseInt(respuestas[4]),  respuestas[5], new ServiciosPublicos(new Vector<>(), new Vector<>() ), new ServiciosPublicos(new Vector<>(), new Vector<>()), new ServiciosPublicos(new Vector<>(), new Vector<>()), new ServiciosPublicos(new Vector<>(), new Vector<>()), new Vector<String>());
    	 }catch(InputVacia e){
    		 alerta = new Alert(AlertType.WARNING);
    		 alerta.setTitle("No fue posible registrar el cliente");
    		 alerta.setHeaderText("WARNING: Por favor rellene todos los espacios");
    		 alerta.setContentText(e.getMessage());
    		 alerta.show();
    	 }catch(ErrorCedula ex) {
    		 alerta = new Alert(AlertType.INFORMATION);
    		 alerta.setHeaderText("Error al ingresar la cedula");
    		 alerta.setTitle("No fue posible registrar al cliente");
    		 alerta.setContentText(ex.getMessage());
    		 alerta.show();
    	 } catch (ErrorTelefono t) {
    		 alerta = new Alert(AlertType.INFORMATION);
    		 alerta.setHeaderText("Error al ingresar el telefono");
    		 alerta.setTitle("No fue posible registrar al cliente");
    		 alerta.setContentText(t.getMessage());
    		 alerta.show();
		} catch (ErrorEstrato E) {
			alerta = new Alert(AlertType.INFORMATION);
			alerta.setHeaderText("Error al ingresar el estrato");
    		alerta.setTitle("No fue posible registrar al cliente");
			alerta.setContentText(E.getMessage());
			alerta.show();
		}
       
     }
     
     if(criterios.length== 5){
    	 try {
    		 metodos.espacioVacio(respuestas[0], "Cedula");
    		 metodos.espacioVacio(respuestas[1], "Nombre");
    		 metodos.espacioVacio(respuestas[2], "Edad");
    		 metodos.espacioVacio(respuestas[3], "Telefono");
    		 metodos.espacioVacio(respuestas[4], "Direccion");
    		 metodos.cedulaCorrecta(respuestas[0]);
    		 metodos.telefonoCorrecto(respuestas[3]);
    		 new Operario(respuestas[0], respuestas[1], Integer.parseInt(respuestas[2]), respuestas[3], respuestas[4], new Vector<Double>());   	     
    	 }catch(InputVacia e){
    		 alerta = new Alert(AlertType.WARNING);
    		 alerta.setTitle("No fue posible registrar el operario");
    		 alerta.setHeaderText("WARNING: Por favor rellene todos los espacios");
    		 alerta.setContentText(e.getMessage());
    		 alerta.show();
    	 } catch (ErrorCedula c) {
    		 alerta = new Alert(AlertType.INFORMATION);
    		 alerta.setHeaderText("Error al ingresar la cedula");
    		 alerta.setTitle("No fue posible registrar al operario");
    		 alerta.setContentText(c.getMessage());
    		 alerta.show();
		}catch (ErrorTelefono t) {
    		 alerta = new Alert(AlertType.INFORMATION);
    		 alerta.setHeaderText("Error al ingresar el telefono");
    		 alerta.setTitle("No fue posible registrar al operario");
    		 alerta.setContentText(t.getMessage());
    		 alerta.show();
		} 
       }
     
     if(criterios.length== 3){
    	 try {
    		 metodos.espacioVacio(respuestas[0], "Nombre del producto");
    		 metodos.espacioVacio(respuestas[1], "Precio del producto");
    		 metodos.espacioVacio(respuestas[2], "Años garantia");
    		 metodos.revisarGarantia(respuestas[2]);
    		 new Producto(respuestas[0], Integer.parseInt(respuestas[1]), respuestas[2]);
    	 }catch(ErrorGarantia g) {
    		 alerta = new Alert(AlertType.INFORMATION);
    		 alerta.setHeaderText("Error al ingresar el producto");
    		 alerta.setTitle("No fue posible registrar el producto");
    		 alerta.setContentText(g.getMessage());
    		 alerta.show();
    	 } catch (InputVacia e) {
    		 alerta = new Alert(AlertType.WARNING);
    		 alerta.setHeaderText("WARNING: Por favor rellene todos los espacios");
    		 alerta.setTitle("No fue posible registrar el producto");
    		 alerta.setContentText(e.getMessage());
    		 alerta.show();
		}
     }
     }
     public void consultarObjeto(){
    	 try {
    		 String idConsultar= campos[0].getText();
    		 
     int indice;
     if(criterios.length== 6){
    	 metodos.espacioVacio(idConsultar, "Cedula");
    	 metodos.cedulaCorrecta(idConsultar);
       Cliente clienteEncontrado= null;  
       for(int i= 0; i<Cliente.listaClientes.size(); i++){
         if(idConsultar.equals(Cliente.listaClientes.get(i).getCedula())){
           clienteEncontrado= Cliente.listaClientes.get(i);
         }
       }

       if(clienteEncontrado==null) {
    	   throw new ObjetoNoExiste("Cliente");
       }
       campos[1].setText(clienteEncontrado.getNombre());
       campos[2].setText(String.valueOf(clienteEncontrado.getEdad()));
       campos[3].setText(clienteEncontrado.getTelefono());
       campos[4].setText(String.valueOf(clienteEncontrado.getEstrato()));
       campos[5].setText(clienteEncontrado.getDireccion());
     }
     
     if(criterios.length== 5){
    	 metodos.espacioVacio(idConsultar,"Cedula");
    	 metodos.cedulaCorrecta(idConsultar);
       Operario operarioEncontrado= null;  
       for(int i= 0; i<Operario.listaOperario.size(); i++){
         if(idConsultar.equals(Operario.listaOperario.get(i).getCedula())){
           operarioEncontrado= Operario.listaOperario.get(i);
         }
       }
       if(operarioEncontrado==null) {
    	   throw new ObjetoNoExiste("Operario");
       }
       campos[1].setText(operarioEncontrado.getNombre());
       campos[2].setText(String.valueOf(operarioEncontrado.getEdad()));
       campos[3].setText(operarioEncontrado.getTelefono());
       campos[4].setText(operarioEncontrado.getDireccion());
     }
     
     
     if(criterios.length== 3){
    	 metodos.espacioVacio(idConsultar,"Nombre del producto");
      Producto productoEncontrado= null;
      for(int i= 0; i<Producto.listaProducto.size(); i++){
         if (idConsultar.equals(Producto.listaProducto.get(i).getNombre())) {
           productoEncontrado= Producto.listaProducto.get(i);
         }
      }
      if(productoEncontrado==null) {
    	  throw new ObjetoNoExiste("Producto");
      }
      campos[2].setText(productoEncontrado.getGarantia());
      campos[1].setText(String.valueOf(productoEncontrado.getCosto()));
     }
    	 }catch(InputVacia c) {
    		 if(criterios.length==6) {
    			 alerta = new Alert(AlertType.WARNING);
        		 alerta.setTitle("Error al consultar");
        		 alerta.setHeaderText("Por favor ingrese la cedula del cliente");
        		 alerta.setContentText(c.getMessage());
        		 alerta.show();
    		 }else if(criterios.length==5) {
    			 alerta = new Alert(AlertType.WARNING);
        		 alerta.setTitle("Error al consultar");
        		 alerta.setHeaderText("Por favor ingrese la cedula del operario");
        		 alerta.setContentText(c.getMessage());
        		 alerta.show();
    		 }else {
    			 alerta = new Alert(AlertType.WARNING);
        		 alerta.setTitle("Error al consultar");
        		 alerta.setHeaderText("Por favor ingrese el nombre del producto");
        		 alerta.setContentText(c.getMessage());
        		 alerta.show();
    		 }
    		 
    	 }catch(ErrorCedula e) {
    		 if(criterios.length==6) {
    			 alerta = new Alert(AlertType.INFORMATION);
        		 alerta.setTitle("Error al consultar el cliente");
        		 alerta.setHeaderText("Cedula invalida");
        		 alerta.setContentText(e.getMessage());
        		 alerta.show();
    		 }else {
    			 alerta = new Alert(AlertType.INFORMATION);
        		 alerta.setTitle("Error al consultar el operario");
        		 alerta.setHeaderText("Cedula invalida");
        		 alerta.setContentText(e.getMessage());
        		 alerta.show();
    		 }
    		 
    	 } catch (ObjetoNoExiste e) {
			if(criterios.length==6) {
			 alerta = new Alert(AlertType.WARNING);
       		 alerta.setTitle("Error al consultar el cliente");
       		 alerta.setHeaderText("WARNING: no se pudo encontrar el cliente.");
       		 alerta.setContentText(e.getMessage());
       		 alerta.show();
			}if(criterios.length==5) {
				alerta = new Alert(AlertType.WARNING);
	       		 alerta.setTitle("Error al consultar el operario");
	       		 alerta.setHeaderText("WARNING: no se pudo encontrar el operario.");
	       		 alerta.setContentText(e.getMessage());
	       		 alerta.show();
			}if (criterios.length==3){
				alerta = new Alert(AlertType.WARNING);
	       		 alerta.setTitle("Error al consultar el producto");
	       		 alerta.setHeaderText("WARNING: no se pudo encontrar el producto.");
	       		 alerta.setContentText(e.getMessage());
	       		 alerta.show();
			}
			
		}
   }
   public void editarObjeto(){
	   try {
     String idEditar= campos[0].getText();
     if(criterios.length== 6){
    	 metodos.cedulaCorrecta(idEditar);
    	 metodos.espacioVacio(idEditar, "Cedula");
       Cliente clienteEncontrado= null;  
       for(int i= 0; i<Cliente.listaClientes.size(); i++){
         if(idEditar.equals(Cliente.listaClientes.get(i).getCedula())){
           clienteEncontrado= Cliente.listaClientes.get(i);
         }
       }

       if(clienteEncontrado==null) {
    	   throw new ObjetoNoExiste("Cliente");
       }
       metodos.estratoCorrecto(campos[4].getText());
       metodos.telefonoCorrecto(campos[3].getText());
       clienteEncontrado.setNombre(campos[1].getText());
       clienteEncontrado.setEdad(campos[2].getText());
       clienteEncontrado.setTelefono(campos[3].getText());
       clienteEncontrado.setEstrato(Integer.parseInt(campos[4].getText()));
       clienteEncontrado.setDireccion(campos[5].getText());
     }
     
     if(criterios.length== 5){
    	 metodos.cedulaCorrecta(idEditar);
    	 metodos.espacioVacio(idEditar, "Operario");
       Operario operarioEncontrado= null;  
       for(int i= 0; i<Operario.listaOperario.size(); i++){
         if(idEditar.equals(Operario.listaOperario.get(i).getCedula())){
           operarioEncontrado= Operario.listaOperario.get(i);
         }
       }

       if(operarioEncontrado==null) {
    	   throw new ObjetoNoExiste("Operario");
       }
       metodos.telefonoCorrecto(campos[3].getText());
       operarioEncontrado.setNombre(campos[1].getText());
       operarioEncontrado.setEdad(campos[2].getText());
       operarioEncontrado.setTelefono(campos[3].getText());
       operarioEncontrado.setDireccion(campos[4].getText());
       
     }
     
     
     if(criterios.length== 3){
      Producto productoEncontrado= null;
      for(int i= 0; i<Producto.listaProducto.size(); i++){
         if(idEditar.equals(Producto.listaProducto.get(i).getNombre())){
           productoEncontrado= Producto.listaProducto.get(i);
         }
      }

      if(productoEncontrado==null) {
   	   throw new ObjetoNoExiste("Producto");
      }
      metodos.revisarGarantia(campos[2].getText());
      productoEncontrado.setCosto(Integer.parseInt(campos[1].getText()));
      productoEncontrado.setGarantia(campos[2].getText());
     }
	   }catch(InputVacia e) {
		   if(criterios.length==6) {
  			 alerta = new Alert(AlertType.WARNING);
      		 alerta.setTitle("Error al modificar cliente");
      		 alerta.setHeaderText("Por favor ingrese la cedula del cliente a modificar");
      		 alerta.setContentText(e.getMessage());
      		 alerta.show();
  		 }else if(criterios.length==5) {
  			 alerta = new Alert(AlertType.WARNING);
      		 alerta.setTitle("Error al modificar operario");
      		 alerta.setHeaderText("Por favor ingrese la cedula del operario a modificar");
      		 alerta.setContentText(e.getMessage());
      		 alerta.show();
  		 }else {
  			 alerta = new Alert(AlertType.WARNING);
      		 alerta.setTitle("Error al modificar producto");
      		 alerta.setHeaderText("Por favor ingrese el nombre del producto a modificar");
      		 alerta.setContentText(e.getMessage());
      		 alerta.show();
  		 }
	   } catch (ObjetoNoExiste o) {
		   if(criterios.length==6) {
				 alerta = new Alert(AlertType.WARNING);
	       		 alerta.setTitle("Error al modificar el cliente");
	       		 alerta.setHeaderText("WARNING: no se pudo encontrar el cliente a modificar.");
	       		 alerta.setContentText(o.getMessage());
	       		 alerta.show();
				}else if(criterios.length==5) {
					alerta = new Alert(AlertType.WARNING);
		       		 alerta.setTitle("Error al modificar el operario");
		       		 alerta.setHeaderText("WARNING: no se pudo encontrar el operario a modificar.");
		       		 alerta.setContentText(o.getMessage());
		       		 alerta.show();
				}else {
					alerta = new Alert(AlertType.WARNING);
		       		 alerta.setTitle("Error al modificar el producto");
		       		 alerta.setHeaderText("WARNING: no se pudo encontrar el producto a modificar.");
		       		 alerta.setContentText(o.getMessage());
		       		 alerta.show();
				}
	} catch (ErrorCedula c) {
		if(criterios.length==6) {
			alerta = new Alert(AlertType.INFORMATION);
   		    alerta.setTitle("Error al consultar el cliente");
   		    alerta.setHeaderText("Cedula invalida");
   		    alerta.setContentText(c.getMessage());
   		    alerta.show();
		 }else {
			 alerta = new Alert(AlertType.INFORMATION);
   		 alerta.setTitle("Error al consultar el operario");
   		 alerta.setHeaderText("Cedula invalida");
   		 alerta.setContentText(c.getMessage());
   		 alerta.show();
		 }
	} catch (ErrorEstrato E) {
		alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Error al asignar el estrato");
		alerta.setHeaderText("Estrato ingresado invalido");
		alerta.setContentText(E.getMessage());
		alerta.show();
	} catch (ErrorTelefono t) {
			alerta = new Alert(AlertType.INFORMATION);
			alerta.setTitle("Error al asignar el telefono");
			alerta.setHeaderText("Telefono ingresado invalido");
			alerta.setContentText(t.getMessage());
			alerta.show();
		
		
	} catch (ErrorGarantia g) {
		alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Error al asignar garantia");
		alerta.setHeaderText("Garantia ingresada invalida");
		alerta.setContentText(g.getMessage());
		alerta.show();
	}
     
   }  
     
   public void borrarTodo(){
     for(int i= 0; i<criterios.length; i++){
        campos[i].setText(null);
        campos[i].requestFocus();
     }
   }
   public static void actualizar(){
       
     valoresGananciasMes[0]= GananciasMes.getGananciasLuz();
     valoresGananciasMes[1]= GananciasMes.getGananciasAcueducto();
     valoresGananciasMes[2]= GananciasMes.getGananciasAlcantarillado();
     valoresGananciasMes[3]= GananciasMes.getGananciasGas();
     valoresGananciasMes[4]= GananciasMes.getConsumoLuz();
     valoresGananciasMes[5]= GananciasMes.getConsumoAcueducto();
     valoresGananciasMes[6]= GananciasMes.getConsumoAlcantarillado();
     valoresGananciasMes[7]= GananciasMes.getConsumoGas();
       
     for(int i= 0; i<tamaño; i++){
        camposGananciasMes[i].setText(String.valueOf(valoresGananciasMes[i]));
        }
               
   }
    public static void actualizar2(){
     valoresGananciasSemestre[0]= GananciasSemestre.getGananciasLuz();
     valoresGananciasSemestre[1]= GananciasSemestre.getGananciasAcueducto();
     valoresGananciasSemestre[2]= GananciasSemestre.getGananciasAlcantarillado();
     valoresGananciasSemestre[3]= GananciasSemestre.getGananciasGas();
     valoresGananciasSemestre[4]= GananciasSemestre.getSuma();
     valoresGananciasSemestre[5]= GananciasSemestre.getConsumoLuz();
     valoresGananciasSemestre[6]= GananciasSemestre.getConsumoAcueducto();
     valoresGananciasSemestre[7]= GananciasSemestre.getConsumoAlcantarillado();
     valoresGananciasSemestre[8]= GananciasSemestre.getConsumoGas();
       
     for(int i= 0; i<tamaño2; i++){
        camposGananciasSemestre[i].setText(String.valueOf(valoresGananciasSemestre[i]));
     }
     System.out.println(camposGananciasSemestre[0].getText());
   }
  
}