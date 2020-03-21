/*En esta clase estarán todos los métodos que se usarán para revisar
que los datos ingresados estén correctos
*/
package ErroresAplicacion;

public class Utilidades_Metodos implements Constantes {

	//revisa que la garantía sea un número entero entre 1 y 12
	public void revisarGarantia(String n) throws ErrorGarantia {
		try {
			int num = Integer.parseInt(n);
			boolean tamano = num > 12;
			if (tamano) {
				throw new ErrorGarantia("ser menor o igual a 12 meses");
			}
			if (num < 1) {
				if (num == 0) {
					throw new ErrorGarantia("ser de minimo un mes");
				}
				throw new ErrorGarantia("ser un numero positivo");
			}
		} catch (NumberFormatException e) {
			throw new ErrorGarantia("ser un numero entero positivo");
		}
	}
	//revisa que la cedula sea un numero de 9 digitos y que sea positivo
	public void cedulaCorrecta(String cedula) throws ErrorCedula {
		try {
			int num = Integer.parseInt(cedula);
			if (cedula.length() != longCedula) {
				throw new ErrorCedula("debe tener una longitud de 9 digitos");
			}
			if (num < 0) {
				throw new ErrorCedula("no debe contener numeros negativos");
			}
		} catch (NumberFormatException e) {
			throw new ErrorCedula("debe estar compuesta por numeros enteros");
		}
	}
	//revisa si el string ingresado en un textfield está vácio
	public void espacioVacio(String input, String nombreTextField)throws InputVacia {
		if(input.isEmpty()) {
			throw new InputVacia(nombreTextField);
		}
	}
	
}
