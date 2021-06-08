package Clases.Usuario;

import java.util.Date;

public class Entrenador extends Usuario {

    private double horasDeTrabajo;
    private String biografia;

    public Entrenador() {
    }

    public Entrenador(String em, String pass, String n, String ap, Date fecha, String gen, String tlf, String foto) {
        super(em, pass, n, ap, fecha, gen, tlf, foto);
        horasDeTrabajo = 0;
        biografia = null;
    }

    public Entrenador(String em, String pass, String n, String ap, Date fecha) {
        super(em, pass, n, ap, fecha);
    }

    public double getHorasDeTrabajo() {
        return horasDeTrabajo;
    }

    public void setHorasDeTrabajo(double h) {
        this.horasDeTrabajo = h;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String b) {
        this.biografia = b;
    }

    public void aumentaHorasDeTrabajo(double h) {
        horasDeTrabajo += h;
    }
}

