package Controladores.CambiarPerfil;

import Menus.ClasesInterfaces.Interfaz;
import Menus.Interfaces.PasswordPopUp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CambiarContraseña implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Interfaz.setVentana(new PasswordPopUp());
    }
}
