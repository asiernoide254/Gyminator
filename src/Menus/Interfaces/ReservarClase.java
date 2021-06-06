package Menus.Interfaces;

import Clases.Clase;
import Controladores.Generales.CargarMenuPrincipal;
import Controladores.Reserva.BuscarClases;
import Menus.ClasesInterfaces.Interfaz;
import Menus.ClasesInterfaces.VentanaMensaje;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.List;

public class ReservarClase extends Interfaz {

    private JScrollPane lista;

    private JDateChooser fecha;
    private JTextArea PosiblesReservas;
    private JButton buscar;
    private List<Clase> clases;
    private JButton botonVolver;
    private JButton botonclase;

    private BuscarClases bc;

    public ReservarClase() {

        addTitulo("RESERVA DE CLASES");

        Interfaz listaClases = new Interfaz();

        //Fecha
        fecha = new JDateChooser();
        fecha.setPreferredSize(new Dimension(100, 20));
        fecha.setDateFormatString("dd/MM/yyyy");


        buscar = new JButton("Buscar");
        bc = new BuscarClases(this);
        buscar.addActionListener(bc);

        addCampo("Fecha: ", fecha, buscar);

        clases = bc.getClases();

        if (clases.isEmpty()) {
            new VentanaMensaje("No hay clases a reservar ese día.");
        } else {
            for (int i = 0; i < clases.size(); i++) {
                botonclase = new JButton(clases.get(i).InfoBasica());
                listaClases.addFila(botonclase);
            }
            lista = new JScrollPane(listaClases);
            addFila(lista);
        }

        botonVolver = new JButton("Volver");
        botonVolver.addActionListener(new CargarMenuPrincipal());
        addFila(botonVolver);
    }

    public Date getDate() {
        return fecha.getDate();
    }
}
