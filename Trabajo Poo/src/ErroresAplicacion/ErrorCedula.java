package ErroresAplicacion;

public class ErrorCedula extends ExcepcionC1 {
	public ErrorCedula(String e) {
		super("La cedula ingresada " + e);
	}
}
