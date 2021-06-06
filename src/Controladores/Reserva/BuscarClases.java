package Controladores.Reserva;

import BaseDeDatos.BaseDeDatos;
import Clases.Clase;
import Menus.Interfaces.ReservarClase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BuscarClases implements ActionListener {
    private ReservarClase r;
    private List<Clase> clases;

    public BuscarClases(ReservarClase r) {
        this.r = r;
    }

    public void actionPerformed(ActionEvent e) {
        clases = BaseDeDatos.getClasesDisponibles(r.getDate());
    }

    public List<Clase> getClases() {
        return clases;
    }
}
