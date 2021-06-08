package Controladores.Reserva;

import BaseDeDatos.BaseDeDatos;
import Clases.Clase;
import Clases.Usuario.Usuario;
import Menus.ClasesInterfaces.*;
import Menus.Interfaces.ReservarClase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GuardarReserva implements ActionListener {
    private ReservarClase r;
    private Clase clase;
    private Date fechaActual;
    private Usuario cliente;

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public GuardarReserva(ReservarClase reservarClase, Clase c){
        r = reservarClase;
        clase = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cliente = Interfaz.getUsuario();
        fechaActual = new Date();

        if(BaseDeDatos.claseReservada(cliente, clase))
            new VentanaMensaje("Ya ha reservado esta clase.");
        else {
            BaseDeDatos.addReserva(clase, formatter.format(fechaActual), cliente);

            if(clase.getPlazasRestantes() == 0){
                new VentanaMensaje("Has sido añadido a la lista de espera de la clase N.º " + clase.getCodigo());
            }
            else if(clase.getPlazasRestantes() > 0){
                new VentanaMensaje("Se ha reservado la clase N.º " + clase.getCodigo() + " con éxito.");
            }
        }
    }
}
