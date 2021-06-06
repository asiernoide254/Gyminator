package Menus.Interfaces;

import Controladores.Generales.CargarMenuPrincipal;
import Controladores.Herramientas.cargarCalculadora;
import Controladores.Herramientas.cargarCronometro;
import Menus.ClasesInterfaces.Interfaz;

import javax.swing.*;

public class Herramientas extends Interfaz {
    private JButton calculadora;
    private JButton cronometro;
    private JButton botonVolver;

    public Herramientas() {
        addTitulo("HERRAMIENTAS");
        calculadora = new JButton("CALCULADORA");
        calculadora.addActionListener(new cargarCalculadora());
        cronometro = new JButton("CRONOMETRO");
        cronometro.addActionListener(new cargarCronometro());
        addFila(cronometro, calculadora);
        botonVolver = new JButton("Volver");
        botonVolver.addActionListener(new CargarMenuPrincipal());
        addFila(botonVolver);
    }

}
