package Menus.Interfaces;

import Controladores.Generales.CargarInicioSesion;
import Controladores.NuevaPassword.ComprobarDatosNuevaPassword;
import Menus.ClasesInterfaces.Etiqueta;
import Menus.ClasesInterfaces.Interfaz;

import javax.swing.*;

public class NuevaPassword extends Interfaz {
    private JTextField codigo;
    private JPasswordField password;
    private JPasswordField password2;
    private JButton botonOK;
    private JButton volver;


    public NuevaPassword() {
        addTitulo("NUEVA CONTRASEÑA");
        // Cambiar email
        addFila(new Etiqueta("Se ha enviado un correo a " + Interfaz.getUsuario().getEmail() + " con un código de verificación. Introdúzcalo a" +
                " continuación para obtener una contraseña nueva."
        ));

        Interfaz datos = new Interfaz();

        codigo = new JTextField(10);
        datos.addCampo("Código", codigo);

        password = new JPasswordField(20);
        datos.addCampo("Nueva contraseña: ", password);

        password2 = new JPasswordField(20);
        datos.addCampo("Repita la contraseña: ", password2);

        botonOK = new JButton("OK");
        datos.addFila(botonOK);

        volver = new JButton("Volver");
        datos.addFila(volver);
        volver.addActionListener(new CargarInicioSesion());

        addFila(datos);

        botonOK.addActionListener(new ComprobarDatosNuevaPassword(this));
    }

    public String getCodigo() {
        return codigo.getText();
    }

    public String getPassword() {
        return new String(password.getPassword());
    }

    public String getPassword2() {
        return new String(password2.getPassword());
    }
}
