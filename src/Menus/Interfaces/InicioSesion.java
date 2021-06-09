package Menus.Interfaces;

import Controladores.CambiarPerfil.CargarRegistro;
import Controladores.InicioSesion.CargarCambioContraseña;
import Controladores.InicioSesion.ComprobarDatosLogin;
import Menus.ClasesInterfaces.Etiqueta;
import Menus.ClasesInterfaces.Interfaz;

import javax.swing.*;

public class InicioSesion extends Interfaz {
    private Etiqueta titulo;
    private Etiqueta icono;
    private JTextField email;
    private JPasswordField password;
    private JButton botonRegistrarse;
    private JButton botonEntrar;
    private JButton botonOlvidoPassword;

    public InicioSesion() {
        addTitulo("GYMINATOR");

        Etiqueta icono = new Etiqueta(Interfaz.ICONO);
        addFila(icono);

        Interfaz datos = new Interfaz();
        datos.setAnchoTextoCampo(120);

        email = new JTextField(20);
        datos.addCampo("Email:", email);

        password = new JPasswordField(20);
        datos.addCampo("Contraseña:", password);

        botonRegistrarse = new JButton("Registrarse");
        botonEntrar = new JButton("Entrar");
        botonOlvidoPassword = new JButton("¿Ha olvidado su contraseña?");
        datos.addFila(botonRegistrarse, botonEntrar, botonOlvidoPassword);

        addFila(datos);

        botonRegistrarse.addActionListener(new CargarRegistro());
        botonEntrar.addActionListener(new ComprobarDatosLogin(this));
        botonOlvidoPassword.addActionListener(new CargarCambioContraseña());
    }

    public String getEmail() {
        return email.getText();
    }

    public String getPassword() {
        return new String(password.getPassword());
    }
}
