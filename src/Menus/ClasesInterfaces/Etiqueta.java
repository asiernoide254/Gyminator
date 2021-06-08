package Menus.ClasesInterfaces;

import javax.swing.*;
import java.awt.*;

public class Etiqueta extends JLabel {

    public Etiqueta() {
        super();
    }

    public Etiqueta(String texto, int alineamiento) {
        super(texto, alineamiento);
    }

    public Etiqueta(String texto, int alineamiento, int ancho) {
        super(texto, alineamiento);
        setPreferredSize(new Dimension(ancho, 20));
    }

    public Etiqueta(String texto) {
        super(texto);
    }

    public Etiqueta(Icon componente) {
        super(componente);
    }

    public void formatoTitulo() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        Font font = getFont();
        setFont(new Font(font.getName(), Font.BOLD, 30));
    }
}
