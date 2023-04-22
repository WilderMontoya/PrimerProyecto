package primerProyecto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class index {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		admin administrador = new admin("admin", "098");
		usuarios usuario0 = new usuarios("1234", "Pedro Gonzales", "1", "pedroG", "123");
		usuarios usuario1 = new usuarios("8746", "Flor Perez", "2", "FlorP", "123");
		usuarios usuario2 = new usuarios("0044", "Pepe Gomez", "2", "pepeG", "4321");
                usuarios usuario3;
		List<propuestas> listaPropuestas0 = new ArrayList<propuestas>();
		List<propuestas> listaPropuestas1 = new ArrayList<propuestas>();
		List<propuestas> listaPropuestas2 = new ArrayList<propuestas>();
		proyectos proyecto0 = new proyectos(0, "Terraza Decorada",
				"Ampliar la reeaza de una casa y adecuarla para encuentros familiares", usuario1, 2000000,
				listaPropuestas0);
		proyectos proyecto1 = new proyectos(1, "Plano para casa",
				"Distenar el plano para una casa campestre, combinacion entre diseno moderno y antiguo", usuario1,
				1800000, listaPropuestas1);
		proyectos proyecto2 = new proyectos(2, "Aplicativo web", "Pagina o aplicativo web para una empresa de costura",
				usuario1, 5000000, listaPropuestas2);
		proyectos proyecto3;
		propuestas propuesta0 = new propuestas(0,
				"Ampliacion de la terraza, embaldozacion o decoracion del suelo, diseno de la adecuacion, adecuacion",
				10000, usuario0, "Pendiente", proyecto0);
		propuestas propuesta1 = new propuestas(1,
				"Ampliacion de la terraza, tapizado de suelo, diseno de la adecuacion, adecuacion", 12000, usuario0,
				"Pendiente", proyecto0);
		propuestas propuesta2 = new propuestas(2,
				"Inicia el boceto del plano segun informacion dada, mostrar y se hacen las modificaciones correspondientes 10 veces max",
				20000, usuario0, "Pendiente", proyecto1);
		propuestas propuesta3 = new propuestas(3,
				"Platica con el cliente acerca del recuerso y de lo que quiere, desarrollo del boceto inicial, modificaciones 20 veces max",
				25000, usuario0, "Pendiente", proyecto1);
		propuestas propuesta4;
		valoraciones valoracion0 = new valoraciones(3, usuario0);
		valoraciones valoracion1;
		listaPropuestas0.add(propuesta0);
		listaPropuestas0.add(propuesta1);
		listaPropuestas1.add(propuesta2);
		listaPropuestas1.add(propuesta3);
		usuarios headU = null, pointerU = null;
		proyectos headPy = null, pointerPy = null;
		propuestas headP = null, pointerP = null;
		valoraciones headV = null, pointerV = null;
		// Comienza a enlazar la lista de objetos ya creados.
		usuario0.next = usuario1;
                usuario1.next = usuario2;
		headU = usuario0;
		pointerU = headU;
		proyecto0.next = proyecto1;
		proyecto1.next = proyecto2;
		headPy = proyecto0;
		pointerPy = headPy;
		propuesta0.next = propuesta1;
		propuesta1.next = propuesta2;
		propuesta2.next = propuesta3;
		headP = propuesta0;
		pointerP = headP;
		headV = valoracion0;
		pointerV = headV;

		boolean cerrar = false;
		do {
			// Comienza el programa

			String opcionInicio = "";
			String user = "", pass = "";
			boolean sesionAdmin = false, sesionNormal = false;
			System.out.println("¿Qué desea realizar? Digite el número que corressponda");
			System.out.println("1. Iniciar Sesion");
			System.out.println("2. Registrarse");
			opcionInicio = sc.nextLine();
			switch (opcionInicio) {
			case "1":
				System.out.println("Digite su nombre de usuario");
				user = sc.nextLine();
				System.out.println("Digite su contraseña");
				pass = sc.nextLine();
				sesionAdmin = admin.iniciarSesionA(user, pass, administrador);
				if (sesionAdmin) {
					boolean menuAdmin = false;
					do {
						admin.mostrarProyectosyUsuarios(pointerU, headU, pointerPy, headPy);
						String opcion = "";
						System.out.println("¿Qué deseas realizar? Digita el número que corresponda");
						System.out.println("1. Eliminar usuario");
						System.out.println("2. Eliminar proyecto");
						System.out.println("Cualquier otro digito para salir");
						opcion = sc.nextLine();
						if (opcion.equals("1")) {
							String usuarioEliminar = "";
							System.out.println("Ingrese el ID del usuario a eliminar");
							usuarioEliminar = sc.nextLine();
							if (admin.eliminarUsuario(pointerU, headU, usuarioEliminar)) {
								System.out.println("Usuario eliminado exitosamente");
								sc.nextLine();
							} else {
								System.out.println("No es posible eliminar el usuario");
								sc.nextLine();
							}
						} else if (opcion.equals("2")) {
							int proyectoEliminar = 0;
							System.out.println("Ingrese el ID del proyecto a eliminar");
							proyectoEliminar = sc.nextInt();

							if (admin.eliminarProyecto(pointerPy, headPy, proyectoEliminar)) {
								System.out.println("Proyecto eliminado exitosamente");
								sc.nextLine();
							} else {
								System.out.println("No es posible eliminar el Proyecto");
								sc.nextLine();
							}
						} else {
							System.out.println("Goodbye, thank you");
							menuAdmin = true;
						}
						sc.nextLine();
					} while (menuAdmin != true);
				} else {
                                    pointerU=headU;
                                    while(pointerU!=null){
					sesionNormal = usuarios.iniciarSesion(user, pass, pointerU);
                                        if(sesionNormal){
                                            break;
                                        }
                                        pointerU=pointerU.next;
                                    }
					if (sesionNormal) {
						if (pointerU.perfil.equals("1")) {
							String menuContratista = "", actividades = "", estado = "";
							int valorHora, idPropuesta, idProyectoProponer;
							proyectos proyectoElegido = null;
							System.out.println("CONTRATISTA");
							System.out.println("Bienvenido " + pointerU.nombre);
							proyectos.mostrarProyectos(pointerPy, headPy);
							System.out.println("¿Qué deseas realizar? Digita el número que corresponda");
							System.out.println("1. Publicar propuesta");
							menuContratista = sc.nextLine();
							if (menuContratista.equals("1")) {
								System.out.println("Ingrese el ID del proyecto al cual desea hacerle una propuesta");
								idProyectoProponer = sc.nextInt();
								int i = 0;
								while (pointerP.next != null) {
									i++;
									pointerP = pointerP.next;
								}
								idPropuesta = i + 1;
								System.out.println("Actividades separadadas por comas");
								actividades = sc.nextLine();
								System.out.println("Tarifa por hora, sin comas ni puntos");
								valorHora = sc.nextInt();
								while (pointerPy != null) {
									if (pointerPy.id == idProyectoProponer) {
										proyectoElegido = pointerPy;
										break;
									}
									pointerPy = pointerPy.next;
								}
								propuesta4 = new propuestas(idPropuesta, actividades, valorHora, pointerU, estado,
										proyectoElegido);
								propuestas.insertarNuevo(headP, propuesta4, pointerP);
							}
						} else if (pointerU.perfil.equals("2")) {
							boolean menuA = false;
							do {
								String menuContratante = "", nombreProyecto = "", descripcion = "";
								int presupuesto, idProyecto;
								System.out.println("CONTRATANTE");
								System.out.println("Bienvenido " + pointerU.nombre);
								proyectos.mostrarProyectosUsusario(pointerPy, pointerU, headPy);
								System.out.println("¿Qué deseas realizar? Digita el número que corresponda");
								System.out.println("1. Publicar nuevo proyecto");
								System.out.println("2. Ver propuestas");
								System.out.println("3. Consultal el costo total de una propuesta");
								System.out.println("4. Calificar a un contratista");
								System.out.println("5. Ver contratistas con sus calificaciones");
								menuContratante = sc.nextLine();
								switch (menuContratante) {
								case "1":
									System.out.println("Ingrese los siguentes datos");
									int i = 0;
									while (pointerPy.next != null) {
										i++;
										pointerPy = pointerPy.next;
									}
									idProyecto = i + 1;
									System.out.println("Nombre del proyecto");
									nombreProyecto = sc.nextLine();
									System.out.println("Descripcion del proyecto");
									descripcion = sc.nextLine();
									System.out.println("Presupuesto para el proyecto");
									presupuesto = sc.nextInt();
									proyecto3 = new proyectos(idProyecto, nombreProyecto, descripcion, pointerU,
											presupuesto, null);
									proyectos.insertarNuevo(proyecto3, pointerPy, headPy);
									break;
								case "2":
									propuestas.mostrarPropuestasUsuario(pointerP, pointerU, headP);
									break;
								case "3":
									int valorHora = 0, horasTrabajadas = 0;
									System.out.println("Ingrese la tarifa por hora que paga al contratista");
									valorHora = sc.nextInt();
									System.out.println("Ingrese las horas que este contratista trabajo");
									horasTrabajadas = sc.nextInt();
									int totalPagar = pagos.calcularTotalPagar(valorHora, horasTrabajadas);
									System.out.println("En total a este debe pagar " + totalPagar);
									break;
								case "4":
									String idUsuarioACalificar = "";
									double numeroEstrellas = 0;
									usuarios contratista = null;
									System.out.println("Digite el id del usuario a calificar");
									idUsuarioACalificar = sc.nextLine();
									contratista = usuarios.buscarUsuarios(pointerU, idUsuarioACalificar, headU);
									System.out.println("Digite el numero de estrellas que le da a este usuario");
									numeroEstrellas = sc.nextInt();
									valoracion1 = new valoraciones(numeroEstrellas, contratista);
									valoraciones.insertarValoracion(headV, valoracion1);
									break;
								case "5":
									valoraciones.mostrarPromedioestrellas(headU, pointerU, headV);
									menuA = true;
									break;
								default:
									menuA = false;
									break;
								}
							} while (menuA != true);
						} // Contratante cierre
					} else {
						System.out.println("El ususario o contraseña son incorrectas");
						cerrar = false;
					} // Sesion Normal contratista y contratante
				} // cierre de sino es admin
				break;
			case "2":
				System.out.println("Registro de nuevo usuario");
				String idUsuario = "", nombre = "", perfil = "", usuario = "", contrasena = "";
				System.out.println("Digite los siguientes datos");
				System.out.println("Numero de identificacion");
				idUsuario = sc.nextLine();
				System.out.println("Nombre");
				nombre = sc.nextLine();
				System.out.println("1.Contratista o 2.contratante digite 1 o 2");
				perfil = sc.nextLine();
				System.out.println("Usuario");
				usuario = sc.nextLine();
				System.out.println("Contraseña");
				contrasena = sc.nextLine();
				usuario3 = new usuarios(idUsuario, nombre, perfil, usuario, contrasena);
				if (usuarios.insertarNuevoUsuario(headU, usuario3, pointerU)) {
					System.out.println("Usuarios registrado correctamente");
					cerrar = false;
				}
				break;
			default:
				System.out.println("La opcion elegida no es valida");
				cerrar = false;
				break;
			}// Cierre de Swich de menu principal
		} while (cerrar != true);
	}// cierre main
}// cierre class
