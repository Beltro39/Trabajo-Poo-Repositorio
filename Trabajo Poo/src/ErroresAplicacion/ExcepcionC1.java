package ErroresAplicacion;
//Los hijos son: ErrorCedula, ErrorTelefono y inputVacia
public class ExcepcionC1 extends ErrorAplicacion {

	public ExcepcionC1(String subTipo) {
		super("Excepcion tipo 1: " + subTipo);
	}
}
