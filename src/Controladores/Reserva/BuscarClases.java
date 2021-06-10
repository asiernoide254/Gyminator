package Controladores.Reserva;

import BaseDeDatos.BaseDeDatos;
import Clases.Clase;
import Menus.Interfaces.ReservarClase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

public class BuscarClases implements ActionListener {
    private ReservarClase r;

    public BuscarClases(ReservarClase r) {
        this.r = r;
    }

    public void actionPerformed(ActionEvent e) {
        r.mostrarClases(buscar(r.getDate()));
    }

    public List<Clase> buscar(Date fecha) {
        return BaseDeDatos.getClasesDisponibles(fecha);
    }
}
