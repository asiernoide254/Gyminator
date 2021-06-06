package Controladores.MenuPrincipal;

import Menus.ClasesInterfaces.Interfaz;
import Menus.Interfaces.RegistrarEjercicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cargarRegistrarEjercicios implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        Interfaz.setVentana(new RegistrarEjercicio());
    }
}
