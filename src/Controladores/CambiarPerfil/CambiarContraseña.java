package Controladores.CambiarPerfil;

import Menus.Interfaces.PasswordPopUp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CambiarContraseña implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = new JFrame();
        frame.add(new PasswordPopUp());
        frame.pack();
        frame.setVisible(true);
    }
}
