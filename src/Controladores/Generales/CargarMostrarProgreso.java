package Controladores.Generales;

import Menus.ClasesInterfaces.Interfaz;
import Menus.Interfaces.MostrarProgreso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CargarMostrarProgreso implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        Interfaz.setVentana(new MostrarProgreso());
    }
}
