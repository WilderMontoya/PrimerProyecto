package primerProyecto;

import java.util.List;

public class proyectos {
	public int id;
	public String nombreProyecto;
	public String descripcion;
	public usuarios contratante;
	public int presupuesto;
	public List<propuestas> listaPropuestas;
	public proyectos next = null;
	public proyectos head = null;

	public proyectos(int id, String nombreProyecto, String descripcion, usuarios contratante, int presupuesto,
			List<propuestas> listaPropuestas) {
		this.id = id;
		this.nombreProyecto = nombreProyecto;
		this.descripcion = descripcion;
		this.contratante = contratante;
		this.presupuesto = presupuesto;
		this.listaPropuestas = listaPropuestas;
	}

	public static void insertarNuevo(proyectos proyectoNuevo, proyectos pointer, proyectos head) {
		if (head != null) {
			pointer = head;
			while (pointer.next != null) {
				pointer = pointer.next;
			}
			pointer.next = proyectoNuevo;
		}
		head = proyectoNuevo;
	}

	public static void mostrarProyectos(proyectos pointer, proyectos head) {
		pointer = head;
		while (pointer != null) {
			System.out.println("ID: " + pointer.id);
			System.out.println("Nombre del proyecto: " + pointer.nombreProyecto);
			System.out.println("Descripción: " + pointer.descripcion);
			System.out.println("Contratante: " + pointer.contratante.nombre);
			System.out.println("Presupuesto: " + pointer.presupuesto);
			pointer = pointer.next;
		}
	}

	public static void mostrarProyectosUsusario(proyectos pointer, usuarios pointerU, proyectos head) {
		pointer = head;
		while (pointer != null) {
			if (pointer.contratante.equals(pointerU)) {
				System.out.println("ID: " + pointer.id);
				System.out.println("Nombre del proyecto: " + pointer.nombreProyecto);
				System.out.println("Descripción: " + pointer.descripcion);
				System.out.println("propuestas: " + pointer.listaPropuestas.size());
				System.out.println("Presupuesto: " + pointer.presupuesto);
			}
			pointer = pointer.next;
		}
	}

	public static void mostrarListaPropuesta(proyectos pointer, usuarios pointerU, proyectos head,
			int idPyListaDetallada) {// Py = proyecto
		pointer = head;
		while (pointer != null) {
			if (pointer.contratante.equals(pointerU)) {
				System.out.println("ID: " + pointer.id);
				System.out.println("Nombre del proyecto: " + pointer.nombreProyecto);
				for (int i = 0; i < (pointer.listaPropuestas.size()); i++) {
					System.out.println(pointer.listaPropuestas.get(i).toString());
				}
				break;
			}
			pointer = pointer.next;
		}
	}

}
