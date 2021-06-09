package Controladores.MenuPrincipal;

import Menus.ClasesInterfaces.Interfaz;
import Menus.Interfaces.ReservarClase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cargarReserva implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        Interfaz.setVentana(new ReservarClase());
    }

}
