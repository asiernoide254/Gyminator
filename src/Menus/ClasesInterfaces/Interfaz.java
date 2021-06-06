package Menus.ClasesInterfaces;

import Clases.Usuario.Usuario;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Interfaz extends JPanel {
    private static final String RUTA_RECURSOS = "/Menus/Imagenes/";
    public static int LEFT = 0;
    public static int CENTER = 1;
    public static int RIGHT = 2;
    private static JFrame principal;
    private static Usuario usuario;
    private int anchoBordes = 50;
    private int anchoSeparadores = 50;
    private int anchoTextoCampo = 130;


    public Interfaz() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addEspacio();
    }

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario us) {
        usuario = us;
    }

    public static JFrame principal() {
        return principal;
    }

    public static void setVentana(Interfaz ventana) {
        if (principal == null) {
            principal = new JFrame();
            principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            principal.setIconImage(crearIcono("cool_clown.png").getImage());
            principal.setVisible(true);
        }

        principal.setContentPane(ventana);
        principal.pack();
        principal.setLocationRelativeTo(null);
    }

    public static ImageIcon crearIcono(String nombreArchivo) {
        URL rutaImagen = Interfaz.class.getResource(RUTA_RECURSOS + nombreArchivo);

        if (rutaImagen != null)
            return new ImageIcon(rutaImagen);

        System.err.println("ERROR: no se ha podido obtener la imagen.");
        return null;
    }

    public void setAnchoTextoCampo(int ancho) {
        anchoTextoCampo = ancho;
    }

    public void addTitulo(String t) {
        Etiqueta titulo = new Etiqueta(t);
        titulo.formatoTitulo();
        addFila(titulo);
    }

    public void addFila(Component... componentes) {
        addFila(CENTER, componentes);
    }

    public void addFila(int alineamiento, Component... componentes) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(alineamiento));

        Dimension dimensionesBordes = new Dimension(anchoBordes, 0);

        JPanel separador = new JPanel();
        separador.setPreferredSize(dimensionesBordes);
        panel.add(separador);

        for (int i = 0; i < componentes.length - 1; i++) {
            panel.add(componentes[i]);
            panel.add(new Interfaz());
        }
        panel.add(componentes[componentes.length - 1]);
        separador = new JPanel();
        separador.setPreferredSize(dimensionesBordes);
        panel.add(separador);

        add(panel);

        addEspacio();
    }

    public void addCampo(String texto, Component... componentes) {
        Component[] comp = new Component[componentes.length + 1];
        comp[0] = new Etiqueta(texto, Etiqueta.RIGHT, anchoTextoCampo);
        for (int i = 1; i < comp.length; i++)
            comp[i] = componentes[i - 1];
        addFila(LEFT, comp);
    }

    private void addEspacio() {
        JPanel espacio = new JPanel();
        espacio.setPreferredSize(new Dimension(0, 15));
        add(espacio);
    }

    public void setAnchoBordes(int ancho) {
        anchoBordes = ancho;
    }
}
