package Menus.Interfaces;

import BaseDeDatos.BaseDeDatos;
import Clases.Ejercicio;
import Controladores.Ejercicios.CargarRegistroEjercicio;
import Controladores.Generales.CargarMenuPrincipal;
import Controladores.MenuPrincipal.cargarRegistrarEjercicios;
import Menus.ClasesInterfaces.Interfaz;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MostrarProgreso extends Interfaz {
    private JButton BotonVolver;
    private JButton RegistrarEjercicio;
    private JButton botonEjercicio;

    private Interfaz listaEjercicios;

    public MostrarProgreso() {

        addTitulo("PROGRESO");


        List<Ejercicio> ejercicios = BaseDeDatos.getEjercicios(Interfaz.getUsuario().getEmail());

        listaEjercicios = new Interfaz();
        listaEjercicios.setAnchoBordes(0);

        for (Ejercicio ejercicio : ejercicios)
            addBotonEjercicio(ejercicio);

        JScrollPane panelEjercicios = new JScrollPane(listaEjercicios);
        addFila(panelEjercicios);

        BotonVolver = new JButton("Volver");
        BotonVolver.addActionListener(new CargarMenuPrincipal());
        RegistrarEjercicio = new JButton("Registrar ejercicio");
        RegistrarEjercicio.addActionListener(new cargarRegistrarEjercicios());
        addFila(BotonVolver, RegistrarEjercicio);
    }

    private void addBotonEjercicio(Ejercicio ejercicio){
        botonEjercicio = new JButton("<html>" + ejercicio.getNombre() + "<br/>" + ejercicio.getFecha() + "</html>");
        botonEjercicio.setPreferredSize(new Dimension(200, 50));
        botonEjercicio.addActionListener(new CargarRegistroEjercicio(ejercicio));
        listaEjercicios.addFila(Interfaz.LEFT, botonEjercicio);
    }
}
