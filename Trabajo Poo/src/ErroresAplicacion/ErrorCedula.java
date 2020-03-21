package ErroresAplicacion;

public class ErrorCedula extends ExcepcionC1 {
	boolean number = true;

	public ErrorCedula(String e) {
		super("La cedula ingresada " + e);
	}
}
