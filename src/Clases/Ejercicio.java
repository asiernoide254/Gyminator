package Clases;

import java.util.Date;


public class Ejercicio {
    private String nombre;
    private int series;
    private int repeticiones;
    private double peso;
    private double tiempo;
    private Date fecha;
    private String sensaciones;

    public Ejercicio(String nom, int ser, int rep, double p, double t, Date f, String sens) {
        nombre = nom;
        series = ser;
        repeticiones = rep;
        peso = p;
        tiempo = t;
        fecha = f;
        sensaciones = sens;
    }

    public Ejercicio(String nom, Date f) {
        nombre = nom;
        fecha = f;
        sensaciones = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String n) {
        nombre = n;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int s) {
        series = s;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int rep) {
        repeticiones = rep;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double p) {
        peso = p;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double t) {
        tiempo = t;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date f) {
        fecha = f;
    }

    public String getSensaciones() {
        return sensaciones;
    }

    public void setSensaciones(String s) {
        sensaciones = s;
    }
}
