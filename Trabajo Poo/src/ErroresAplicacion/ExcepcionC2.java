package ErroresAplicacion;
//hijos: ErrorGarantia,ErrorEstrato,ObjetoNoExiste
public class ExcepcionC2 extends ErrorAplicacion {
	ExcepcionC2(String subTipo) {
		super("Error tipo 2: " + subTipo);
	}
}
