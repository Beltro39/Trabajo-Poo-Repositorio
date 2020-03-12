package gestorAplicacion;
//Clase que permite las instancias de sevicios publicos de luz, acueducto, alcantarillado y gas
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Vector;
import java.util.Iterator;

public  class ServiciosPublicos {
       private Cliente cliente;
       private Vector<Double> pilaConsumo;
       private Vector<Double> pilaPagar;
        
	public ServiciosPublicos( Vector pilaConsumo, Vector pilaPagar){
            this.pilaConsumo= pilaConsumo;
            this.pilaPagar= pilaPagar;
        }
       
        
        public void SetCliente(Cliente cliente){
        this.cliente= cliente;
        }
        public void setPilaConsumo(Vector<Double> pilaConsumo) {
        	this.pilaConsumo= pilaConsumo;
        }
        public void setPilaPagar(Vector<Double> pilaPagar) {
        	this.pilaPagar =pilaPagar;
        }
        public Vector<Double> getPilaConsumo(){
        	return this.pilaConsumo;
        }
        public Vector<Double> getPilaPagar(){
        	return this.pilaPagar;
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
}





