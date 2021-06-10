package Menus.Interfaces;

import Controladores.Generales.CargarInicioSesion;
import Controladores.Registro.ComprobarDatosRegistro;
import Menus.ClasesInterfaces.Etiqueta;
import Menus.ClasesInterfaces.Interfaz;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Registro extends Interfaz {
    /*
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String obligatorio = ANSI_RED + "*" + ANSI_RESET;

     */

    public static final String obligatorio = "*";

    private Etiqueta titulo;
    private JTextField email;
    private JPasswordField password;
    private JPasswordField password2;
    private JTextField nombre;
    private JTextField apellidos;
    private JDateChooser fechaNacimiento;
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    private JRadioButton masculino;
    private JRadioButton femenino;
    private JRadioButton nsnc;
    private JTextField telefono;
    private JButton registrarse;
    private JButton tengoCuenta;

    public Registro() {
        addTitulo("CREE UNA CUENTA");

        Interfaz datos = new Interfaz();

        email = new JTextField(20);
        datos.addCampo(obligatorio + " Email:", email);

        password = new JPasswordField(20);
        datos.addCampo(obligatorio + " Contraseña:", password);

        password2 = new JPasswordField(20);
        datos.addCampo(obligatorio + " Repita la contraseña:", password2);

        nombre = new JTextField(10);
        datos.addCampo(obligatorio + " Nombre:", nombre);

        apellidos = new JTextField(20);
        datos.addCampo(obligatorio + " Apellidos:", apellidos);

        fechaNacimiento = new JDateChooser();
        fechaNacimiento.setPreferredSize(new Dimension(100, 20));
        fechaNacimiento.setDateFormatString("dd/MM/yyyy");
        datos.addCampo(obligatorio + " Fecha de nacimiento:", fechaNacimiento);

        Interfaz genero = new Interfaz();
        genero.setAnchoBordes(0);

        ButtonGroup grupoBotonesGenero = new ButtonGroup();
        masculino = new JRadioButton("M");
        grupoBotonesGenero.add(masculino);
        femenino = new JRadioButton("F");
        grupoBotonesGenero.add(femenino);
        nsnc = new JRadioButton("NS/NC");
        grupoBotonesGenero.add(nsnc);
        nsnc.setSelected(true);

        datos.addCampo("Género:", masculino, femenino, nsnc);

        telefono = new JTextField(10);
        datos.addCampo("Teléfono:", telefono);

        addFila(datos);

        registrarse = new JButton("Registrarse");
        tengoCuenta = new JButton("Ya tengo cuenta");
        addFila(registrarse, tengoCuenta);

        registrarse.addActionListener(new ComprobarDatosRegistro(this));
        tengoCuenta.addActionListener(new CargarInicioSesion());
    }

    public String getEmail() {
        return email.getText();
    }

    public String getPassword1() {
        return new String(password.getPassword());
    }

    public String getPassword2() {
        return new String(password2.getPassword());
    }

    public String getNombre() {
        return nombre.getText();
    }

    public String getApellidos() {
        return apellidos.getText();
    }

    public Date getFecha() {
        Date fecha = fechaNacimiento.getDate();

        return fecha == null ? null : fecha;
    }

    public String getGenero() {
        return masculino.isSelected() ? "M" : femenino.isSelected() ? "F" : null;
    }

    public String getTelefono() {
        return telefono.getText();
    }
}
