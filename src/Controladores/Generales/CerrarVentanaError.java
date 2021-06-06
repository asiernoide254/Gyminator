package Controladores.Generales;

import Menus.ClasesInterfaces.Interfaz;
import Menus.ClasesInterfaces.VentanaMensaje;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CerrarVentanaError implements ActionListener {
    VentanaMensaje ventana;

    public CerrarVentanaError(VentanaMensaje v) {
        ventana = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ventana.dispose();
        Interfaz.principal().setEnabled(true);
    }
}
