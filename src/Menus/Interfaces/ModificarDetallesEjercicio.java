package Menus.Interfaces;

import Clases.Ejercicio;
import Controladores.Ejercicios.CargarRegistroEjercicio;
import Menus.ClasesInterfaces.Interfaz;
import Controladores.Ejercicios.GuardarModificacion;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class ModificarDetallesEjercicio extends Interfaz {

    private Ejercicio ej;
    private JTextField nombre;
    private JTextField series;
    private JTextField repeticiones;
    private JTextField peso;
    private JTextField tiempo;
    private JDateChooser fecha;
    private JTextArea sensaciones;
    private JButton volver;
    private JButton guardar;

    public ModificarDetallesEjercicio(Ejercicio ej) {

        this.ej = ej;

        addTitulo("MODIFICA LOS DATOS DEL EJERCICIO");

        Interfaz datos = new Interfaz();

        nombre = new JTextField(20);
        nombre.setText(ej.getNombre());
        datos.addCampo("Nombre: ", nombre);

        series = new JTextField(10);
        series.setText(String.valueOf(ej.getSeries()));
        datos.addCampo("Series: ", series);

        repeticiones = new JTextField(10);
        repeticiones.setText(String.valueOf(ej.getRepeticiones()));
        datos.addCampo("Repeticiones: ", repeticiones);

        peso = new JTextField(10);
        peso.setText(String.valueOf(ej.getPeso()));
        datos.addCampo("Peso: ", peso);

        tiempo = new JTextField(10);
        tiempo.setText(String.valueOf(ej.getTiempo()));
        datos.addCampo("Tiempo: ", tiempo);

        fecha = new JDateChooser();
        fecha.setPreferredSize(new Dimension(100, 20));
        fecha.setDateFormatString("dd/MM/yyyy");
        fecha.setDate(ej.getFecha());
        datos.addCampo("Fecha:", fecha);

        sensaciones = new JTextArea(5, 50);
        sensaciones.setText(ej.getSensaciones());
        datos.addCampo("Sensaciones: ", sensaciones);

        addFila(datos);

        volver = new JButton("Volver");
        guardar = new JButton("Guardar");

        addFila(volver, guardar);

        volver.addActionListener(new CargarRegistroEjercicio(ej));
        guardar.addActionListener(new GuardarModificacion(this, ej));
    }

    public String getNombre() {
        return nombre.getText();
    }

    public String getSeries() {
        return series.getText();
    }

    public String getRepeticiones() {
        return repeticiones.getText();
    }

    public String getPeso() {
        return peso.getText();
    }

    public String getTiempo() {
        return tiempo.getText();
    }

    public Date getFecha() {
        return fecha.getDate();
    }

    public String getSensaciones() {
        return sensaciones.getText();
    }
}
