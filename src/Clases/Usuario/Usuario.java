package Clases.Usuario;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public abstract class Usuario {
    private String email;
    private String password;
    private String nombre;
    private String apellidos;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private Date fechaNacimiento;
    private String genero;
    private String telefono;
    private String foto;

    public Usuario() {
    }

    public Usuario(String em, String pass, String n, String ap, Date fecha, String gen, String tlf, String fot) {
        email = em;
        password = pass;
        nombre = n;
        apellidos = ap;
        fechaNacimiento = fecha;
        genero = gen;
        telefono = tlf;
        foto = fot;
    }

    public Usuario(String em, String pass, String n, String ap, Date fecha) {
        this(em, pass, n, ap, fecha, null, null, null);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String em) {
        email = em;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pass) {
        password = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nom) {
        nombre = nom;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apell) {
        apellidos = apell;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fecha) {
        fechaNacimiento = fecha;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String gen) {
        genero = gen;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String tlf) {
        telefono = tlf;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String fot) {
        foto = fot;
    }

    //TODO: Comprobar si funciona el calculo de la edad
    public int getEdad() {
        LocalDate fActual = LocalDate.now();
        LocalDate fNacimiento = LocalDate.parse(fechaNacimiento + "", formatter);

        return Period.between(fNacimiento, fActual).getYears();
    }

    //TODO: Sistema de mensajeria
    public void enviarMsj(String contenido, Usuario usuario) {

    }

}
