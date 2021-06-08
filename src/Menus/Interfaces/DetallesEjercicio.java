package Menus.Interfaces;

import Clases.Ejercicio;
import Controladores.Ejercicios.BorrarEjercicio;
import Controladores.Ejercicios.ModificarEjercicio;
import Controladores.Generales.CargarMostrarProgreso;
import Menus.ClasesInterfaces.Interfaz;

import javax.swing.*;

public class DetallesEjercicio extends Interfaz {

    private Ejercicio ejercicio;
    private JButton borrar;
    private JButton modificar;
    private JButton volver;

    public DetallesEjercicio(Ejercicio ej) {
        ejercicio = ej;

        addTitulo("DETALLES DEL EJERCICIO");

        Interfaz datos = new Interfaz();

        datos.addCampo("Nombre: ", new JLabel(ejercicio.getNombre()));
        datos.addCampo("Fecha: ", new JLabel(ejercicio.getFecha().toString()));
        datos.addCampo("Series: ", new JLabel(String.valueOf(ejercicio.getSeries())));
        datos.addCampo("Repeticiones: ", new JLabel(String.valueOf(ejercicio.getRepeticiones())));
        datos.addCampo("Peso: ", new JLabel(String.valueOf(ejercicio.getPeso())));
        datos.addCampo("Tiempo: ", new JLabel(String.valueOf(ejercicio.getTiempo())));
        datos.addCampo("Fecha:", new JLabel(String.valueOf(ejercicio.getFecha())));
        datos.addCampo("Sensaciones: ", new JLabel(ejercicio.getSensaciones()));

        addFila(datos);

        //Botones
        borrar = new JButton("Borrar Progreso");
        borrar.addActionListener(new BorrarEjercicio(ejercicio, Interfaz.getUsuario()));
        modificar = new JButton("Modificar Progreso");
        modificar.addActionListener(new ModificarEjercicio(ejercicio));
        volver = new JButton("Volver");
        volver.addActionListener(new CargarMostrarProgreso());

        addFila(volver, modificar, borrar);
    }


}
