package Menus.Interfaces;

import Controladores.Generales.CargarCambioPerfil;
import Controladores.Generales.CargarInicioSesion;
import Controladores.Generales.CargarMostrarProgreso;
import Controladores.MenuPrincipal.cargarHerramientas;
import Controladores.MenuPrincipal.cargarReserva;
import Menus.ClasesInterfaces.Interfaz;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends Interfaz {
    //Elementos de Interfaz

    private JPanel ButtonPanel;
    private JPanel PerfilPanel;

    private JButton perfil;


    private JButton herramientas;
    private JButton reservarClase;
    private JButton nuestrosEntrenadores;
    private JButton noticias;
    private JButton chat;
    private JButton progreso;
    private JButton cerrarSesion;


    //Calendario
    private JPanel jpCald;
    //JDate;


    //MenuPrincipal Cliente
    public MenuPrincipal() {

        //TITULO
        addTitulo("GYMINATOR");

        //PERFIL
        perfil = new JButton("PERFIL");
        perfil.setPreferredSize(new Dimension(300, 40));
        perfil.addActionListener(new CargarCambioPerfil());
        addFila(perfil);

        //RESERVA CLASE
        reservarClase = new JButton("RESERVAR CLASE");
        reservarClase.setPreferredSize(new Dimension(300, 40));
        reservarClase.addActionListener(new cargarReserva());
        addFila(reservarClase);

        //HERRAMIENTAS
        herramientas = new JButton("HERRAMIENTAS");
        herramientas.setPreferredSize(new Dimension(300, 40));
        herramientas.addActionListener(new cargarHerramientas());
        addFila(herramientas);

        //NOTICIAS
        noticias = new JButton("NOTICIAS");
        noticias.setPreferredSize(new Dimension(300, 40));
        //noticias.addActionListener(new cargarNoticias());
        addFila(noticias);


        //MOSTRAR PROGRESO
        progreso = new JButton("PROGRESO");
        progreso.setPreferredSize(new Dimension(300, 40));
        progreso.addActionListener(new CargarMostrarProgreso());
        addFila(progreso);

        //CHAT
        chat = new JButton("CHAT INTERNO");
        chat.setPreferredSize(new Dimension(300, 40));
        addFila(chat);

        //ENTRENADORES
        nuestrosEntrenadores = new JButton("CONOCE A NUESTROS ENTRENADORES");
        nuestrosEntrenadores.setPreferredSize(new Dimension(300, 40));
        addFila(nuestrosEntrenadores);

        //CERRAR SESION
        cerrarSesion = new JButton("CERRAR SESIÓN");
        cerrarSesion.setPreferredSize(new Dimension(300, 40));
        addFila(cerrarSesion);
        //Comprobar para cerrar la sesion del usuario
        cerrarSesion.addActionListener(new CargarInicioSesion());

    }


}
