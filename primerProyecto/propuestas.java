package primerProyecto;

public class propuestas {
	public int id;
	public String actividades;
	public int tarifaHora;
	public usuarios contratista;
	public String estado;
	public proyectos proyecto;
	public propuestas next=null;
	public propuestas head=null;
	
	public propuestas(int id, String actividades, int tarifaHora, usuarios contratista, String estado, proyectos proyecto) {
		this.id=id;
		this.actividades=actividades;
		this.tarifaHora=tarifaHora;
		this.contratista=contratista;
		this.estado=estado;
	}
	public static void insertarNuevo(propuestas head, propuestas propuestaNueva, propuestas pointer) {
		if(head!=null) {
			while(pointer.next!=null) {
				pointer=pointer.next;
			}pointer.next=propuestaNueva;
		}head=propuestaNueva;
	}
	public static void mostrarPropuestasUsuario(propuestas pointer, usuarios pointerU, propuestas head) {
		pointer = head;
		while (pointer != null) {
			if (pointer.proyecto.contratante.equals(pointerU)) {
				System.out.println("ID: " + pointer.id);
				System.out.println("Acticidades: " + pointer.actividades);
				System.out.println("Tarifa por hora: " + pointer.tarifaHora);
				System.out.println("ID de contratista: " + pointer.contratista.id);
				System.out.println("Nombre de contratista: " + pointer.contratista.nombre);
				System.out.println("Estado actual: " + pointer.estado);
				System.out.println("Proyecto: " + pointer.proyecto.nombreProyecto);
			}
			pointer = pointer.next;
		}
	}
}
