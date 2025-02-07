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

    public clsUsuarios(String nombreCompleto, String correo, String numTelefono, String direccion, int edad, String clave) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.numTelefono = numTelefono;
        this.direccion = direccion;
        this.edad = edad;
        this.clave = clave;
    }

    public clsUsuarios(String nombreCompleto, String correo, String numTelefono, String direccion, int edad, String clave, String motivoInhabilitacion) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.numTelefono = numTelefono;
        this.direccion = direccion;
        this.edad = edad;
        this.clave = clave;
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

    @Override
    public String toString() {
        return nombreCompleto + "\t" + correo + "\t" + numTelefono + "\t" + direccion + "\t" + edad + "\t" + clave;
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
        String clave = clsH.recibeString("Digite la clave de acceso para este usuario: ");

        usuarios[posUsuario] = new clsUsuarios(nombreCompleto, correo, numTelefono, direccion, edad, clave);
        posUsuario++;
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
                        + "\n F. Clave"
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
                    case 'F':
                        usuarios[posCBuscado].setClave(clsH.recibeString("Digite la nueva clave del usuario: "));
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
            usuarios[posUsuario - 1] = null;
            posUsuario--;
            clsH.imprimeMensaje("El usuario se eliminó correctamente");
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

    public void inhabilitarUsuario(clsUsuarios usuariosInhabilitados[], int posUsuarioInhabilitado, clsUsuarios usuarios[], int posUsuario) {
    clsHelper clsH = new clsHelper();
    int posUsuarioInhabilitar = this.obtenerPosUsuario(usuarios, posUsuario, "inhabilitar");
    if (posUsuarioInhabilitar == -1) {
        clsH.imprimeMensaje("No se encontraron coincidencias con el nombre indicado.");
    } else {
        if (usuarios[posUsuarioInhabilitar] != null) {
            String motivo = clsH.recibeString("Digite el motivo de inhabilitación: ");
            usuarios[posUsuarioInhabilitar].setMotivoInhabilitacion(motivo);
            usuariosInhabilitados[posUsuarioInhabilitado] = usuarios[posUsuarioInhabilitar];
            usuarios[posUsuarioInhabilitar] = null;
            posUsuarioInhabilitado++;
            clsH.imprimeMensaje("Usuario inhabilitado correctamente.");
        } else {
            clsH.imprimeMensaje("El usuario ya está inhabilitado o no existe.");
        }
    }
}

    public void habilitarUsuario(clsUsuarios usuariosInhabilitados[], int posUsuarioInhabilitado, clsUsuarios usuarios[], int posUsuario) {
        clsHelper clsH = new clsHelper();
        int posUsuarioHabilitar = this.obtenerPosUsuarioInhabilitado(usuariosInhabilitados, posUsuarioInhabilitado, "habilitar");
        if (posUsuarioHabilitar == -1) {
            clsH.imprimeMensaje("No se encontraron coincidencias con el nombre indicado.");
        } else {
            clsUsuarios usuarioHabilitado = usuariosInhabilitados[posUsuarioHabilitar];
            usuariosInhabilitados[posUsuarioHabilitar] = null;
            int posDisponible = buscarPosicionDisponible(usuarios);
            usuarios[posDisponible] = usuarioHabilitado;
            clsH.imprimeMensaje("Usuario habilitado correctamente.");
        }
    }

    public int buscarPosicionDisponible(clsUsuarios usuarios[]) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] == null) {
                return i;
            }
        }
        return -1; 
    }

    public void listarUsuariosInhabilitados(clsUsuarios usuariosInhabilitados[], int posUsuarioInhabilitado) {
        clsHelper clsH = new clsHelper();
        String impresion = "Nombre\tCorreo\tTelefono\tDireccion\tEdad\tMotivo de Inhabilitación\n";
        for (int i = 0; i < posUsuarioInhabilitado; i++) {
            if (usuariosInhabilitados[i] != null) {
                impresion += usuariosInhabilitados[i].toString() + "\t" + usuariosInhabilitados[i].getMotivoInhabilitacion() + "\n";
            }
        }
        if (impresion.equals("Nombre\tCorreo\tTelefono\tDireccion\tEdad\tMotivo de Inhabilitación\n")) {
            clsH.imprimeMensaje("No hay usuarios inhabilitados para listar.");
        } else {
            clsH.imprimeMensaje(new TextArea(impresion));
        }
    }

}
