package BaseDatos;
import gestorAplicacion.Cliente;
import java.util.Scanner;

public class probando {

	public static void main(String[] args) {
		Scanner scanner;
		scanner = new Scanner(System.in) ;
		System.out.print("cedula");
		String cedula = scanner.next();
		System.out.print("nombre");
		String nombre = scanner.next();
		System.out.print("edad");
		int edad = scanner.nextInt();
		System.out.print("telefono");
		String telefono = scanner.next();
		System.out.print("direccion");
		String direccion = scanner.next();
		int estrato = scanner.nextInt();
		int saldo = scanner.nextInt();
		int añosServicio = scanner.nextInt();
		try {
			Cliente cliente1 = new Cliente(estrato,saldo,añosServicio,cedula,nombre,edad,telefono,direccion);
		}catch(Exception e) {
			System.out.println("idk something happenned "+ e.getMessage());
		}
		

	}

}
