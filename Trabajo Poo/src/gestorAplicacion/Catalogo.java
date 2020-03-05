package gestorAplicacion;

import java.util.HashMap;
import java.util.Scanner;

abstract public class Catalogo {
	Scanner scanner;
	public static HashMap<String, Double> productosCatalogo = new HashMap<String, Double>();
	public static HashMap<String, Integer> cantidadProductos = new HashMap<String,Integer>();
	
	public void añadirProducto(String nombreProducto, double precioProducto) {
		productosCatalogo.put(nombreProducto, precioProducto);
		System.out.println("Por favor insertar la cantidad de productos, por defecto es 1 ");
		scanner = new Scanner(System.in);
		int cantidadProducto = scanner.nextInt();
		if(cantidadProducto>1) {
			cantidadProductos.put(nombreProducto, cantidadProducto);
		}else {
			cantidadProductos.put(nombreProducto, 1);
		}
	}
	public void getCantidadProducto(String producto) {
		try {
			 System.out.println(cantidadProductos.get(producto));
		}catch(Exception e) {
			System.out.println("El producto no existe");
		}
		
	}
	public double getPrecioProducto(String producto) {
		return productosCatalogo.get(producto);
	}
	public void comprarProducto(String producto) {
		try {
			int cantidad = cantidadProductos.get(producto);
			cantidad --;
			if(cantidad<=0) {
				productosCatalogo.remove(producto);
				cantidadProductos.remove(producto);
			}else {
				cantidadProductos.put(producto,cantidad);
			}
		}catch(Exception e) {
			System.out.println("El producto no se puede retirar porque no existe");
		}
	}
	public static HashMap<String, Double> traerCatalogo(){
		return productosCatalogo;
	}
	public static HashMap<String, Integer> traerCantidadProductos(){
		return cantidadProductos;
	}
	
}
