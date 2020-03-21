package ErroresAplicacion;

public class ErrorAplicacion extends Exception {
	public ErrorAplicacion(String tipoError) {
		super("Manejo de errores delaAplicacion: " + tipoError);
	}
}
