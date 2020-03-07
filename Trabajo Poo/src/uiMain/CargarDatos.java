package uiMain;

import java.util.Vector;

public class CargarDatos extends OpcionDeMenu{
    public void ejecutar(){
      Vector<Double> pilaPagar= new Vector<Double>();
      Vector<Double> pilaConsumo= new Vector<Double>();
                  
      pilaPagar.add(17710.0);
      pilaPagar.add(84392.0);
      pilaPagar.add(65912.0);
      pilaPagar.add(51744.0);
      pilaPagar.add(41426.0);
      pilaPagar.add(62832.0);
      
      pilaConsumo.add(115.0);
      pilaConsumo.add(548.0);
      pilaConsumo.add(428.0);
      pilaConsumo.add(336.0);
      pilaConsumo.add(269.0);
      pilaConsumo.add(408.0);
      
      Vector<Double> pilaPagar2= new Vector<Double>();
      Vector<Double> pilaConsumo2= new Vector<Double>();
      pilaPagar2.add(13400.0);
      pilaPagar2.add(15800.0);
      pilaPagar2.add(14600.0 );
      pilaPagar2.add(15200.0);
      pilaPagar2.add(415800.0);
      pilaPagar2.add(21200.0);
      
      pilaConsumo2.add(9.0);
      pilaConsumo2.add(13.0);
      pilaConsumo2.add(11.0);
      pilaConsumo2.add(12.0);
      pilaConsumo2.add(13.0);
      pilaConsumo2.add(22.0);
      
      Vector<Double> pilaPagar3= new Vector<Double>();
      Vector<Double> pilaConsumo3= new Vector<Double>();
        //14.0 21900.0 21.0 26450.0 14.0 21900.0 13.0 21250.0 10.0 19300.0 23.0 27750.0 20.0 25800.0  
      pilaPagar3.add(21900.0);
      pilaPagar3.add(26450.0);
      pilaPagar3.add(21900.0);
      pilaPagar3.add(15200.0);
      pilaPagar3.add(19300.0);
      pilaPagar3.add(27750.0);
      
      pilaConsumo3.add(14.0 );
      pilaConsumo3.add(14.0);
      pilaConsumo3.add(13.0);
      pilaConsumo3.add(10.0);
      pilaConsumo3.add(23.0);
      pilaConsumo3.add(22.0);
   
      //new Cliente("1001366260", "Sebastian", 19, "3007904147", 4, "Calle 10", new SeviciosPublicos(pilaPagar, pilaConsumo), new SeviciosPublicos(pilaPagar2, pilaConsumo2),  )
    }
}
