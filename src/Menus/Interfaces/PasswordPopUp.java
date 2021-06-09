package Menus.Interfaces;


import Controladores.CambiarPerfil.CambioContraseñaPerfil;
import Controladores.Generales.CargarCambioPerfil;
import Menus.ClasesInterfaces.Interfaz;

import javax.swing.*;

public class PasswordPopUp extends Interfaz {
    private JPasswordField txtCurrent;
    private JPasswordField txtNew1;
    private JPasswordField txtNew2;
    private JButton volver;
    private JButton cambiarCon;

    public PasswordPopUp() {
        txtCurrent = new JPasswordField(20);
        setAnchoTextoCampo(190);
        addCampo("Introduza su contraseña actual:", txtCurrent);

        txtNew1 = new JPasswordField(20);
        addCampo("Introduzca la nueva contraseña:", txtNew1);

        txtNew2 = new JPasswordField(20);
        addCampo("Confirme la nueva contraseña:", txtNew2);

        volver = new JButton("Volver");
        volver.addActionListener(new CargarCambioPerfil());
        cambiarCon = new JButton("Cambiar contraseña");
        cambiarCon.addActionListener(new CambioContraseñaPerfil(this));
        addFila(volver, cambiarCon);
    }

    public String getCurrentPassword() {
        return new String(txtCurrent.getPassword());
    }

    public String getNewPassword() {
        return new String(txtNew1.getPassword());
    }

    public String getNewPassword2() {
        return new String(txtNew2.getPassword());
    }
}
