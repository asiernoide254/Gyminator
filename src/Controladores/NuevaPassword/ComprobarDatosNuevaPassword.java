package Controladores.NuevaPassword;

import BaseDeDatos.BaseDeDatos;
import Menus.ClasesInterfaces.Interfaz;
import Menus.ClasesInterfaces.VentanaMensaje;
import Menus.Interfaces.InicioSesion;
import Menus.Interfaces.NuevaPassword;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ComprobarDatosNuevaPassword implements ActionListener {
    private NuevaPassword nuevaPassword;

    public ComprobarDatosNuevaPassword(NuevaPassword nuevaP) {
        nuevaPassword = nuevaP;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String email = Interfaz.getUsuario().getEmail();
        List<Integer> codigosUsuario = BaseDeDatos.getCodigosPassword(email);

        Integer codigo = Integer.parseInt(nuevaPassword.getCodigo());
        String password = nuevaPassword.getPassword();
        String password2 = nuevaPassword.getPassword2();

        if (!codigosUsuario.contains(codigo))
            new VentanaMensaje("Código no válido.");
        else if (!password.equals(password2))
            new VentanaMensaje("Las contraseñas no coinciden");
        else {
            BaseDeDatos.borrarCodigosPassword(email);
            BaseDeDatos.actualizarUsuario(email, "CONTRASEÑA", password);
            Interfaz.setVentana(new InicioSesion());
        }
    }
}
