package Controladores.Herramientas;

import Menus.Interfaces.Calculadora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cargarCalculadora implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        new Calculadora();
    }
}
