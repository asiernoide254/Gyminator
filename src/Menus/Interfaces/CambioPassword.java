package Menus.Interfaces;

import Controladores.CambioPassword.ComprobarEmailCambioPassword;
import Controladores.Generales.CargarInicioSesion;
import Menus.ClasesInterfaces.Interfaz;

import javax.swing.*;
import java.util.Random;

public class CambioPassword extends Interfaz {
    private JTextField email;
    private JButton botonOK;
    private JButton volver;
    private Random rnd = new Random();

    public CambioPassword() {
        addTitulo("REESTABLEZCA SU CUENTA");

        Interfaz datos = new Interfaz();
        datos.setAnchoTextoCampo(35);

        email = new JTextField(20);
        datos.addCampo("Email:", email);

        botonOK = new JButton("OK");
        volver = new JButton("Volver");
        volver.addActionListener(new CargarInicioSesion());
        datos.addFila(volver, botonOK);

        addFila(datos);

        botonOK.addActionListener(new ComprobarEmailCambioPassword(this));
    }

    public String getEmail() {
        return email.getText();
    }
}
