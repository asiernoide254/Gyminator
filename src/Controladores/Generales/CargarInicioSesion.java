package Controladores.Generales;

import Menus.ClasesInterfaces.Interfaz;
import Menus.Interfaces.InicioSesion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CargarInicioSesion implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Interfaz.setVentana(new InicioSesion());
    }
}

