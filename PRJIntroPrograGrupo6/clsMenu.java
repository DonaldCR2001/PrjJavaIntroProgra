/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra.moduloadministracion;

/**
 *
 * @author donal
 */
public class clsMenu {
    public void menuCliente() {
        clsHelper clsH = new clsHelper();
        clsUsuarios clsU = new clsUsuarios();
        clsUsuarios usuarios[] = new clsUsuarios[10]; // Ajustar el tamaño según sea necesario
        clsUsuarios usuariosInhabilitados[] = new clsUsuarios[10]; // Ajustar el tamaño según sea necesario
        int posUsuario = 0;
        int posUsuariosInhabilitados = 0;
        char opcion = 'S';

        do {
            opcion = clsH.recibeChar("Seleccione una opción:\n"
                    + " A. Agregar Usuario\n"
                    + " B. Eliminar Usuario\n"
                    + " C. Modificar Usuario\n"
                    + " D. Buscar Usuario\n"
                    + " E. Listar Usuarios\n"
                    + " F. Inhabilitar Usuario\n"
                    + " G. Habilitar Usuario\n"
                    + " H. Listar Usuarios Inhabilitados\n"
                    + " S. Salir");

            switch (opcion) {
                case 'A':
                    if (posUsuario < usuarios.length) {
                        posUsuario = clsU.agregarUsuario(usuarios, posUsuario);
                    } else {
                        clsH.imprimeMensaje("La lista de usuarios se encuentra llena.");
                    }
                    break;
                case 'B':
                    if (posUsuario == 0) {
                        clsH.imprimeMensaje("No hay usuarios para eliminar.");
                    } else {
                        posUsuario = clsU.eliminarUsuario(usuarios, posUsuario);
                    }
                    break;
                case 'C':
                    if (posUsuario == 0) {
                        clsH.imprimeMensaje("No hay usuarios para modificar.");
                    } else {
                        clsU.modificarUsuario(usuarios, posUsuario);
                    }
                    break;
                case 'D':
                    if (posUsuario == 0) {
                        clsH.imprimeMensaje("No hay usuarios para buscar.");
                    } else {
                        clsU.buscarUsuario(usuarios, posUsuario);
                    }
                    break;
                case 'E':
                    if (posUsuario == 0) {
                        clsH.imprimeMensaje("No hay usuarios para listar.");
                    } else {
                        clsU.listarUsuarios(usuarios, posUsuario);
                    }
                    break;
                case 'F':
                    if (posUsuario == 0) {
                        clsH.imprimeMensaje("No hay usuarios para inhabilitar.");
                    } else {
                        clsU.inhabilitarUsuario(usuariosInhabilitados, posUsuariosInhabilitados, usuarios, posUsuario);
                    }
                    break;
                case 'G':
                    if (posUsuariosInhabilitados == 0) {
                        clsH.imprimeMensaje("No hay usuarios inhabilitados para habilitar.");
                    } else {
                        clsU.habilitarUsuario(usuariosInhabilitados, posUsuariosInhabilitados, usuarios, posUsuario);
                    }
                    break;
                case 'H':
                    if (posUsuariosInhabilitados == 0) {
                        clsH.imprimeMensaje("No hay usuarios inhabilitados para mostrar.");
                    } else {
                        clsU.listarUsuariosInhabilitados(usuariosInhabilitados, posUsuariosInhabilitados);
                    }
                    break;
                case 'S':
                    break;
                default:
                    clsH.imprimeMensaje("La opción seleccionada no es válida.");
            }
        } while (opcion != 'S');
    }
}

