package Controladores.InicioSesion;

import Menus.ClasesInterfaces.Interfaz;
import Menus.Interfaces.CambioPassword;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CargarCambioContrase├▒a implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Interfaz.setVentana(new CambioPassword());
    }
}
