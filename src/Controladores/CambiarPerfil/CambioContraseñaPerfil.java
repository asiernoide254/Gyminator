package Controladores.CambiarPerfil;

import BaseDeDatos.BaseDeDatos;
import Clases.Usuario.Usuario;
import Menus.ClasesInterfaces.Interfaz;
import Menus.ClasesInterfaces.VentanaMensaje;
import Menus.Interfaces.PasswordPopUp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CambioContraseñaPerfil implements ActionListener {
    PasswordPopUp passwordPopUp;

    public CambioContraseñaPerfil(PasswordPopUp pass){
        passwordPopUp = pass;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String passwordAnterior = passwordPopUp.getCurrentPassword();
        String password = passwordPopUp.getNewPassword();
        String password2 = passwordPopUp.getNewPassword2();

        Usuario usuario = Interfaz.getUsuario();
        String passwordInterfaz = usuario.getPassword();

        if(!passwordAnterior.equals(passwordInterfaz))
            new VentanaMensaje("Contraseña no válida.");
        else if(password.length() < 8)
            new VentanaMensaje("La contraseña debe tener un mínimo de 8 caracteres.");
        else if(!password.equals(password2))
            new VentanaMensaje("Las contraseñas no coinciden.");
        else {
            BaseDeDatos.actualizarUsuario(usuario.getEmail(), "CONTRASEÑA", password);
            new VentanaMensaje("Cambios aplicados.");
        }
    }
}
