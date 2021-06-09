package Controladores.CambiarPerfil;

import Menus.ClasesInterfaces.Interfaz;
import Menus.Interfaces.Registro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CargarRegistro implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Interfaz.setVentana(new Registro());
    }
}
