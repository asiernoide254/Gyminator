package Controladores.Ejercicios;

import BaseDeDatos.BaseDeDatos;
import Clases.Ejercicio;
import Clases.Usuario.Usuario;
import Menus.ClasesInterfaces.Interfaz;
import Menus.Interfaces.MostrarProgreso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorrarEjercicio implements ActionListener {


    Usuario u;
    Ejercicio e;

    public BorrarEjercicio(Ejercicio e, Usuario u) {
        this.e = e;
        this.u = u;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        BaseDeDatos.eliminarEjercicio(e, u);
        Interfaz.setVentana(new MostrarProgreso());
    }
}
