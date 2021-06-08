package Controladores.Herramientas;

import Interfaces.Interfaces.Cronometro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cargarCronometro implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        new Cronometro();
    }
}
