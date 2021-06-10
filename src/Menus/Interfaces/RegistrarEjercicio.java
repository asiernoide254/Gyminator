package Menus.Interfaces;

import Controladores.Ejercicios.GuardarEjercicio;
import Controladores.Generales.CargarMostrarProgreso;
import Menus.ClasesInterfaces.Interfaz;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
public class RegistrarEjercicio extends Interfaz {
    private JTextField nombre;
    private JTextField series;
    private JTextField repeticiones;
    private JTextField peso;
    private JTextField tiempo;
    private JDateChooser fecha;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private JTextArea sensaciones;
    private JButton botonVolver;
    private JButton botonGuardado;



    public RegistrarEjercicio() {
        addTitulo("REGISTRAR EJERCICIO");


        Interfaz datos = new Interfaz();

        //Nombre

        nombre = new JTextField(20);
        datos.addCampo("Nombre:", nombre);

        //Series

        series = new JTextField(5);
        datos.addCampo("Series:", series);

        //Repeticiones

        repeticiones = new JTextField(5);
        datos.addCampo("Repeticiones:", repeticiones);

        //Peso

        peso = new JTextField(5);
        datos.addCampo("Peso:", peso);

        //Tiempo

        tiempo = new JTextField(10);
        datos.addCampo("Tiempo:", tiempo);

        //Fecha
        fecha = new JDateChooser();
        fecha.setPreferredSize(new Dimension(100, 20));
        fecha.setDateFormatString("dd/MM/yyyy");
        fecha.setDate(new Date(System.currentTimeMillis()));
        datos.addCampo("Fecha:", fecha);


        //Sensaciones

        sensaciones = new JTextArea(5, 30);
        datos.addCampo("Sensaciones:", sensaciones);

        addFila(datos);

        //Botón de guardado

        botonGuardado = new JButton("Guardar");
        botonGuardado.addActionListener(new GuardarEjercicio(this));
        botonVolver = new JButton("Volver");
        botonVolver.addActionListener(new CargarMostrarProgreso());
        addFila(botonVolver, botonGuardado);
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


