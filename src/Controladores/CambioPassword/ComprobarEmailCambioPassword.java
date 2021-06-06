package Controladores.CambioPassword;

import BaseDeDatos.BaseDeDatos;
import Clases.EnviarEmail;
import Clases.Usuario.Usuario;
import Menus.ClasesInterfaces.Interfaz;
import Menus.ClasesInterfaces.VentanaMensaje;
import Menus.Interfaces.CambioPassword;
import Menus.Interfaces.NuevaPassword;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

public class ComprobarEmailCambioPassword implements ActionListener {
    private CambioPassword cambioPassword;
    private Random rnd;

    public ComprobarEmailCambioPassword(CambioPassword cambioContr) {
        cambioPassword = cambioContr;
        rnd = new Random();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String email = cambioPassword.getEmail();
        Usuario usuario = BaseDeDatos.getUsuario(email);

        if (usuario.getEmail() != null) {
            Interfaz.setUsuario(usuario);

            List<Integer> codigosBD = BaseDeDatos.getCodigosPassword();
            int codigo = rnd.nextInt(900000) + 100000;
            while (codigosBD.contains(codigo))
                codigo = rnd.nextInt(900000) + 100000;

            BaseDeDatos.addCodigoPassword(codigo, email);

            new EnviarEmail(
                    email,
                    "Restablezca su contraseña en Gyminator",
                    "<p>¡Hola, " + usuario.getNombre() + "!</p>" +
                            "<p>Hemos detectado que ha solicitado un cambio de contraseña. Introduzca el código" +
                            " siguiente en la aplicación para obtener una nueva.</p>" +
                            "<h1><b>" + codigo + "</b></h1>"
            );

            Interfaz.setVentana(new NuevaPassword());
        } else
            new VentanaMensaje("El email introducido no está asociado a ninguna cuenta.");
    }
}
