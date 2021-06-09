package Controladores.MenuPrincipal;

import Menus.ClasesInterfaces.Interfaz;
import Menus.Interfaces.Herramientas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cargarHerramientas implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        Interfaz.setVentana(new Herramientas());
    }

}

