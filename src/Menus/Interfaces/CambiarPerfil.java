package Menus.Interfaces;

import Clases.Usuario.Usuario;
import Controladores.CambiarPerfil.CambiarContraseña;
import Controladores.CambiarPerfil.GuardarCambiosPerfil;
import Controladores.Generales.CargarMenuPrincipal;
import Menus.ClasesInterfaces.Interfaz;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class CambiarPerfil extends Interfaz {


    //objetos de la interfaz
    //private Usuario u;

    private JTextField txtEmail;
    private JTextField txtNombre;
    private JTextField txtApellidos;
    private JDateChooser fechaNacimiento;
    private ButtonGroup generoBotones;
    private JRadioButton masculino;
    private JRadioButton femenino;
    private JRadioButton otroGenero;
    private JTextField txtTlf;
    private JButton InicioSesionButton;
    private JButton RegistroButton;
    private JTextField txtCodigo;
    private JButton botonCambiarPassword;
    private JButton botonGuardar;
    private JButton botonVolver;

    public CambiarPerfil() {
        Usuario usuario = Interfaz.getUsuario();

        addTitulo("PERFIL");

        //EMAIL
        txtEmail = new JTextField(20);
        txtEmail.setText(usuario.getEmail());

        addCampo("Email:", txtEmail);

        //NOMBRE Y APELLIDO
        txtNombre = new JTextField(20);
        txtNombre.setText(usuario.getNombre());
        txtApellidos = new JTextField(20);
        txtApellidos.setText(usuario.getApellidos());

        //NOMBRE
        addCampo("Nombre:", txtNombre);

        //APELLIDOS
        addCampo("Apellidos:", txtApellidos);

        //FECHA DE NACIMIENTO
        fechaNacimiento = new JDateChooser();
        fechaNacimiento.setDate(usuario.getFechaNacimiento());
        fechaNacimiento.setPreferredSize(new Dimension(100, 20));
        fechaNacimiento.setDateFormatString("dd/MM/yyyy");
        addCampo("Fecha de nacimiento:", fechaNacimiento);

        //GÉNERO
        masculino = new JRadioButton("M");
        femenino = new JRadioButton("F");
        otroGenero = new JRadioButton("NS/NC");

        String genero = usuario.getGenero();
        if (genero == null) {
            otroGenero.setSelected(true);
        } else if (genero.equals("M")) {
            masculino.setSelected(true);
        } else {
            femenino.setSelected(true);
        }

        generoBotones = new ButtonGroup();
        generoBotones.add(masculino);
        generoBotones.add(femenino);
        generoBotones.add(otroGenero);

        addCampo("Género:", masculino, femenino, otroGenero);

        //TELÉFONO
        txtTlf = new JTextField(20);
        txtTlf.setText(usuario.getTelefono());
        addCampo("Teléfono:", txtTlf);


        //CONTRASEÑA
        botonCambiarPassword = new JButton("Cambiar contraseña");
        botonCambiarPassword.addActionListener(new CambiarContraseña());
        botonGuardar = new JButton("Aplicar cambios");
        botonGuardar.addActionListener(new GuardarCambiosPerfil(this));
        botonVolver = new JButton("Volver");
        botonVolver.addActionListener(new CargarMenuPrincipal());

        addFila(botonVolver, botonGuardar, botonCambiarPassword);
    }

    public String getGenero() {
        if (masculino.isSelected()) {
            return "M";
        } else if (femenino.isSelected())
            return "F";

        return null;
    }

    public String getEmail() {
        return txtEmail.getText();
    }

    public String getNombre() {
        return txtNombre.getText();
    }

    public String getApellidos() {
        return txtApellidos.getText();
    }

    public Date getFecha() {
        return fechaNacimiento.getDate();
    }

    public String getTelefono() {
        return txtTlf.getText();
    }

    public String getCodigo() {
        return txtCodigo.getText();
    }

}

