package ErroresAplicacion;

public class ObjetoNoExiste extends ExcepcionC2 implements Constantes {
	public ObjetoNoExiste(String tipo) {
		super("El " +tipo+ " no se encuentra registrado en la base de datos");
	}
}
