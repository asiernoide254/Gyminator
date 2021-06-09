package Menus.Interfaces;

import Clases.Clase;
import Controladores.Generales.CargarMenuPrincipal;
import Controladores.Reserva.BuscarClases;
import Controladores.Reserva.GuardarReserva;
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
    private JButton botonVolver;
    private JButton botonClase;

    private Interfaz listaClases;

    private BuscarClases buscarClases;

    public ReservarClase() {
        addTitulo("RESERVA DE CLASES");

        //Fecha
        fecha = new JDateChooser();
        fecha.setPreferredSize(new Dimension(100, 20));
        fecha.setDate(new Date(System.currentTimeMillis()));
        fecha.setDateFormatString("dd/MM/yyyy");

        buscar = new JButton("Buscar");
        buscarClases = new BuscarClases(this);
        buscar.addActionListener(buscarClases);

        addCampo("Fecha: ", fecha, buscar);

        listaClases = new Interfaz();
        listaClases.setAnchoBordes(0);
        addClasesHoy();

        lista = new JScrollPane(listaClases);

        addFila(lista);

        botonVolver = new JButton("Volver");
        botonVolver.addActionListener(new CargarMenuPrincipal());
        addFila(botonVolver);
    }

    private void addClasesHoy() {
        listaClases.removeAll();

        List<Clase> clases = buscarClases.buscar(new Date(System.currentTimeMillis()));
        for(Clase clase : clases)
            addBotonClase(clase);
    }

    public void mostrarClases(List<Clase> clases){
        listaClases.removeAll();

        if (clases.isEmpty()) {
            new VentanaMensaje("No hay clases a reservar ese día.");
        } else {
            for (Clase clase : clases)
                addBotonClase(clase);
        }

        Interfaz.setVentana(this);
    }

    private void addBotonClase(Clase clase){
        botonClase = new JButton(clase.InfoBasica());
        botonClase.setPreferredSize(new Dimension(450, 50));
        botonClase.addActionListener(new GuardarReserva(this, clase));
        listaClases.addFila(botonClase);
    }

    public Date getDate() {
        return fecha.getDate();
    }
}
