package Controladores.Ejercicios;

import Clases.Ejercicio;
import Menus.Interfaces.ModificarDetallesEjercicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificarEjercicio implements ActionListener {

    private Ejercicio ej;

    public ModificarEjercicio(Ejercicio ej) {

        this.ej = ej;

    }

    public void actionPerformed(ActionEvent e) {
        new ModificarDetallesEjercicio(ej);

    }
}
