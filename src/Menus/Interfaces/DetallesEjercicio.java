package Menus.Interfaces;

import Clases.Ejercicio;
import Controladores.Ejercicios.BorrarEjercicio;
import Controladores.Generales.CargarMostrarProgreso;
import Menus.ClasesInterfaces.Interfaz;

import javax.swing.*;

public class DetallesEjercicio extends Interfaz {

    private Ejercicio ejercicio;
    private JButton Borrar;
    private JButton Modificar;
    private JButton Volver;

    public DetallesEjercicio(Ejercicio ej) {
        ejercicio = ej;

        addTitulo("DETALLES DEL EJERCICIO: " + ej.getFecha());

        addFila(new JLabel("Nombre: "), new JLabel(ejercicio.getNombre()));
        addFila(new JLabel("Fecha: "), new JLabel(ejercicio.getFecha().toString()));
        addFila(new JLabel("Series: "), new JLabel(String.valueOf(ejercicio.getSeries())));
        addFila(new JLabel("Repeticiones: "), new JLabel(String.valueOf(ejercicio.getRepeticiones())));
        addFila(new JLabel("Peso: "), new JLabel(String.valueOf(ejercicio.getPeso())));
        addFila(new JLabel("Tiempo: "), new JLabel(String.valueOf(ejercicio.getTiempo())));
        addFila(new JLabel("Fecha: "), new JLabel(String.valueOf(ejercicio.getFecha())));
        addFila(new JLabel("Sensaciones: "), new JLabel(ejercicio.getSensaciones()));


        //Botones
        Borrar = new JButton("Borrar Progreso");
        Borrar.addActionListener(new BorrarEjercicio(ejercicio, Interfaz.getUsuario()));
        Modificar = new JButton("Modificar Progreso");
//        Modificar.addActionListener(new ModificarEjercicio(ejercicio));
        Volver = new JButton("Volver");
        Volver.addActionListener(new CargarMostrarProgreso());

        addFila(Volver, Modificar, Borrar);
    }


}
