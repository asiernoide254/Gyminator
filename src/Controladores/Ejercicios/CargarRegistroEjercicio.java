package Controladores.Ejercicios;

import Clases.Ejercicio;
import Menus.ClasesInterfaces.Interfaz;
import Menus.Interfaces.DetallesEjercicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CargarRegistroEjercicio implements ActionListener {
    private Ejercicio ejercicio;

    public CargarRegistroEjercicio(Ejercicio e) {
        ejercicio = e;
    }

    public void actionPerformed(ActionEvent e) {
        Interfaz.setVentana(new DetallesEjercicio(ejercicio));
    }

}
