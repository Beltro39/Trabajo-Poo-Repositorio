package uiMain;
// Clase que guarda clientes, operarios y productos en un txt
import java.awt.AWTException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GuardarDatos extends OpcionDeMenu{
    public void ejecutar(){
      BaseDatos.EscritorJson.escribirClientes();
      BaseDatos.EscritorJson.escribirOperarios();
      BaseDatos.EscritorJson.escribirProductos();
    }
   
}
