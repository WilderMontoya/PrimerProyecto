package primerProyecto;

public class valoraciones {
	public double estrellas;
	public usuarios usuario;
	public valoraciones next = null;
	public valoraciones head = null;

	public valoraciones(double estrellas, usuarios usuario) {
		this.estrellas = estrellas;
		this.usuario = usuario;
	}

	public static void insertarValoracion(valoraciones head, valoraciones nueva) {
		valoraciones pointer = head;
		while (pointer.next != null) {
			pointer = pointer.next;
		}
		pointer.next = nueva;
	}

	public static void mostrarPromedioestrellas(usuarios headU,usuarios pointerU, valoraciones head) {
		valoraciones pointer = head;pointerU = headU;
		while (pointerU != null) {
			double suma = 0, promEstrellas=0;
			int i = 0;
			while (pointer != null) {
				if (pointer.usuario == pointerU) {
					suma = suma + pointer.estrellas;
					i++;
				}
			}promEstrellas=suma/i;
			System.out.println("Usuario: "+pointerU.id);
			System.out.println("Usuario: "+pointerU.nombre);
			System.out.println("Promedio de Calificacion: "+promEstrellas+" estrellas");
			pointerU=pointerU.next;
		}
	}

}
