package ErroresAplicacion;

public class ErrorGarantia extends ExcepcionC2 {
	public ErrorGarantia(String error) {
		super("La garantia debe " + error);
	}

	
}
