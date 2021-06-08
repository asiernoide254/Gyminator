package Menus.Interfaces;

import Menus.ClasesInterfaces.Interfaz;

import javax.swing.*;

public class VerificarCodigo extends Interfaz {

    private JTextField codigo;

    public VerificarCodigo() {

        addTitulo("VERIFICACIÓN DE CÓDIGO");
        addCampo("Introduzca el código de su gimnasio:", codigo);

    }

    public String getCodigo() {
        return codigo.getText();
    }


}
