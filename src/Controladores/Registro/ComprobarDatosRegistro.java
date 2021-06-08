package Controladores.Registro;

import BaseDeDatos.BaseDeDatos;
import Clases.Usuario.Cliente;
import Menus.ClasesInterfaces.Interfaz;
import Menus.ClasesInterfaces.VentanaMensaje;
import Menus.Interfaces.MenuPrincipal;
import Menus.Interfaces.Registro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ComprobarDatosRegistro implements ActionListener {
    private Registro registro;

    public ComprobarDatosRegistro(Registro r) {
        registro = r;
    }

    public void actionPerformed(ActionEvent e) {

        String email = registro.getEmail();
        String psw = registro.getPassword1();
        String psw2 = registro.getPassword2();
        String nombre = registro.getNombre();
        String apellidos = registro.getApellidos();
        Date fecha = registro.getFecha();
        String genero = registro.getGenero();
        String tlf = registro.getTelefono().replaceAll("\\s+", "");

        if (!emailCorrecto(email))
            new VentanaMensaje("Email no válido.");
        else if (BaseDeDatos.getUsuario(email).getEmail() != null)
            new VentanaMensaje("El email ya está en uso.");
        else if (psw.length() < 8)
            new VentanaMensaje("La contraseña debe tener como mínimo 8 caracteres.");
        else if (!psw.equals(psw2))
            new VentanaMensaje("Las contraseñas no coinciden.");
        else if (nombre.length() == 0)
            new VentanaMensaje("Introduzca su nombre.");
        else if (apellidos.length() == 0)
            new VentanaMensaje("Introduzca sus apellidos.");
        else if (fecha == null)
            new VentanaMensaje("Introduzca su fecha de nacimiento.");
        else if (tlf.length() != 0 && (tlf.length() != 9 || !esNumero(tlf)))
            new VentanaMensaje("Teléfono no válido.");
        else {
            BaseDeDatos.addUsuario(new Cliente(email, psw, nombre, apellidos, fecha, genero, tlf, null));
            Interfaz.setVentana(new MenuPrincipal());
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
