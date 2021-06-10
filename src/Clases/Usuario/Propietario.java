package Clases.Usuario;

import Clases.Gimnasio;

import java.util.Date;

public class Propietario extends Usuario {
    private Gimnasio gimnasio;

    public Propietario(String em, String pass, String n, String ap, Date fecha, String gen, String tlf, String foto) {
        super(em, pass, n, ap, fecha, gen, tlf, foto);
    }

    public Propietario(String em, String pass, String n, String ap, Date fecha) {
        super(em, pass, n, ap, fecha);
    }
}