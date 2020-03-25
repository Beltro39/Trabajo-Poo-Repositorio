package BaseDatos;
import gestorAplicacion.*;
import uiMain.RecolectarDatos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class EscritorJson {
    public static void escribirProductos(){
      try{
            BufferedWriter bw= new BufferedWriter(new FileWriter("documentos/listaProductos.txt"));
            for(int i= 0; i<Producto.listaProducto.size(); i++){
              bw.write(Producto.listaProducto.get(i).toString());
              bw.newLine();
            }
            bw.flush();
           }catch(IOException e){
             
           }
       }
    public static void escribirMes(){
      try{
            BufferedWriter bw= new BufferedWriter(new FileWriter("documentos/Mes.txt"));
            
              bw.write(String.valueOf(RecolectarDatos.getI()));
              bw.newLine();
         
            bw.flush();
           }catch(IOException e){
             
           }
       }
   public static void escribirClientes(){
      try{
            BufferedWriter bw= new BufferedWriter(new FileWriter("documentos/listaClientes.txt"));
            for(int i= 0; i<Cliente.listaClientes.size(); i++){
              bw.write(Cliente.listaClientes.get(i).toString());
              bw.newLine();
            }
            bw.flush();
           }catch(IOException e){
             
           }
       } 
   public static void  escribirOperarios(){
      try{
            BufferedWriter bw= new BufferedWriter(new FileWriter("documentos/listaOperarios.txt"));
            for(int i= 0; i<Operario.listaOperario.size(); i++){
              bw.write(Operario.listaOperario.get(i).toString());
              bw.newLine();
            }
            bw.flush();
           }catch(IOException e){
             
           }
       } 
	 public static void  borrarDatos(){
      try{
            BufferedWriter bw= new BufferedWriter(new FileWriter("documentos/listaClientes.txt"));
            bw.write("");
            bw.flush();
            bw= new BufferedWriter(new FileWriter("documentos/listaOperarios.txt"));
            bw.write("");
            bw.flush();
            bw= new BufferedWriter(new FileWriter("documentos/listaProductos.txt"));
            bw.write("");
            bw.flush();
            bw= new BufferedWriter(new FileWriter("documentos/Mes.txt"));
            bw.write("-1");
           bw.flush();
            
           }catch(IOException e){
             
           }
       } 
	
	
}
