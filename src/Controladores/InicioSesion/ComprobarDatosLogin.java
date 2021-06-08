package Controladores.InicioSesion;

import BaseDeDatos.BaseDeDatos;
import Clases.Usuario.Usuario;
import Menus.ClasesInterfaces.Interfaz;
import Menus.ClasesInterfaces.VentanaMensaje;
import Menus.Interfaces.InicioSesion;
import Menus.Interfaces.MenuPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComprobarDatosLogin implements ActionListener {
    private InicioSesion inicioSesion;

    public ComprobarDatosLogin(InicioSesion l) {
        inicioSesion = l;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String email = inicioSesion.getEmail();
        String password = inicioSesion.getPassword();

        Usuario usuario = BaseDeDatos.getUsuario(email);
        String passwordBD = usuario.getPassword();

        if (passwordBD == null)
            new VentanaMensaje("Email no válido.");
        else if (!password.equals(passwordBD))
            new VentanaMensaje("Contraseña incorrecta.");
        else {
            Interfaz.setUsuario(usuario);
            Interfaz.setVentana(new MenuPrincipal());
        }
    }
}
