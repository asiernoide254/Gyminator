package Menus.Interfaces;

import Clases.Ejercicio;
import Menus.ClasesInterfaces.Interfaz;

import javax.swing.*;

public class ModificarDetallesEjercicio extends Interfaz {

    private Ejercicio ej;
    private JTextField nombre;
    private JTextField series;
    private JTextField repeticiones;
    private JTextField peso;
    private JTextField tiempo;
    private JTextField fecha;
    private JTextField sensaciones;
    private JButton volver;
    private JButton guardar;

    public ModificarDetallesEjercicio(Ejercicio ej) {

        this.ej = ej;

        addTitulo("MODIFICA LOS DATOS DEL EJERCICIO");

        Interfaz datos = new Interfaz();

        nombre = new JTextField(ej.getNombre());
        datos.addCampo("Nombre: ", nombre);

        series = new JTextField(ej.getSeries());
        datos.addCampo("Series: ", series);

        repeticiones = new JTextField(ej.getRepeticiones());
        datos.addCampo("Repeticiones: ", repeticiones);

        peso = new JTextField(String.valueOf(ej.getPeso()));
        datos.addCampo("Peso: ", peso);

        tiempo = new JTextField(String.valueOf(ej.getTiempo()));
        datos.addCampo("Tiempo: ", tiempo);

        addFila(new JLabel("Fecha: "), new JLabel(String.valueOf(ej.getFecha())));

        sensaciones = new JTextField(ej.getSensaciones());
        datos.addCampo("Sensaciones: ", sensaciones);

        volver = new JButton();
        guardar = new JButton();

        addFila(guardar, volver);

        //    volver.addActionListener(CargarRegistroEjercicio(ej));
        //     guardar.addActionListener(GuardarModificacion(ej));


    }
}
