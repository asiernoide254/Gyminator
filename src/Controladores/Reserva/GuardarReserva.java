package Controladores.Reserva;

import Menus.Interfaces.ReservarClase;

import javax.swing.*;

public class GuardarReserva {
    private ReservarClase r;
    private JDialog j;

    public GuardarReserva(ReservarClase r) {
        this.r = r;
    }
    /*
    public void actionPerformed(ActionEvent e){
        Ejercicio ej = new Ejercicio(r.getNombre(),
                Integer.parseInt(r.getSeries()),
                Integer.parseInt(r.getRepeticiones()),
                Integer.parseInt(r.getPeso()),
                Integer.parseInt (r.getTiempo()),
                r.getFecha(),
                r.getSensaciones());

        BaseDeDatos.addEjercicio(ej);
    }
    */
}

