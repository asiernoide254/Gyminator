package Menus.ClasesInterfaces;

import Controladores.Generales.CerrarVentanaError;

import javax.swing.*;
import java.awt.*;

public class VentanaMensaje extends JFrame {
    private static Image icono = Interfaz.crearIcono("cool_clown.png").getImage();

    public VentanaMensaje(String mensaje) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Interfaz interfaz = new Interfaz();

        interfaz.addFila(new Etiqueta(mensaje, Etiqueta.CENTER));

        JButton botonOK = new JButton("OK");
        interfaz.addFila(botonOK);

        botonOK.addActionListener(new CerrarVentanaError(this));

        add(interfaz);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        Interfaz.principal().setEnabled(false);
    }
}
