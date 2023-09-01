/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra.moduloadministracion;

import java.awt.TextArea;

/**
 *
 * @author donal
 */
public class clsUsuarios {

    private String nombreCompleto;
    private String correo;
    private String numTelefono;
    private String direccion;
    private int edad;
    private String clave;
    private String motivoInhabilitacion;
    private char perfil;

    public clsUsuarios(String nombreCompleto, String correo, String numTelefono, String direccion, int edad, String clave, char perfil) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.numTelefono = numTelefono;
        this.direccion = direccion;
        this.edad = edad;
        this.clave = clave;
        this.perfil = perfil;
    }

    public clsUsuarios(String nombreCompleto, String correo, String numTelefono, String direccion, int edad, String clave, char perfil, String motivoInhabilitacion) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.numTelefono = numTelefono;
        this.direccion = direccion;
        this.edad = edad;
        this.clave = clave;
        this.perfil = perfil;
        this.motivoInhabilitacion = motivoInhabilitacion;
    }

    public clsUsuarios() {
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getMotivoInhabilitacion() {
        return motivoInhabilitacion;
    }

    public void setMotivoInhabilitacion(String motivoInhabilitacion) {
        this.motivoInhabilitacion = motivoInhabilitacion;
    }

    public char getPerfil() {
        return perfil;
    }

    public void setPerfil(char perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return nombreCompleto + "\t" + correo + "\t" + numTelefono + "\t" + direccion + "\t" + edad;
    }

    public clsUsuarios[] generarListaUsuarios() {
        clsHelper clsH = new clsHelper();
        int tamaño = clsH.recibeInt("Digite la cantidad de usuarios que quiere almacenar: ");
        clsUsuarios usuarios[] = new clsUsuarios[tamaño];
        //clsCliente []clientes = new clsCliente[tamaño];

        return usuarios;
    }

    public int agregarUsuario(clsUsuarios usuarios[], int posUsuario) {
        clsHelper clsH = new clsHelper();
        String nombreCompleto = clsH.recibeString("Digite el nombre completo del usuario: ");
        String correo = clsH.recibeString("Digite el correo del usuario: ");
        String numTelefono = clsH.recibeString("Digite el teléfono del usuario: ");
        String direccion = clsH.recibeString("Digite la dirección del usuario: ");
        int edad = clsH.recibeInt("Digite la edad del usuario: ");

        usuarios[posUsuario] = new clsUsuarios(nombreCompleto, correo, numTelefono, direccion, edad, clave, perfil);
        posUsuario++;
        clsH.imprimeMensaje("Usuario agregado correctamente");
        return posUsuario;
    }

    public int obtenerPosUsuario(clsUsuarios usuarios[], int posUsuario, String accion) {
        clsHelper clsH = new clsHelper();
        String nombreBuscar = clsH.recibeString("Digite el nombre del usuario que desea " + accion + ": ");
        int posUsuarioBuscado = -1;
        for (int i = 0; i < posUsuario; i++) {
            if (usuarios[i] != null && nombreBuscar.equalsIgnoreCase(usuarios[i].getNombreCompleto())) {
                posUsuarioBuscado = i;
                break;
            }
        }
        return posUsuarioBuscado;
    }

    public int obtenerPosUsuarioInhabilitado(clsUsuarios usuariosInhabilitados[], int posUsuarioInhabilitado, String accion) {
        clsHelper clsH = new clsHelper();
        String nombreBuscar = clsH.recibeString("Digite el nombre del usuario que desea " + accion + ": ");
        int posUsuarioBuscado = -1;
        for (int i = 0; i < posUsuarioInhabilitado; i++) {
            if (nombreBuscar.equalsIgnoreCase(usuariosInhabilitados[i].getNombreCompleto())) {
                posUsuarioBuscado = i;
                break;
            }
        }
        return posUsuarioBuscado;
    }

    public void modificarUsuario(clsUsuarios usuarios[], int posUsuario) {
        clsHelper clsH = new clsHelper();
        int posCBuscado = this.obtenerPosUsuario(usuarios, posUsuario, "modificar");
        if (posCBuscado == -1) {
            clsH.imprimeMensaje("No se encontraron coincidencias con el nombre indicado.");
        } else {
            char opcion = 'S';
            do {
                opcion = clsH.recibeChar("Selecciones el dato que desea modificar: "
                        + "\n A. Nombre Completo"
                        + "\n B. Correo"
                        + "\n C. Teléfono"
                        + "\n D. Dirección"
                        + "\n E. Edad"
                        + "\n S. Salir");
                switch (opcion) {
                    case 'A':
                        usuarios[posCBuscado].setNombreCompleto(clsH.recibeString("Digite el nuevo nombre del usuario: "));
                        break;
                    case 'B':
                        usuarios[posCBuscado].setCorreo(clsH.recibeString("Digite el nuevo correo del usuario: "));
                        break;
                    case 'C':
                        usuarios[posCBuscado].setNumTelefono(clsH.recibeString("Digite el nuevo teléfono del usuario: "));
                        break;
                    case 'D':
                        usuarios[posCBuscado].setDireccion(clsH.recibeString("Digite la nueva dirección del usuario: "));
                        break;
                    case 'E':
                        usuarios[posCBuscado].setEdad(clsH.recibeInt("Digite la nueva edad del usuario: "));
                        break;
                    case 'S':
                        clsH.imprimeMensaje("Datos modificados correctamente.");
                        break;
                    default:
                        clsH.imprimeMensaje("Opción seleccionada incorrecta.");
                        break;
                }
            } while (opcion != 'S');
        }
    }

    public int eliminarUsuario(clsUsuarios usuarios[], int posUsuario) {
        clsHelper clsH = new clsHelper();
        int posc = this.obtenerPosUsuario(usuarios, posUsuario, "eliminar");

        if (posc == -1) {
            clsH.imprimeMensaje("No se encontraron coincidencias con el nombre digitado.");
        } else {
            for (int i = posc; i < posUsuario - 1; i++) {
                usuarios[i] = usuarios[i + 1];
            }

            usuarios[posUsuario - 1] = new clsUsuarios();

            if (posUsuario > 0) {
                posUsuario--;
            }
            clsH.imprimeMensaje("El usuario se eliminó correctamente.");
        }

        return posUsuario;
    }

    public void buscarUsuario(clsUsuarios usuarios[], int posUsuario) {
        clsHelper clsH = new clsHelper();
        int posc = this.obtenerPosUsuario(usuarios, posUsuario, "buscar");
        if (posc == -1) {
            clsH.imprimeMensaje("No se encontraron coincidencias con el nombre digitado.");
        } else {
            clsH.imprimeMensaje("Los datos del usuario son:\n"
                    + " Nombre: " + usuarios[posc].getNombreCompleto()
                    + " \nCorreo: " + usuarios[posc].getCorreo()
                    + " \nTeléfono: " + usuarios[posc].getNumTelefono()
                    + " \nDirección: " + usuarios[posc].getDireccion()
                    + " \nEdad: " + usuarios[posc].getEdad());
        }
    }

    public void listarUsuarios(clsUsuarios usuarios[], int posUsuario) {
        clsHelper clsH = new clsHelper();
        String impresion = "Nombre\tCorreo\tTelefono\tDireccion\tEdad\n";
        for (int i = 0; i < posUsuario; i++) {
            if (usuarios[i] != null) {
                impresion += usuarios[i].toString() + "\n";
            }
        }
        if (impresion.equals("Nombre\tCorreo\tTelefono\tDireccion\tEdad\n")) {
            clsH.imprimeMensaje("No hay usuarios para listar.");
        } else {
            clsH.imprimeMensaje(new TextArea(impresion));
        }
    }

    public void inhabilitarUsuario(clsUsuarios usuarios[], int posUsuario, clsUsuarios usuariosInhabilitados[], int posUsuariosInhabilitados) {
        clsHelper clsH = new clsHelper();
        int posc = this.obtenerPosUsuario(usuarios, posUsuario, "inhabilitar");

        if (posc == -1) {
            clsH.imprimeMensaje("No se encontraron coincidencias con el nombre digitado.");
        } else {
            String motivo = clsH.recibeString("Ingrese el motivo de la inhabilitación: ");
            usuarios[posc].setMotivoInhabilitacion(motivo);

            usuariosInhabilitados[posUsuariosInhabilitados] = usuarios[posc];
            posUsuariosInhabilitados++;

            for (int i = posc; i < posUsuario - 1; i++) {
                usuarios[i] = usuarios[i + 1];
            }
            usuarios[posUsuario - 1] = null;
            posUsuario--;

            clsH.imprimeMensaje("El usuario ha sido inhabilitado correctamente.");

            clsH.imprimeMensaje("Lista de Usuarios Inhabilitados:");
            for (int i = 0; i < posUsuariosInhabilitados; i++) {
                if (usuariosInhabilitados[i] != null) {
                    clsH.imprimeMensaje(usuariosInhabilitados[i].toString());
                }
            }
        }
    }

    public void habilitarUsuario(clsUsuarios usuarios[], int posUsuario, clsUsuarios usuariosInhabilitados[], int posUsuariosInhabilitados) {
        clsHelper clsH = new clsHelper();
        int posc = this.obtenerPosUsuarioInhabilitado(usuariosInhabilitados, posUsuariosInhabilitados, "habilitar");

        if (posc == -1) {
            clsH.imprimeMensaje("No se encontraron coincidencias con el nombre digitado.");
        } else {
            usuarios[posUsuario] = usuariosInhabilitados[posc];

            for (int i = posc; i < posUsuariosInhabilitados - 1; i++) {
                usuariosInhabilitados[i] = usuariosInhabilitados[i + 1];
            }

            usuariosInhabilitados[posUsuariosInhabilitados - 1] = new clsUsuarios();
            posUsuariosInhabilitados--;

            posUsuario++;
            clsH.imprimeMensaje("El usuario ha sido habilitado correctamente.");
        }
    }

    public void listarUsuariosInhabilitados(clsUsuarios usuariosInhabilitados[], int posUsuariosInhabilitados) {
        clsHelper clsH = new clsHelper();
        String impresion = "Nombre\tMotivo Inhabilitación\n";
        for (int i = 0; i < posUsuariosInhabilitados; i++) {
            if (usuariosInhabilitados[i] != null) {
                impresion += usuariosInhabilitados[i].getNombreCompleto() + "\t" + usuariosInhabilitados[i].getMotivoInhabilitacion() + "\n";
            } else {
                clsH.imprimeMensaje("No hay usuarios inhabilitados para listar.");
            }
            clsH.imprimeMensaje(new TextArea(impresion));
        }

    }

    public void asignarPerfilAUsuario(clsUsuarios usuarios[], int posUsuario) {
        clsHelper clsH = new clsHelper();

        int posUsuarioEncontrado = obtenerPosUsuario(usuarios, posUsuario, "asignar perfil o clave");

        if (posUsuarioEncontrado == -1) {
            clsH.imprimeMensaje("Usuario inválido o no existe.");
            return;
        }

        char opcion;
        do {
            opcion = clsH.recibeChar("Selecciones una opción: "
                    + "\n A. Asignar perfil"
                    + "\n B. Asignar clave"
                    + "\n S. Salir");
            switch (opcion) {
                case 'A':
                    char perfil = clsH.recibeChar("Ingrese el perfil (A->Administrador/C->Cajero/V->Vendedor) para el usuario: ");
                    usuarios[posUsuarioEncontrado].setPerfil(perfil);
                    clsH.imprimeMensaje("Perfil asignado correctamente.");
                    break;
                case 'B':
                    String clave = clsH.recibeString("Ingrese la clave para el perfil del usuario: ");
                    usuarios[posUsuarioEncontrado].setClave(clave);
                    clsH.imprimeMensaje("Clave asignada correctamente.");
                    break;
                case 'S':
                    clsH.imprimeMensaje("Saliendo del menú de asignación.");
                    break;
                default:
                    clsH.imprimeMensaje("Opción no válida.");
            }
        } while (opcion != 'S');
    }

    public void listarUsuariosConPerfiles(clsUsuarios usuarios[], int posUsuario) {
        clsHelper clsH = new clsHelper();
        String impresion = "Nombre\tPerfil\tClave\n";
        for (int i = 0; i < posUsuario; i++) {
            if (usuarios[i] != null) {
                impresion += usuarios[i].getNombreCompleto() + "\t" + usuarios[i].getPerfil() + "\t" + usuarios[i].getClave() + "\n";
            }
        }
        if (impresion.equals("Nombre\tPerfil\tClave\n")) {
            clsH.imprimeMensaje("No hay usuarios con perfiles para listar.");
        } else {
            clsH.imprimeMensaje(new TextArea(impresion));
        }
    }

}
