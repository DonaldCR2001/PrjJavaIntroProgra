/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra.moduloadministracion;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author donal
 */
public class clsMenu {

    private StringBuilder bitacora = new StringBuilder();

    public void menuUsuarios() {
        clsHelper clsH = new clsHelper();
        clsUsuarios clsU = new clsUsuarios();
        clsUsuarios usuarios[] = new clsUsuarios[10];
        clsUsuarios usuariosInhabilitados[] = new clsUsuarios[10];
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
                    + " I. Gestión de Perfiles y Claves\n"
                    + " J. Mostrar Bitácora\n"
                    + " S. Salir");

            switch (opcion) {
                case 'A':
                    if (posUsuario < usuarios.length) {
                        posUsuario = clsU.agregarUsuario(usuarios, posUsuario);
                        registrarEvento("Se agregó al usuario: " + usuarios[posUsuario - 1].getNombreCompleto());
                    } else {
                        clsH.imprimeMensaje("La lista de usuarios se encuentra llena.");
                    }
                    break;
                case 'B':
                    if (posUsuario == 0) {
                        clsH.imprimeMensaje("No hay usuarios para eliminar.");
                    } else {
                        posUsuario = clsU.eliminarUsuario(usuarios, posUsuario);
                        registrarEvento("Se eliminó al usuario: " + usuarios[posUsuario - 1].getNombreCompleto());
                    }
                    break;
                case 'C':
                    if (posUsuario == 0) {
                        clsH.imprimeMensaje("No hay usuarios para modificar.");
                    } else {
                        clsU.modificarUsuario(usuarios, posUsuario);
                        registrarEvento("Se modificó al usuario: " + usuarios[posUsuario - 1].getNombreCompleto());
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
                        clsU.inhabilitarUsuario(usuarios, posUsuario, usuariosInhabilitados, posUsuariosInhabilitados);
                        registrarEvento("Se inhabilitó al usuario: " + usuarios[posUsuario - 1].getNombreCompleto());
                    }
                    break;
                case 'G':
                    if (posUsuariosInhabilitados == 0) {
                        clsH.imprimeMensaje("No hay usuarios inhabilitados para habilitar.");
                    } else {
                        clsU.habilitarUsuario(usuarios, posUsuario, usuariosInhabilitados, posUsuariosInhabilitados);
                        registrarEvento("Se habilitó al usuario: " + usuarios[posUsuario - 1].getNombreCompleto());
                    }
                    break;
                case 'H':
                    if (posUsuariosInhabilitados == 0) {
                        clsH.imprimeMensaje("No hay usuarios inhabilitados para listar.");
                    } else {
                        clsU.listarUsuariosInhabilitados(usuariosInhabilitados, posUsuariosInhabilitados);
                    }
                    break;
                case 'I':
                    if (posUsuario == 0) {
                        clsH.imprimeMensaje("No hay usuarios para gestionar perfiles y claves.");
                    } else {
                        this.MenuGestionPerfiles(usuarios, posUsuario);
                    }
                    break;
                case 'J':
                    if (bitacora.length() == 0) {
                        clsH.imprimeMensaje("La bitácora está vacía.");
                    } else {
                        this.mostrarBitacora();
                    }
                    break;
                case 'S':
                    break;
                default:
                    clsH.imprimeMensaje("La opción seleccionada no es válida.");
            }
        } while (opcion != 'S');
    }

    public void MenuGestionPerfiles(clsUsuarios usuarios[], int posUsuario) {
        clsHelper clsH = new clsHelper();
        clsUsuarios clsU = new clsUsuarios();
        char opcion = 'S';

        do {
            opcion = clsH.recibeChar("Seleccione una opción:\n"
                    + " A. Gestión de Perfil y Claves\n"
                    + " B. Mostrar perfiles y claves\n"
                    + " S. Salir");

            switch (opcion) {
                case 'A':
                    if (posUsuario == -1) {
                        clsH.imprimeMensaje("No hay usuarios para asignar perfiles y claves.");
                    } else {
                        clsU.asignarPerfilAUsuario(usuarios, posUsuario);
                    }
                    break;
                case 'B':
                    if (posUsuario == -1) {
                        clsH.imprimeMensaje("No hay perfiles para mostrar.");
                    } else {
                        clsU.listarUsuariosConPerfiles(usuarios, posUsuario);
                    }
                    break;
                case 'S':
                    break;
                default:
                    clsH.imprimeMensaje("La opción seleccionada no es válida.");
            }
        } while (opcion != 'S');
    }

    private void registrarEvento(String evento) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaHoraActual = sdf.format(new Date());
        bitacora.append(fechaHoraActual).append(" - ").append(evento).append("\n");
    }

    public void mostrarBitacora() {
        clsHelper clsH = new clsHelper();
        clsH.imprimeMensaje(bitacora.toString());
    }

}
