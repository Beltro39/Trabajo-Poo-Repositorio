package gestorAplicacion;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Vector;
import java.util.Iterator;

public  class ServiciosPublicos {
       private Cliente cliente;
	Date fecha;
        public Vector<Double> pilaConsumo;
        public Vector<Double> pilaPagar;
        
	DateTimeFormatter miFormatoFec,has = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public ServiciosPublicos( Vector pilaConsumo, Vector pilaPagar, String fecha){
            this.pilaConsumo= pilaConsumo;
            this.pilaPagar= pilaPagar;	
	}
        
        public void SetCliente(Cliente cliente){
        this.cliente= cliente;
        }
        public String toString(){
          Iterator itrC= pilaConsumo.iterator();
          Iterator itrP= pilaPagar.iterator();
          String mensaje= "";
          while(itrC.hasNext()){
            mensaje= mensaje+itrC.next();
            if(itrP.hasNext()){
                mensaje= mensaje+" "+itrP.next()+" ";
            }
          }   
        return mensaje;
        }
        ServiciosPublicos(Vector pilaConsumo, Vector pilaPagar, String fecha, Cliente cliente){
        	this.cliente = cliente;
        	this.pilaConsumo= pilaConsumo;
            this.pilaPagar= pilaPagar;
        }
        public Vector<Double> getPilaPagar(){
        	return this.pilaPagar;
        }
        public Vector<Double> getPilaConsumo(){
        	return this.pilaConsumo;
        }
        public Date getFecha() {
        	return this.fecha;
        }
        public Cliente getCliente() {
        	return this.cliente;
        }
}





