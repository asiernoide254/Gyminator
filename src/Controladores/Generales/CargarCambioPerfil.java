package Controladores.Generales;

import Menus.ClasesInterfaces.Interfaz;
import Menus.Interfaces.CambiarPerfil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CargarCambioPerfil implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Interfaz.setVentana(new CambiarPerfil());
    }
}
