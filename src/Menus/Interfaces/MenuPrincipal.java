package Menus.Interfaces;

import Controladores.Generales.CargarCambioPerfil;
import Controladores.Generales.CargarInicioSesion;
import Controladores.Generales.CargarMostrarProgreso;
import Controladores.MenuPrincipal.cargarHerramientas;
import Controladores.MenuPrincipal.cargarRegistrarEjercicios;
import Controladores.MenuPrincipal.cargarReserva;
import Menus.ClasesInterfaces.Interfaz;

import javax.swing.*;

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
    private JButton ejercicios;
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
        perfil.addActionListener(new CargarCambioPerfil());
        addFila(perfil);

        //RESERVA CLASE
        reservarClase = new JButton("RESERVAR CLASE");
        reservarClase.addActionListener(new cargarReserva());
        addFila(reservarClase);

        //HERRAMIENTAS
        herramientas = new JButton("HERRAMIENTAS");
        herramientas.addActionListener(new cargarHerramientas());
        addFila(herramientas);

        //NOTICIAS
        noticias = new JButton("NOTICIAS");
        //noticias.addActionListener(new cargarNoticias());
        addFila(noticias);

        //APUNTAR EJERCICIOS
        ejercicios = new JButton("REGISTRAR EJERCICIO");
        ejercicios.addActionListener(new cargarRegistrarEjercicios());
        addFila(ejercicios);

        //MOSTRAR PROGRESO
        progreso = new JButton("PROGRESO");
        progreso.addActionListener(new CargarMostrarProgreso());
        addFila(progreso);

        //CHAT
        chat = new JButton("CHAT INTERNO");
        addFila(chat);

        //ENTRENADORES
        nuestrosEntrenadores = new JButton("CONOCE A NUESTROS ENTRENADORES");
        addFila(nuestrosEntrenadores);

        //CERRAR SESION
        cerrarSesion = new JButton("CERRAR SESIÓN");
        addFila(cerrarSesion);
        //Comprobar para cerrar la sesion del usuario
        cerrarSesion.addActionListener(new CargarInicioSesion());

    }


}
