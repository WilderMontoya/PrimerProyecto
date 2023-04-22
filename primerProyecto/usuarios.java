package primerProyecto;

public class usuarios {

    public String id;
    public String nombre;
    public String perfil;//1=Contratista 2=Contratante
    public String usuario;
    public String password;
    public usuarios next = null;
    public usuarios head = null;

    /* Una funcion que permita registrar un usuario con todos sus datos (Atributos)*/
    public usuarios(String id, String nombre, String perfil, String usuario, String password) {
        this.id = id;
        this.nombre = nombre;
        this.perfil = perfil;
        this.usuario = usuario;
        this.password = password;
    }

    public static boolean insertarNuevoUsuario(usuarios head, usuarios nuevo, usuarios pointer) {
        if (head != null) {
            pointer = head;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = nuevo;
        }
        nuevo = head;
        return true;
    }

    public static boolean iniciarSesion(String usuario, String password, usuarios pointer) {
        boolean valor = false;
        if (usuario.equals(pointer.usuario) && password.equals(pointer.password)) {
            valor = true;
        } else {
            valor = false;
        }
        return valor;
    }

    public static usuarios buscarUsuarios(usuarios pointer, String idUsuario, usuarios head) {
        usuarios usuarioEncontrado = pointer;
        pointer = head;
        while (pointer != null) {
            if (pointer.id.equals(idUsuario)) {
                usuarioEncontrado = pointer;
            }
            pointer = pointer.next;
        }
        return usuarioEncontrado;
    }

    public static void mostrarUsuarios(usuarios pointer, usuarios head) {
        pointer = head;
        while (pointer != null) {
            System.out.println("ID: " + pointer.id);
            System.out.println("Nombre: " + pointer.nombre);
            System.out.println("Perfil:" + pointer.perfil);//1. contratista. 2. cotratante
            System.out.println("Usuario:" + pointer.usuario);
            pointer = pointer.next;
        }
    }
}
