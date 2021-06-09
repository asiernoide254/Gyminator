package Menus.ClasesInterfaces;

import Controladores.Generales.CerrarVentanaError;

import javax.swing.*;
import java.awt.*;

public class VentanaMensaje extends JFrame {
    public VentanaMensaje(String mensaje) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Interfaz.ICONO.getImage());

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
