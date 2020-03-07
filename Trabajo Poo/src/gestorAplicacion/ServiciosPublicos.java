package gestorAplicacion;
//Clase que permite las instancias de sevicios publicos de luz, acueducto, alcantarillado y gas
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Vector;
import java.util.Iterator;

public  class ServiciosPublicos {
       private Cliente cliente;
	
        public Vector<Double> pilaConsumo;
        public Vector<Double> pilaPagar;
        

	public ServiciosPublicos( Vector pilaConsumo, Vector pilaPagar){
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
}





