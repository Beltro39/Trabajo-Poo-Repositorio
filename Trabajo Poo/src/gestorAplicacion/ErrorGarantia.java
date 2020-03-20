package gestorAplicacion;

public class ErrorGarantia extends ExcepcionC2 {
	public ErrorGarantia(String error) {
		super("La garant�a debe " + error);
	}

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
			throw new ErrorGarantia("ser un número entero positivo");
		}
	}
}
