package BaseDatos;

import gestorAplicacion.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import uiMain.RecolectarDatos;
abstract public class LectorJson {
    public static void leerProductos(){
      try{
            BufferedReader br= new BufferedReader(new FileReader("documentos/listaProductos.txt"));
            String linea= br.readLine();
            while(linea!= null){
              String[] partes= linea.split(" ");
              new Producto(partes[0], Integer.parseInt(partes[1]),partes[2]);
              linea= br.readLine();
            }
            br.close();
           }catch(IOException e){
             System.out.println("Error leer productos");
           }
       }
    public static void leerClientes(){
      try{
            BufferedReader br= new BufferedReader(new FileReader("documentos/listaClientes.txt"));
            String linea= br.readLine();
            while(linea!= null){
              String[] partes= linea.split("  ");
              ServiciosPublicos luz= new ServiciosPublicos(leerListas(partes[6]), leerListas(partes[7]));
              ServiciosPublicos acueducto= new ServiciosPublicos(leerListas(partes[8]), leerListas(partes[9]));
              ServiciosPublicos alcantarillado= new ServiciosPublicos(leerListas(partes[10]), leerListas(partes[11]));
              ServiciosPublicos gas= new ServiciosPublicos(leerListas(partes[12]), leerListas(partes[13]));
              Vector<String> v= leerListas2(partes[14]);
              new Cliente(partes[0], partes[1], Integer.parseInt(partes[2]),partes[3], Integer.parseInt(partes[4]), partes[5], luz ,acueducto, alcantarillado, gas, v );
                linea= br.readLine();
            }
            br.close();
           }catch(IOException e){
             System.out.println("Error leer clientes");
           }
       }
    public static void leerOperarios(){
      try{
            BufferedReader br= new BufferedReader(new FileReader("documentos/listaOperarios.txt"));
            String linea= br.readLine();
            while(linea!= null){
              String[] partes= linea.split("  ");
              Vector<Double> v= leerListas(partes[5]);
              new Operario(partes[0], partes[1], Integer.parseInt(partes[2]),partes[3], partes[4], v );
                linea= br.readLine();
            }
            br.close();
           }catch(IOException e){
             System.out.println("Error leer Operarios");
           }
       }
    public static void leerMes(){
      try{
            BufferedReader br= new BufferedReader(new FileReader("documentos/Mes.txt"));
            String linea= br.readLine();
            RecolectarDatos.setI(Integer.parseInt(linea));
            br.close();
           }catch(IOException e){
             System.out.println("Error leer Operarios");
           }
       }
    public static Vector<Double> leerListas(String lista){
      String partes[]= lista.split(" ");
      Vector<Double> v= new Vector<>(); 
      for(int i= 0; i<partes.length; i++){
          
          v.add(Double.parseDouble(partes[i].replace("[", "").replace("]", "").replace(",", "")));
      }
      return v;
      
    }
    public static Vector<String> leerListas2(String lista){
      String partes[]= lista.split(" ");
      Vector<String> v= new Vector<>(); 
      for(int i= 0; i<partes.length; i++){
              
             v.add(partes[i].replace("[", "").replace("]", "").replace(",", ""));
      }
      return v;
}
}
      /*
      String partesI[]= partes[0].split("");
      for(int i= 1; i<partesI.length; i++){
        partes[0]= partesI[i];
      }
      int l= partes.length-1;
      String partesF[]= partes[l].split("");
      for(int i= 0; i<partesI.length-2; i++){
        partes[l]= partesF[i];
      }
      Vector<String> v= new Vector<String>();
      for(int i= 0; i<partesI.length; i++){
        v.add(partes[i]);
      }
      return v;
    }
              */
