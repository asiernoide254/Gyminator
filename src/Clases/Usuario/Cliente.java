package Clases.Usuario;


import Clases.Clase;
import Clases.Ejercicio;

import java.util.Date;

public class Cliente extends Usuario {

    public Cliente() {
    }

    public Cliente(String em, String pass, String n, String ap, Date fecha, String gen, String tlf, String foto) {
        super(em, pass, n, ap, fecha, gen, tlf, foto);
    }

    public Cliente(String em, String pass, String n, String ap, Date fecha) {
        super(em, pass, n, ap, fecha);
    }


    public void introducirResultado(Ejercicio e) {
        //Mostrar GUI para introducir resultados
        //Subir a la BBDD los resultados del usuario para el ejercicio e
    }

    public void reservarClase(Clase c) {
        if (c.getPlazasRestantes() == 0) {
            c.addListaEspera(this);
        } else {
            c.addParticipante(this);
        }
        //Actualizar base de datos con nueva lista
    }

}
