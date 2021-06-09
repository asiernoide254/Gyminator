package Controladores.Generales;


import Menus.ClasesInterfaces.Interfaz;
import Menus.Interfaces.MenuPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CargarMenuPrincipal implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        Interfaz.setVentana(new MenuPrincipal());
    }
}
