package grafos;

import java.util.Scanner;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in);
		GrafoMatriz grafo = new GrafoMatriz();
		int opcion;
		do {
			System.out.println("----------GRAFOS-----------------\n" + "opcion 1.- ingresar vertices\n"
					+ "opcion 2.- ingresar arcos\n" + "opcion 3.- visualizar nodos conectados\n" + "opcion 4.- salir");

			opcion = leer.nextInt();

			switch (opcion) {
			case 1:
				System.out.println("cuantos vertices va a ingresar: ");
				int numv = leer.nextInt();
				while (numv <= 0 || numv >= 20) {
					System.out.println("ingrese un valor dentro del rango de 0-20");
					numv = leer.nextInt();
				}
				for (int i = 0; i < numv; i++) {
					System.out.print("Ingrese el nombre del vértice: ");
					String vertice = leer.next();
					grafo.nuevoVertice(vertice);
					System.out.println("Vértice agregado: " + vertice);

				}

				break;
			case 2:
				System.out.print("Ingrese el nombre del vértice A: ");
				String verticeA = leer.next();
				System.out.print("Ingrese el nombre del vértice B: ");
				String verticeB = leer.next();
				try {
					grafo.nuevoArco(verticeA, verticeB);
					System.out.println("Arco agregado entre " + verticeA + " y " + verticeB);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try {
					List<Vertice> nodosConectadosA = grafo.nodosConectados("A");

					System.out.println("Nodos conectados a A:");
					for (Vertice v : nodosConectadosA) {
						System.out.println(v.nomVertice());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
			case 4:
				System.out.println("ha salido del menu");
				break;
			default:
				System.out.println("Opción no válida");

			}
		} while (opcion != 4);

	}
}
