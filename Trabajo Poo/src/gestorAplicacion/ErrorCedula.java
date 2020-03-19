package gestorAplicacion;

public class ErrorCedula extends ExcepcionC1 {
	boolean number = true;

	public ErrorCedula(String e) {
		super("La cedula ingresada " + e);
	}

	public void cedulaCorrecta(String cedula) throws ErrorCedula {
		try {
			int num = Integer.parseInt(cedula);
			if (cedula.length() != 9) {
				throw new ErrorCedula("debe tener una longitud de 9 digitos");
			}
			if (num < 0) {
				throw new ErrorCedula("no debe contener numeros negativos");
			}
		} catch (NumberFormatException e) {
			throw new ErrorCedula("debe estar compuesta por numeros enteros");
		}
	}

}
