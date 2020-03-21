package ErroresAplicacion;

public class InputVacia extends ExcepcionC1{
	public InputVacia(String vacio) {
		super("El espacio "+ vacio +" no puede dejarse en blanco");
	}
}
