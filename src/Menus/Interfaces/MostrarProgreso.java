package Menus.Interfaces;

import BaseDeDatos.BaseDeDatos;
import Clases.Ejercicio;
import Controladores.Ejercicios.CargarRegistroEjercicio;
import Controladores.Generales.CargarMenuPrincipal;
import Controladores.MenuPrincipal.cargarRegistrarEjercicios;
import Menus.ClasesInterfaces.Interfaz;

import javax.swing.*;
import java.util.List;

public class MostrarProgreso extends Interfaz {
    private JButton BotonVolver;
    private JButton RegistrarEjercicio;

    public MostrarProgreso() {

        addTitulo("PROGRESO");


        List<Ejercicio> ejercicios = BaseDeDatos.getEjercicios(Interfaz.getUsuario().getEmail()); //Cambiar

        Interfaz listaEjercicios = new Interfaz();


        for (Ejercicio e : ejercicios) {

            JButton botonEj = new JButton("<html>" + e.getNombre() + "<br/>" + e.getFecha() + "</html>");
            listaEjercicios.addFila(botonEj);
            botonEj.addActionListener(new CargarRegistroEjercicio(e));


        }

        JScrollPane panelEjercicios = new JScrollPane();
        panelEjercicios.add(listaEjercicios);
        addFila(panelEjercicios);


        BotonVolver = new JButton("Volver");
        BotonVolver.addActionListener(new CargarMenuPrincipal());
        RegistrarEjercicio = new JButton("Registrar ejercicio");
        RegistrarEjercicio.addActionListener(new cargarRegistrarEjercicios());
        addFila(BotonVolver, RegistrarEjercicio);
    }

}









