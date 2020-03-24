package ErroresAplicacion;

public class ErrorTelefono extends ExcepcionC1 implements Constantes {
	public ErrorTelefono(String e) {
		super("El telefono ingresado "+ e);
	}
}
