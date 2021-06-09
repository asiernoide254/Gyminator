package Controladores.CambiarPerfil;

import BaseDeDatos.BaseDeDatos;
import Clases.Usuario.Cliente;
import Clases.Usuario.Usuario;
import Menus.ClasesInterfaces.Interfaz;
import Menus.ClasesInterfaces.VentanaMensaje;
import Menus.Interfaces.CambiarPerfil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GuardarCambiosPerfil implements ActionListener {
    private CambiarPerfil cambiarPerfil;
    private JDialog dialog;
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

    public GuardarCambiosPerfil(CambiarPerfil perfil) {
        cambiarPerfil = perfil;
    }

    public void actionPerformed(ActionEvent e) {
        //Comprobar que datos hay que cambiar

        Usuario usuario = Interfaz.getUsuario();

        String email = cambiarPerfil.getEmail();
        String nombre = cambiarPerfil.getNombre();
        String apellidos = cambiarPerfil.getApellidos();
        Date fecha = cambiarPerfil.getFecha();
        String genero = cambiarPerfil.getGenero();
        String tlf = cambiarPerfil.getTelefono().replaceAll("\\s+", "");

        String emailBD = BaseDeDatos.getUsuario(email).getEmail();

        if (!emailCorrecto(email))
            new VentanaMensaje("Email no válido.");
        else if (emailBD != null && !Interfaz.getUsuario().getEmail().equals(emailBD))
            new VentanaMensaje("El email ya está en uso.");
        else if (nombre.length() == 0)
            new VentanaMensaje("Introduzca su nombre.");
        else if (apellidos.length() == 0)
            new VentanaMensaje("Introduzca sus apellidos.");
        else if (fecha == null)
            new VentanaMensaje("Introduzca su fecha de nacimiento.");
        else if (tlf.length() != 0 && (tlf.length() != 9 || !esNumero(tlf)))
            new VentanaMensaje("Teléfono no válido.");
        else {
            String emailAnterior = Interfaz.getUsuario().getEmail();
            String password = Interfaz.getUsuario().getPassword();
            BaseDeDatos.actualizarUsuario(emailAnterior, "EMAIL", email, "CONTRASEÑA", password, "NOMBRE", nombre, "APELLIDOS", apellidos,
                    "FECHANACIMIENTO", formatter.format(fecha), "GENERO", genero, "TELEFONO", tlf, "FOTO", null);
            Usuario usuarioNuevo = new Cliente(email, Interfaz.getUsuario().getPassword(), nombre, apellidos, fecha, genero, tlf, null);
            Interfaz.setUsuario(usuarioNuevo);
            new VentanaMensaje("Perfil actualizado correctamente.");
        }

    }

    private boolean emailCorrecto(String email) {
        String[] em = email.split("@");

        if (em.length != 2 || !caracteresValidos(em[0]))
            return false;

        if (em[1].equals("gmail.com") || em[1].equals("hotmail.es") || em[1].equals("hotmail.com") || em[1].equals("uma.es"))
            return true;

        return false;
    }

    private boolean caracteresValidos(String s) {
        boolean validos = true;
        int tam = s.length();

        int i = 0;
        while (i < tam && validos) {
            char c = s.charAt(i);
            validos = Character.isLetterOrDigit(c) || (c == '.' && i != 0 && i != tam - 1 && s.charAt(i - 1) != c);
            i++;
        }

        return validos;
    }

    private boolean esNumero(String tlf) {
        int n;

        try {
            n = Integer.parseInt(tlf);
        } catch (NumberFormatException e) {
            return false;
        }

        return n >= 0;
    }
}

