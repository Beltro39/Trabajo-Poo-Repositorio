package ErroresAplicacion;

public class ErrorEstrato extends ExcepcionC2 implements Constantes {
	public ErrorEstrato(String s) {
		super("El estrato "+ s);
	}
}
