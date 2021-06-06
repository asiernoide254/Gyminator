package Controladores.Ejercicios;

import BaseDeDatos.BaseDeDatos;
import Clases.Ejercicio;
import Menus.Interfaces.RegistrarEjercicio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuardarEjercicio implements ActionListener {
    private RegistrarEjercicio r;
    private JDialog j;

    public GuardarEjercicio(RegistrarEjercicio r) {
        this.r = r;
    }

    public void actionPerformed(ActionEvent e) {
        Ejercicio ej = new Ejercicio(r.getNombre(),
                Integer.parseInt(r.getSeries()),
                Integer.parseInt(r.getRepeticiones()),
                Integer.parseInt(r.getPeso()),
                Integer.parseInt(r.getTiempo()),
                r.getFecha(),
                r.getSensaciones());

        BaseDeDatos.addEjercicio(ej);
    }


}
