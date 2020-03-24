package ErroresAplicacion;

public class Metodos implements Constantes {
	//revisa que la garantía sea un número entero entre 1 y 12
		public void revisarGarantia(String n) throws ErrorGarantia {
			try {
				int num = Integer.parseInt(n);
				boolean tamano = num > 3;
				if (tamano) {
					throw new ErrorGarantia("ser menor o igual a 3 años");
				}
				if (num < 1) {
					if (num == 0) {
						throw new ErrorGarantia("ser de minimo un año");
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
				throw new ErrorCedula("debe estar compuesta por numeros entero positivos");
			}
		}
		//revisa si el string ingresado en un textfield está vácio
		public void espacioVacio(String input, String nombreTextField)throws InputVacia {
			if(input.isEmpty()) {
				throw new InputVacia(nombreTextField);
			}
		}
		public void telefonoCorrecto(String telefono)throws ErrorTelefono {
			try {
				float tel = Float.parseFloat(telefono);
				if(telefono.length()!=longTelefono) {
					throw new ErrorTelefono("debe tener una longitud de 10 digitos");
				}
				if(tel<0) {
					throw new ErrorTelefono("no puede contener numeros negativos");
				}
			}catch(NumberFormatException e) {
				throw new ErrorTelefono("debe estar compuesto por numeros enteros positivos");
			}
			
		}
		public void estratoCorrecto(String estrato)throws ErrorEstrato {
			try {
				int est = Integer.parseInt(estrato);
				if(est>estratoMax || est<estratoMin) {
					throw new ErrorEstrato("debe estar entre 1 y 5");
				}				
			}catch(NumberFormatException e) {
				throw new ErrorEstrato("debe ser un numero entero entre 1 y 5");
			}
		}
		
}
